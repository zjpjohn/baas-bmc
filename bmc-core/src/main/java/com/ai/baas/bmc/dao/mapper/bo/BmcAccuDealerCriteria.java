package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class BmcAccuDealerCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BmcAccuDealerCriteria() {
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

        public Criteria andTenantidIsNull() {
            addCriterion("tenantId is null");
            return (Criteria) this;
        }

        public Criteria andTenantidIsNotNull() {
            addCriterion("tenantId is not null");
            return (Criteria) this;
        }

        public Criteria andTenantidEqualTo(String value) {
            addCriterion("tenantId =", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotEqualTo(String value) {
            addCriterion("tenantId <>", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidGreaterThan(String value) {
            addCriterion("tenantId >", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidGreaterThanOrEqualTo(String value) {
            addCriterion("tenantId >=", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLessThan(String value) {
            addCriterion("tenantId <", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLessThanOrEqualTo(String value) {
            addCriterion("tenantId <=", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLike(String value) {
            addCriterion("tenantId like", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotLike(String value) {
            addCriterion("tenantId not like", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidIn(List<String> values) {
            addCriterion("tenantId in", values, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotIn(List<String> values) {
            addCriterion("tenantId not in", values, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidBetween(String value1, String value2) {
            addCriterion("tenantId between", value1, value2, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotBetween(String value1, String value2) {
            addCriterion("tenantId not between", value1, value2, "tenantid");
            return (Criteria) this;
        }

        public Criteria andSystemidIsNull() {
            addCriterion("systemId is null");
            return (Criteria) this;
        }

        public Criteria andSystemidIsNotNull() {
            addCriterion("systemId is not null");
            return (Criteria) this;
        }

        public Criteria andSystemidEqualTo(String value) {
            addCriterion("systemId =", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotEqualTo(String value) {
            addCriterion("systemId <>", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidGreaterThan(String value) {
            addCriterion("systemId >", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidGreaterThanOrEqualTo(String value) {
            addCriterion("systemId >=", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidLessThan(String value) {
            addCriterion("systemId <", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidLessThanOrEqualTo(String value) {
            addCriterion("systemId <=", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidLike(String value) {
            addCriterion("systemId like", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotLike(String value) {
            addCriterion("systemId not like", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidIn(List<String> values) {
            addCriterion("systemId in", values, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotIn(List<String> values) {
            addCriterion("systemId not in", values, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidBetween(String value1, String value2) {
            addCriterion("systemId between", value1, value2, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotBetween(String value1, String value2) {
            addCriterion("systemId not between", value1, value2, "systemid");
            return (Criteria) this;
        }

        public Criteria andDealercodeIsNull() {
            addCriterion("dealerCode is null");
            return (Criteria) this;
        }

        public Criteria andDealercodeIsNotNull() {
            addCriterion("dealerCode is not null");
            return (Criteria) this;
        }

        public Criteria andDealercodeEqualTo(String value) {
            addCriterion("dealerCode =", value, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeNotEqualTo(String value) {
            addCriterion("dealerCode <>", value, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeGreaterThan(String value) {
            addCriterion("dealerCode >", value, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeGreaterThanOrEqualTo(String value) {
            addCriterion("dealerCode >=", value, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeLessThan(String value) {
            addCriterion("dealerCode <", value, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeLessThanOrEqualTo(String value) {
            addCriterion("dealerCode <=", value, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeLike(String value) {
            addCriterion("dealerCode like", value, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeNotLike(String value) {
            addCriterion("dealerCode not like", value, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeIn(List<String> values) {
            addCriterion("dealerCode in", values, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeNotIn(List<String> values) {
            addCriterion("dealerCode not in", values, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeBetween(String value1, String value2) {
            addCriterion("dealerCode between", value1, value2, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealercodeNotBetween(String value1, String value2) {
            addCriterion("dealerCode not between", value1, value2, "dealercode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeIsNull() {
            addCriterion("dealerAreaCode is null");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeIsNotNull() {
            addCriterion("dealerAreaCode is not null");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeEqualTo(String value) {
            addCriterion("dealerAreaCode =", value, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeNotEqualTo(String value) {
            addCriterion("dealerAreaCode <>", value, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeGreaterThan(String value) {
            addCriterion("dealerAreaCode >", value, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeGreaterThanOrEqualTo(String value) {
            addCriterion("dealerAreaCode >=", value, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeLessThan(String value) {
            addCriterion("dealerAreaCode <", value, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeLessThanOrEqualTo(String value) {
            addCriterion("dealerAreaCode <=", value, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeLike(String value) {
            addCriterion("dealerAreaCode like", value, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeNotLike(String value) {
            addCriterion("dealerAreaCode not like", value, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeIn(List<String> values) {
            addCriterion("dealerAreaCode in", values, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeNotIn(List<String> values) {
            addCriterion("dealerAreaCode not in", values, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeBetween(String value1, String value2) {
            addCriterion("dealerAreaCode between", value1, value2, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andDealerareacodeNotBetween(String value1, String value2) {
            addCriterion("dealerAreaCode not between", value1, value2, "dealerareacode");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
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