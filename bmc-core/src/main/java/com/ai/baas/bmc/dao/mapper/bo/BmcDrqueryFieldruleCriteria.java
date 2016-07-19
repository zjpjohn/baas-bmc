package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class BmcDrqueryFieldruleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BmcDrqueryFieldruleCriteria() {
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

        public Criteria andTableidIsNull() {
            addCriterion("tableid is null");
            return (Criteria) this;
        }

        public Criteria andTableidIsNotNull() {
            addCriterion("tableid is not null");
            return (Criteria) this;
        }

        public Criteria andTableidEqualTo(String value) {
            addCriterion("tableid =", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotEqualTo(String value) {
            addCriterion("tableid <>", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidGreaterThan(String value) {
            addCriterion("tableid >", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidGreaterThanOrEqualTo(String value) {
            addCriterion("tableid >=", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLessThan(String value) {
            addCriterion("tableid <", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLessThanOrEqualTo(String value) {
            addCriterion("tableid <=", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLike(String value) {
            addCriterion("tableid like", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotLike(String value) {
            addCriterion("tableid not like", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidIn(List<String> values) {
            addCriterion("tableid in", values, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotIn(List<String> values) {
            addCriterion("tableid not in", values, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidBetween(String value1, String value2) {
            addCriterion("tableid between", value1, value2, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotBetween(String value1, String value2) {
            addCriterion("tableid not between", value1, value2, "tableid");
            return (Criteria) this;
        }

        public Criteria andFieldDescIsNull() {
            addCriterion("field_desc is null");
            return (Criteria) this;
        }

        public Criteria andFieldDescIsNotNull() {
            addCriterion("field_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFieldDescEqualTo(String value) {
            addCriterion("field_desc =", value, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescNotEqualTo(String value) {
            addCriterion("field_desc <>", value, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescGreaterThan(String value) {
            addCriterion("field_desc >", value, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescGreaterThanOrEqualTo(String value) {
            addCriterion("field_desc >=", value, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescLessThan(String value) {
            addCriterion("field_desc <", value, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescLessThanOrEqualTo(String value) {
            addCriterion("field_desc <=", value, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescLike(String value) {
            addCriterion("field_desc like", value, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescNotLike(String value) {
            addCriterion("field_desc not like", value, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescIn(List<String> values) {
            addCriterion("field_desc in", values, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescNotIn(List<String> values) {
            addCriterion("field_desc not in", values, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescBetween(String value1, String value2) {
            addCriterion("field_desc between", value1, value2, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldDescNotBetween(String value1, String value2) {
            addCriterion("field_desc not between", value1, value2, "fieldDesc");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNull() {
            addCriterion("field_type is null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNotNull() {
            addCriterion("field_type is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeEqualTo(Integer value) {
            addCriterion("field_type =", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotEqualTo(Integer value) {
            addCriterion("field_type <>", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThan(Integer value) {
            addCriterion("field_type >", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_type >=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThan(Integer value) {
            addCriterion("field_type <", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThanOrEqualTo(Integer value) {
            addCriterion("field_type <=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIn(List<Integer> values) {
            addCriterion("field_type in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotIn(List<Integer> values) {
            addCriterion("field_type not in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeBetween(Integer value1, Integer value2) {
            addCriterion("field_type between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("field_type not between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIsNull() {
            addCriterion("field_length is null");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIsNotNull() {
            addCriterion("field_length is not null");
            return (Criteria) this;
        }

        public Criteria andFieldLengthEqualTo(Integer value) {
            addCriterion("field_length =", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotEqualTo(Integer value) {
            addCriterion("field_length <>", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthGreaterThan(Integer value) {
            addCriterion("field_length >", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_length >=", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthLessThan(Integer value) {
            addCriterion("field_length <", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthLessThanOrEqualTo(Integer value) {
            addCriterion("field_length <=", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIn(List<Integer> values) {
            addCriterion("field_length in", values, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotIn(List<Integer> values) {
            addCriterion("field_length not in", values, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthBetween(Integer value1, Integer value2) {
            addCriterion("field_length between", value1, value2, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("field_length not between", value1, value2, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andParentNodeIsNull() {
            addCriterion("parent_node is null");
            return (Criteria) this;
        }

        public Criteria andParentNodeIsNotNull() {
            addCriterion("parent_node is not null");
            return (Criteria) this;
        }

        public Criteria andParentNodeEqualTo(String value) {
            addCriterion("parent_node =", value, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeNotEqualTo(String value) {
            addCriterion("parent_node <>", value, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeGreaterThan(String value) {
            addCriterion("parent_node >", value, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_node >=", value, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeLessThan(String value) {
            addCriterion("parent_node <", value, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeLessThanOrEqualTo(String value) {
            addCriterion("parent_node <=", value, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeLike(String value) {
            addCriterion("parent_node like", value, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeNotLike(String value) {
            addCriterion("parent_node not like", value, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeIn(List<String> values) {
            addCriterion("parent_node in", values, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeNotIn(List<String> values) {
            addCriterion("parent_node not in", values, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeBetween(String value1, String value2) {
            addCriterion("parent_node between", value1, value2, "parentNode");
            return (Criteria) this;
        }

        public Criteria andParentNodeNotBetween(String value1, String value2) {
            addCriterion("parent_node not between", value1, value2, "parentNode");
            return (Criteria) this;
        }

        public Criteria andSrcContentIsNull() {
            addCriterion("src_content is null");
            return (Criteria) this;
        }

        public Criteria andSrcContentIsNotNull() {
            addCriterion("src_content is not null");
            return (Criteria) this;
        }

        public Criteria andSrcContentEqualTo(String value) {
            addCriterion("src_content =", value, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentNotEqualTo(String value) {
            addCriterion("src_content <>", value, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentGreaterThan(String value) {
            addCriterion("src_content >", value, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentGreaterThanOrEqualTo(String value) {
            addCriterion("src_content >=", value, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentLessThan(String value) {
            addCriterion("src_content <", value, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentLessThanOrEqualTo(String value) {
            addCriterion("src_content <=", value, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentLike(String value) {
            addCriterion("src_content like", value, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentNotLike(String value) {
            addCriterion("src_content not like", value, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentIn(List<String> values) {
            addCriterion("src_content in", values, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentNotIn(List<String> values) {
            addCriterion("src_content not in", values, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentBetween(String value1, String value2) {
            addCriterion("src_content between", value1, value2, "srcContent");
            return (Criteria) this;
        }

        public Criteria andSrcContentNotBetween(String value1, String value2) {
            addCriterion("src_content not between", value1, value2, "srcContent");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputIsNull() {
            addCriterion("default_output is null");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputIsNotNull() {
            addCriterion("default_output is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputEqualTo(Integer value) {
            addCriterion("default_output =", value, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputNotEqualTo(Integer value) {
            addCriterion("default_output <>", value, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputGreaterThan(Integer value) {
            addCriterion("default_output >", value, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_output >=", value, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputLessThan(Integer value) {
            addCriterion("default_output <", value, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputLessThanOrEqualTo(Integer value) {
            addCriterion("default_output <=", value, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputIn(List<Integer> values) {
            addCriterion("default_output in", values, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputNotIn(List<Integer> values) {
            addCriterion("default_output not in", values, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputBetween(Integer value1, Integer value2) {
            addCriterion("default_output between", value1, value2, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andDefaultOutputNotBetween(Integer value1, Integer value2) {
            addCriterion("default_output not between", value1, value2, "defaultOutput");
            return (Criteria) this;
        }

        public Criteria andSrcWhereIsNull() {
            addCriterion("src_where is null");
            return (Criteria) this;
        }

        public Criteria andSrcWhereIsNotNull() {
            addCriterion("src_where is not null");
            return (Criteria) this;
        }

        public Criteria andSrcWhereEqualTo(String value) {
            addCriterion("src_where =", value, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereNotEqualTo(String value) {
            addCriterion("src_where <>", value, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereGreaterThan(String value) {
            addCriterion("src_where >", value, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereGreaterThanOrEqualTo(String value) {
            addCriterion("src_where >=", value, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereLessThan(String value) {
            addCriterion("src_where <", value, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereLessThanOrEqualTo(String value) {
            addCriterion("src_where <=", value, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereLike(String value) {
            addCriterion("src_where like", value, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereNotLike(String value) {
            addCriterion("src_where not like", value, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereIn(List<String> values) {
            addCriterion("src_where in", values, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereNotIn(List<String> values) {
            addCriterion("src_where not in", values, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereBetween(String value1, String value2) {
            addCriterion("src_where between", value1, value2, "srcWhere");
            return (Criteria) this;
        }

        public Criteria andSrcWhereNotBetween(String value1, String value2) {
            addCriterion("src_where not between", value1, value2, "srcWhere");
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