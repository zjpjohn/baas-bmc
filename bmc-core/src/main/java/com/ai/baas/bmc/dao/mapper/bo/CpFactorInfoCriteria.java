package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class CpFactorInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpFactorInfoCriteria() {
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

        public Criteria andFactorInfoIdIsNull() {
            addCriterion("FACTOR_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdIsNotNull() {
            addCriterion("FACTOR_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdEqualTo(Integer value) {
            addCriterion("FACTOR_INFO_ID =", value, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdNotEqualTo(Integer value) {
            addCriterion("FACTOR_INFO_ID <>", value, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdGreaterThan(Integer value) {
            addCriterion("FACTOR_INFO_ID >", value, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FACTOR_INFO_ID >=", value, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdLessThan(Integer value) {
            addCriterion("FACTOR_INFO_ID <", value, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("FACTOR_INFO_ID <=", value, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdIn(List<Integer> values) {
            addCriterion("FACTOR_INFO_ID in", values, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdNotIn(List<Integer> values) {
            addCriterion("FACTOR_INFO_ID not in", values, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("FACTOR_INFO_ID between", value1, value2, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andFactorInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FACTOR_INFO_ID not between", value1, value2, "factorInfoId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("SYSTEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("SYSTEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("SYSTEM_ID =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("SYSTEM_ID <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("SYSTEM_ID >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_ID >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("SYSTEM_ID <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_ID <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("SYSTEM_ID like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("SYSTEM_ID not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("SYSTEM_ID in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("SYSTEM_ID not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("SYSTEM_ID between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_ID not between", value1, value2, "systemId");
            return (Criteria) this;
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

        public Criteria andFactorCodeIsNull() {
            addCriterion("FACTOR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFactorCodeIsNotNull() {
            addCriterion("FACTOR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFactorCodeEqualTo(String value) {
            addCriterion("FACTOR_CODE =", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeNotEqualTo(String value) {
            addCriterion("FACTOR_CODE <>", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeGreaterThan(String value) {
            addCriterion("FACTOR_CODE >", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FACTOR_CODE >=", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeLessThan(String value) {
            addCriterion("FACTOR_CODE <", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeLessThanOrEqualTo(String value) {
            addCriterion("FACTOR_CODE <=", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeLike(String value) {
            addCriterion("FACTOR_CODE like", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeNotLike(String value) {
            addCriterion("FACTOR_CODE not like", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeIn(List<String> values) {
            addCriterion("FACTOR_CODE in", values, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeNotIn(List<String> values) {
            addCriterion("FACTOR_CODE not in", values, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeBetween(String value1, String value2) {
            addCriterion("FACTOR_CODE between", value1, value2, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeNotBetween(String value1, String value2) {
            addCriterion("FACTOR_CODE not between", value1, value2, "factorCode");
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