package com.ai.baas.bmc.business.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.pricemaking.params.ElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.ExtInfo;
import com.ai.baas.bmc.api.pricemaking.params.FeeInfo;
import com.ai.baas.bmc.api.pricemaking.params.OrderTypeInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceInfo;
import com.ai.baas.bmc.business.interfaces.IPricemakingBusiSV;
import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.constants.BmcConstants;
import com.ai.baas.bmc.dao.interfaces.CpPricemakingRuleMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPricemakingRule;
import com.ai.baas.bmc.dao.mapper.bo.CpPricemakingRuleCriteria;
import com.ai.baas.dshm.client.CacheFactoryUtil;
import com.ai.baas.dshm.client.impl.CacheBLMapper;
import com.ai.baas.dshm.client.impl.DshmClient;
import com.ai.baas.dshm.client.interfaces.IDshmClient;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.alibaba.fastjson.JSON;

@Component
@Transactional
public class PriceMakingBusiSVImpl implements IPricemakingBusiSV {
    private static final Logger LOGGER = LogManager.getLogger(PriceMakingBusiSVImpl.class);

    @Autowired
    private transient CpPricemakingRuleMapper cpPricemakingRuleMapper;

    @Override
    public List<PriceInfo> queryPricemaking(PriceElementInfo request) {
        String tenantId = request.getTenantId();
        List<OrderTypeInfo> orderTypeList = request.getOrderTypeList();
        Timestamp sysdate = DateUtil.getSysDate();
        List<ExtInfo> extInfos = request.getExtInfoList();
        IDshmClient dshmClient = new DshmClient();
        ICacheClient calParamCacheClient = CacheFactoryUtil
                .getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
        List<PriceInfo> priceInfos = new ArrayList<PriceInfo>();
        for (OrderTypeInfo orderTypeInfo : orderTypeList) {
            String priceType = orderTypeInfo.getPriceType();
            List<ElementInfo> elementInfos = orderTypeInfo.getElementInfoList();
            // 根据定价类型获取定价因子
            List<Map<String, String>> results = getPriceFactor(tenantId, priceType, dshmClient,
                    calParamCacheClient);
            // 定价因子数据整理成 Map<price_product_id, List<Map<filedName, value>>>
            Map<String, List<Map<String, String>>> map = aseembleDataMap(results);
            // 匹配出price_product_id,使用反向匹配，用配置的因子去匹配入参
            String priceProductId = null;
            for (Entry<String, List<Map<String, String>>> entry : map.entrySet()) {
                // 针对某一个定价产品ID，必须所有的因子都匹配到,才认为是匹配
                boolean isMatch = true;
                for (Map<String, String> m : entry.getValue()) {
                    String factorName = m.get(BmcCacheConstant.Dshm.FieldName.FACTOR_NAME);
                    String factorValue = m.get(BmcCacheConstant.Dshm.FieldName.FACTOR_VALUE);
                    // 针对某一个因子，在入参的元素列表和扩展列表中，只要匹配到一个，即认为是匹配成功
                    boolean isFactorMatch = false;
                    for (ElementInfo elementInfo : elementInfos) {
                        if (factorName.equals(elementInfo.getName())
                                && factorValue.equals(elementInfo.getValue())) {
                            isFactorMatch = true;
                            break;
                        }
                    }
                    for (ExtInfo extInfo : extInfos) {
                        if (factorName.equals(extInfo.getExtName())
                                && factorValue.equals(extInfo.getExtValue())) {
                            isFactorMatch = true;
                            break;
                        }
                    }
                    if (!isFactorMatch) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    priceProductId = entry.getKey();
                }
            }
            if (StringUtil.isBlank(priceProductId)) {
                throw new BusinessException("未匹配出定价产品ID");
            }
            // 查询定价价格规则表
            CpPricemakingRuleCriteria criteria = new CpPricemakingRuleCriteria();
            criteria.createCriteria().andTenantIdEqualTo(tenantId).andPriceTypeEqualTo(priceType)
                    .andPriceProductIdEqualTo(priceProductId)
                    .andPriceTypeEqualTo(BmcConstants.CpPricemakingRule.PriceType.PER_HOUR)
                    .andActiveTimeLessThan(sysdate).andInactiveTimeGreaterThanOrEqualTo(sysdate);
            List<CpPricemakingRule> cpPricemakingRules = cpPricemakingRuleMapper
                    .selectByExample(criteria);
            if (CollectionUtil.isEmpty(cpPricemakingRules)) {
                throw new BusinessException("定价产品ID[" + priceProductId + "]定价规则不存在");
            }
            CpPricemakingRule cpPricemakingRule = cpPricemakingRules.get(0);
            // 计算费用值
            String price = "";
            if (BmcConstants.CpPricemakingRule.RuleCode.CONST.equals(cpPricemakingRule
                    .getRuleCode())) {
                // 常量
                price = cpPricemakingRule.getRuleExpresion();
            } else if (BmcConstants.CpPricemakingRule.RuleCode.EXPR.equals(cpPricemakingRule
                    .getRuleCode())) {

                HashMap<String, String> variables = new HashMap<String, String>();
                for (ElementInfo elementInfo : elementInfos) {
                    variables.put(elementInfo.getName(), elementInfo.getValue());
                }
                for (ExtInfo extInfo : extInfos) {
                    variables.put(extInfo.getExtName(), extInfo.getExtValue());
                }
                @SuppressWarnings("unchecked")
                Map<String, String> extConst = (Map<String, String>) JSON.parse(cpPricemakingRule
                        .getExtInfo());
                for (Entry<String, String> entry : extConst.entrySet()) {
                    variables.put(entry.getKey(), entry.getValue());
                }
                // 表达式
                String expression = cpPricemakingRule.getRuleExpresion();
                Evaluator evaluator = new Evaluator();
                evaluator.setVariables(variables);
                try {
                    price = evaluator.evaluate(expression);
                } catch (EvaluationException e) {
                    LOGGER.error("费用计算错误", e);
                    throw new SystemException("费用计算错误", e);
                }
            } else {
                throw new SystemException("不支持此计算规则[" + cpPricemakingRule.getRuleCode() + "]");
            }

            FeeInfo feeInfo = new FeeInfo();
            feeInfo.setPrice(price);
            List<FeeInfo> feeInfos = new ArrayList<FeeInfo>();
            feeInfos.add(feeInfo);
            PriceInfo priceInfo = new PriceInfo();
            priceInfo.setListId(orderTypeInfo.getListId());
            priceInfo.setFeeInfos(feeInfos);
            priceInfos.add(priceInfo);
        }
        return priceInfos;
    }

    private Map<String, List<Map<String, String>>> aseembleDataMap(List<Map<String, String>> results) {
        Map<String, List<Map<String, String>>> map = new HashMap<String, List<Map<String, String>>>();
        for (Map<String, String> m : results) {
            String priceProductId = m.get(BmcCacheConstant.Dshm.FieldName.PRICE_PRODUCT_ID);
            if (map.containsKey(priceProductId)) {
                List<Map<String, String>> list = map.get(priceProductId);
                list.add(m);
            } else {
                List<Map<String, String>> list = new ArrayList<Map<String, String>>();
                list.add(m);
                map.put(priceProductId, list);
            }
        }
        return map;
    }

    private List<Map<String, String>> getPriceFactor(String tenantId, String priceType,
            IDshmClient dshmClient, ICacheClient calParamCacheClient) {
        Map<String, String> params = new TreeMap<String, String>();
        params.put(BmcCacheConstant.Dshm.FieldName.TENANT_ID, tenantId);
        params.put(BmcCacheConstant.Dshm.FieldName.PRICE_PRODUCT_TYPE, priceType);
        List<Map<String, String>> results = dshmClient
                .list(BmcCacheConstant.Dshm.TableName.CP_PRICEMAKING_FACTOR).where(params)
                .executeQuery(calParamCacheClient);
        if (CollectionUtil.isEmpty(results)) {
            throw new BusinessException(ExceptCodeConstants.Special.NO_DATA_OR_CACAE_ERROR,
                    "该定价产品类型[" + priceType + "]定价因子不存在");
        }
        return results;
    }

}
