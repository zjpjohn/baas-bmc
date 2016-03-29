package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CpPriceDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpPriceDetailCriteria() {
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

        public Criteria andDetailIdIsNull() {
            addCriterion("DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Long value) {
            addCriterion("DETAIL_ID =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Long value) {
            addCriterion("DETAIL_ID <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Long value) {
            addCriterion("DETAIL_ID >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DETAIL_ID >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Long value) {
            addCriterion("DETAIL_ID <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("DETAIL_ID <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Long> values) {
            addCriterion("DETAIL_ID in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Long> values) {
            addCriterion("DETAIL_ID not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Long value1, Long value2) {
            addCriterion("DETAIL_ID between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("DETAIL_ID not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andPriceCodeIsNull() {
            addCriterion("PRICE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPriceCodeIsNotNull() {
            addCriterion("PRICE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceCodeEqualTo(String value) {
            addCriterion("PRICE_CODE =", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeNotEqualTo(String value) {
            addCriterion("PRICE_CODE <>", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeGreaterThan(String value) {
            addCriterion("PRICE_CODE >", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_CODE >=", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeLessThan(String value) {
            addCriterion("PRICE_CODE <", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeLessThanOrEqualTo(String value) {
            addCriterion("PRICE_CODE <=", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeLike(String value) {
            addCriterion("PRICE_CODE like", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeNotLike(String value) {
            addCriterion("PRICE_CODE not like", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeIn(List<String> values) {
            addCriterion("PRICE_CODE in", values, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeNotIn(List<String> values) {
            addCriterion("PRICE_CODE not in", values, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeBetween(String value1, String value2) {
            addCriterion("PRICE_CODE between", value1, value2, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeNotBetween(String value1, String value2) {
            addCriterion("PRICE_CODE not between", value1, value2, "priceCode");
            return (Criteria) this;
        }

        public Criteria andDetailNameIsNull() {
            addCriterion("DETAIL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDetailNameIsNotNull() {
            addCriterion("DETAIL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDetailNameEqualTo(String value) {
            addCriterion("DETAIL_NAME =", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameNotEqualTo(String value) {
            addCriterion("DETAIL_NAME <>", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameGreaterThan(String value) {
            addCriterion("DETAIL_NAME >", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_NAME >=", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameLessThan(String value) {
            addCriterion("DETAIL_NAME <", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_NAME <=", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameLike(String value) {
            addCriterion("DETAIL_NAME like", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameNotLike(String value) {
            addCriterion("DETAIL_NAME not like", value, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameIn(List<String> values) {
            addCriterion("DETAIL_NAME in", values, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameNotIn(List<String> values) {
            addCriterion("DETAIL_NAME not in", values, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameBetween(String value1, String value2) {
            addCriterion("DETAIL_NAME between", value1, value2, "detailName");
            return (Criteria) this;
        }

        public Criteria andDetailNameNotBetween(String value1, String value2) {
            addCriterion("DETAIL_NAME not between", value1, value2, "detailName");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("CHARGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("CHARGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(String value) {
            addCriterion("CHARGE_TYPE =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(String value) {
            addCriterion("CHARGE_TYPE <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(String value) {
            addCriterion("CHARGE_TYPE >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHARGE_TYPE >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(String value) {
            addCriterion("CHARGE_TYPE <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(String value) {
            addCriterion("CHARGE_TYPE <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLike(String value) {
            addCriterion("CHARGE_TYPE like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotLike(String value) {
            addCriterion("CHARGE_TYPE not like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<String> values) {
            addCriterion("CHARGE_TYPE in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<String> values) {
            addCriterion("CHARGE_TYPE not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(String value1, String value2) {
            addCriterion("CHARGE_TYPE between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(String value1, String value2) {
            addCriterion("CHARGE_TYPE not between", value1, value2, "chargeType");
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

        public Criteria andServiceTypeIsNull() {
            addCriterion("SERVICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("SERVICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("SERVICE_TYPE =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("SERVICE_TYPE <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("SERVICE_TYPE >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_TYPE >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("SERVICE_TYPE <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_TYPE <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("SERVICE_TYPE like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("SERVICE_TYPE not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("SERVICE_TYPE in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("SERVICE_TYPE not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("SERVICE_TYPE between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("SERVICE_TYPE not between", value1, value2, "serviceType");
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