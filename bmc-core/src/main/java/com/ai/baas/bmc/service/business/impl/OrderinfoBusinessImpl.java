package com.ai.baas.bmc.service.business.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.apache.hadoop.hbase.client.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.orderinfo.params.ExtInfo;
import com.ai.baas.bmc.api.orderinfo.params.OrderExt;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.api.orderinfo.params.Product;
import com.ai.baas.bmc.api.orderinfo.params.ProductExt;
import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.constants.BmcConstants;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConTradeSeqLog;
import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
import com.ai.baas.bmc.dao.interfaces.BlCustinfoMapper;
import com.ai.baas.bmc.dao.interfaces.BlSubsCommMapper;
import com.ai.baas.bmc.dao.interfaces.BlSubscommExtMapper;
import com.ai.baas.bmc.dao.interfaces.BlUserinfoExtMapper;
import com.ai.baas.bmc.dao.interfaces.BlUserinfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;
import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExt;
import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExtCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoExt;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoExtCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlAcctInfoAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IBlCustinfoAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IBlSubsCommAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IBlSubscommExtAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IBlUserinfoAtomSV;
import com.ai.baas.bmc.service.business.interfaces.IOrderinfoBusiSV;
import com.ai.baas.bmc.util.BmcSeqUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.fastjson.JSON;

@Service
@Transactional
public class OrderinfoBusinessImpl implements IOrderinfoBusiSV {
    private static final Logger LOGGER = LogManager.getLogger(OrderinfoBusinessImpl.class);

    @Autowired
    private transient IBlSubscommExtAtomSV iBlSubscommExtAtomSV;

    @Autowired
    private transient IBlSubsCommAtomSV iBlSubsCommAtomSV;

    @Autowired
    private BlUserinfoExtMapper aBlUserinfoExtMapper;

    @Autowired
    private transient BlAcctInfoMapper blAcctInfoMapper;

    @Autowired
    private transient BlUserinfoMapper blUserinfoMapper;

    @Autowired
    private BlSubsCommMapper aBlSubsCommMapper;

    @Autowired
    private transient BlCustinfoMapper blCustinfoMapper;

    @Autowired
    private BlSubscommExtMapper blSubscommExtMapper;

    @Autowired
    private transient IBlCustinfoAtomSV iBlCustinfoAtomSV;

    @Autowired
    private transient IBlAcctInfoAtomSV iBlAcctInfoAtomSV;

    @Autowired
    private transient IBlUserinfoAtomSV iBlUserinfoAtomSV;

    @Override
    public boolean hasSeq(OrderInfoParams record) throws IOException {
        String rowkey = record.getTenantId() + Context.SPLIT + Context.ORDER_INFO_CODE
                + Context.SPLIT + record.getTradeSeq();
        Table table = MyHbaseUtil.getTable(TableCon.TRADE_SEQ_LOG);

        if (MyHbaseUtil.hasExists(table, rowkey)) {
            return true;
        }
        MyHbaseUtil.addData(
                table,
                rowkey,
                CellTemp.inst(ConTradeSeqLog.TENANT_ID, record.getTenantId()),
                CellTemp.inst(ConTradeSeqLog.INTERFACE_CODE, Context.ORDER_INFO_CODE),
                CellTemp.inst(ConTradeSeqLog.TRADE_SEQ, record.getTradeSeq()),
                CellTemp.inst(ConTradeSeqLog.RECEIVE_TIME,
                        DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
                CellTemp.inst(ConTradeSeqLog.MSG_CONTENT, MyJsonUtil.toJson(record)));
        return false;
    }

    @Override
    public void writeData(OrderInfoParams request) {
        // 解析参数
        String tenantId = request.getTenantId();
        String extCustId = request.getExtCustId();
        String serviceId = request.getServiceId();

        Timestamp sysdate = DateUtil.getSysDate();

        // 查询用户信息
        String custId = null;
        String subsId = null;
        String acctId = null;
        Map<String, String> params = new TreeMap<String, String>();
        params.put("service_id", serviceId);
        params.put("tenant_id", tenantId);
        List<Map<String, String>> result = DshmUtil.getClient().list("bl_userinfo").where(params)
                .executeQuery(DshmUtil.getCacheClient());

        // 按生失效时间获取有效记录
        if (!CollectionUtil.isEmpty(result)) {
            for (Map<String, String> r : result) {
                if (!r.isEmpty()) {
                    if (DateUtil.getTimestamp(
                            Long.parseLong(r.get(BmcCacheConstant.Dshm.FieldName.ACTIVE_TIME)))
                            .before(sysdate)
                            && DateUtil.getTimestamp(
                                    Long.parseLong(r
                                            .get(BmcCacheConstant.Dshm.FieldName.INACTIVE_TIME)))
                                    .after(sysdate)) {
                        subsId = r.get("subs_id");
                        acctId = r.get("acct_id");
                        break;
                    }
                }
            }
        }

        if (StringUtil.isBlank(subsId)) {
            // 用户不存在，需新建用户
            // 查询客户信息
            params = new TreeMap<String, String>();
            params.put(BmcCacheConstant.Dshm.FieldName.EXT_CUST_ID, extCustId);
            params.put(BmcCacheConstant.Dshm.FieldName.TENANT_ID, tenantId);
            result = DshmUtil.getClient().list(BmcCacheConstant.Dshm.TableName.BL_CUSTINFO)
                    .where(params).executeQuery(DshmUtil.getCacheClient());

            if (CollectionUtil.isEmpty(result)) {
                // 客户不存在，新建
                BlCustinfo blCustinfo = new BlCustinfo();
                custId = BmcSeqUtil.getCustId();
                blCustinfo.setCustId(custId);
                blCustinfo.setTenantId(tenantId);
                blCustinfo.setExtCustId(extCustId);
                blCustinfo.setCustName(custId);
                blCustinfo.setState(BmcConstants.BlCustinfo.State.NORMAL);
                blCustinfo.setStateChgTime(sysdate);
                blCustinfoMapper.insertSelective(blCustinfo);
                // 写入缓存
                iBlCustinfoAtomSV.addDshmData(blCustinfo);
            } else {
                custId = result.get(0).get(BmcCacheConstant.Dshm.FieldName.CUST_ID);
            }
            // 查询账户信息
            BlAcctInfoCriteria blAcctInfoCriteria = new BlAcctInfoCriteria();
            blAcctInfoCriteria.createCriteria().andTenantIdEqualTo(tenantId)
                    .andOwnerTypeEqualTo(BmcConstants.BlAcctInfo.OwnerType.CUST)
                    .andOwnerIdEqualTo(custId);
            List<BlAcctInfo> blAcctInfos = blAcctInfoMapper.selectByExample(blAcctInfoCriteria);
            if (CollectionUtil.isEmpty(blAcctInfos)) {
                // 账户不存在，创建账户
                acctId = BmcSeqUtil.getAcctId();
                BlAcctInfo blAcctInfo = new BlAcctInfo();
                blAcctInfo.setTenantId(tenantId);
                blAcctInfo.setAcctId(acctId);
                blAcctInfo.setOwnerType(BmcConstants.BlAcctInfo.OwnerType.CUST);
                blAcctInfo.setOwnerId(custId);
                blAcctInfo.setCreateTime(sysdate);
                blAcctInfoMapper.insertSelective(blAcctInfo);
                // 写入缓存
                iBlAcctInfoAtomSV.addDshmData(blAcctInfo);
            } else {
                acctId = blAcctInfos.get(0).getAcctId();
            }
            // 新增用户信息表
            BlUserinfo blUserinfo = new BlUserinfo();
            blUserinfo.setTenantId(tenantId);
            blUserinfo.setCustId(custId);
            subsId = BmcSeqUtil.getSubsId();
            blUserinfo.setSubsId(subsId);
            blUserinfo.setAcctId(acctId);
            blUserinfo.setServiceId(serviceId);
            if (!StringUtil.isBlank(request.getOrderTime())) {
                blUserinfo.setDealTime(DateUtil.getTimestamp(request.getOrderTime(),
                        DateUtil.YYYYMMDDHHMMSS));
            }
            blUserinfo.setActiveTime(DateUtil.getTimestamp(StringUtil.isBlank(request
                    .getActiveTime()) ? "20160101120000" : request.getActiveTime(),
                    DateUtil.YYYYMMDDHHMMSS));
            blUserinfo.setInactiveTime(DateUtil.getTimestamp(StringUtil.isBlank(request
                    .getInactiveTime()) ? "20990101120000" : request.getInactiveTime(),
                    DateUtil.YYYYMMDDHHMMSS));
            blUserinfo.setProvinceCode(request.getProvinceCode());
            blUserinfo.setCityCode(request.getCityCode());
            blUserinfo.setChlId(request.getChlId());
            blUserinfo.setDevId(request.getDevId());
            blUserinfo.setRemark(request.getRemark());
            blUserinfo.setUserType(request.getUsetype());
            blUserinfo.setUserState(request.getState());
            blUserinfoMapper.insertSelective(blUserinfo);
            // 写入缓存
            iBlUserinfoAtomSV.addDshmData(blUserinfo);
        }
        // 处理用户扩展信息表
        if (!CollectionUtil.isEmpty(request.getOrderExtInfo())) {
            for (OrderExt orderExt : request.getOrderExtInfo()) {
                writeBlUserinfoExt(subsId, orderExt, tenantId);
            }
        }

        // 当产品列表不为空时，循环插入产品表
        if (request.getProductList() != null) {
            for (Product p : request.getProductList()) {
                writeBlSubsComm(p, tenantId, custId, subsId, request.getSublist());
            }
        }

    }

    // 用户扩展信息表操作
    private void writeBlUserinfoExt(String subsId, OrderExt orderExt, String tenantId) {
        if (OrderExt.UpdateFlag.D.equals(orderExt.getUpdateFlag())) {
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            // 查出要删除的记录
            List<BlUserinfoExt> blUserinfoExts = aBlUserinfoExtMapper.selectByExample(example);
            for (BlUserinfoExt blUserinfoExt : blUserinfoExts) {
                // 刷新用户扩展信息表的内存表
                JSONObject json = new JSONObject();
                json.put("EXT_ID", blUserinfoExt.getExtId());
                json.put("SUBS_ID", blUserinfoExt.getSubsId());
                json.put("EXT_NAME", blUserinfoExt.getExtName());
                json.put("EXT_VALUE", blUserinfoExt.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initdel("bl_userinfo_ext", json.toString());
            }
            aBlUserinfoExtMapper.deleteByExample(example);

        } else if ("U".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            List<BlUserinfoExt> blUserinfoExts = aBlUserinfoExtMapper.selectByExample(example);
            for (BlUserinfoExt blUserinfoExt : blUserinfoExts) {
                blUserinfoExt.setExtValue(orderExt.getExtValue());
                aBlUserinfoExtMapper.updateByPrimaryKey(blUserinfoExt);

                JSONObject json = new JSONObject();
                json.put("EXT_ID", blUserinfoExt.getExtId());
                json.put("SUBS_ID", blUserinfoExt.getSubsId());
                json.put("EXT_NAME", blUserinfoExt.getExtName());
                json.put("EXT_VALUE", blUserinfoExt.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initLoader("bl_userinfo_ext", json.toString(), 0);
            }
        } else if ("N".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExtCriteria check = new BlUserinfoExtCriteria();
            check.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            List<BlUserinfoExt> blUserinfoExtCheck = aBlUserinfoExtMapper.selectByExample(check);
            if (!CollectionUtil.isEmpty(blUserinfoExtCheck)) {
                LOGGER.error("用户扩展信息已存在[subs_id：" + subsId + ", ext_name:" + orderExt.getExtName()
                        + "]");
                throw new BusinessException("用户扩展信息已存在[subs_id：" + subsId + ", ext_name:"
                        + orderExt.getExtName() + "]");
            }
            System.err.println("新增BlUserInfoExt表信息");
            BlUserinfoExt aBlUserinfoExt = new BlUserinfoExt();
            aBlUserinfoExt.setSubsId(subsId);

            aBlUserinfoExt.setExtName(orderExt.getExtName());
            aBlUserinfoExt.setExtValue(orderExt.getExtValue());
            aBlUserinfoExtMapper.insertSelective(aBlUserinfoExt);
            // 刷新用户扩展信息表的内存表
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
            DshmUtil.getIdshmSV().initLoader("bl_userinfo_ext", json.toString(), 1); // redis 0更新
                                                                                     // 1插入

        }
    }

    // 产品订购信息表操作
    private void writeBlSubsComm(Product product, String tenantId, String custId, String subsId,
            List<ExtInfo> extInfos) {
        System.err.println("BlSubsComm有 " + product.getProductNumber() + " 个相同的产品");
        for (int i = 0; i < product.getProductNumber(); i++) {
            String subsProductId = StringUtil.isBlank(product.getSubsProductId()) ? BmcSeqUtil
                    .getSubsProductId() : product.getSubsProductId();
            String productId = product.getProductId();

            BlSubsComm aBlSubsComm = new BlSubsComm();
            aBlSubsComm.setActiveTime(DateUtil.getTimestamp(product.getActiveTime(),
                    DateUtil.YYYYMMDDHHMMSS));
            aBlSubsComm.setInactiveTime(DateUtil.getTimestamp(product.getInactiveTime(),
                    DateUtil.YYYYMMDDHHMMSS));
            aBlSubsComm.setSubsId(subsId);
            aBlSubsComm.setSubsProductId(subsProductId);
            aBlSubsComm.setProductId(productId);
            aBlSubsComm.setResBonusFlag(product.getResBonusFlag());
            aBlSubsComm.setTenantId(tenantId);
            aBlSubsComm.setCustId(custId);
            aBlSubsComm.setProductType(product.getProductType());
            aBlSubsCommMapper.insertSelective(aBlSubsComm);
            // 刷新产品订购信息的内存表
            iBlSubsCommAtomSV.addDshmData(aBlSubsComm);
            // 如果产品订购扩展信息不为空则对产品订购扩展信息表进行操作
            if (product.getProductExtInfoList() != null) {
                for (ProductExt productExt : product.getProductExtInfoList()) {

                    if ("D".equals(productExt.getUpdateFlag())) {
                        System.err.println("删除 BlSubsCommExt表");
                        BlSubscommExtCriteria example = new BlSubscommExtCriteria();
                        example.createCriteria().andProductIdEqualTo(productId)
                                .andSubsProductIdEqualTo(subsProductId)
                                .andExtNameEqualTo(productExt.getExtName());
                        List<BlSubscommExt> blSubscommExts = blSubscommExtMapper
                                .selectByExample(example);
                        for (BlSubscommExt blSubscommExt : blSubscommExts) {
                            JSONObject json = new JSONObject();
                            json.put("EXT_ID", blSubscommExt.getExtId());
                            json.put("PRODUCT_ID", blSubscommExt.getProductId());
                            json.put("EXT_NAME", blSubscommExt.getExtName());
                            json.put("EXT_VALUE", blSubscommExt.getExtValue());
                            json.put("TENANT_ID", tenantId);
                            DshmUtil.getIdshmSV().initdel("bl_subscomm_ext", json.toString());
                        }
                        blSubscommExtMapper.deleteByExample(example);
                    } else if ("U".equals(productExt.getUpdateFlag())) {
                        System.err.println("更新 BlSubsCommExt表");
                        System.err.println("productId  " + product + ","
                                + JSON.toJSONString(productExt));
                        BlSubscommExtCriteria example = new BlSubscommExtCriteria();
                        example.createCriteria().andProductIdEqualTo(productId)
                                .andSubsProductIdEqualTo(subsProductId)
                                .andExtNameEqualTo(productExt.getExtName());
                        // 刷新用户扩展信息表的内存表
                        List<BlSubscommExt> blSubsExtList = blSubscommExtMapper
                                .selectByExample(example);
                        if (blSubsExtList.size() == 0) {
                            System.err.println("BlSubscommExt表中无数据，更新失败");
                        }
                        BlSubscommExt temp = blSubsExtList.get(0);
                        temp.setExtValue(productExt.getExtValue());
                        blSubscommExtMapper.updateByExampleSelective(temp, example);
                        JSONObject json = new JSONObject();
                        json.put("EXT_ID", temp.getExtId());
                        json.put("PRODUCT_ID", temp.getProductId());
                        json.put("SUBS_PRODUCT_ID", temp.getSubsProductId());
                        json.put("EXT_NAME", temp.getExtName());
                        json.put("EXT_VALUE", temp.getExtValue());
                        json.put("TENANT_ID", tenantId);
                        DshmUtil.getIdshmSV().initLoader("bl_subscomm_ext", json.toString(), 0);

                    } else if ("N".equals(productExt.getUpdateFlag())) {
                        System.err.println("新增 BlSubsCommExt表");
                        System.err.println("productId  " + product + "," + "ProductExt :"
                                + JSON.toJSONString(productExt));
                        BlSubscommExt blSubscommExt = new BlSubscommExt();
                        blSubscommExt.setExtId(BmcSeqUtil.getSubscommExtId());
                        blSubscommExt.setProductId(productId);
                        blSubscommExt.setSubsProductId(subsProductId);
                        blSubscommExt.setSubsId(subsId);
                        blSubscommExt.setExtName(productExt.getExtName());
                        blSubscommExt.setExtValue(productExt.getExtValue());
                        blSubscommExtMapper.insertSelective(blSubscommExt);
                        // 刷新用户扩展信息表的内存表
                        iBlSubscommExtAtomSV.addDshmData(blSubscommExt);
                    }

                }
            }
            if (!CollectionUtil.isEmpty(extInfos)) {
                for (ExtInfo extInfo : extInfos) {

                    BlSubscommExt blSubscommExt = new BlSubscommExt();
                    blSubscommExt.setExtId(BmcSeqUtil.getSubscommExtId());
                    blSubscommExt.setProductId(productId);
                    blSubscommExt.setSubsProductId(subsProductId);
                    blSubscommExt.setSubsId(subsId);
                    blSubscommExt.setExtName(extInfo.getExtType());
                    blSubscommExt.setExtValue(JSON.toJSONString(extInfo.getInfolist()));
                    blSubscommExtMapper.insertSelective(blSubscommExt);
                    // 刷新用户扩展信息表的内存表
                    iBlSubscommExtAtomSV.addDshmData(blSubscommExt);

                }
            }
        }

    }
}
