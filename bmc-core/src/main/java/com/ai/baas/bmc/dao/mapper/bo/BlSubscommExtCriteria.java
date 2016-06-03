package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class BlSubscommExtCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BlSubscommExtCriteria() {
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

        public Criteria andExtIdIsNull() {
            addCriterion("EXT_ID is null");
            return (Criteria) this;
        }

        public Criteria andExtIdIsNotNull() {
            addCriterion("EXT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExtIdEqualTo(Integer value) {
            addCriterion("EXT_ID =", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotEqualTo(Integer value) {
            addCriterion("EXT_ID <>", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdGreaterThan(Integer value) {
            addCriterion("EXT_ID >", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXT_ID >=", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLessThan(Integer value) {
            addCriterion("EXT_ID <", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLessThanOrEqualTo(Integer value) {
            addCriterion("EXT_ID <=", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdIn(List<Integer> values) {
            addCriterion("EXT_ID in", values, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotIn(List<Integer> values) {
            addCriterion("EXT_ID not in", values, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdBetween(Integer value1, Integer value2) {
            addCriterion("EXT_ID between", value1, value2, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("EXT_ID not between", value1, value2, "extId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdIsNull() {
            addCriterion("SUBS_PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdIsNotNull() {
            addCriterion("SUBS_PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdEqualTo(String value) {
            addCriterion("SUBS_PRODUCT_ID =", value, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdNotEqualTo(String value) {
            addCriterion("SUBS_PRODUCT_ID <>", value, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdGreaterThan(String value) {
            addCriterion("SUBS_PRODUCT_ID >", value, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUBS_PRODUCT_ID >=", value, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdLessThan(String value) {
            addCriterion("SUBS_PRODUCT_ID <", value, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdLessThanOrEqualTo(String value) {
            addCriterion("SUBS_PRODUCT_ID <=", value, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdLike(String value) {
            addCriterion("SUBS_PRODUCT_ID like", value, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdNotLike(String value) {
            addCriterion("SUBS_PRODUCT_ID not like", value, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdIn(List<String> values) {
            addCriterion("SUBS_PRODUCT_ID in", values, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdNotIn(List<String> values) {
            addCriterion("SUBS_PRODUCT_ID not in", values, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdBetween(String value1, String value2) {
            addCriterion("SUBS_PRODUCT_ID between", value1, value2, "subsProductId");
            return (Criteria) this;
        }

        public Criteria andSubsProductIdNotBetween(String value1, String value2) {
            addCriterion("SUBS_PRODUCT_ID not between", value1, value2, "subsProductId");
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

        public Criteria andSubsIdIsNull() {
            addCriterion("SUBS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubsIdIsNotNull() {
            addCriterion("SUBS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubsIdEqualTo(String value) {
            addCriterion("SUBS_ID =", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotEqualTo(String value) {
            addCriterion("SUBS_ID <>", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThan(String value) {
            addCriterion("SUBS_ID >", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUBS_ID >=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThan(String value) {
            addCriterion("SUBS_ID <", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThanOrEqualTo(String value) {
            addCriterion("SUBS_ID <=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLike(String value) {
            addCriterion("SUBS_ID like", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotLike(String value) {
            addCriterion("SUBS_ID not like", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdIn(List<String> values) {
            addCriterion("SUBS_ID in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotIn(List<String> values) {
            addCriterion("SUBS_ID not in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdBetween(String value1, String value2) {
            addCriterion("SUBS_ID between", value1, value2, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotBetween(String value1, String value2) {
            addCriterion("SUBS_ID not between", value1, value2, "subsId");
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