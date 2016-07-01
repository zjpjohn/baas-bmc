package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CpPricemakingRuleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpPricemakingRuleCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeIsNull() {
            addCriterion("PRICE_PRODUCT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeIsNotNull() {
            addCriterion("PRICE_PRODUCT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeEqualTo(String value) {
            addCriterion("PRICE_PRODUCT_TYPE =", value, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeNotEqualTo(String value) {
            addCriterion("PRICE_PRODUCT_TYPE <>", value, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeGreaterThan(String value) {
            addCriterion("PRICE_PRODUCT_TYPE >", value, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_PRODUCT_TYPE >=", value, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeLessThan(String value) {
            addCriterion("PRICE_PRODUCT_TYPE <", value, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeLessThanOrEqualTo(String value) {
            addCriterion("PRICE_PRODUCT_TYPE <=", value, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeLike(String value) {
            addCriterion("PRICE_PRODUCT_TYPE like", value, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeNotLike(String value) {
            addCriterion("PRICE_PRODUCT_TYPE not like", value, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeIn(List<String> values) {
            addCriterion("PRICE_PRODUCT_TYPE in", values, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeNotIn(List<String> values) {
            addCriterion("PRICE_PRODUCT_TYPE not in", values, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeBetween(String value1, String value2) {
            addCriterion("PRICE_PRODUCT_TYPE between", value1, value2, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductTypeNotBetween(String value1, String value2) {
            addCriterion("PRICE_PRODUCT_TYPE not between", value1, value2, "priceProductType");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdIsNull() {
            addCriterion("PRICE_PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdIsNotNull() {
            addCriterion("PRICE_PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdEqualTo(String value) {
            addCriterion("PRICE_PRODUCT_ID =", value, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdNotEqualTo(String value) {
            addCriterion("PRICE_PRODUCT_ID <>", value, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdGreaterThan(String value) {
            addCriterion("PRICE_PRODUCT_ID >", value, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_PRODUCT_ID >=", value, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdLessThan(String value) {
            addCriterion("PRICE_PRODUCT_ID <", value, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRICE_PRODUCT_ID <=", value, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdLike(String value) {
            addCriterion("PRICE_PRODUCT_ID like", value, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdNotLike(String value) {
            addCriterion("PRICE_PRODUCT_ID not like", value, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdIn(List<String> values) {
            addCriterion("PRICE_PRODUCT_ID in", values, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdNotIn(List<String> values) {
            addCriterion("PRICE_PRODUCT_ID not in", values, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdBetween(String value1, String value2) {
            addCriterion("PRICE_PRODUCT_ID between", value1, value2, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceProductIdNotBetween(String value1, String value2) {
            addCriterion("PRICE_PRODUCT_ID not between", value1, value2, "priceProductId");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNull() {
            addCriterion("PRICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNotNull() {
            addCriterion("PRICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeEqualTo(String value) {
            addCriterion("PRICE_TYPE =", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotEqualTo(String value) {
            addCriterion("PRICE_TYPE <>", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThan(String value) {
            addCriterion("PRICE_TYPE >", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_TYPE >=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThan(String value) {
            addCriterion("PRICE_TYPE <", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("PRICE_TYPE <=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLike(String value) {
            addCriterion("PRICE_TYPE like", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotLike(String value) {
            addCriterion("PRICE_TYPE not like", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIn(List<String> values) {
            addCriterion("PRICE_TYPE in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotIn(List<String> values) {
            addCriterion("PRICE_TYPE not in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeBetween(String value1, String value2) {
            addCriterion("PRICE_TYPE between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotBetween(String value1, String value2) {
            addCriterion("PRICE_TYPE not between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNull() {
            addCriterion("ACTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNotNull() {
            addCriterion("ACTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeEqualTo(Timestamp value) {
            addCriterion("ACTIVE_TIME =", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotEqualTo(Timestamp value) {
            addCriterion("ACTIVE_TIME <>", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThan(Timestamp value) {
            addCriterion("ACTIVE_TIME >", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ACTIVE_TIME >=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThan(Timestamp value) {
            addCriterion("ACTIVE_TIME <", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("ACTIVE_TIME <=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIn(List<Timestamp> values) {
            addCriterion("ACTIVE_TIME in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotIn(List<Timestamp> values) {
            addCriterion("ACTIVE_TIME not in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ACTIVE_TIME between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ACTIVE_TIME not between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRuleCodeIsNull() {
            addCriterion("RULE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRuleCodeIsNotNull() {
            addCriterion("RULE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCodeEqualTo(String value) {
            addCriterion("RULE_CODE =", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotEqualTo(String value) {
            addCriterion("RULE_CODE <>", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeGreaterThan(String value) {
            addCriterion("RULE_CODE >", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RULE_CODE >=", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLessThan(String value) {
            addCriterion("RULE_CODE <", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLessThanOrEqualTo(String value) {
            addCriterion("RULE_CODE <=", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLike(String value) {
            addCriterion("RULE_CODE like", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotLike(String value) {
            addCriterion("RULE_CODE not like", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeIn(List<String> values) {
            addCriterion("RULE_CODE in", values, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotIn(List<String> values) {
            addCriterion("RULE_CODE not in", values, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeBetween(String value1, String value2) {
            addCriterion("RULE_CODE between", value1, value2, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotBetween(String value1, String value2) {
            addCriterion("RULE_CODE not between", value1, value2, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionIsNull() {
            addCriterion("RULE_EXPRESION is null");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionIsNotNull() {
            addCriterion("RULE_EXPRESION is not null");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionEqualTo(String value) {
            addCriterion("RULE_EXPRESION =", value, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionNotEqualTo(String value) {
            addCriterion("RULE_EXPRESION <>", value, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionGreaterThan(String value) {
            addCriterion("RULE_EXPRESION >", value, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionGreaterThanOrEqualTo(String value) {
            addCriterion("RULE_EXPRESION >=", value, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionLessThan(String value) {
            addCriterion("RULE_EXPRESION <", value, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionLessThanOrEqualTo(String value) {
            addCriterion("RULE_EXPRESION <=", value, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionLike(String value) {
            addCriterion("RULE_EXPRESION like", value, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionNotLike(String value) {
            addCriterion("RULE_EXPRESION not like", value, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionIn(List<String> values) {
            addCriterion("RULE_EXPRESION in", values, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionNotIn(List<String> values) {
            addCriterion("RULE_EXPRESION not in", values, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionBetween(String value1, String value2) {
            addCriterion("RULE_EXPRESION between", value1, value2, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andRuleExpresionNotBetween(String value1, String value2) {
            addCriterion("RULE_EXPRESION not between", value1, value2, "ruleExpresion");
            return (Criteria) this;
        }

        public Criteria andExtInfoIsNull() {
            addCriterion("EXT_INFO is null");
            return (Criteria) this;
        }

        public Criteria andExtInfoIsNotNull() {
            addCriterion("EXT_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andExtInfoEqualTo(String value) {
            addCriterion("EXT_INFO =", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotEqualTo(String value) {
            addCriterion("EXT_INFO <>", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoGreaterThan(String value) {
            addCriterion("EXT_INFO >", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_INFO >=", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLessThan(String value) {
            addCriterion("EXT_INFO <", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLessThanOrEqualTo(String value) {
            addCriterion("EXT_INFO <=", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLike(String value) {
            addCriterion("EXT_INFO like", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotLike(String value) {
            addCriterion("EXT_INFO not like", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoIn(List<String> values) {
            addCriterion("EXT_INFO in", values, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotIn(List<String> values) {
            addCriterion("EXT_INFO not in", values, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoBetween(String value1, String value2) {
            addCriterion("EXT_INFO between", value1, value2, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotBetween(String value1, String value2) {
            addCriterion("EXT_INFO not between", value1, value2, "extInfo");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIsNull() {
            addCriterion("INACTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIsNotNull() {
            addCriterion("INACTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeEqualTo(Timestamp value) {
            addCriterion("INACTIVE_TIME =", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotEqualTo(Timestamp value) {
            addCriterion("INACTIVE_TIME <>", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeGreaterThan(Timestamp value) {
            addCriterion("INACTIVE_TIME >", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("INACTIVE_TIME >=", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeLessThan(Timestamp value) {
            addCriterion("INACTIVE_TIME <", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("INACTIVE_TIME <=", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIn(List<Timestamp> values) {
            addCriterion("INACTIVE_TIME in", values, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotIn(List<Timestamp> values) {
            addCriterion("INACTIVE_TIME not in", values, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("INACTIVE_TIME between", value1, value2, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("INACTIVE_TIME not between", value1, value2, "inactiveTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}