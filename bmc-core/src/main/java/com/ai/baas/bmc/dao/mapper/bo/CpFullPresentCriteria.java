package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CpFullPresentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpFullPresentCriteria() {
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

        public Criteria andPresentIdIsNull() {
            addCriterion("PRESENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPresentIdIsNotNull() {
            addCriterion("PRESENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPresentIdEqualTo(Long value) {
            addCriterion("PRESENT_ID =", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotEqualTo(Long value) {
            addCriterion("PRESENT_ID <>", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdGreaterThan(Long value) {
            addCriterion("PRESENT_ID >", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PRESENT_ID >=", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdLessThan(Long value) {
            addCriterion("PRESENT_ID <", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdLessThanOrEqualTo(Long value) {
            addCriterion("PRESENT_ID <=", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdIn(List<Long> values) {
            addCriterion("PRESENT_ID in", values, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotIn(List<Long> values) {
            addCriterion("PRESENT_ID not in", values, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdBetween(Long value1, Long value2) {
            addCriterion("PRESENT_ID between", value1, value2, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotBetween(Long value1, Long value2) {
            addCriterion("PRESENT_ID not between", value1, value2, "presentId");
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

        public Criteria andPresentTypeIsNull() {
            addCriterion("PRESENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPresentTypeIsNotNull() {
            addCriterion("PRESENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPresentTypeEqualTo(String value) {
            addCriterion("PRESENT_TYPE =", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeNotEqualTo(String value) {
            addCriterion("PRESENT_TYPE <>", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeGreaterThan(String value) {
            addCriterion("PRESENT_TYPE >", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRESENT_TYPE >=", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeLessThan(String value) {
            addCriterion("PRESENT_TYPE <", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeLessThanOrEqualTo(String value) {
            addCriterion("PRESENT_TYPE <=", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeLike(String value) {
            addCriterion("PRESENT_TYPE like", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeNotLike(String value) {
            addCriterion("PRESENT_TYPE not like", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeIn(List<String> values) {
            addCriterion("PRESENT_TYPE in", values, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeNotIn(List<String> values) {
            addCriterion("PRESENT_TYPE not in", values, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeBetween(String value1, String value2) {
            addCriterion("PRESENT_TYPE between", value1, value2, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeNotBetween(String value1, String value2) {
            addCriterion("PRESENT_TYPE not between", value1, value2, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentAmountIsNull() {
            addCriterion("PRESENT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPresentAmountIsNotNull() {
            addCriterion("PRESENT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPresentAmountEqualTo(Double value) {
            addCriterion("PRESENT_AMOUNT =", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountNotEqualTo(Double value) {
            addCriterion("PRESENT_AMOUNT <>", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountGreaterThan(Double value) {
            addCriterion("PRESENT_AMOUNT >", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("PRESENT_AMOUNT >=", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountLessThan(Double value) {
            addCriterion("PRESENT_AMOUNT <", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountLessThanOrEqualTo(Double value) {
            addCriterion("PRESENT_AMOUNT <=", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountIn(List<Double> values) {
            addCriterion("PRESENT_AMOUNT in", values, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountNotIn(List<Double> values) {
            addCriterion("PRESENT_AMOUNT not in", values, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountBetween(Double value1, Double value2) {
            addCriterion("PRESENT_AMOUNT between", value1, value2, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountNotBetween(Double value1, Double value2) {
            addCriterion("PRESENT_AMOUNT not between", value1, value2, "presentAmount");
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

        public Criteria andProductIdsIsNull() {
            addCriterion("PRODUCT_IDS is null");
            return (Criteria) this;
        }

        public Criteria andProductIdsIsNotNull() {
            addCriterion("PRODUCT_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdsEqualTo(String value) {
            addCriterion("PRODUCT_IDS =", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsNotEqualTo(String value) {
            addCriterion("PRODUCT_IDS <>", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsGreaterThan(String value) {
            addCriterion("PRODUCT_IDS >", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_IDS >=", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsLessThan(String value) {
            addCriterion("PRODUCT_IDS <", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_IDS <=", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsLike(String value) {
            addCriterion("PRODUCT_IDS like", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsNotLike(String value) {
            addCriterion("PRODUCT_IDS not like", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsIn(List<String> values) {
            addCriterion("PRODUCT_IDS in", values, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsNotIn(List<String> values) {
            addCriterion("PRODUCT_IDS not in", values, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsBetween(String value1, String value2) {
            addCriterion("PRODUCT_IDS between", value1, value2, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_IDS not between", value1, value2, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsIsNull() {
            addCriterion("PRODUCT_GIFT_IDS is null");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsIsNotNull() {
            addCriterion("PRODUCT_GIFT_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsEqualTo(String value) {
            addCriterion("PRODUCT_GIFT_IDS =", value, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsNotEqualTo(String value) {
            addCriterion("PRODUCT_GIFT_IDS <>", value, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsGreaterThan(String value) {
            addCriterion("PRODUCT_GIFT_IDS >", value, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_GIFT_IDS >=", value, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsLessThan(String value) {
            addCriterion("PRODUCT_GIFT_IDS <", value, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_GIFT_IDS <=", value, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsLike(String value) {
            addCriterion("PRODUCT_GIFT_IDS like", value, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsNotLike(String value) {
            addCriterion("PRODUCT_GIFT_IDS not like", value, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsIn(List<String> values) {
            addCriterion("PRODUCT_GIFT_IDS in", values, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsNotIn(List<String> values) {
            addCriterion("PRODUCT_GIFT_IDS not in", values, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsBetween(String value1, String value2) {
            addCriterion("PRODUCT_GIFT_IDS between", value1, value2, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andProductGiftIdsNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_GIFT_IDS not between", value1, value2, "productGiftIds");
            return (Criteria) this;
        }

        public Criteria andPresentCodeIsNull() {
            addCriterion("PRESENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPresentCodeIsNotNull() {
            addCriterion("PRESENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPresentCodeEqualTo(String value) {
            addCriterion("PRESENT_CODE =", value, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeNotEqualTo(String value) {
            addCriterion("PRESENT_CODE <>", value, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeGreaterThan(String value) {
            addCriterion("PRESENT_CODE >", value, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRESENT_CODE >=", value, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeLessThan(String value) {
            addCriterion("PRESENT_CODE <", value, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeLessThanOrEqualTo(String value) {
            addCriterion("PRESENT_CODE <=", value, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeLike(String value) {
            addCriterion("PRESENT_CODE like", value, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeNotLike(String value) {
            addCriterion("PRESENT_CODE not like", value, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeIn(List<String> values) {
            addCriterion("PRESENT_CODE in", values, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeNotIn(List<String> values) {
            addCriterion("PRESENT_CODE not in", values, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeBetween(String value1, String value2) {
            addCriterion("PRESENT_CODE between", value1, value2, "presentCode");
            return (Criteria) this;
        }

        public Criteria andPresentCodeNotBetween(String value1, String value2) {
            addCriterion("PRESENT_CODE not between", value1, value2, "presentCode");
            return (Criteria) this;
        }

        public Criteria andReachAmountIsNull() {
            addCriterion("REACH_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReachAmountIsNotNull() {
            addCriterion("REACH_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReachAmountEqualTo(Double value) {
            addCriterion("REACH_AMOUNT =", value, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountNotEqualTo(Double value) {
            addCriterion("REACH_AMOUNT <>", value, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountGreaterThan(Double value) {
            addCriterion("REACH_AMOUNT >", value, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("REACH_AMOUNT >=", value, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountLessThan(Double value) {
            addCriterion("REACH_AMOUNT <", value, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountLessThanOrEqualTo(Double value) {
            addCriterion("REACH_AMOUNT <=", value, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountIn(List<Double> values) {
            addCriterion("REACH_AMOUNT in", values, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountNotIn(List<Double> values) {
            addCriterion("REACH_AMOUNT not in", values, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountBetween(Double value1, Double value2) {
            addCriterion("REACH_AMOUNT between", value1, value2, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andReachAmountNotBetween(Double value1, Double value2) {
            addCriterion("REACH_AMOUNT not between", value1, value2, "reachAmount");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("ACCOUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("ACCOUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(String value) {
            addCriterion("ACCOUNT_TYPE >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(String value) {
            addCriterion("ACCOUNT_TYPE <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLike(String value) {
            addCriterion("ACCOUNT_TYPE like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotLike(String value) {
            addCriterion("ACCOUNT_TYPE not like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<String> values) {
            addCriterion("ACCOUNT_TYPE in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<String> values) {
            addCriterion("ACCOUNT_TYPE not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(String value1, String value2) {
            addCriterion("ACCOUNT_TYPE between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_TYPE not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountIsNull() {
            addCriterion("RELATED_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountIsNotNull() {
            addCriterion("RELATED_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountEqualTo(String value) {
            addCriterion("RELATED_ACCOUNT =", value, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountNotEqualTo(String value) {
            addCriterion("RELATED_ACCOUNT <>", value, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountGreaterThan(String value) {
            addCriterion("RELATED_ACCOUNT >", value, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountGreaterThanOrEqualTo(String value) {
            addCriterion("RELATED_ACCOUNT >=", value, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountLessThan(String value) {
            addCriterion("RELATED_ACCOUNT <", value, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountLessThanOrEqualTo(String value) {
            addCriterion("RELATED_ACCOUNT <=", value, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountLike(String value) {
            addCriterion("RELATED_ACCOUNT like", value, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountNotLike(String value) {
            addCriterion("RELATED_ACCOUNT not like", value, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountIn(List<String> values) {
            addCriterion("RELATED_ACCOUNT in", values, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountNotIn(List<String> values) {
            addCriterion("RELATED_ACCOUNT not in", values, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountBetween(String value1, String value2) {
            addCriterion("RELATED_ACCOUNT between", value1, value2, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andRelatedAccountNotBetween(String value1, String value2) {
            addCriterion("RELATED_ACCOUNT not between", value1, value2, "relatedAccount");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIsNull() {
            addCriterion("ACTIVE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIsNotNull() {
            addCriterion("ACTIVE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andActiveFlagEqualTo(String value) {
            addCriterion("ACTIVE_FLAG =", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotEqualTo(String value) {
            addCriterion("ACTIVE_FLAG <>", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagGreaterThan(String value) {
            addCriterion("ACTIVE_FLAG >", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVE_FLAG >=", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLessThan(String value) {
            addCriterion("ACTIVE_FLAG <", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLessThanOrEqualTo(String value) {
            addCriterion("ACTIVE_FLAG <=", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLike(String value) {
            addCriterion("ACTIVE_FLAG like", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotLike(String value) {
            addCriterion("ACTIVE_FLAG not like", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIn(List<String> values) {
            addCriterion("ACTIVE_FLAG in", values, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotIn(List<String> values) {
            addCriterion("ACTIVE_FLAG not in", values, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagBetween(String value1, String value2) {
            addCriterion("ACTIVE_FLAG between", value1, value2, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotBetween(String value1, String value2) {
            addCriterion("ACTIVE_FLAG not between", value1, value2, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveCycleIsNull() {
            addCriterion("ACTIVE_CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andActiveCycleIsNotNull() {
            addCriterion("ACTIVE_CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andActiveCycleEqualTo(String value) {
            addCriterion("ACTIVE_CYCLE =", value, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleNotEqualTo(String value) {
            addCriterion("ACTIVE_CYCLE <>", value, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleGreaterThan(String value) {
            addCriterion("ACTIVE_CYCLE >", value, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVE_CYCLE >=", value, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleLessThan(String value) {
            addCriterion("ACTIVE_CYCLE <", value, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleLessThanOrEqualTo(String value) {
            addCriterion("ACTIVE_CYCLE <=", value, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleLike(String value) {
            addCriterion("ACTIVE_CYCLE like", value, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleNotLike(String value) {
            addCriterion("ACTIVE_CYCLE not like", value, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleIn(List<String> values) {
            addCriterion("ACTIVE_CYCLE in", values, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleNotIn(List<String> values) {
            addCriterion("ACTIVE_CYCLE not in", values, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleBetween(String value1, String value2) {
            addCriterion("ACTIVE_CYCLE between", value1, value2, "activeCycle");
            return (Criteria) this;
        }

        public Criteria andActiveCycleNotBetween(String value1, String value2) {
            addCriterion("ACTIVE_CYCLE not between", value1, value2, "activeCycle");
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