package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class RtmSrcRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RtmSrcRecordCriteria() {
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

        public Criteria andInfoIdIsNull() {
            addCriterion("INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(String value) {
            addCriterion("INFO_ID =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(String value) {
            addCriterion("INFO_ID <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(String value) {
            addCriterion("INFO_ID >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_ID >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(String value) {
            addCriterion("INFO_ID <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(String value) {
            addCriterion("INFO_ID <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLike(String value) {
            addCriterion("INFO_ID like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotLike(String value) {
            addCriterion("INFO_ID not like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<String> values) {
            addCriterion("INFO_ID in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<String> values) {
            addCriterion("INFO_ID not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(String value1, String value2) {
            addCriterion("INFO_ID between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(String value1, String value2) {
            addCriterion("INFO_ID not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNull() {
            addCriterion("FIELD_ID is null");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNotNull() {
            addCriterion("FIELD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIdEqualTo(String value) {
            addCriterion("FIELD_ID =", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotEqualTo(String value) {
            addCriterion("FIELD_ID <>", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThan(String value) {
            addCriterion("FIELD_ID >", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_ID >=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThan(String value) {
            addCriterion("FIELD_ID <", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThanOrEqualTo(String value) {
            addCriterion("FIELD_ID <=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLike(String value) {
            addCriterion("FIELD_ID like", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotLike(String value) {
            addCriterion("FIELD_ID not like", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIn(List<String> values) {
            addCriterion("FIELD_ID in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotIn(List<String> values) {
            addCriterion("FIELD_ID not in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdBetween(String value1, String value2) {
            addCriterion("FIELD_ID between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotBetween(String value1, String value2) {
            addCriterion("FIELD_ID not between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNull() {
            addCriterion("FIELD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("FIELD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("FIELD_NAME =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("FIELD_NAME <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("FIELD_NAME >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_NAME >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("FIELD_NAME <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("FIELD_NAME <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("FIELD_NAME like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("FIELD_NAME not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("FIELD_NAME in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("FIELD_NAME not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("FIELD_NAME between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("FIELD_NAME not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andStartLocalIsNull() {
            addCriterion("START_LOCAL is null");
            return (Criteria) this;
        }

        public Criteria andStartLocalIsNotNull() {
            addCriterion("START_LOCAL is not null");
            return (Criteria) this;
        }

        public Criteria andStartLocalEqualTo(String value) {
            addCriterion("START_LOCAL =", value, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalNotEqualTo(String value) {
            addCriterion("START_LOCAL <>", value, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalGreaterThan(String value) {
            addCriterion("START_LOCAL >", value, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalGreaterThanOrEqualTo(String value) {
            addCriterion("START_LOCAL >=", value, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalLessThan(String value) {
            addCriterion("START_LOCAL <", value, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalLessThanOrEqualTo(String value) {
            addCriterion("START_LOCAL <=", value, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalLike(String value) {
            addCriterion("START_LOCAL like", value, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalNotLike(String value) {
            addCriterion("START_LOCAL not like", value, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalIn(List<String> values) {
            addCriterion("START_LOCAL in", values, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalNotIn(List<String> values) {
            addCriterion("START_LOCAL not in", values, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalBetween(String value1, String value2) {
            addCriterion("START_LOCAL between", value1, value2, "startLocal");
            return (Criteria) this;
        }

        public Criteria andStartLocalNotBetween(String value1, String value2) {
            addCriterion("START_LOCAL not between", value1, value2, "startLocal");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIsNull() {
            addCriterion("FIELD_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIsNotNull() {
            addCriterion("FIELD_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andFieldLengthEqualTo(String value) {
            addCriterion("FIELD_LENGTH =", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotEqualTo(String value) {
            addCriterion("FIELD_LENGTH <>", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthGreaterThan(String value) {
            addCriterion("FIELD_LENGTH >", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_LENGTH >=", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthLessThan(String value) {
            addCriterion("FIELD_LENGTH <", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthLessThanOrEqualTo(String value) {
            addCriterion("FIELD_LENGTH <=", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthLike(String value) {
            addCriterion("FIELD_LENGTH like", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotLike(String value) {
            addCriterion("FIELD_LENGTH not like", value, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthIn(List<String> values) {
            addCriterion("FIELD_LENGTH in", values, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotIn(List<String> values) {
            addCriterion("FIELD_LENGTH not in", values, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthBetween(String value1, String value2) {
            addCriterion("FIELD_LENGTH between", value1, value2, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldLengthNotBetween(String value1, String value2) {
            addCriterion("FIELD_LENGTH not between", value1, value2, "fieldLength");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNull() {
            addCriterion("FIELD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNotNull() {
            addCriterion("FIELD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeEqualTo(String value) {
            addCriterion("FIELD_TYPE =", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotEqualTo(String value) {
            addCriterion("FIELD_TYPE <>", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThan(String value) {
            addCriterion("FIELD_TYPE >", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_TYPE >=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThan(String value) {
            addCriterion("FIELD_TYPE <", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThanOrEqualTo(String value) {
            addCriterion("FIELD_TYPE <=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLike(String value) {
            addCriterion("FIELD_TYPE like", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotLike(String value) {
            addCriterion("FIELD_TYPE not like", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIn(List<String> values) {
            addCriterion("FIELD_TYPE in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotIn(List<String> values) {
            addCriterion("FIELD_TYPE not in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeBetween(String value1, String value2) {
            addCriterion("FIELD_TYPE between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotBetween(String value1, String value2) {
            addCriterion("FIELD_TYPE not between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andIsSnIsNull() {
            addCriterion("IS_SN is null");
            return (Criteria) this;
        }

        public Criteria andIsSnIsNotNull() {
            addCriterion("IS_SN is not null");
            return (Criteria) this;
        }

        public Criteria andIsSnEqualTo(String value) {
            addCriterion("IS_SN =", value, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnNotEqualTo(String value) {
            addCriterion("IS_SN <>", value, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnGreaterThan(String value) {
            addCriterion("IS_SN >", value, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SN >=", value, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnLessThan(String value) {
            addCriterion("IS_SN <", value, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnLessThanOrEqualTo(String value) {
            addCriterion("IS_SN <=", value, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnLike(String value) {
            addCriterion("IS_SN like", value, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnNotLike(String value) {
            addCriterion("IS_SN not like", value, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnIn(List<String> values) {
            addCriterion("IS_SN in", values, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnNotIn(List<String> values) {
            addCriterion("IS_SN not in", values, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnBetween(String value1, String value2) {
            addCriterion("IS_SN between", value1, value2, "isSn");
            return (Criteria) this;
        }

        public Criteria andIsSnNotBetween(String value1, String value2) {
            addCriterion("IS_SN not between", value1, value2, "isSn");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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