package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class CpExtInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpExtInfoCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
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

        public Criteria andExtOwnerIsNull() {
            addCriterion("EXT_OWNER is null");
            return (Criteria) this;
        }

        public Criteria andExtOwnerIsNotNull() {
            addCriterion("EXT_OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andExtOwnerEqualTo(String value) {
            addCriterion("EXT_OWNER =", value, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerNotEqualTo(String value) {
            addCriterion("EXT_OWNER <>", value, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerGreaterThan(String value) {
            addCriterion("EXT_OWNER >", value, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_OWNER >=", value, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerLessThan(String value) {
            addCriterion("EXT_OWNER <", value, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerLessThanOrEqualTo(String value) {
            addCriterion("EXT_OWNER <=", value, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerLike(String value) {
            addCriterion("EXT_OWNER like", value, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerNotLike(String value) {
            addCriterion("EXT_OWNER not like", value, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerIn(List<String> values) {
            addCriterion("EXT_OWNER in", values, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerNotIn(List<String> values) {
            addCriterion("EXT_OWNER not in", values, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerBetween(String value1, String value2) {
            addCriterion("EXT_OWNER between", value1, value2, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtOwnerNotBetween(String value1, String value2) {
            addCriterion("EXT_OWNER not between", value1, value2, "extOwner");
            return (Criteria) this;
        }

        public Criteria andExtCodeIsNull() {
            addCriterion("EXT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andExtCodeIsNotNull() {
            addCriterion("EXT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andExtCodeEqualTo(String value) {
            addCriterion("EXT_CODE =", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotEqualTo(String value) {
            addCriterion("EXT_CODE <>", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeGreaterThan(String value) {
            addCriterion("EXT_CODE >", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_CODE >=", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeLessThan(String value) {
            addCriterion("EXT_CODE <", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeLessThanOrEqualTo(String value) {
            addCriterion("EXT_CODE <=", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeLike(String value) {
            addCriterion("EXT_CODE like", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotLike(String value) {
            addCriterion("EXT_CODE not like", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeIn(List<String> values) {
            addCriterion("EXT_CODE in", values, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotIn(List<String> values) {
            addCriterion("EXT_CODE not in", values, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeBetween(String value1, String value2) {
            addCriterion("EXT_CODE between", value1, value2, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotBetween(String value1, String value2) {
            addCriterion("EXT_CODE not between", value1, value2, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtTypeIsNull() {
            addCriterion("EXT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExtTypeIsNotNull() {
            addCriterion("EXT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExtTypeEqualTo(String value) {
            addCriterion("EXT_TYPE =", value, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeNotEqualTo(String value) {
            addCriterion("EXT_TYPE <>", value, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeGreaterThan(String value) {
            addCriterion("EXT_TYPE >", value, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_TYPE >=", value, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeLessThan(String value) {
            addCriterion("EXT_TYPE <", value, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeLessThanOrEqualTo(String value) {
            addCriterion("EXT_TYPE <=", value, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeLike(String value) {
            addCriterion("EXT_TYPE like", value, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeNotLike(String value) {
            addCriterion("EXT_TYPE not like", value, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeIn(List<String> values) {
            addCriterion("EXT_TYPE in", values, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeNotIn(List<String> values) {
            addCriterion("EXT_TYPE not in", values, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeBetween(String value1, String value2) {
            addCriterion("EXT_TYPE between", value1, value2, "extType");
            return (Criteria) this;
        }

        public Criteria andExtTypeNotBetween(String value1, String value2) {
            addCriterion("EXT_TYPE not between", value1, value2, "extType");
            return (Criteria) this;
        }

        public Criteria andExtNameIsNull() {
            addCriterion("EXT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExtNameIsNotNull() {
            addCriterion("EXT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExtNameEqualTo(String value) {
            addCriterion("EXT_NAME =", value, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameNotEqualTo(String value) {
            addCriterion("EXT_NAME <>", value, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameGreaterThan(String value) {
            addCriterion("EXT_NAME >", value, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_NAME >=", value, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameLessThan(String value) {
            addCriterion("EXT_NAME <", value, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameLessThanOrEqualTo(String value) {
            addCriterion("EXT_NAME <=", value, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameLike(String value) {
            addCriterion("EXT_NAME like", value, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameNotLike(String value) {
            addCriterion("EXT_NAME not like", value, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameIn(List<String> values) {
            addCriterion("EXT_NAME in", values, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameNotIn(List<String> values) {
            addCriterion("EXT_NAME not in", values, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameBetween(String value1, String value2) {
            addCriterion("EXT_NAME between", value1, value2, "extName");
            return (Criteria) this;
        }

        public Criteria andExtNameNotBetween(String value1, String value2) {
            addCriterion("EXT_NAME not between", value1, value2, "extName");
            return (Criteria) this;
        }

        public Criteria andExtValueIsNull() {
            addCriterion("EXT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andExtValueIsNotNull() {
            addCriterion("EXT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andExtValueEqualTo(String value) {
            addCriterion("EXT_VALUE =", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueNotEqualTo(String value) {
            addCriterion("EXT_VALUE <>", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueGreaterThan(String value) {
            addCriterion("EXT_VALUE >", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_VALUE >=", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueLessThan(String value) {
            addCriterion("EXT_VALUE <", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueLessThanOrEqualTo(String value) {
            addCriterion("EXT_VALUE <=", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueLike(String value) {
            addCriterion("EXT_VALUE like", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueNotLike(String value) {
            addCriterion("EXT_VALUE not like", value, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueIn(List<String> values) {
            addCriterion("EXT_VALUE in", values, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueNotIn(List<String> values) {
            addCriterion("EXT_VALUE not in", values, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueBetween(String value1, String value2) {
            addCriterion("EXT_VALUE between", value1, value2, "extValue");
            return (Criteria) this;
        }

        public Criteria andExtValueNotBetween(String value1, String value2) {
            addCriterion("EXT_VALUE not between", value1, value2, "extValue");
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