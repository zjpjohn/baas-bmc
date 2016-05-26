package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class CpCyclefeeInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpCyclefeeInfoCriteria() {
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

        public Criteria andCycleFeeTpyeIsNull() {
            addCriterion("CYCLE_FEE_TPYE is null");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeIsNotNull() {
            addCriterion("CYCLE_FEE_TPYE is not null");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeEqualTo(String value) {
            addCriterion("CYCLE_FEE_TPYE =", value, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeNotEqualTo(String value) {
            addCriterion("CYCLE_FEE_TPYE <>", value, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeGreaterThan(String value) {
            addCriterion("CYCLE_FEE_TPYE >", value, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeGreaterThanOrEqualTo(String value) {
            addCriterion("CYCLE_FEE_TPYE >=", value, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeLessThan(String value) {
            addCriterion("CYCLE_FEE_TPYE <", value, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeLessThanOrEqualTo(String value) {
            addCriterion("CYCLE_FEE_TPYE <=", value, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeLike(String value) {
            addCriterion("CYCLE_FEE_TPYE like", value, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeNotLike(String value) {
            addCriterion("CYCLE_FEE_TPYE not like", value, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeIn(List<String> values) {
            addCriterion("CYCLE_FEE_TPYE in", values, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeNotIn(List<String> values) {
            addCriterion("CYCLE_FEE_TPYE not in", values, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeBetween(String value1, String value2) {
            addCriterion("CYCLE_FEE_TPYE between", value1, value2, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeTpyeNotBetween(String value1, String value2) {
            addCriterion("CYCLE_FEE_TPYE not between", value1, value2, "cycleFeeTpye");
            return (Criteria) this;
        }

        public Criteria andCycleFeeIsNull() {
            addCriterion("CYCLE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andCycleFeeIsNotNull() {
            addCriterion("CYCLE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andCycleFeeEqualTo(Long value) {
            addCriterion("CYCLE_FEE =", value, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeNotEqualTo(Long value) {
            addCriterion("CYCLE_FEE <>", value, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeGreaterThan(Long value) {
            addCriterion("CYCLE_FEE >", value, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("CYCLE_FEE >=", value, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeLessThan(Long value) {
            addCriterion("CYCLE_FEE <", value, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeLessThanOrEqualTo(Long value) {
            addCriterion("CYCLE_FEE <=", value, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeIn(List<Long> values) {
            addCriterion("CYCLE_FEE in", values, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeNotIn(List<Long> values) {
            addCriterion("CYCLE_FEE not in", values, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeBetween(Long value1, Long value2) {
            addCriterion("CYCLE_FEE between", value1, value2, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andCycleFeeNotBetween(Long value1, Long value2) {
            addCriterion("CYCLE_FEE not between", value1, value2, "cycleFee");
            return (Criteria) this;
        }

        public Criteria andDetailCodeIsNull() {
            addCriterion("DETAIL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDetailCodeIsNotNull() {
            addCriterion("DETAIL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDetailCodeEqualTo(String value) {
            addCriterion("DETAIL_CODE =", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeNotEqualTo(String value) {
            addCriterion("DETAIL_CODE <>", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeGreaterThan(String value) {
            addCriterion("DETAIL_CODE >", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_CODE >=", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeLessThan(String value) {
            addCriterion("DETAIL_CODE <", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_CODE <=", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeLike(String value) {
            addCriterion("DETAIL_CODE like", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeNotLike(String value) {
            addCriterion("DETAIL_CODE not like", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeIn(List<String> values) {
            addCriterion("DETAIL_CODE in", values, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeNotIn(List<String> values) {
            addCriterion("DETAIL_CODE not in", values, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeBetween(String value1, String value2) {
            addCriterion("DETAIL_CODE between", value1, value2, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeNotBetween(String value1, String value2) {
            addCriterion("DETAIL_CODE not between", value1, value2, "detailCode");
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