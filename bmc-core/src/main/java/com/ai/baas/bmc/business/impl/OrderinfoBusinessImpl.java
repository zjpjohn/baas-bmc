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
import com.ai.baas.bmc.context.TableCon.ConBlCustinfo;
import com.ai.baas.bmc.context.TableCon.ConBlSubsComm;
import com.ai.baas.bmc.context.TableCon.ConBlUserinfo;
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
import com.ai.runner.center.dshm.api.dshmservice.interfaces.IdshmreadSV;

@Service
@Transactional
public class OrderinfoBusinessImpl implements IOrderinfoBusiness {
    @Autowired
    private BlUserinfoMapper aBlUserinfoMapper;

    @Autowired
    private BlUserinfoExtMapper aBlUserinfoExtMapper;

    @Autowired
    private BlAcctInfoMapper aBlAcctInfoMapper;

//    @Autowired
//    private BlAcctinfoExtMapper aBlAcctinfoExtMapper;

    @Autowired
    private BlSubsCommMapper aBlSubsCommMapper;

    @Autowired
    private BlSubscommExtMapper aBlSubscommExtMapper;

    @Autowired
    private ISysSequenceSvc aISysSequenceSvc;

    // 远程调用缓存接口
//    private IdshmSV dshmSV = DubboConsumerFactory.getService("IdshmSV", IdshmSV.class);

    @Override
    public boolean hasSeq(OrderInfoParams record) throws IOException {
        String rowkey = record.getTradeSeq();
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
    public void writeData(OrderInfoParams record) {
        BlUserinfo aBlUserinfo = writeBlUserinfo(record);
        // 当产品列表不为空时，循环插入产品表
        if (record.getProductList() != null) {
            for (Product p : record.getProductList()) {
                writeBlSubsComm(aBlUserinfo, p);
            }
        }
        // 根据用户信息创建账户信息
        writeAcctInfo(aBlUserinfo);

    }

    // 用户信息表操作,成功返回用户信息
    private BlUserinfo writeBlUserinfo(OrderInfoParams record) {
        // 通过缓存获得内部的custId
        IdshmreadSV dshmread = DshmUtil.getDshmread();
        Map<String, String> params = new TreeMap<String, String>();
        params.put(ConBlCustinfo.EXT_CUST_ID, record.getExtCustId());
        List<Map<String, String>> result = dshmread.list(TableCon.BL_CUSTINFO).where(params)
                .executeQuery();
        // 获得对应的内部的custId
        if (result == null || result.isEmpty()) {
            LoggerUtil.log.debug("内存查custId为找到，EXT_CUST_ID为" + record.getExtCustId());
            throw new BusinessException(ErrorCode.NULL, "客户不存在");
        }
        String custIds[] = result.get(0).get(ConBlCustinfo.CUST_ID).split("#");
        // 设置插入用户表模板
        BlUserinfo aBluserinfo = new BlUserinfo();
        aBluserinfo.setCustId(custIds[custIds.length - 1]);
        aBluserinfo.setTenantId(record.getTenantId());
        // subsId调用序列
        aBluserinfo
                .setSubsId(aISysSequenceSvc.terrigerSysSequence(ConBlUserinfo.SUBS_ID, 1).get(0));
        aBluserinfo.setActiveTime(
                DateUtil.getTimestamp(record.getActiveTime(), DateUtil.YYYYMMDDHHMMSS));
        // acctId调用序列
        aBluserinfo
                .setAcctId(aISysSequenceSvc.terrigerSysSequence(ConBlUserinfo.ACCT_ID, 1).get(0));
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

        aBlUserinfoMapper.insert(aBluserinfo);
        // 刷新用户的内存表
        // ********************************
        // ^^meixie
        // ********************************
        // 当扩展信息为空退出，否则循环操作用户扩展信息
        if (record.getOrderExtInfo() != null) {
            for (OrderExt o : record.getOrderExtInfo()) {
                writeBlUserinfoExt(aBluserinfo.getSubsId(), o);
            }
        }
        return aBluserinfo;
    }

    // 用户扩展信息表操作
    private void writeBlUserinfoExt(String subsId, OrderExt orderExt) {
        if ("D".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            aBlUserinfoExtMapper.deleteByExample(example);
            // 刷新用户扩展信息表的内存表
            // ********************************
            // ^^meixie
            // ********************************
        } else if ("U".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExt aBlUserinfoExt = new BlUserinfoExt();
            aBlUserinfoExt.setExtValue(orderExt.getExtValue());
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            aBlUserinfoExtMapper.updateByExample(aBlUserinfoExt, example);
            // 刷新用户扩展信息表的内存表
            // ********************************
            // ^^meixie
            // ********************************
        } else if ("N".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExt aBlUserinfoExt = new BlUserinfoExt();
            aBlUserinfoExt.setSubsId(subsId);
            aBlUserinfoExt.setExtName(orderExt.getExtName());
            aBlUserinfoExt.setExtValue(orderExt.getExtValue());
            aBlUserinfoExtMapper.insert(aBlUserinfoExt);
            // 刷新用户扩展信息表的内存表
            // ********************************
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
                    aISysSequenceSvc.terrigerSysSequence(ConBlSubsComm.SUBS_PRODUCT_ID, 1).get(0));
            aBlSubsComm.setActiveTime(
                    DateUtil.getTimestamp(product.getActiveTime(), DateUtil.YYYYMMDDHHMMSS));
            aBlSubsComm.setProductId(product.getProductId());
            aBlSubsComm.setResBonusFlag(product.getResBonusFlag());
            aBlSubsComm.setInactiveTime(
                    DateUtil.getTimestamp(product.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS));
            aBlSubsComm.setTenantId(userInfo.getTenantId());
            aBlSubsComm.setCustId(userInfo.getCustId());
            aBlSubsCommMapper.insert(aBlSubsComm);
            // 刷新产品订购信息的内存表
            // ********************************
            // ^^meixie
            // ********************************
            // 如果产品订购扩展信息不为空则对产品订购扩展信息表进行操作
            if (product.getProductExtInfoList() != null) {
                for (ProductExt pe : product.getProductExtInfoList()) {
                    writeBlSubsCommExt(aBlSubsComm.getProductId(), aBlSubsComm.getSubsProductId(),
                            pe);
                }
            }
        }
    }

    // 产品订购扩展信息表操作
    private void writeBlSubsCommExt(String productId, String subsProductId, ProductExt pe) {
        if ("D".equals(pe.getUpdateFlag())) {
            BlSubscommExtCriteria example = new BlSubscommExtCriteria();
            example.createCriteria().andProductIdEqualTo(productId)
                    .andSubsProductIdEqualTo(subsProductId).andExtNameEqualTo(pe.getExtName());
            aBlSubscommExtMapper.deleteByExample(example);
            // 刷新用户扩展信息表的内存表
            // ********************************
            // ^^meixie
            // ********************************
        } else if ("U".equals(pe.getUpdateFlag())) {
            BlSubscommExt aBlSubscommExt = new BlSubscommExt();
            aBlSubscommExt.setExtValue(pe.getExtValue());
            BlSubscommExtCriteria example = new BlSubscommExtCriteria();
            example.createCriteria().andProductIdEqualTo(productId)
                    .andSubsProductIdEqualTo(subsProductId).andExtNameEqualTo(pe.getExtName());
            aBlSubscommExtMapper.updateByExample(aBlSubscommExt, example);
            // 刷新用户扩展信息表的内存表
            // ********************************
            // ^^meixie
            // ********************************
        } else if ("N".equals(pe.getUpdateFlag())) {
            BlSubscommExt aBlSubscommExt = new BlSubscommExt();
            aBlSubscommExt.setProductId(productId);
            aBlSubscommExt.setSubsProductId(subsProductId);
            aBlSubscommExt.setExtName(pe.getExtName());
            aBlSubscommExt.setExtValue(pe.getExtValue());
            aBlSubscommExtMapper.insert(aBlSubscommExt);
            // 刷新用户扩展信息表的内存表
            // ********************************
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
        aBlAcctInfoMapper.insert(aBlAcctInfo);
        // 刷新用户扩展信息表的内存表
        // ********************************
        // ^^meixie
        // ********************************
    }
    // 账户扩展信息表操作^^目前不使用
    // private void writeAcctInfoExt(BlAcctinfoExt aBlAcctinfoExt){
    //
    // }
}
