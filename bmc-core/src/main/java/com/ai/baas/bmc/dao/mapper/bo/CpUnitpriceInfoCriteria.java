package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class CpUnitpriceInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CpUnitpriceInfoCriteria() {
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

        public Criteria andUnitPriceIdIsNull() {
            addCriterion("UNIT_PRICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdIsNotNull() {
            addCriterion("UNIT_PRICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdEqualTo(Integer value) {
            addCriterion("UNIT_PRICE_ID =", value, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdNotEqualTo(Integer value) {
            addCriterion("UNIT_PRICE_ID <>", value, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdGreaterThan(Integer value) {
            addCriterion("UNIT_PRICE_ID >", value, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNIT_PRICE_ID >=", value, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdLessThan(Integer value) {
            addCriterion("UNIT_PRICE_ID <", value, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdLessThanOrEqualTo(Integer value) {
            addCriterion("UNIT_PRICE_ID <=", value, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdIn(List<Integer> values) {
            addCriterion("UNIT_PRICE_ID in", values, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdNotIn(List<Integer> values) {
            addCriterion("UNIT_PRICE_ID not in", values, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdBetween(Integer value1, Integer value2) {
            addCriterion("UNIT_PRICE_ID between", value1, value2, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UNIT_PRICE_ID not between", value1, value2, "unitPriceId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeIsNull() {
            addCriterion("UNIT_PRICE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeIsNotNull() {
            addCriterion("UNIT_PRICE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeEqualTo(String value) {
            addCriterion("UNIT_PRICE_CODE =", value, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeNotEqualTo(String value) {
            addCriterion("UNIT_PRICE_CODE <>", value, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeGreaterThan(String value) {
            addCriterion("UNIT_PRICE_CODE >", value, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_PRICE_CODE >=", value, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeLessThan(String value) {
            addCriterion("UNIT_PRICE_CODE <", value, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeLessThanOrEqualTo(String value) {
            addCriterion("UNIT_PRICE_CODE <=", value, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeLike(String value) {
            addCriterion("UNIT_PRICE_CODE like", value, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeNotLike(String value) {
            addCriterion("UNIT_PRICE_CODE not like", value, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeIn(List<String> values) {
            addCriterion("UNIT_PRICE_CODE in", values, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeNotIn(List<String> values) {
            addCriterion("UNIT_PRICE_CODE not in", values, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeBetween(String value1, String value2) {
            addCriterion("UNIT_PRICE_CODE between", value1, value2, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andUnitPriceCodeNotBetween(String value1, String value2) {
            addCriterion("UNIT_PRICE_CODE not between", value1, value2, "unitPriceCode");
            return (Criteria) this;
        }

        public Criteria andPriceNameIsNull() {
            addCriterion("PRICE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPriceNameIsNotNull() {
            addCriterion("PRICE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPriceNameEqualTo(String value) {
            addCriterion("PRICE_NAME =", value, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameNotEqualTo(String value) {
            addCriterion("PRICE_NAME <>", value, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameGreaterThan(String value) {
            addCriterion("PRICE_NAME >", value, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_NAME >=", value, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameLessThan(String value) {
            addCriterion("PRICE_NAME <", value, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameLessThanOrEqualTo(String value) {
            addCriterion("PRICE_NAME <=", value, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameLike(String value) {
            addCriterion("PRICE_NAME like", value, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameNotLike(String value) {
            addCriterion("PRICE_NAME not like", value, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameIn(List<String> values) {
            addCriterion("PRICE_NAME in", values, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameNotIn(List<String> values) {
            addCriterion("PRICE_NAME not in", values, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameBetween(String value1, String value2) {
            addCriterion("PRICE_NAME between", value1, value2, "priceName");
            return (Criteria) this;
        }

        public Criteria andPriceNameNotBetween(String value1, String value2) {
            addCriterion("PRICE_NAME not between", value1, value2, "priceName");
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