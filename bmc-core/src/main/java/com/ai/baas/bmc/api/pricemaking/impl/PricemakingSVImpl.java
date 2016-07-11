package com.ai.baas.bmc.api.pricemaking.impl;

import java.util.ArrayList;
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
        // 参数转换
        PriceElementInfo priceElementInfo = assembleRequest(request);
        // 业务层实现
        List<PriceInfo> priceInfoList = iPricemakingBusiSV.queryPricemaking(priceElementInfo);
        // 参数转换
        List<CostInfo> detail_costs = assembleResponse(priceInfoList);

        PricemakingResponseZX response = new PricemakingResponseZX();
        response.setResponseHeader(new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS,
                "成功"));
        response.setDetail_costs(detail_costs);
        return response;
    }

    private List<CostInfo> assembleResponse(List<PriceInfo> priceInfoList) {
        List<CostInfo> costInfos = new ArrayList<CostInfo>();
        for (PriceInfo priceInfo : priceInfoList) {
            CostInfo costInfo = new CostInfo();
            costInfo.setList_id(priceInfo.getListId());
            List<Cost> cost = new ArrayList<Cost>();
            for (FeeInfo feeInfo : priceInfo.getFeeInfos()) {
                Cost cost1 = new Cost();
                cost1.setCost_name(feeInfo.getPriceDesc());
                cost1.setCost_unit(feeInfo.getPriceUnit());
                cost1.setCost_value(feeInfo.getPrice());
                cost.add(cost1);
            }
            costInfo.setCost(cost);
            costInfos.add(costInfo);
        }
        return costInfos;
    }

    private PriceElementInfo assembleRequest(PriceElementInfoZX request) {
        PriceElementInfo priceElementInfo = new PriceElementInfo();
        priceElementInfo.setTenantId(BmcConstants.TenantId.ZX);
        List<OrderTypeInfo> orderTypeList = new ArrayList<OrderTypeInfo>();
        for (ShoppingList shoppingList : request.getShopping_lists()) {
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
            orderTypeInfo.setListId(shoppingList.getList_id());
            orderTypeInfo.setElementInfoList(elementInfoList);
            orderTypeInfo.setPriceType(BusinessUtil.getPriceTypeByServiceId(shoppingList
                    .getService_id()));
            orderTypeList.add(orderTypeInfo);
        }
        priceElementInfo.setOrderTypeList(orderTypeList);
        return priceElementInfo;
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
