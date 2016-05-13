package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class CpStepInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpStepInfoCriteria() {
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

        public Criteria andSetpIdIsNull() {
            addCriterion("SETP_ID is null");
            return (Criteria) this;
        }

        public Criteria andSetpIdIsNotNull() {
            addCriterion("SETP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSetpIdEqualTo(Long value) {
            addCriterion("SETP_ID =", value, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdNotEqualTo(Long value) {
            addCriterion("SETP_ID <>", value, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdGreaterThan(Long value) {
            addCriterion("SETP_ID >", value, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SETP_ID >=", value, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdLessThan(Long value) {
            addCriterion("SETP_ID <", value, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdLessThanOrEqualTo(Long value) {
            addCriterion("SETP_ID <=", value, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdIn(List<Long> values) {
            addCriterion("SETP_ID in", values, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdNotIn(List<Long> values) {
            addCriterion("SETP_ID not in", values, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdBetween(Long value1, Long value2) {
            addCriterion("SETP_ID between", value1, value2, "setpId");
            return (Criteria) this;
        }

        public Criteria andSetpIdNotBetween(Long value1, Long value2) {
            addCriterion("SETP_ID not between", value1, value2, "setpId");
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

        public Criteria andStepSeqIsNull() {
            addCriterion("STEP_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andStepSeqIsNotNull() {
            addCriterion("STEP_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andStepSeqEqualTo(Long value) {
            addCriterion("STEP_SEQ =", value, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqNotEqualTo(Long value) {
            addCriterion("STEP_SEQ <>", value, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqGreaterThan(Long value) {
            addCriterion("STEP_SEQ >", value, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("STEP_SEQ >=", value, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqLessThan(Long value) {
            addCriterion("STEP_SEQ <", value, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqLessThanOrEqualTo(Long value) {
            addCriterion("STEP_SEQ <=", value, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqIn(List<Long> values) {
            addCriterion("STEP_SEQ in", values, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqNotIn(List<Long> values) {
            addCriterion("STEP_SEQ not in", values, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqBetween(Long value1, Long value2) {
            addCriterion("STEP_SEQ between", value1, value2, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andStepSeqNotBetween(Long value1, Long value2) {
            addCriterion("STEP_SEQ not between", value1, value2, "stepSeq");
            return (Criteria) this;
        }

        public Criteria andSectionAIsNull() {
            addCriterion("SECTION_A is null");
            return (Criteria) this;
        }

        public Criteria andSectionAIsNotNull() {
            addCriterion("SECTION_A is not null");
            return (Criteria) this;
        }

        public Criteria andSectionAEqualTo(Double value) {
            addCriterion("SECTION_A =", value, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionANotEqualTo(Double value) {
            addCriterion("SECTION_A <>", value, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionAGreaterThan(Double value) {
            addCriterion("SECTION_A >", value, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionAGreaterThanOrEqualTo(Double value) {
            addCriterion("SECTION_A >=", value, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionALessThan(Double value) {
            addCriterion("SECTION_A <", value, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionALessThanOrEqualTo(Double value) {
            addCriterion("SECTION_A <=", value, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionAIn(List<Double> values) {
            addCriterion("SECTION_A in", values, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionANotIn(List<Double> values) {
            addCriterion("SECTION_A not in", values, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionABetween(Double value1, Double value2) {
            addCriterion("SECTION_A between", value1, value2, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionANotBetween(Double value1, Double value2) {
            addCriterion("SECTION_A not between", value1, value2, "sectionA");
            return (Criteria) this;
        }

        public Criteria andSectionBIsNull() {
            addCriterion("SECTION_B is null");
            return (Criteria) this;
        }

        public Criteria andSectionBIsNotNull() {
            addCriterion("SECTION_B is not null");
            return (Criteria) this;
        }

        public Criteria andSectionBEqualTo(Double value) {
            addCriterion("SECTION_B =", value, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBNotEqualTo(Double value) {
            addCriterion("SECTION_B <>", value, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBGreaterThan(Double value) {
            addCriterion("SECTION_B >", value, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBGreaterThanOrEqualTo(Double value) {
            addCriterion("SECTION_B >=", value, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBLessThan(Double value) {
            addCriterion("SECTION_B <", value, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBLessThanOrEqualTo(Double value) {
            addCriterion("SECTION_B <=", value, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBIn(List<Double> values) {
            addCriterion("SECTION_B in", values, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBNotIn(List<Double> values) {
            addCriterion("SECTION_B not in", values, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBBetween(Double value1, Double value2) {
            addCriterion("SECTION_B between", value1, value2, "sectionB");
            return (Criteria) this;
        }

        public Criteria andSectionBNotBetween(Double value1, Double value2) {
            addCriterion("SECTION_B not between", value1, value2, "sectionB");
            return (Criteria) this;
        }

        public Criteria andFactorCodeIsNull() {
            addCriterion("FACTOR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFactorCodeIsNotNull() {
            addCriterion("FACTOR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFactorCodeEqualTo(String value) {
            addCriterion("FACTOR_CODE =", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeNotEqualTo(String value) {
            addCriterion("FACTOR_CODE <>", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeGreaterThan(String value) {
            addCriterion("FACTOR_CODE >", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FACTOR_CODE >=", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeLessThan(String value) {
            addCriterion("FACTOR_CODE <", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeLessThanOrEqualTo(String value) {
            addCriterion("FACTOR_CODE <=", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeLike(String value) {
            addCriterion("FACTOR_CODE like", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeNotLike(String value) {
            addCriterion("FACTOR_CODE not like", value, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeIn(List<String> values) {
            addCriterion("FACTOR_CODE in", values, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeNotIn(List<String> values) {
            addCriterion("FACTOR_CODE not in", values, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeBetween(String value1, String value2) {
            addCriterion("FACTOR_CODE between", value1, value2, "factorCode");
            return (Criteria) this;
        }

        public Criteria andFactorCodeNotBetween(String value1, String value2) {
            addCriterion("FACTOR_CODE not between", value1, value2, "factorCode");
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

        public Criteria andTotalPriceValueIsNull() {
            addCriterion("TOTAL_PRICE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueIsNotNull() {
            addCriterion("TOTAL_PRICE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueEqualTo(Double value) {
            addCriterion("TOTAL_PRICE_VALUE =", value, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueNotEqualTo(Double value) {
            addCriterion("TOTAL_PRICE_VALUE <>", value, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueGreaterThan(Double value) {
            addCriterion("TOTAL_PRICE_VALUE >", value, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_PRICE_VALUE >=", value, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueLessThan(Double value) {
            addCriterion("TOTAL_PRICE_VALUE <", value, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_PRICE_VALUE <=", value, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueIn(List<Double> values) {
            addCriterion("TOTAL_PRICE_VALUE in", values, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueNotIn(List<Double> values) {
            addCriterion("TOTAL_PRICE_VALUE not in", values, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueBetween(Double value1, Double value2) {
            addCriterion("TOTAL_PRICE_VALUE between", value1, value2, "totalPriceValue");
            return (Criteria) this;
        }

        public Criteria andTotalPriceValueNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_PRICE_VALUE not between", value1, value2, "totalPriceValue");
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

        public Criteria andExtCodeEqualTo(Long value) {
            addCriterion("EXT_CODE =", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotEqualTo(Long value) {
            addCriterion("EXT_CODE <>", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeGreaterThan(Long value) {
            addCriterion("EXT_CODE >", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("EXT_CODE >=", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeLessThan(Long value) {
            addCriterion("EXT_CODE <", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeLessThanOrEqualTo(Long value) {
            addCriterion("EXT_CODE <=", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeIn(List<Long> values) {
            addCriterion("EXT_CODE in", values, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotIn(List<Long> values) {
            addCriterion("EXT_CODE not in", values, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeBetween(Long value1, Long value2) {
            addCriterion("EXT_CODE between", value1, value2, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotBetween(Long value1, Long value2) {
            addCriterion("EXT_CODE not between", value1, value2, "extCode");
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

        public Criteria andIsPriceEqualIsNull() {
            addCriterion("IS_PRICE_EQUAL is null");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualIsNotNull() {
            addCriterion("IS_PRICE_EQUAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualEqualTo(String value) {
            addCriterion("IS_PRICE_EQUAL =", value, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualNotEqualTo(String value) {
            addCriterion("IS_PRICE_EQUAL <>", value, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualGreaterThan(String value) {
            addCriterion("IS_PRICE_EQUAL >", value, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PRICE_EQUAL >=", value, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualLessThan(String value) {
            addCriterion("IS_PRICE_EQUAL <", value, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualLessThanOrEqualTo(String value) {
            addCriterion("IS_PRICE_EQUAL <=", value, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualLike(String value) {
            addCriterion("IS_PRICE_EQUAL like", value, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualNotLike(String value) {
            addCriterion("IS_PRICE_EQUAL not like", value, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualIn(List<String> values) {
            addCriterion("IS_PRICE_EQUAL in", values, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualNotIn(List<String> values) {
            addCriterion("IS_PRICE_EQUAL not in", values, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualBetween(String value1, String value2) {
            addCriterion("IS_PRICE_EQUAL between", value1, value2, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualNotBetween(String value1, String value2) {
            addCriterion("IS_PRICE_EQUAL not between", value1, value2, "isPriceEqual");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceIsNull() {
            addCriterion("IS_TOTAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceIsNotNull() {
            addCriterion("IS_TOTAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceEqualTo(String value) {
            addCriterion("IS_TOTAL_PRICE =", value, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceNotEqualTo(String value) {
            addCriterion("IS_TOTAL_PRICE <>", value, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceGreaterThan(String value) {
            addCriterion("IS_TOTAL_PRICE >", value, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TOTAL_PRICE >=", value, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceLessThan(String value) {
            addCriterion("IS_TOTAL_PRICE <", value, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("IS_TOTAL_PRICE <=", value, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceLike(String value) {
            addCriterion("IS_TOTAL_PRICE like", value, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceNotLike(String value) {
            addCriterion("IS_TOTAL_PRICE not like", value, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceIn(List<String> values) {
            addCriterion("IS_TOTAL_PRICE in", values, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceNotIn(List<String> values) {
            addCriterion("IS_TOTAL_PRICE not in", values, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceBetween(String value1, String value2) {
            addCriterion("IS_TOTAL_PRICE between", value1, value2, "isTotalPrice");
            return (Criteria) this;
        }

        public Criteria andIsTotalPriceNotBetween(String value1, String value2) {
            addCriterion("IS_TOTAL_PRICE not between", value1, value2, "isTotalPrice");
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