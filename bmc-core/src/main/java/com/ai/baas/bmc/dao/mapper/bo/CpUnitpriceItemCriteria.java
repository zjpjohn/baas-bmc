package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CpUnitpriceItemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpUnitpriceItemCriteria() {
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

        public Criteria andUnitItemIdIsNull() {
            addCriterion("UNIT_ITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdIsNotNull() {
            addCriterion("UNIT_ITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdEqualTo(Integer value) {
            addCriterion("UNIT_ITEM_ID =", value, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdNotEqualTo(Integer value) {
            addCriterion("UNIT_ITEM_ID <>", value, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdGreaterThan(Integer value) {
            addCriterion("UNIT_ITEM_ID >", value, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNIT_ITEM_ID >=", value, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdLessThan(Integer value) {
            addCriterion("UNIT_ITEM_ID <", value, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("UNIT_ITEM_ID <=", value, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdIn(List<Integer> values) {
            addCriterion("UNIT_ITEM_ID in", values, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdNotIn(List<Integer> values) {
            addCriterion("UNIT_ITEM_ID not in", values, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdBetween(Integer value1, Integer value2) {
            addCriterion("UNIT_ITEM_ID between", value1, value2, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andUnitItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UNIT_ITEM_ID not between", value1, value2, "unitItemId");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeIsNull() {
            addCriterion("FEE_ITEM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeIsNotNull() {
            addCriterion("FEE_ITEM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeEqualTo(String value) {
            addCriterion("FEE_ITEM_CODE =", value, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeNotEqualTo(String value) {
            addCriterion("FEE_ITEM_CODE <>", value, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeGreaterThan(String value) {
            addCriterion("FEE_ITEM_CODE >", value, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_ITEM_CODE >=", value, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeLessThan(String value) {
            addCriterion("FEE_ITEM_CODE <", value, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeLessThanOrEqualTo(String value) {
            addCriterion("FEE_ITEM_CODE <=", value, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeLike(String value) {
            addCriterion("FEE_ITEM_CODE like", value, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeNotLike(String value) {
            addCriterion("FEE_ITEM_CODE not like", value, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeIn(List<String> values) {
            addCriterion("FEE_ITEM_CODE in", values, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeNotIn(List<String> values) {
            addCriterion("FEE_ITEM_CODE not in", values, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeBetween(String value1, String value2) {
            addCriterion("FEE_ITEM_CODE between", value1, value2, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeItemCodeNotBetween(String value1, String value2) {
            addCriterion("FEE_ITEM_CODE not between", value1, value2, "feeItemCode");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNull() {
            addCriterion("FEE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNotNull() {
            addCriterion("FEE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(Integer value) {
            addCriterion("FEE_TYPE =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotEqualTo(Integer value) {
            addCriterion("FEE_TYPE <>", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThan(Integer value) {
            addCriterion("FEE_TYPE >", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEE_TYPE >=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThan(Integer value) {
            addCriterion("FEE_TYPE <", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("FEE_TYPE <=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIn(List<Integer> values) {
            addCriterion("FEE_TYPE in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotIn(List<Integer> values) {
            addCriterion("FEE_TYPE not in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("FEE_TYPE between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("FEE_TYPE not between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andPriceValueIsNull() {
            addCriterion("PRICE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andPriceValueIsNotNull() {
            addCriterion("PRICE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceValueEqualTo(Double value) {
            addCriterion("PRICE_VALUE =", value, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueNotEqualTo(Double value) {
            addCriterion("PRICE_VALUE <>", value, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueGreaterThan(Double value) {
            addCriterion("PRICE_VALUE >", value, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueGreaterThanOrEqualTo(Double value) {
            addCriterion("PRICE_VALUE >=", value, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueLessThan(Double value) {
            addCriterion("PRICE_VALUE <", value, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueLessThanOrEqualTo(Double value) {
            addCriterion("PRICE_VALUE <=", value, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueIn(List<Double> values) {
            addCriterion("PRICE_VALUE in", values, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueNotIn(List<Double> values) {
            addCriterion("PRICE_VALUE not in", values, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueBetween(Double value1, Double value2) {
            addCriterion("PRICE_VALUE between", value1, value2, "priceValue");
            return (Criteria) this;
        }

        public Criteria andPriceValueNotBetween(Double value1, Double value2) {
            addCriterion("PRICE_VALUE not between", value1, value2, "priceValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueIsNull() {
            addCriterion("UNIT_TYPE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueIsNotNull() {
            addCriterion("UNIT_TYPE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueEqualTo(Double value) {
            addCriterion("UNIT_TYPE_VALUE =", value, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueNotEqualTo(Double value) {
            addCriterion("UNIT_TYPE_VALUE <>", value, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueGreaterThan(Double value) {
            addCriterion("UNIT_TYPE_VALUE >", value, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueGreaterThanOrEqualTo(Double value) {
            addCriterion("UNIT_TYPE_VALUE >=", value, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueLessThan(Double value) {
            addCriterion("UNIT_TYPE_VALUE <", value, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueLessThanOrEqualTo(Double value) {
            addCriterion("UNIT_TYPE_VALUE <=", value, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueIn(List<Double> values) {
            addCriterion("UNIT_TYPE_VALUE in", values, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueNotIn(List<Double> values) {
            addCriterion("UNIT_TYPE_VALUE not in", values, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueBetween(Double value1, Double value2) {
            addCriterion("UNIT_TYPE_VALUE between", value1, value2, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeValueNotBetween(Double value1, Double value2) {
            addCriterion("UNIT_TYPE_VALUE not between", value1, value2, "unitTypeValue");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNull() {
            addCriterion("UNIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNotNull() {
            addCriterion("UNIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeEqualTo(String value) {
            addCriterion("UNIT_TYPE =", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotEqualTo(String value) {
            addCriterion("UNIT_TYPE <>", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThan(String value) {
            addCriterion("UNIT_TYPE >", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_TYPE >=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThan(String value) {
            addCriterion("UNIT_TYPE <", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("UNIT_TYPE <=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLike(String value) {
            addCriterion("UNIT_TYPE like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotLike(String value) {
            addCriterion("UNIT_TYPE not like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIn(List<String> values) {
            addCriterion("UNIT_TYPE in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotIn(List<String> values) {
            addCriterion("UNIT_TYPE not in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeBetween(String value1, String value2) {
            addCriterion("UNIT_TYPE between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotBetween(String value1, String value2) {
            addCriterion("UNIT_TYPE not between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeIsNull() {
            addCriterion("SUBJECT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeIsNotNull() {
            addCriterion("SUBJECT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeEqualTo(String value) {
            addCriterion("SUBJECT_CODE =", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeNotEqualTo(String value) {
            addCriterion("SUBJECT_CODE <>", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeGreaterThan(String value) {
            addCriterion("SUBJECT_CODE >", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT_CODE >=", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeLessThan(String value) {
            addCriterion("SUBJECT_CODE <", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT_CODE <=", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeLike(String value) {
            addCriterion("SUBJECT_CODE like", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeNotLike(String value) {
            addCriterion("SUBJECT_CODE not like", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeIn(List<String> values) {
            addCriterion("SUBJECT_CODE in", values, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeNotIn(List<String> values) {
            addCriterion("SUBJECT_CODE not in", values, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeBetween(String value1, String value2) {
            addCriterion("SUBJECT_CODE between", value1, value2, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeNotBetween(String value1, String value2) {
            addCriterion("SUBJECT_CODE not between", value1, value2, "subjectCode");
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

        public Criteria andActiveStatusIsNull() {
            addCriterion("ACTIVE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andActiveStatusIsNotNull() {
            addCriterion("ACTIVE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andActiveStatusEqualTo(String value) {
            addCriterion("ACTIVE_STATUS =", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotEqualTo(String value) {
            addCriterion("ACTIVE_STATUS <>", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusGreaterThan(String value) {
            addCriterion("ACTIVE_STATUS >", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVE_STATUS >=", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusLessThan(String value) {
            addCriterion("ACTIVE_STATUS <", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusLessThanOrEqualTo(String value) {
            addCriterion("ACTIVE_STATUS <=", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusLike(String value) {
            addCriterion("ACTIVE_STATUS like", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotLike(String value) {
            addCriterion("ACTIVE_STATUS not like", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusIn(List<String> values) {
            addCriterion("ACTIVE_STATUS in", values, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotIn(List<String> values) {
            addCriterion("ACTIVE_STATUS not in", values, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusBetween(String value1, String value2) {
            addCriterion("ACTIVE_STATUS between", value1, value2, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotBetween(String value1, String value2) {
            addCriterion("ACTIVE_STATUS not between", value1, value2, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeIsNull() {
            addCriterion("ITEM_EXT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeIsNotNull() {
            addCriterion("ITEM_EXT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeEqualTo(String value) {
            addCriterion("ITEM_EXT_CODE =", value, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeNotEqualTo(String value) {
            addCriterion("ITEM_EXT_CODE <>", value, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeGreaterThan(String value) {
            addCriterion("ITEM_EXT_CODE >", value, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_EXT_CODE >=", value, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeLessThan(String value) {
            addCriterion("ITEM_EXT_CODE <", value, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeLessThanOrEqualTo(String value) {
            addCriterion("ITEM_EXT_CODE <=", value, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeLike(String value) {
            addCriterion("ITEM_EXT_CODE like", value, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeNotLike(String value) {
            addCriterion("ITEM_EXT_CODE not like", value, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeIn(List<String> values) {
            addCriterion("ITEM_EXT_CODE in", values, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeNotIn(List<String> values) {
            addCriterion("ITEM_EXT_CODE not in", values, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeBetween(String value1, String value2) {
            addCriterion("ITEM_EXT_CODE between", value1, value2, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andItemExtCodeNotBetween(String value1, String value2) {
            addCriterion("ITEM_EXT_CODE not between", value1, value2, "itemExtCode");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("comments like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("comments not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("comments not between", value1, value2, "comments");
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