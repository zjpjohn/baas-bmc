package com.ai.baas.bmc.service.business.impl;
//package com.ai.baas.bmc.business.impl;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ai.baas.bmc.api.orderrequest.params.OrderRequestInfo;
//import com.ai.baas.bmc.api.orderrequest.params.OrderTypeInfo;
//import com.ai.baas.bmc.api.orderrequest.params.ResponseMessage;
//import com.ai.baas.bmc.business.interfaces.IOrderRequestBusiSV;
//import com.ai.baas.bmc.constants.BmcConstants;
//import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
//import com.ai.baas.bmc.dao.interfaces.BlCustinfoMapper;
//import com.ai.baas.bmc.dao.interfaces.BlUserinfoMapper;
//import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
//import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
//import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
//import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfoCriteria;
//import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;
//import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoCriteria;
//import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
//import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoCriteria;
//import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
//import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
//import com.ai.baas.bmc.util.BmcSeqUtil;
//import com.ai.baas.bmc.util.BusinessUtil;
//import com.ai.opt.base.exception.SystemException;
//import com.ai.opt.sdk.util.CollectionUtil;
//import com.ai.opt.sdk.util.DateUtil;
//
//@Component
//@Transactional
//public class OrderRequestBusiSVImpl implements IOrderRequestBusiSV {
//    @Autowired
//    private transient BlUserinfoMapper blUserinfoMapper;
//
//    @Autowired
//    private transient BlCustinfoMapper blCustinfoMapper;
//
//    @Autowired
//    private transient BlAcctInfoMapper blAcctInfoMapper;
//
//    @Autowired
//    private transient CpPriceInfoMapper cpPriceInfoMapper;
//
//    @Autowired
//    private transient CpPriceDetailMapper cpPriceDetailMapper;
//
//    @Override
//    public ResponseMessage orderRequest(OrderRequestInfo request) {
//        // 参数解析
//        String tenantId = request.getTenantId();
//        String serviceId = request.getServiceId();
//
//        Timestamp sysdate = DateUtil.getSysDate();
//
//        BlUserinfoCriteria blUserinfoCriteria = new BlUserinfoCriteria();
//        blUserinfoCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
//                .andServiceIdEqualTo(serviceId).andActiveTimeLessThan(sysdate)
//                .andInactiveTimeGreaterThanOrEqualTo(sysdate);
//        // 查询当前服务标识的用户信息
//        List<BlUserinfo> blUserinfos = blUserinfoMapper.selectByExample(blUserinfoCriteria);
//        if (CollectionUtil.isEmpty(blUserinfos)) {
//            // 查询客户信息
//            BlCustinfoCriteria blCustinfoCriteria = new BlCustinfoCriteria();
//            String extCustId = request.getExtCustId();
//            blCustinfoCriteria.createCriteria().andTenantIdEqualTo(tenantId)
//                    .andExtCustIdEqualTo(extCustId);
//            List<BlCustinfo> blCustinfos = blCustinfoMapper.selectByExample(blCustinfoCriteria);
//            String custId;
//            if (CollectionUtil.isEmpty(blCustinfos)) {
//                // 客户不存在，新建客户信息
//                BlCustinfo blCustinfo = new BlCustinfo();
//                custId = BmcSeqUtil.getCustId();
//                blCustinfo.setCustId(custId);
//                blCustinfo.setTenantId(tenantId);
//                blCustinfo.setExtCustId(extCustId);
//                blCustinfoMapper.insertSelective(blCustinfo);
//            } else {
//                custId = blCustinfos.get(0).getCustId();
//            }
//            // 查询账户信息
//            BlAcctInfoCriteria blAcctInfoCriteria = new BlAcctInfoCriteria();
//            blAcctInfoCriteria.createCriteria().andTenantIdEqualTo(tenantId)
//                    .andOwnerTypeEqualTo(BmcConstants.BlAcctInfo.OwnerType.CUST)
//                    .andOwnerIdEqualTo(custId);
//            List<BlAcctInfo> blAcctInfos = blAcctInfoMapper.selectByExample(blAcctInfoCriteria);
//            String acctId;
//            if (CollectionUtil.isEmpty(blAcctInfos)) {
//                // 账户不存在，创建账户
//                acctId = BmcSeqUtil.getAcctId();
//                BlAcctInfo blAcctInfo = new BlAcctInfo();
//                blAcctInfo.setTenantId(tenantId);
//                blAcctInfo.setAcctId(acctId);
//                blAcctInfo.setOwnerType(BmcConstants.BlAcctInfo.OwnerType.CUST);
//                blAcctInfo.setOwnerId(custId);
//                blAcctInfo.setCreateTime(sysdate);
//                blAcctInfoMapper.insertSelective(blAcctInfo);
//            } else {
//                acctId = blAcctInfos.get(0).getAcctId();
//            }
//            // 新增用户信息表
//            BlUserinfo blUserinfo = new BlUserinfo();
//            blUserinfo.setTenantId(tenantId);
//            blUserinfo.setCustId(custId);
//            blUserinfo.setSubsId(BmcSeqUtil.getSubsId());
//            blUserinfo.setAcctId(acctId);
//            blUserinfo.setServiceId(serviceId);
//            blUserinfo.setDealTime(sysdate);
//            blUserinfo.setActiveTime(sysdate);
//            blUserinfo.setRemark("订购请求创建用户");
//            blUserinfoMapper.insertSelective(blUserinfo);
//        }
//        for (OrderTypeInfo orderTypeInfo : request.getOrderTypeList()) {
//            // 保存资费信息表
//            String priceCode = BmcSeqUtil.getPriceCode();
//            String chargeType = BusinessUtil.getChargeTypeByPriceType(orderTypeInfo.getPriceType());
//            CpPriceInfo cpPriceInfo = new CpPriceInfo();
//            cpPriceInfo.setTenantId(tenantId);
//            cpPriceInfo.setPriceCode(priceCode);
//            cpPriceInfo.setActiveTime(DateUtil.getTimestamp("20150101", DateUtil.YYYYMMDD));
//            cpPriceInfo.setInactiveTime(DateUtil.getTimestamp("20300101", DateUtil.YYYYMMDD));
//            cpPriceInfo.setCreateTime(sysdate);
//            cpPriceInfo.setActiveStatus(BmcConstants.CpPriceInfo.ActiveStatus.ACTIVE);
//            cpPriceInfo.setChargeType(chargeType);
//            cpPriceInfoMapper.insertSelective(cpPriceInfo);
//            // 保存资费计划明细
//            String detailCode = BmcSeqUtil.getDetailCode();
//            CpPriceDetail cpPriceDetail = new CpPriceDetail();
//            cpPriceDetail.setPriceCode(priceCode);
//            cpPriceDetail.setChargeType(chargeType);
//            cpPriceDetail.setActiveTime(DateUtil.getTimestamp("20150101", DateUtil.YYYYMMDD));
//            cpPriceDetail.setInactiveTime(DateUtil.getTimestamp("20300101", DateUtil.YYYYMMDD));
//            cpPriceDetail.setDetailCode(detailCode);
//            cpPriceDetailMapper.insertSelective(cpPriceDetail);
//            // 根据chargeType不同保存相关表
//            if (BmcConstants.CpPriceInfo.ChargeType.CUNIT.equals(chargeType)) {
//                // 保存复合单价列表
//
//            } else if (BmcConstants.CpPriceInfo.ChargeType.PACKAGE.equals(chargeType)) {
//
//            } else {
//                throw new SystemException("暂不支持该计费类型[" + chargeType + "]");
//            }
//        }
//        return null;
//    }
//
//}
