package com.ai.baas.bmc.business.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.hbase.client.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.orderinfo.params.OrderExt;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.api.orderinfo.params.Product;
import com.ai.baas.bmc.api.orderinfo.params.ProductExt;
import com.ai.baas.bmc.business.interfaces.IOrderinfoBusiness;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.context.ErrorCode;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConTradeSeqLog;
import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
import com.ai.baas.bmc.dao.interfaces.BlSubsCommMapper;
import com.ai.baas.bmc.dao.interfaces.BlSubscommExtMapper;
import com.ai.baas.bmc.dao.interfaces.BlUserinfoExtMapper;
import com.ai.baas.bmc.dao.interfaces.BlUserinfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;
import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExt;
import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExtCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoExt;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoExtCriteria;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;

import net.sf.json.JSONObject;

@Service
@Transactional
public class OrderinfoBusinessImpl implements IOrderinfoBusiness {
    @Autowired
    private BlUserinfoMapper aBlUserinfoMapper;

    @Autowired
    private BlUserinfoExtMapper aBlUserinfoExtMapper;

    @Autowired
    private BlAcctInfoMapper aBlAcctInfoMapper;

    // @Autowired
    // private BlAcctinfoExtMapper aBlAcctinfoExtMapper;

    @Autowired
    private BlSubsCommMapper aBlSubsCommMapper;

    @Autowired
    private BlSubscommExtMapper aBlSubscommExtMapper;

    @Autowired
    private ISysSequenceSvc aISysSequenceSvc;

    @Override
    public boolean hasSeq(OrderInfoParams record) throws IOException {
        String rowkey = record.getTenantId() + Context.SPLIT + Context.ORDER_INFO_CODE
                + Context.SPLIT + record.getTradeSeq();
        Table table = MyHbaseUtil.getTable(TableCon.TRADE_SEQ_LOG);

        if (MyHbaseUtil.hasExists(table, rowkey)) {
            return true;
        }
        MyHbaseUtil.addData(table, rowkey,
                CellTemp.inst(ConTradeSeqLog.TENANT_ID, record.getTenantId()),
                CellTemp.inst(ConTradeSeqLog.INTERFACE_CODE, Context.ORDER_INFO_CODE),
                CellTemp.inst(ConTradeSeqLog.TRADE_SEQ, record.getTradeSeq()),
                CellTemp.inst(ConTradeSeqLog.RECEIVE_TIME,
                        DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
                CellTemp.inst(ConTradeSeqLog.MSG_CONTENT, MyJsonUtil.toJson(record)));
        return false;
    }

    @Override
    public void writeData(OrderInfoParams record, String custId) {
        // *************判重*************************
        // 通过共享内存查找subsId
        String subsId = null;
        String acctId = null;
        Map<String, String> params = new TreeMap<String, String>();
        params.put("cust_id", custId);
        params.put("tenant_id", record.getTenantId());
        List<Map<String, String>> result = DshmUtil.getClient().list("bl_userinfo")
                .where(params).executeQuery(DshmUtil.getCacheClient());
        //获得缓存中第一条有效数据
        if (!(result == null || result.isEmpty())) {
            for(Map<String, String> r : result){
                if(r.isEmpty()){
                    String temp[] = result.get(0).get("subs_id").split("#");
                    subsId = temp[temp.length - 1];
                    temp = result.get(0).get("acct_id").split("#");
                    acctId = temp[temp.length - 1];
                    break;
                }
            }
        }
        // *************判重end**********************
        BlUserinfo aBlUserinfo = writeBlUserinfo(record, custId, subsId, acctId);
        System.err.println(MyJsonUtil.toJson(aBlUserinfo));
        // 当产品列表不为空时，循环插入产品表
        if (record.getProductList() != null) {
            for (Product p : record.getProductList()) {
                writeBlSubsComm(aBlUserinfo, p);
            }
        }
        // 根据用户信息创建账户信息
        if(StringUtil.isBlank(subsId)){
            writeAcctInfo(aBlUserinfo);
        }

    }

    // 用户信息表操作,成功返回用户信息
    private BlUserinfo writeBlUserinfo(OrderInfoParams record, String custId, String subsId,
            String acctId) {
        // 设置插入用户表模板
        BlUserinfo aBluserinfo = new BlUserinfo();
        aBluserinfo.setCustId(custId);
        aBluserinfo.setTenantId(record.getTenantId());
        aBluserinfo.setActiveTime(
                DateUtil.getTimestamp(record.getActiveTime(), DateUtil.YYYYMMDDHHMMSS));
        aBluserinfo.setServiceId(record.getServiceId());
        // 受理时间设为订购时间
        aBluserinfo
                .setDealTime(DateUtil.getTimestamp(record.getOrderTime(), DateUtil.YYYYMMDDHHMMSS));
        aBluserinfo.setProvinceCode(record.getProvinceCode());
        aBluserinfo.setCityCode(record.getCityCode());
        aBluserinfo.setChlId(record.getChlId());
        aBluserinfo.setDevId(record.getDevId());
        aBluserinfo.setInactiveTime(
                DateUtil.getTimestamp(record.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS));
        aBluserinfo.setRemark(record.getRemark());
        aBluserinfo.setUserType(record.getUsetype());
        aBluserinfo.setUserState(record.getState());
        // ^^业务类型不确定，暂为空
        // 如果subsId为空则认为需要插入，否则执行更新
        if (StringUtil.isBlank(subsId)) {
            // subsId调用序列
            aBluserinfo.setSubsId(
                    aISysSequenceSvc.terrigerSysSequence("SUBS_ID", 1).get(0));
            // acctId调用序列
            aBluserinfo.setAcctId(
                    aISysSequenceSvc.terrigerSysSequence("ACCT_ID", 1).get(0));
            aBlUserinfoMapper.insertSelective(aBluserinfo);
        } else {
            aBluserinfo.setSubsId(subsId);
            aBluserinfo.setAcctId(acctId);
            aBlUserinfoMapper.updateByPrimaryKeySelective(aBluserinfo);
        }
        // 刷新用户的内存表
        // ********************************
        JSONObject json = new JSONObject();
        json.put("tenant_id", aBluserinfo.getTenantId());
        json.put("subs_id", aBluserinfo.getSubsId());
        json.put("active_time", aBluserinfo.getActiveTime());
        json.put("cust_id", aBluserinfo.getCustId());
        json.put("acct_id", aBluserinfo.getAcctId());
        json.put("service_id", aBluserinfo.getServiceId());
        json.put("deal_time", aBluserinfo.getDealTime());
        json.put("province_code", aBluserinfo.getProvinceCode());
        json.put("city_code", aBluserinfo.getCityCode());
        json.put("chl_id", aBluserinfo.getChlId());
        json.put("dev_id", aBluserinfo.getDevId());
        json.put("inactive_time", aBluserinfo.getInactiveTime());
        json.put("remark", aBluserinfo.getRemark());
        json.put("serv_type", aBluserinfo.getServType());
        json.put("user_type", aBluserinfo.getUserType());
        json.put("user_state", aBluserinfo.getUserState());
//        DshmUtil.getIdshmSV().initDel(TableCon.BL_USERINFO, json.toString());
        // 如果subsId为空则认为需要插入，否则执行更新
        if (StringUtil.isBlank(subsId)) {
            DshmUtil.getIdshmSV().initLoader("bl_userinfo", json.toString(),1);
        } else {
            DshmUtil.getIdshmSV().initLoader("bl_userinfo", json.toString(),0);
        }
        LoggerUtil.log.debug("刷新用户表共享内存：" + json.toString());
        // ^^^
        // ********************************
        // 当扩展信息为空退出，否则循环操作用户扩展信息
        if (record.getOrderExtInfo() != null) {
            for (OrderExt o : record.getOrderExtInfo()) {
                writeBlUserinfoExt(aBluserinfo.getSubsId(), o,record.getTenantId());
            }
        }
        return aBluserinfo;
    }

    // 用户扩展信息表操作
    private void writeBlUserinfoExt(String subsId, OrderExt orderExt,String tenantId) {
        if ("D".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            // 查出要删除的记录
            try {
                BlUserinfoExt temp = aBlUserinfoExtMapper.selectByExample(example).get(0);
                aBlUserinfoExtMapper.deleteByExample(example);
                // 刷新用户扩展信息表的内存表
                // ********************************
                JSONObject json = new JSONObject();
                json.put("EXT_ID", temp.getExtId());
                json.put("SUBS_ID", temp.getSubsId());
                json.put("EXT_NAME", temp.getExtName());
                json.put("EXT_VALUE", temp.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initdel("bl_userinfo_ext", json.toString());
                // ^^meixie
                // ********************************
            } catch (NullPointerException e) {
                throw new BusinessException(ErrorCode.NULL, "用户扩展信息不在表中，无法删除");
            }
        } else if ("U".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExt aBlUserinfoExt = new BlUserinfoExt();
            aBlUserinfoExt.setExtValue(orderExt.getExtValue());
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            try {
                // 查出要更新的记录
//                BlUserinfoExt temp = aBlUserinfoExtMapper.selectByExample(example).get(0);
                aBlUserinfoExtMapper.updateByExampleSelective(aBlUserinfoExt, example);
                // 刷新用户扩展信息表的内存表
                // ********************************
//                JSONObject json = new JSONObject();
//                json.put("EXT_ID", temp.getExtId());
//                json.put("SUBS_ID", temp.getSubsId());
//                json.put("EXT_NAME", temp.getExtName());
//                json.put("EXT_VALUE", temp.getExtValue());
//                json.put("TENANT_ID", tenantId);
//                DshmUtil.getIdshmSV().initdel("bl_userinfo_ext",json.toString());
                // 查出更新后的记录
                BlUserinfoExt temp = aBlUserinfoExtMapper.selectByExample(example).get(0);
                JSONObject json = new JSONObject();
                json.put("EXT_ID", temp.getExtId());
                json.put("SUBS_ID", temp.getSubsId());
                json.put("EXT_NAME", temp.getExtName());
                json.put("EXT_VALUE", temp.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initLoader("bl_userinfo_ext", json.toString(),0);
                // ^^meixie
                // ********************************
            } catch (NullPointerException e) {
                throw new BusinessException(ErrorCode.NULL, "用户扩展信息不在表中，无法更新");
            }
        } else if ("N".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExt aBlUserinfoExt = new BlUserinfoExt();
            aBlUserinfoExt.setSubsId(subsId);
            aBlUserinfoExt.setExtName(orderExt.getExtName());
            aBlUserinfoExt.setExtValue(orderExt.getExtValue());
            aBlUserinfoExtMapper.insertSelective(aBlUserinfoExt);
            // 刷新用户扩展信息表的内存表
            // ********************************
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            BlUserinfoExt temp = aBlUserinfoExtMapper.selectByExample(example).get(0);
            JSONObject json = new JSONObject();
            json.put("EXT_ID", temp.getExtId());
            json.put("SUBS_ID", temp.getSubsId());
            json.put("EXT_NAME", temp.getExtName());
            json.put("EXT_VALUE", temp.getExtValue());
            json.put("TENANT_ID", tenantId);
            DshmUtil.getIdshmSV().initLoader("bl_userinfo_ext", json.toString(),1);
            // ^^meixie
            // ********************************
        }
    }

    // 产品订购信息表操作
    private void writeBlSubsComm(BlUserinfo userInfo, Product product) {
        for (int i = 0; i < product.getProductNumber(); i++) {
            BlSubsComm aBlSubsComm = new BlSubsComm();
            aBlSubsComm.setSubsId(userInfo.getSubsId());
            aBlSubsComm.setSubsProductId(
                    aISysSequenceSvc.terrigerSysSequence("SUBS_PRODUCT_ID", 1).get(0));
            aBlSubsComm.setActiveTime(
                    DateUtil.getTimestamp(product.getActiveTime(), DateUtil.YYYYMMDDHHMMSS));
            aBlSubsComm.setProductId(product.getProductId());
            aBlSubsComm.setResBonusFlag(product.getResBonusFlag());
            aBlSubsComm.setInactiveTime(
                    DateUtil.getTimestamp(product.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS));
            aBlSubsComm.setTenantId(userInfo.getTenantId());
            aBlSubsComm.setCustId(userInfo.getCustId());
            aBlSubsCommMapper.insertSelective(aBlSubsComm);
            // 刷新产品订购信息的内存表
            // ********************************
            JSONObject json = new JSONObject();
            json.put("subs_id", aBlSubsComm.getSubsId());
            json.put("subs_product_id", aBlSubsComm.getSubsProductId());
            json.put("active_time", aBlSubsComm.getActiveTime());
            json.put("product_id", aBlSubsComm.getProductId());
            json.put("res_bonus_flag", aBlSubsComm.getResBonusFlag());
            json.put("inactive_time", aBlSubsComm.getInactiveTime());
            json.put("tenant_id", aBlSubsComm.getTenantId());
            json.put("cust_id", aBlSubsComm.getCustId());
//            DshmUtil.getIdshmSV().initdel(TableCon.BL_SUBS_COMM, json.toString());
            DshmUtil.getIdshmSV().initLoader("bl_subs_comm", json.toString(),1);
            LoggerUtil.log.debug("刷新产品订购信息表共享内存：" + json.toString());
            // ^^meixie
            // ********************************
            // 如果产品订购扩展信息不为空则对产品订购扩展信息表进行操作
            if (product.getProductExtInfoList() != null) {
                for (ProductExt pe : product.getProductExtInfoList()) {
                    writeBlSubsCommExt(aBlSubsComm.getProductId(), aBlSubsComm.getSubsProductId(),
                            pe,userInfo.getTenantId());
                }
            }
        }
    }

    // 产品订购扩展信息表操作
    private void writeBlSubsCommExt(String productId, String subsProductId, ProductExt pe,String tenantId) {
        if ("D".equals(pe.getUpdateFlag())) {
            BlSubscommExtCriteria example = new BlSubscommExtCriteria();
            example.createCriteria().andProductIdEqualTo(productId)
                    .andSubsProductIdEqualTo(subsProductId).andExtNameEqualTo(pe.getExtName());
            try {
                BlSubscommExt temp = aBlSubscommExtMapper.selectByExample(example).get(0);
                aBlSubscommExtMapper.deleteByExample(example);
                // 刷新用户扩展信息表的内存表
                // ********************************
                JSONObject json = new JSONObject();
                json.put("EXT_ID", temp.getExtId());
                json.put("PRODUCT_ID", temp.getProductId());
                json.put("SUBS_PRODUCT_ID", temp.getSubsProductId());
                json.put("EXT_NAME", temp.getExtName());
                json.put("EXT_VALUE", temp.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initdel("bl_subscomm_ext", json.toString());
                // ^^meixie
                // ********************************
            } catch (NullPointerException e) {
                throw new BusinessException(ErrorCode.NULL, "产品订购扩展信息不在表中，无法删除");
            }
        } else if ("U".equals(pe.getUpdateFlag())) {
            BlSubscommExt aBlSubscommExt = new BlSubscommExt();
            aBlSubscommExt.setExtValue(pe.getExtValue());
            BlSubscommExtCriteria example = new BlSubscommExtCriteria();
            example.createCriteria().andProductIdEqualTo(productId)
                    .andSubsProductIdEqualTo(subsProductId).andExtNameEqualTo(pe.getExtName());
            try {
//                BlSubscommExt temp = aBlSubscommExtMapper.selectByExample(example).get(0);
                aBlSubscommExtMapper.updateByExampleSelective(aBlSubscommExt, example);
                // 刷新用户扩展信息表的内存表
                // ********************************
                
//                DshmUtil.getIdshmSV().initdel("bl_subscomm_ext", MyJsonUtil.toJson(temp));
                BlSubscommExt temp = aBlSubscommExtMapper.selectByExample(example).get(0);
                JSONObject json = new JSONObject();
                json.put("EXT_ID", temp.getExtId());
                json.put("PRODUCT_ID", temp.getProductId());
                json.put("SUBS_PRODUCT_ID", temp.getSubsProductId());
                json.put("EXT_NAME", temp.getExtName());
                json.put("EXT_VALUE", temp.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initLoader("bl_subscomm_ext", json.toString(),0);
                // ^^meixie
                // ********************************
            } catch (NullPointerException e) {
                throw new BusinessException(ErrorCode.NULL, "产品订购扩展信息不在表中，无法更新");
            }
        } else if ("N".equals(pe.getUpdateFlag())) {
            BlSubscommExt aBlSubscommExt = new BlSubscommExt();
            aBlSubscommExt.setProductId(productId);
            aBlSubscommExt.setSubsProductId(subsProductId);
            aBlSubscommExt.setExtName(pe.getExtName());
            aBlSubscommExt.setExtValue(pe.getExtValue());
            aBlSubscommExtMapper.insertSelective(aBlSubscommExt);
            // 刷新用户扩展信息表的内存表
            // ********************************
            BlSubscommExtCriteria example = new BlSubscommExtCriteria();
            example.createCriteria().andProductIdEqualTo(productId)
                    .andSubsProductIdEqualTo(subsProductId).andExtNameEqualTo(pe.getExtName());
            BlSubscommExt temp = aBlSubscommExtMapper.selectByExample(example).get(0);
            JSONObject json = new JSONObject();
            json.put("EXT_ID", temp.getExtId());
            json.put("PRODUCT_ID", temp.getProductId());
            json.put("SUBS_PRODUCT_ID", temp.getSubsProductId());
            json.put("EXT_NAME", temp.getExtName());
            json.put("EXT_VALUE", temp.getExtValue());
            json.put("TENANT_ID", tenantId);
            DshmUtil.getIdshmSV().initLoader("bl_subscomm_ext", json.toString(),1);
            // ^^meixie
            // ********************************
        }
    }

    // 账户信息表操作
    private void writeAcctInfo(BlUserinfo userinfo) {
        BlAcctInfo aBlAcctInfo = new BlAcctInfo();
        aBlAcctInfo.setAcctId(userinfo.getAcctId());
        aBlAcctInfo.setTenantId(userinfo.getTenantId());
        aBlAcctInfo.setOwnerType("USER");
        aBlAcctInfo.setOwnerId(userinfo.getSubsId());
        // ^^账户名称和账户类型不确定
        aBlAcctInfo.setCreateTime(DateUtil.getTimestamp(System.currentTimeMillis()));
        // ^^说明为空
        aBlAcctInfoMapper.deleteByPrimaryKey(aBlAcctInfo.getAcctId());
        aBlAcctInfoMapper.insertSelective(aBlAcctInfo);
        // 刷新用户扩展信息表的内存表
        // ********************************
        JSONObject json = new JSONObject();
        json.put("acct_id", aBlAcctInfo.getAcctId());
        json.put("tenant_id", aBlAcctInfo.getTenantId());
        json.put("owner_type", aBlAcctInfo.getOwnerType());
        json.put("owner_id", aBlAcctInfo.getOwnerId());
        json.put("acct_name", aBlAcctInfo.getAcctName());
        json.put("acct_type", aBlAcctInfo.getAcctType());
        json.put("create_time", aBlAcctInfo.getCreateTime());
        json.put("comments", aBlAcctInfo.getComments());
//        DshmUtil.getIdshmSV().initdel(TableCon.BL_ACCT_INFO, json.toString());
        DshmUtil.getIdshmSV().initLoader("bl_acct_info", json.toString(),1);
        LoggerUtil.log.debug("刷新账户表共享内存：" + json.toString());
        // ^^^
        // ********************************
    }
    // 账户扩展信息表操作^^目前不使用
    // private void writeAcctInfoExt(BlAcctinfoExt aBlAcctinfoExt){
    //
    // }
}
