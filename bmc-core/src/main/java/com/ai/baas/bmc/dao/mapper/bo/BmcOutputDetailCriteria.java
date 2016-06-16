package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class BmcOutputDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BmcOutputDetailCriteria() {
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

        public Criteria andDetailCodeIsNull() {
            addCriterion("detail_code is null");
            return (Criteria) this;
        }

        public Criteria andDetailCodeIsNotNull() {
            addCriterion("detail_code is not null");
            return (Criteria) this;
        }

        public Criteria andDetailCodeEqualTo(Long value) {
            addCriterion("detail_code =", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeNotEqualTo(Long value) {
            addCriterion("detail_code <>", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeGreaterThan(Long value) {
            addCriterion("detail_code >", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("detail_code >=", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeLessThan(Long value) {
            addCriterion("detail_code <", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeLessThanOrEqualTo(Long value) {
            addCriterion("detail_code <=", value, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeIn(List<Long> values) {
            addCriterion("detail_code in", values, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeNotIn(List<Long> values) {
            addCriterion("detail_code not in", values, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeBetween(Long value1, Long value2) {
            addCriterion("detail_code between", value1, value2, "detailCode");
            return (Criteria) this;
        }

        public Criteria andDetailCodeNotBetween(Long value1, Long value2) {
            addCriterion("detail_code not between", value1, value2, "detailCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeIsNull() {
            addCriterion("info_code is null");
            return (Criteria) this;
        }

        public Criteria andInfoCodeIsNotNull() {
            addCriterion("info_code is not null");
            return (Criteria) this;
        }

        public Criteria andInfoCodeEqualTo(Long value) {
            addCriterion("info_code =", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeNotEqualTo(Long value) {
            addCriterion("info_code <>", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeGreaterThan(Long value) {
            addCriterion("info_code >", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("info_code >=", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeLessThan(Long value) {
            addCriterion("info_code <", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeLessThanOrEqualTo(Long value) {
            addCriterion("info_code <=", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeIn(List<Long> values) {
            addCriterion("info_code in", values, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeNotIn(List<Long> values) {
            addCriterion("info_code not in", values, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeBetween(Long value1, Long value2) {
            addCriterion("info_code between", value1, value2, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeNotBetween(Long value1, Long value2) {
            addCriterion("info_code not between", value1, value2, "infoCode");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNull() {
            addCriterion("column_name is null");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNotNull() {
            addCriterion("column_name is not null");
            return (Criteria) this;
        }

        public Criteria andColumnNameEqualTo(String value) {
            addCriterion("column_name =", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotEqualTo(String value) {
            addCriterion("column_name <>", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThan(String value) {
            addCriterion("column_name >", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("column_name >=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThan(String value) {
            addCriterion("column_name <", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThanOrEqualTo(String value) {
            addCriterion("column_name <=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLike(String value) {
            addCriterion("column_name like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotLike(String value) {
            addCriterion("column_name not like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameIn(List<String> values) {
            addCriterion("column_name in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotIn(List<String> values) {
            addCriterion("column_name not in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameBetween(String value1, String value2) {
            addCriterion("column_name between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotBetween(String value1, String value2) {
            addCriterion("column_name not between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("param_name is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("param_name is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("param_name =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("param_name <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("param_name >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("param_name >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("param_name <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("param_name <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("param_name like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("param_name not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("param_name in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("param_name not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("param_name between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("param_name not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andIsKeyIsNull() {
            addCriterion("is_key is null");
            return (Criteria) this;
        }

        public Criteria andIsKeyIsNotNull() {
            addCriterion("is_key is not null");
            return (Criteria) this;
        }

        public Criteria andIsKeyEqualTo(String value) {
            addCriterion("is_key =", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotEqualTo(String value) {
            addCriterion("is_key <>", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyGreaterThan(String value) {
            addCriterion("is_key >", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyGreaterThanOrEqualTo(String value) {
            addCriterion("is_key >=", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLessThan(String value) {
            addCriterion("is_key <", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLessThanOrEqualTo(String value) {
            addCriterion("is_key <=", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLike(String value) {
            addCriterion("is_key like", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotLike(String value) {
            addCriterion("is_key not like", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyIn(List<String> values) {
            addCriterion("is_key in", values, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotIn(List<String> values) {
            addCriterion("is_key not in", values, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyBetween(String value1, String value2) {
            addCriterion("is_key between", value1, value2, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotBetween(String value1, String value2) {
            addCriterion("is_key not between", value1, value2, "isKey");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNull() {
            addCriterion("display_order is null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNotNull() {
            addCriterion("display_order is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderEqualTo(Integer value) {
            addCriterion("display_order =", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotEqualTo(Integer value) {
            addCriterion("display_order <>", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThan(Integer value) {
            addCriterion("display_order >", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("display_order >=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThan(Integer value) {
            addCriterion("display_order <", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThanOrEqualTo(Integer value) {
            addCriterion("display_order <=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIn(List<Integer> values) {
            addCriterion("display_order in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotIn(List<Integer> values) {
            addCriterion("display_order not in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderBetween(Integer value1, Integer value2) {
            addCriterion("display_order between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("display_order not between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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