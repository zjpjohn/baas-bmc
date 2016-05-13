package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class CpPackageInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpPackageInfoCriteria() {
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

        public Criteria andPackageIdIsNull() {
            addCriterion("PACKAGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNotNull() {
            addCriterion("PACKAGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPackageIdEqualTo(Long value) {
            addCriterion("PACKAGE_ID =", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotEqualTo(Long value) {
            addCriterion("PACKAGE_ID <>", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThan(Long value) {
            addCriterion("PACKAGE_ID >", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PACKAGE_ID >=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThan(Long value) {
            addCriterion("PACKAGE_ID <", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThanOrEqualTo(Long value) {
            addCriterion("PACKAGE_ID <=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdIn(List<Long> values) {
            addCriterion("PACKAGE_ID in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotIn(List<Long> values) {
            addCriterion("PACKAGE_ID not in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdBetween(Long value1, Long value2) {
            addCriterion("PACKAGE_ID between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotBetween(Long value1, Long value2) {
            addCriterion("PACKAGE_ID not between", value1, value2, "packageId");
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

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
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

        public Criteria andUnitCodeIsNull() {
            addCriterion("UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNotNull() {
            addCriterion("UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeEqualTo(String value) {
            addCriterion("UNIT_CODE =", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotEqualTo(String value) {
            addCriterion("UNIT_CODE <>", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThan(String value) {
            addCriterion("UNIT_CODE >", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_CODE >=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThan(String value) {
            addCriterion("UNIT_CODE <", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("UNIT_CODE <=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLike(String value) {
            addCriterion("UNIT_CODE like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotLike(String value) {
            addCriterion("UNIT_CODE not like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIn(List<String> values) {
            addCriterion("UNIT_CODE in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotIn(List<String> values) {
            addCriterion("UNIT_CODE not in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeBetween(String value1, String value2) {
            addCriterion("UNIT_CODE between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotBetween(String value1, String value2) {
            addCriterion("UNIT_CODE not between", value1, value2, "unitCode");
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

        public Criteria andExceedTypeIsNull() {
            addCriterion("EXCEED_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExceedTypeIsNotNull() {
            addCriterion("EXCEED_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExceedTypeEqualTo(String value) {
            addCriterion("EXCEED_TYPE =", value, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeNotEqualTo(String value) {
            addCriterion("EXCEED_TYPE <>", value, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeGreaterThan(String value) {
            addCriterion("EXCEED_TYPE >", value, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EXCEED_TYPE >=", value, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeLessThan(String value) {
            addCriterion("EXCEED_TYPE <", value, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeLessThanOrEqualTo(String value) {
            addCriterion("EXCEED_TYPE <=", value, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeLike(String value) {
            addCriterion("EXCEED_TYPE like", value, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeNotLike(String value) {
            addCriterion("EXCEED_TYPE not like", value, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeIn(List<String> values) {
            addCriterion("EXCEED_TYPE in", values, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeNotIn(List<String> values) {
            addCriterion("EXCEED_TYPE not in", values, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeBetween(String value1, String value2) {
            addCriterion("EXCEED_TYPE between", value1, value2, "exceedType");
            return (Criteria) this;
        }

        public Criteria andExceedTypeNotBetween(String value1, String value2) {
            addCriterion("EXCEED_TYPE not between", value1, value2, "exceedType");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeIsNull() {
            addCriterion("UNITPRICE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeIsNotNull() {
            addCriterion("UNITPRICE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeEqualTo(String value) {
            addCriterion("UNITPRICE_CODE =", value, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeNotEqualTo(String value) {
            addCriterion("UNITPRICE_CODE <>", value, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeGreaterThan(String value) {
            addCriterion("UNITPRICE_CODE >", value, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("UNITPRICE_CODE >=", value, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeLessThan(String value) {
            addCriterion("UNITPRICE_CODE <", value, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeLessThanOrEqualTo(String value) {
            addCriterion("UNITPRICE_CODE <=", value, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeLike(String value) {
            addCriterion("UNITPRICE_CODE like", value, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeNotLike(String value) {
            addCriterion("UNITPRICE_CODE not like", value, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeIn(List<String> values) {
            addCriterion("UNITPRICE_CODE in", values, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeNotIn(List<String> values) {
            addCriterion("UNITPRICE_CODE not in", values, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeBetween(String value1, String value2) {
            addCriterion("UNITPRICE_CODE between", value1, value2, "unitpriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitpriceCodeNotBetween(String value1, String value2) {
            addCriterion("UNITPRICE_CODE not between", value1, value2, "unitpriceCode");
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

        public Criteria andExtCodeEqualTo(String value) {
            addCriterion("EXT_CODE =", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotEqualTo(String value) {
            addCriterion("EXT_CODE <>", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeGreaterThan(String value) {
            addCriterion("EXT_CODE >", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_CODE >=", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeLessThan(String value) {
            addCriterion("EXT_CODE <", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeLessThanOrEqualTo(String value) {
            addCriterion("EXT_CODE <=", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeLike(String value) {
            addCriterion("EXT_CODE like", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotLike(String value) {
            addCriterion("EXT_CODE not like", value, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeIn(List<String> values) {
            addCriterion("EXT_CODE in", values, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotIn(List<String> values) {
            addCriterion("EXT_CODE not in", values, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeBetween(String value1, String value2) {
            addCriterion("EXT_CODE between", value1, value2, "extCode");
            return (Criteria) this;
        }

        public Criteria andExtCodeNotBetween(String value1, String value2) {
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