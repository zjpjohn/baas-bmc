package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class CpPricemakingFactorCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpPricemakingFactorCriteria() {
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

        public Criteria andFactorNameIsNull() {
            addCriterion("FACTOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFactorNameIsNotNull() {
            addCriterion("FACTOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFactorNameEqualTo(String value) {
            addCriterion("FACTOR_NAME =", value, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameNotEqualTo(String value) {
            addCriterion("FACTOR_NAME <>", value, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameGreaterThan(String value) {
            addCriterion("FACTOR_NAME >", value, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameGreaterThanOrEqualTo(String value) {
            addCriterion("FACTOR_NAME >=", value, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameLessThan(String value) {
            addCriterion("FACTOR_NAME <", value, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameLessThanOrEqualTo(String value) {
            addCriterion("FACTOR_NAME <=", value, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameLike(String value) {
            addCriterion("FACTOR_NAME like", value, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameNotLike(String value) {
            addCriterion("FACTOR_NAME not like", value, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameIn(List<String> values) {
            addCriterion("FACTOR_NAME in", values, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameNotIn(List<String> values) {
            addCriterion("FACTOR_NAME not in", values, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameBetween(String value1, String value2) {
            addCriterion("FACTOR_NAME between", value1, value2, "factorName");
            return (Criteria) this;
        }

        public Criteria andFactorNameNotBetween(String value1, String value2) {
            addCriterion("FACTOR_NAME not between", value1, value2, "factorName");
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

        public Criteria andFactorValueIsNull() {
            addCriterion("FACTOR_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andFactorValueIsNotNull() {
            addCriterion("FACTOR_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andFactorValueEqualTo(String value) {
            addCriterion("FACTOR_VALUE =", value, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueNotEqualTo(String value) {
            addCriterion("FACTOR_VALUE <>", value, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueGreaterThan(String value) {
            addCriterion("FACTOR_VALUE >", value, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueGreaterThanOrEqualTo(String value) {
            addCriterion("FACTOR_VALUE >=", value, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueLessThan(String value) {
            addCriterion("FACTOR_VALUE <", value, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueLessThanOrEqualTo(String value) {
            addCriterion("FACTOR_VALUE <=", value, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueLike(String value) {
            addCriterion("FACTOR_VALUE like", value, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueNotLike(String value) {
            addCriterion("FACTOR_VALUE not like", value, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueIn(List<String> values) {
            addCriterion("FACTOR_VALUE in", values, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueNotIn(List<String> values) {
            addCriterion("FACTOR_VALUE not in", values, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueBetween(String value1, String value2) {
            addCriterion("FACTOR_VALUE between", value1, value2, "factorValue");
            return (Criteria) this;
        }

        public Criteria andFactorValueNotBetween(String value1, String value2) {
            addCriterion("FACTOR_VALUE not between", value1, value2, "factorValue");
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