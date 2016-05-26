package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class BmcUseQueryCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BmcUseQueryCriteria() {
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

        public Criteria andUniqueIdIsNull() {
            addCriterion("UNIQUE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUniqueIdIsNotNull() {
            addCriterion("UNIQUE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueIdEqualTo(Integer value) {
            addCriterion("UNIQUE_ID =", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdNotEqualTo(Integer value) {
            addCriterion("UNIQUE_ID <>", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdGreaterThan(Integer value) {
            addCriterion("UNIQUE_ID >", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNIQUE_ID >=", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdLessThan(Integer value) {
            addCriterion("UNIQUE_ID <", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdLessThanOrEqualTo(Integer value) {
            addCriterion("UNIQUE_ID <=", value, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdIn(List<Integer> values) {
            addCriterion("UNIQUE_ID in", values, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdNotIn(List<Integer> values) {
            addCriterion("UNIQUE_ID not in", values, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdBetween(Integer value1, Integer value2) {
            addCriterion("UNIQUE_ID between", value1, value2, "uniqueId");
            return (Criteria) this;
        }

        public Criteria andUniqueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UNIQUE_ID not between", value1, value2, "uniqueId");
            return (Criteria) this;
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

        public Criteria andSystemIdIsNull() {
            addCriterion("SYSTEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("SYSTEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("SYSTEM_ID =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("SYSTEM_ID <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("SYSTEM_ID >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_ID >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("SYSTEM_ID <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_ID <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("SYSTEM_ID like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("SYSTEM_ID not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("SYSTEM_ID in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("SYSTEM_ID not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("SYSTEM_ID between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_ID not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andBeginMonthIsNull() {
            addCriterion("BEGIN_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andBeginMonthIsNotNull() {
            addCriterion("BEGIN_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andBeginMonthEqualTo(String value) {
            addCriterion("BEGIN_MONTH =", value, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthNotEqualTo(String value) {
            addCriterion("BEGIN_MONTH <>", value, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthGreaterThan(String value) {
            addCriterion("BEGIN_MONTH >", value, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthGreaterThanOrEqualTo(String value) {
            addCriterion("BEGIN_MONTH >=", value, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthLessThan(String value) {
            addCriterion("BEGIN_MONTH <", value, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthLessThanOrEqualTo(String value) {
            addCriterion("BEGIN_MONTH <=", value, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthLike(String value) {
            addCriterion("BEGIN_MONTH like", value, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthNotLike(String value) {
            addCriterion("BEGIN_MONTH not like", value, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthIn(List<String> values) {
            addCriterion("BEGIN_MONTH in", values, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthNotIn(List<String> values) {
            addCriterion("BEGIN_MONTH not in", values, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthBetween(String value1, String value2) {
            addCriterion("BEGIN_MONTH between", value1, value2, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andBeginMonthNotBetween(String value1, String value2) {
            addCriterion("BEGIN_MONTH not between", value1, value2, "beginMonth");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String string) {
            addCriterion("CUST_ID =", string, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Integer value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Integer value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Integer value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Integer> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Integer> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Integer value1, Integer value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
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

        public Criteria andServiceNumIsNull() {
            addCriterion("SERVICE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andServiceNumIsNotNull() {
            addCriterion("SERVICE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNumEqualTo(String value) {
            addCriterion("SERVICE_NUM =", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotEqualTo(String value) {
            addCriterion("SERVICE_NUM <>", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumGreaterThan(String value) {
            addCriterion("SERVICE_NUM >", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_NUM >=", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumLessThan(String value) {
            addCriterion("SERVICE_NUM <", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_NUM <=", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumLike(String value) {
            addCriterion("SERVICE_NUM like", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotLike(String value) {
            addCriterion("SERVICE_NUM not like", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumIn(List<String> values) {
            addCriterion("SERVICE_NUM in", values, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotIn(List<String> values) {
            addCriterion("SERVICE_NUM not in", values, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumBetween(String value1, String value2) {
            addCriterion("SERVICE_NUM between", value1, value2, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotBetween(String value1, String value2) {
            addCriterion("SERVICE_NUM not between", value1, value2, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andVisitAreaIsNull() {
            addCriterion("VISIT_AREA is null");
            return (Criteria) this;
        }

        public Criteria andVisitAreaIsNotNull() {
            addCriterion("VISIT_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andVisitAreaEqualTo(String value) {
            addCriterion("VISIT_AREA =", value, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaNotEqualTo(String value) {
            addCriterion("VISIT_AREA <>", value, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaGreaterThan(String value) {
            addCriterion("VISIT_AREA >", value, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaGreaterThanOrEqualTo(String value) {
            addCriterion("VISIT_AREA >=", value, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaLessThan(String value) {
            addCriterion("VISIT_AREA <", value, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaLessThanOrEqualTo(String value) {
            addCriterion("VISIT_AREA <=", value, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaLike(String value) {
            addCriterion("VISIT_AREA like", value, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaNotLike(String value) {
            addCriterion("VISIT_AREA not like", value, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaIn(List<String> values) {
            addCriterion("VISIT_AREA in", values, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaNotIn(List<String> values) {
            addCriterion("VISIT_AREA not in", values, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaBetween(String value1, String value2) {
            addCriterion("VISIT_AREA between", value1, value2, "visitArea");
            return (Criteria) this;
        }

        public Criteria andVisitAreaNotBetween(String value1, String value2) {
            addCriterion("VISIT_AREA not between", value1, value2, "visitArea");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNull() {
            addCriterion("RES_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNotNull() {
            addCriterion("RES_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeEqualTo(String value) {
            addCriterion("RES_TYPE =", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotEqualTo(String value) {
            addCriterion("RES_TYPE <>", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThan(String value) {
            addCriterion("RES_TYPE >", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RES_TYPE >=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThan(String value) {
            addCriterion("RES_TYPE <", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThanOrEqualTo(String value) {
            addCriterion("RES_TYPE <=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLike(String value) {
            addCriterion("RES_TYPE like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotLike(String value) {
            addCriterion("RES_TYPE not like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeIn(List<String> values) {
            addCriterion("RES_TYPE in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotIn(List<String> values) {
            addCriterion("RES_TYPE not in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeBetween(String value1, String value2) {
            addCriterion("RES_TYPE between", value1, value2, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotBetween(String value1, String value2) {
            addCriterion("RES_TYPE not between", value1, value2, "resType");
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

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andProductAmountIsNull() {
            addCriterion("PRODUCT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andProductAmountIsNotNull() {
            addCriterion("PRODUCT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andProductAmountEqualTo(Integer value) {
            addCriterion("PRODUCT_AMOUNT =", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotEqualTo(Integer value) {
            addCriterion("PRODUCT_AMOUNT <>", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountGreaterThan(Integer value) {
            addCriterion("PRODUCT_AMOUNT >", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_AMOUNT >=", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountLessThan(Integer value) {
            addCriterion("PRODUCT_AMOUNT <", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_AMOUNT <=", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountIn(List<Integer> values) {
            addCriterion("PRODUCT_AMOUNT in", values, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotIn(List<Integer> values) {
            addCriterion("PRODUCT_AMOUNT not in", values, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_AMOUNT between", value1, value2, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_AMOUNT not between", value1, value2, "productAmount");
            return (Criteria) this;
        }

        public Criteria andMsgSeqIsNull() {
            addCriterion("MSG_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andMsgSeqIsNotNull() {
            addCriterion("MSG_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSeqEqualTo(String value) {
            addCriterion("MSG_SEQ =", value, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqNotEqualTo(String value) {
            addCriterion("MSG_SEQ <>", value, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqGreaterThan(String value) {
            addCriterion("MSG_SEQ >", value, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqGreaterThanOrEqualTo(String value) {
            addCriterion("MSG_SEQ >=", value, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqLessThan(String value) {
            addCriterion("MSG_SEQ <", value, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqLessThanOrEqualTo(String value) {
            addCriterion("MSG_SEQ <=", value, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqLike(String value) {
            addCriterion("MSG_SEQ like", value, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqNotLike(String value) {
            addCriterion("MSG_SEQ not like", value, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqIn(List<String> values) {
            addCriterion("MSG_SEQ in", values, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqNotIn(List<String> values) {
            addCriterion("MSG_SEQ not in", values, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqBetween(String value1, String value2) {
            addCriterion("MSG_SEQ between", value1, value2, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andMsgSeqNotBetween(String value1, String value2) {
            addCriterion("MSG_SEQ not between", value1, value2, "msgSeq");
            return (Criteria) this;
        }

        public Criteria andSubsIdIsNull() {
            addCriterion("SUBS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubsIdIsNotNull() {
            addCriterion("SUBS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubsIdEqualTo(String string) {
            addCriterion("SUBS_ID =", string, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotEqualTo(Integer value) {
            addCriterion("SUBS_ID <>", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThan(Integer value) {
            addCriterion("SUBS_ID >", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUBS_ID >=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThan(Integer value) {
            addCriterion("SUBS_ID <", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThanOrEqualTo(Integer value) {
            addCriterion("SUBS_ID <=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdIn(List<Integer> values) {
            addCriterion("SUBS_ID in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotIn(List<Integer> values) {
            addCriterion("SUBS_ID not in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdBetween(Integer value1, Integer value2) {
            addCriterion("SUBS_ID between", value1, value2, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SUBS_ID not between", value1, value2, "subsId");
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