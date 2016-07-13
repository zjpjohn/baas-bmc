package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class BmcQueryBillCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BmcQueryBillCriteria() {
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

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Integer value) {
            addCriterion("CUST_ID =", value, "custId");
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

        public Criteria andSubsIdIsNull() {
            addCriterion("SUBS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubsIdIsNotNull() {
            addCriterion("SUBS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubsIdEqualTo(Integer value) {
            addCriterion("SUBS_ID =", value, "subsId");
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

        public Criteria andDisFeeIsNull() {
            addCriterion("DIS_FEE is null");
            return (Criteria) this;
        }

        public Criteria andDisFeeIsNotNull() {
            addCriterion("DIS_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andDisFeeEqualTo(Long value) {
            addCriterion("DIS_FEE =", value, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeNotEqualTo(Long value) {
            addCriterion("DIS_FEE <>", value, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeGreaterThan(Long value) {
            addCriterion("DIS_FEE >", value, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("DIS_FEE >=", value, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeLessThan(Long value) {
            addCriterion("DIS_FEE <", value, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeLessThanOrEqualTo(Long value) {
            addCriterion("DIS_FEE <=", value, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeIn(List<Long> values) {
            addCriterion("DIS_FEE in", values, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeNotIn(List<Long> values) {
            addCriterion("DIS_FEE not in", values, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeBetween(Long value1, Long value2) {
            addCriterion("DIS_FEE between", value1, value2, "disFee");
            return (Criteria) this;
        }

        public Criteria andDisFeeNotBetween(Long value1, Long value2) {
            addCriterion("DIS_FEE not between", value1, value2, "disFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNull() {
            addCriterion("ADJUST_FEE is null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNotNull() {
            addCriterion("ADJUST_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeEqualTo(Long value) {
            addCriterion("ADJUST_FEE =", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotEqualTo(Long value) {
            addCriterion("ADJUST_FEE <>", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThan(Long value) {
            addCriterion("ADJUST_FEE >", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("ADJUST_FEE >=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThan(Long value) {
            addCriterion("ADJUST_FEE <", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThanOrEqualTo(Long value) {
            addCriterion("ADJUST_FEE <=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIn(List<Long> values) {
            addCriterion("ADJUST_FEE in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotIn(List<Long> values) {
            addCriterion("ADJUST_FEE not in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeBetween(Long value1, Long value2) {
            addCriterion("ADJUST_FEE between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotBetween(Long value1, Long value2) {
            addCriterion("ADJUST_FEE not between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("TOTAL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("TOTAL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Long value) {
            addCriterion("TOTAL_FEE =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Long value) {
            addCriterion("TOTAL_FEE <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Long value) {
            addCriterion("TOTAL_FEE >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_FEE >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Long value) {
            addCriterion("TOTAL_FEE <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_FEE <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Long> values) {
            addCriterion("TOTAL_FEE in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Long> values) {
            addCriterion("TOTAL_FEE not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Long value1, Long value2) {
            addCriterion("TOTAL_FEE between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_FEE not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("SUBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("SUBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Long value) {
            addCriterion("SUBJECT_ID =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Long value) {
            addCriterion("SUBJECT_ID <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Long value) {
            addCriterion("SUBJECT_ID >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_ID >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Long value) {
            addCriterion("SUBJECT_ID <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_ID <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Long> values) {
            addCriterion("SUBJECT_ID in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Long> values) {
            addCriterion("SUBJECT_ID not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_ID between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_ID not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeIsNull() {
            addCriterion("SUBJECT_AIS_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeIsNotNull() {
            addCriterion("SUBJECT_AIS_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeEqualTo(Long value) {
            addCriterion("SUBJECT_AIS_FEE =", value, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeNotEqualTo(Long value) {
            addCriterion("SUBJECT_AIS_FEE <>", value, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeGreaterThan(Long value) {
            addCriterion("SUBJECT_AIS_FEE >", value, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_AIS_FEE >=", value, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeLessThan(Long value) {
            addCriterion("SUBJECT_AIS_FEE <", value, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeLessThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_AIS_FEE <=", value, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeIn(List<Long> values) {
            addCriterion("SUBJECT_AIS_FEE in", values, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeNotIn(List<Long> values) {
            addCriterion("SUBJECT_AIS_FEE not in", values, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_AIS_FEE between", value1, value2, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAisFeeNotBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_AIS_FEE not between", value1, value2, "subjectAisFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeIsNull() {
            addCriterion("SUBJECT_ADJUST_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeIsNotNull() {
            addCriterion("SUBJECT_ADJUST_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeEqualTo(Long value) {
            addCriterion("SUBJECT_ADJUST_FEE =", value, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeNotEqualTo(Long value) {
            addCriterion("SUBJECT_ADJUST_FEE <>", value, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeGreaterThan(Long value) {
            addCriterion("SUBJECT_ADJUST_FEE >", value, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_ADJUST_FEE >=", value, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeLessThan(Long value) {
            addCriterion("SUBJECT_ADJUST_FEE <", value, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeLessThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_ADJUST_FEE <=", value, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeIn(List<Long> values) {
            addCriterion("SUBJECT_ADJUST_FEE in", values, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeNotIn(List<Long> values) {
            addCriterion("SUBJECT_ADJUST_FEE not in", values, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_ADJUST_FEE between", value1, value2, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectAdjustFeeNotBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_ADJUST_FEE not between", value1, value2, "subjectAdjustFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeIsNull() {
            addCriterion("SUBJECT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeIsNotNull() {
            addCriterion("SUBJECT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeEqualTo(Long value) {
            addCriterion("SUBJECT_FEE =", value, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeNotEqualTo(Long value) {
            addCriterion("SUBJECT_FEE <>", value, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeGreaterThan(Long value) {
            addCriterion("SUBJECT_FEE >", value, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_FEE >=", value, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeLessThan(Long value) {
            addCriterion("SUBJECT_FEE <", value, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeLessThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_FEE <=", value, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeIn(List<Long> values) {
            addCriterion("SUBJECT_FEE in", values, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeNotIn(List<Long> values) {
            addCriterion("SUBJECT_FEE not in", values, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_FEE between", value1, value2, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andSubjectFeeNotBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_FEE not between", value1, value2, "subjectFee");
            return (Criteria) this;
        }

        public Criteria andPageNumIsNull() {
            addCriterion("PAGE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPageNumIsNotNull() {
            addCriterion("PAGE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPageNumEqualTo(Integer value) {
            addCriterion("PAGE_NUM =", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotEqualTo(Integer value) {
            addCriterion("PAGE_NUM <>", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumGreaterThan(Integer value) {
            addCriterion("PAGE_NUM >", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAGE_NUM >=", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumLessThan(Integer value) {
            addCriterion("PAGE_NUM <", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumLessThanOrEqualTo(Integer value) {
            addCriterion("PAGE_NUM <=", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumIn(List<Integer> values) {
            addCriterion("PAGE_NUM in", values, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotIn(List<Integer> values) {
            addCriterion("PAGE_NUM not in", values, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_NUM between", value1, value2, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_NUM not between", value1, value2, "pageNum");
            return (Criteria) this;
        }

        public Criteria andQueryMonIsNull() {
            addCriterion("QUERY_MON is null");
            return (Criteria) this;
        }

        public Criteria andQueryMonIsNotNull() {
            addCriterion("QUERY_MON is not null");
            return (Criteria) this;
        }

        public Criteria andQueryMonEqualTo(String value) {
            addCriterion("QUERY_MON =", value, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonNotEqualTo(String value) {
            addCriterion("QUERY_MON <>", value, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonGreaterThan(String value) {
            addCriterion("QUERY_MON >", value, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonGreaterThanOrEqualTo(String value) {
            addCriterion("QUERY_MON >=", value, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonLessThan(String value) {
            addCriterion("QUERY_MON <", value, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonLessThanOrEqualTo(String value) {
            addCriterion("QUERY_MON <=", value, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonLike(String value) {
            addCriterion("QUERY_MON like", value, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonNotLike(String value) {
            addCriterion("QUERY_MON not like", value, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonIn(List<String> values) {
            addCriterion("QUERY_MON in", values, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonNotIn(List<String> values) {
            addCriterion("QUERY_MON not in", values, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonBetween(String value1, String value2) {
            addCriterion("QUERY_MON between", value1, value2, "queryMon");
            return (Criteria) this;
        }

        public Criteria andQueryMonNotBetween(String value1, String value2) {
            addCriterion("QUERY_MON not between", value1, value2, "queryMon");
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