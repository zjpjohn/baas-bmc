package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class RtmSrcInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RtmSrcInfoCriteria() {
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

        public Criteria andInfoTypeIsNull() {
            addCriterion("INFO_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIsNotNull() {
            addCriterion("INFO_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeEqualTo(String value) {
            addCriterion("INFO_TYPE =", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotEqualTo(String value) {
            addCriterion("INFO_TYPE <>", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeGreaterThan(String value) {
            addCriterion("INFO_TYPE >", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_TYPE >=", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLessThan(String value) {
            addCriterion("INFO_TYPE <", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLessThanOrEqualTo(String value) {
            addCriterion("INFO_TYPE <=", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLike(String value) {
            addCriterion("INFO_TYPE like", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotLike(String value) {
            addCriterion("INFO_TYPE not like", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIn(List<String> values) {
            addCriterion("INFO_TYPE in", values, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotIn(List<String> values) {
            addCriterion("INFO_TYPE not in", values, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeBetween(String value1, String value2) {
            addCriterion("INFO_TYPE between", value1, value2, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotBetween(String value1, String value2) {
            addCriterion("INFO_TYPE not between", value1, value2, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagIsNull() {
            addCriterion("INFO_SPLIT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagIsNotNull() {
            addCriterion("INFO_SPLIT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagEqualTo(String value) {
            addCriterion("INFO_SPLIT_FLAG =", value, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagNotEqualTo(String value) {
            addCriterion("INFO_SPLIT_FLAG <>", value, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagGreaterThan(String value) {
            addCriterion("INFO_SPLIT_FLAG >", value, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_SPLIT_FLAG >=", value, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagLessThan(String value) {
            addCriterion("INFO_SPLIT_FLAG <", value, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagLessThanOrEqualTo(String value) {
            addCriterion("INFO_SPLIT_FLAG <=", value, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagLike(String value) {
            addCriterion("INFO_SPLIT_FLAG like", value, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagNotLike(String value) {
            addCriterion("INFO_SPLIT_FLAG not like", value, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagIn(List<String> values) {
            addCriterion("INFO_SPLIT_FLAG in", values, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagNotIn(List<String> values) {
            addCriterion("INFO_SPLIT_FLAG not in", values, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagBetween(String value1, String value2) {
            addCriterion("INFO_SPLIT_FLAG between", value1, value2, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andInfoSplitFlagNotBetween(String value1, String value2) {
            addCriterion("INFO_SPLIT_FLAG not between", value1, value2, "infoSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagIsNull() {
            addCriterion("record_split_flag is null");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagIsNotNull() {
            addCriterion("record_split_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagEqualTo(String value) {
            addCriterion("record_split_flag =", value, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagNotEqualTo(String value) {
            addCriterion("record_split_flag <>", value, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagGreaterThan(String value) {
            addCriterion("record_split_flag >", value, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagGreaterThanOrEqualTo(String value) {
            addCriterion("record_split_flag >=", value, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagLessThan(String value) {
            addCriterion("record_split_flag <", value, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagLessThanOrEqualTo(String value) {
            addCriterion("record_split_flag <=", value, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagLike(String value) {
            addCriterion("record_split_flag like", value, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagNotLike(String value) {
            addCriterion("record_split_flag not like", value, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagIn(List<String> values) {
            addCriterion("record_split_flag in", values, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagNotIn(List<String> values) {
            addCriterion("record_split_flag not in", values, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagBetween(String value1, String value2) {
            addCriterion("record_split_flag between", value1, value2, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andRecordSplitFlagNotBetween(String value1, String value2) {
            addCriterion("record_split_flag not between", value1, value2, "recordSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagIsNull() {
            addCriterion("field_split_flag is null");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagIsNotNull() {
            addCriterion("field_split_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagEqualTo(String value) {
            addCriterion("field_split_flag =", value, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagNotEqualTo(String value) {
            addCriterion("field_split_flag <>", value, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagGreaterThan(String value) {
            addCriterion("field_split_flag >", value, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagGreaterThanOrEqualTo(String value) {
            addCriterion("field_split_flag >=", value, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagLessThan(String value) {
            addCriterion("field_split_flag <", value, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagLessThanOrEqualTo(String value) {
            addCriterion("field_split_flag <=", value, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagLike(String value) {
            addCriterion("field_split_flag like", value, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagNotLike(String value) {
            addCriterion("field_split_flag not like", value, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagIn(List<String> values) {
            addCriterion("field_split_flag in", values, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagNotIn(List<String> values) {
            addCriterion("field_split_flag not in", values, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagBetween(String value1, String value2) {
            addCriterion("field_split_flag between", value1, value2, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andFieldSplitFlagNotBetween(String value1, String value2) {
            addCriterion("field_split_flag not between", value1, value2, "fieldSplitFlag");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("COMMENTS is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("COMMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("COMMENTS =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("COMMENTS <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("COMMENTS >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENTS >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("COMMENTS <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("COMMENTS <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("COMMENTS like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("COMMENTS not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("COMMENTS in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("COMMENTS not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("COMMENTS between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("COMMENTS not between", value1, value2, "comments");
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