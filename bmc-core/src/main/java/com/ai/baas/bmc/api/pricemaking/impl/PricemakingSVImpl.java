package com.ai.baas.bmc.api.pricemaking.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.pricemaking.interfaces.IPricemakingSV;
import com.ai.baas.bmc.api.pricemaking.params.Cost;
import com.ai.baas.bmc.api.pricemaking.params.CostInfo;
import com.ai.baas.bmc.api.pricemaking.params.ElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.ExtInfo;
import com.ai.baas.bmc.api.pricemaking.params.FeeInfo;
import com.ai.baas.bmc.api.pricemaking.params.OrderTypeInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.PriceInfo;
import com.ai.baas.bmc.api.pricemaking.params.PricemakingResponseZX;
import com.ai.baas.bmc.api.pricemaking.params.ResponseMessage;
import com.ai.baas.bmc.api.pricemaking.params.ShoppingList;
import com.ai.baas.bmc.constants.BmcConstants;
import com.ai.baas.bmc.service.business.interfaces.IPricemakingBusiSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service
public class PricemakingSVImpl implements IPricemakingSV {
    @Autowired
    private IPricemakingBusiSV iPricemakingBusiSV;

    @Override
    public PricemakingResponseZX queryPricemakingZX(PriceElementInfoZX request)
            throws BusinessException, SystemException {
        if (request == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求报文为空为空");
        }
        if (CollectionUtil.isEmpty(request.getShopping_lists())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "购买的清单不能为空");
        }
        for (ShoppingList shoppingList : request.getShopping_lists()) {
            if (StringUtil.isBlank(shoppingList.getService_id())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                        "service_id不能为空");
            }
            if (StringUtil.isBlank(shoppingList.getParameters())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                        "parameters不能为空");
            }
        }
        List<CostInfo> detail_costs = new ArrayList<CostInfo>();
        for (ShoppingList shoppingList : request.getShopping_lists()) {
            // 参数转换
            PriceElementInfo priceElementInfo = assembleRequest(shoppingList);
            // 业务层实现
            List<PriceInfo> priceInfoList = iPricemakingBusiSV.queryPricemaking(priceElementInfo);
            // 参数转换
            List<CostInfo> detail_costs1 = assembleResponse(priceInfoList);
            detail_costs.addAll(detail_costs1);
        }

        PricemakingResponseZX response = new PricemakingResponseZX();
        response.setResponseHeader(new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS,
                "成功"));
        response.setDetail_costs(detail_costs);
        return response;
    }

    private List<CostInfo> assembleResponse(List<PriceInfo> priceInfoList) {
        Cost cost1 = new Cost();
        for (PriceInfo priceInfo : priceInfoList) {
            for (FeeInfo feeInfo : priceInfo.getFeeInfos()) {
                if (StringUtil.isBlank(cost1.getCost_value())) {
                    cost1.setCost_value(feeInfo.getPrice());
                } else {
                    cost1.setCost_value(String.valueOf(Double.parseDouble(cost1.getCost_value())
                            + Double.parseDouble(feeInfo.getPrice())));
                }
                cost1.setCost_name(feeInfo.getPriceDesc());
                cost1.setCost_unit("元");
            }

        }

        List<Cost> cost = new ArrayList<Cost>();
        cost.add(cost1);

        CostInfo costInfo = new CostInfo();
        costInfo.setList_id(priceInfoList.get(0).getListId());
        costInfo.setCost(cost);

        List<CostInfo> costInfos = new ArrayList<CostInfo>();
        costInfos.add(costInfo);

        return costInfos;
    }

    private PriceElementInfo assembleRequest(ShoppingList shoppingList) {
        List<OrderTypeInfo> orderTypeList = new ArrayList<OrderTypeInfo>();
        String service_id = shoppingList.getService_id();
        if (BmcConstants.ZxServiceId.ECS.equals(service_id)) {
            assembleEcsPriceElementInfo(orderTypeList, shoppingList);
        } else if (BmcConstants.ZxServiceId.RDS.equals(service_id)) {
            List<ElementInfo> elementInfoList = new ArrayList<ElementInfo>();
            @SuppressWarnings("unchecked")
            Map<String, String> map = (Map<String, String>) JSON
                    .parse(shoppingList.getParameters());
            for (Entry<String, String> entry : map.entrySet()) {
                ElementInfo elementInfo = new ElementInfo();
                elementInfo.setName(entry.getKey());
                elementInfo.setValue(entry.getValue());
                elementInfoList.add(elementInfo);
            }
            OrderTypeInfo orderTypeInfo = new OrderTypeInfo();
            String listId = shoppingList.getList_id();
            orderTypeInfo.setListId(listId);
            orderTypeInfo.setElementInfoList(elementInfoList);
            orderTypeInfo
                    .setPriceType(BmcConstants.CpPricemakingFactor.PriceProductType.RDS);
            orderTypeList.add(orderTypeInfo);
        } else if (BmcConstants.ZxServiceId.CS.equals(service_id)) {
        } else if (BmcConstants.ZxServiceId.OSS.equals(service_id)) {
        } else if (BmcConstants.ZxServiceId.ONS.equals(service_id)) {
        } else if (BmcConstants.ZxServiceId.KVS.equals(service_id)) {
            List<ElementInfo> elementInfoList = new ArrayList<ElementInfo>();
            @SuppressWarnings("unchecked")
            Map<String, String> map = (Map<String, String>) JSON
                    .parse(shoppingList.getParameters());
            for (Entry<String, String> entry : map.entrySet()) {
                ElementInfo elementInfo = new ElementInfo();
                elementInfo.setName(entry.getKey());
                elementInfo.setValue(entry.getValue());
                elementInfoList.add(elementInfo);
            }
            OrderTypeInfo orderTypeInfo = new OrderTypeInfo();
            String listId = shoppingList.getList_id();
            orderTypeInfo.setListId(listId);
            orderTypeInfo.setElementInfoList(elementInfoList);
            orderTypeInfo
                    .setPriceType(BmcConstants.CpPricemakingFactor.PriceProductType.KVS);
            orderTypeList.add(orderTypeInfo);
        } else {
            throw new BusinessException("暂不支持此类定价:[" + service_id + "]");
        }

        PriceElementInfo priceElementInfo = new PriceElementInfo();
        priceElementInfo.setTenantId(BmcConstants.TenantId.ZX);
        priceElementInfo.setOrderTypeList(orderTypeList);
        return priceElementInfo;
    }

    private void assembleEcsPriceElementInfo(List<OrderTypeInfo> orderTypeList,
            ShoppingList shoppingList) {
        String listId = shoppingList.getList_id();
        // 实例（一个）
        List<ElementInfo> elementInfoList = new ArrayList<ElementInfo>();
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) JSON.parse(shoppingList.getParameters());
        for (Entry<String, String> entry : map.entrySet()) {
            if (BmcConstants.CpPricemakingFactor.FactorName.REGION_ID.equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.INSTANCE_TYPE.equals(entry
                            .getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.INSTANCE_CHARGE_TYPE
                            .equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.PERIOD.equals(entry.getKey())) {
                ElementInfo elementInfo = new ElementInfo();
                elementInfo.setName(entry.getKey());
                elementInfo.setValue(entry.getValue());
                elementInfoList.add(elementInfo);
            }
        }
        OrderTypeInfo orderTypeInfo = new OrderTypeInfo();
        orderTypeInfo.setListId(listId);
        orderTypeInfo.setElementInfoList(elementInfoList);
        orderTypeInfo.setPriceType(BmcConstants.CpPricemakingFactor.PriceProductType.ECS_INSTANCE);
        orderTypeList.add(orderTypeInfo);
        // 系统盘一个
        elementInfoList = new ArrayList<ElementInfo>();
        for (Entry<String, String> entry : map.entrySet()) {
            if (BmcConstants.CpPricemakingFactor.FactorName.REGION_ID.equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.SYSTEM_DISK_CATEGORY
                            .equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.SYSTEM_DISK_SIZE.equals(entry
                            .getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.INSTANCE_CHARGE_TYPE
                            .equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.PERIOD.equals(entry.getKey())) {
                ElementInfo elementInfo = new ElementInfo();
                elementInfo.setName(entry.getKey());
                elementInfo.setValue(entry.getValue());
                elementInfoList.add(elementInfo);
            }
        }
        orderTypeInfo = new OrderTypeInfo();
        orderTypeInfo.setListId(listId);
        orderTypeInfo.setElementInfoList(elementInfoList);
        orderTypeInfo
                .setPriceType(BmcConstants.CpPricemakingFactor.PriceProductType.ECS_SYSTEM_DISK);
        orderTypeList.add(orderTypeInfo);
        // 数据盘多个
        Map<String, Map<String, String>> dataDickMap = new HashMap<String, Map<String, String>>();
        for (Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("DataDisk")) {
                String seq = entry.getKey().split("\\.")[1];
                if (dataDickMap.containsKey(seq)) {
                    dataDickMap.get(seq).put(entry.getKey().replace(seq, "n"), entry.getValue());
                } else {
                    Map<String, String> mapTmp = new HashMap<String, String>();
                    mapTmp.put(entry.getKey().replace(seq, "n"), entry.getValue());
                    dataDickMap.put(seq, mapTmp);
                }
            }
        }
        if (!dataDickMap.isEmpty()) {
            for (Entry<String, Map<String, String>> entry : dataDickMap.entrySet()) {
                for (Entry<String, String> entry1 : map.entrySet()) {
                    if (BmcConstants.CpPricemakingFactor.FactorName.REGION_ID.equals(entry1
                            .getKey())
                            || BmcConstants.CpPricemakingFactor.FactorName.INSTANCE_CHARGE_TYPE
                                    .equals(entry1.getKey())
                            || BmcConstants.CpPricemakingFactor.FactorName.PERIOD.equals(entry1
                                    .getKey())) {
                        entry.getValue().put(entry1.getKey(), entry1.getValue());
                    }
                }
            }
            elementInfoList = new ArrayList<ElementInfo>();
            for (Entry<String, Map<String, String>> entry : dataDickMap.entrySet()) {
                for (Entry<String, String> entry2 : entry.getValue().entrySet()) {
                    ElementInfo elementInfo = new ElementInfo();
                    elementInfo.setName(entry2.getKey());
                    elementInfo.setValue(entry2.getValue());
                    elementInfoList.add(elementInfo);
                }
                orderTypeInfo = new OrderTypeInfo();
                orderTypeInfo.setListId(listId);
                orderTypeInfo.setElementInfoList(elementInfoList);
                orderTypeInfo
                        .setPriceType(BmcConstants.CpPricemakingFactor.PriceProductType.ECS_DATA_DISK);
                orderTypeList.add(orderTypeInfo);
            }
        }
        // 网络一个
        elementInfoList = new ArrayList<ElementInfo>();
        for (Entry<String, String> entry : map.entrySet()) {
            if (BmcConstants.CpPricemakingFactor.FactorName.REGION_ID.equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.INTERNET_CHARGE_TYPE
                            .equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.INTERNET_MAX_BANDWIDTH_OUT
                            .equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.INSTANCE_CHARGE_TYPE
                            .equals(entry.getKey())
                    || BmcConstants.CpPricemakingFactor.FactorName.PERIOD.equals(entry.getKey())) {
                ElementInfo elementInfo = new ElementInfo();
                elementInfo.setName(entry.getKey());
                elementInfo.setValue(entry.getValue());
                elementInfoList.add(elementInfo);
            }
        }
        orderTypeInfo = new OrderTypeInfo();
        orderTypeInfo.setListId(listId);
        orderTypeInfo.setElementInfoList(elementInfoList);
        orderTypeInfo.setPriceType(BmcConstants.CpPricemakingFactor.PriceProductType.ECS_BANDWITH);
        orderTypeList.add(orderTypeInfo);
    }

    @Override
    public ResponseMessage queryPricemaking(PriceElementInfo request) throws BusinessException,
            SystemException {
        // 参数校验
        BusinessUtil.checkBaseInfo(request);
        if (StringUtil.isBlank(request.getTradeSeq())) {
            throw new BusinessException("交易流水为空");
        }
        if (CollectionUtil.isEmpty(request.getOrderTypeList())) {
            throw new BusinessException("类型列表为空");
        }
        for (OrderTypeInfo orderTypeInfo : request.getOrderTypeList()) {
            if (StringUtil.isBlank(orderTypeInfo.getListId())) {
                throw new BusinessException("list_id为空");
            }
            if (StringUtil.isBlank(orderTypeInfo.getPriceType())) {
                throw new BusinessException("定价类型为空");
            }
            if (CollectionUtil.isEmpty(orderTypeInfo.getElementInfoList())) {
                throw new BusinessException("定价元素列表列表为空");
            }
            for (ElementInfo elementInfo : orderTypeInfo.getElementInfoList()) {
                if (StringUtil.isBlank(elementInfo.getName())) {
                    throw new BusinessException("元素名称为空");
                }
                if (StringUtil.isBlank(elementInfo.getValue())) {
                    throw new BusinessException("元素值为空");
                }
            }
        }
        if (!CollectionUtil.isEmpty(request.getExtInfoList())) {
            for (ExtInfo extInfo : request.getExtInfoList()) {
                if (StringUtil.isBlank(extInfo.getExtName())) {
                    throw new BusinessException("扩展信息名称为空");
                }
                if (StringUtil.isBlank(extInfo.getExtValue())) {
                    throw new BusinessException("扩展信息值为空");
                }
            }
        }

        ResponseMessage response = new ResponseMessage();
        response.setResponseHeader(new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS,
                "成功"));
        List<PriceInfo> priceInfoList = iPricemakingBusiSV.queryPricemaking(request);
        response.setPriceInfoList(priceInfoList);
        return response;
    }

}
