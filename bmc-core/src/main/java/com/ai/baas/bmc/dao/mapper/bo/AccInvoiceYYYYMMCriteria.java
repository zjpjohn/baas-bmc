package com.ai.baas.bmc.dao.mapper.bo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AccInvoiceYYYYMMCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public AccInvoiceYYYYMMCriteria() {
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

        public Criteria andInvoiceSeqIsNull() {
            addCriterion("INVOICE_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqIsNotNull() {
            addCriterion("INVOICE_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqEqualTo(String value) {
            addCriterion("INVOICE_SEQ =", value, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqNotEqualTo(String value) {
            addCriterion("INVOICE_SEQ <>", value, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqGreaterThan(String value) {
            addCriterion("INVOICE_SEQ >", value, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_SEQ >=", value, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqLessThan(String value) {
            addCriterion("INVOICE_SEQ <", value, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_SEQ <=", value, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqLike(String value) {
            addCriterion("INVOICE_SEQ like", value, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqNotLike(String value) {
            addCriterion("INVOICE_SEQ not like", value, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqIn(List<String> values) {
            addCriterion("INVOICE_SEQ in", values, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqNotIn(List<String> values) {
            addCriterion("INVOICE_SEQ not in", values, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqBetween(String value1, String value2) {
            addCriterion("INVOICE_SEQ between", value1, value2, "invoiceSeq");
            return (Criteria) this;
        }

        public Criteria andInvoiceSeqNotBetween(String value1, String value2) {
            addCriterion("INVOICE_SEQ not between", value1, value2, "invoiceSeq");
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

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNull() {
            addCriterion("ACCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNotNull() {
            addCriterion("ACCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcctIdEqualTo(String value) {
            addCriterion("ACCT_ID =", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotEqualTo(String value) {
            addCriterion("ACCT_ID <>", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThan(String value) {
            addCriterion("ACCT_ID >", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACCT_ID >=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThan(String value) {
            addCriterion("ACCT_ID <", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThanOrEqualTo(String value) {
            addCriterion("ACCT_ID <=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLike(String value) {
            addCriterion("ACCT_ID like", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotLike(String value) {
            addCriterion("ACCT_ID not like", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIn(List<String> values) {
            addCriterion("ACCT_ID in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotIn(List<String> values) {
            addCriterion("ACCT_ID not in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdBetween(String value1, String value2) {
            addCriterion("ACCT_ID between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotBetween(String value1, String value2) {
            addCriterion("ACCT_ID not between", value1, value2, "acctId");
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

        public Criteria andSubsIdEqualTo(String value) {
            addCriterion("SUBS_ID =", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotEqualTo(String value) {
            addCriterion("SUBS_ID <>", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThan(String value) {
            addCriterion("SUBS_ID >", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUBS_ID >=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThan(String value) {
            addCriterion("SUBS_ID <", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThanOrEqualTo(String value) {
            addCriterion("SUBS_ID <=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLike(String value) {
            addCriterion("SUBS_ID like", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotLike(String value) {
            addCriterion("SUBS_ID not like", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdIn(List<String> values) {
            addCriterion("SUBS_ID in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotIn(List<String> values) {
            addCriterion("SUBS_ID not in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdBetween(String value1, String value2) {
            addCriterion("SUBS_ID between", value1, value2, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotBetween(String value1, String value2) {
            addCriterion("SUBS_ID not between", value1, value2, "subsId");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeIsNull() {
            addCriterion("BUSI_OPER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeIsNotNull() {
            addCriterion("BUSI_OPER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeEqualTo(String value) {
            addCriterion("BUSI_OPER_CODE =", value, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeNotEqualTo(String value) {
            addCriterion("BUSI_OPER_CODE <>", value, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeGreaterThan(String value) {
            addCriterion("BUSI_OPER_CODE >", value, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_OPER_CODE >=", value, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeLessThan(String value) {
            addCriterion("BUSI_OPER_CODE <", value, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeLessThanOrEqualTo(String value) {
            addCriterion("BUSI_OPER_CODE <=", value, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeLike(String value) {
            addCriterion("BUSI_OPER_CODE like", value, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeNotLike(String value) {
            addCriterion("BUSI_OPER_CODE not like", value, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeIn(List<String> values) {
            addCriterion("BUSI_OPER_CODE in", values, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeNotIn(List<String> values) {
            addCriterion("BUSI_OPER_CODE not in", values, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeBetween(String value1, String value2) {
            addCriterion("BUSI_OPER_CODE between", value1, value2, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andBusiOperCodeNotBetween(String value1, String value2) {
            addCriterion("BUSI_OPER_CODE not between", value1, value2, "busiOperCode");
            return (Criteria) this;
        }

        public Criteria andSvcTypeIsNull() {
            addCriterion("SVC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSvcTypeIsNotNull() {
            addCriterion("SVC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSvcTypeEqualTo(String value) {
            addCriterion("SVC_TYPE =", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeNotEqualTo(String value) {
            addCriterion("SVC_TYPE <>", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeGreaterThan(String value) {
            addCriterion("SVC_TYPE >", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SVC_TYPE >=", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeLessThan(String value) {
            addCriterion("SVC_TYPE <", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeLessThanOrEqualTo(String value) {
            addCriterion("SVC_TYPE <=", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeLike(String value) {
            addCriterion("SVC_TYPE like", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeNotLike(String value) {
            addCriterion("SVC_TYPE not like", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeIn(List<String> values) {
            addCriterion("SVC_TYPE in", values, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeNotIn(List<String> values) {
            addCriterion("SVC_TYPE not in", values, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeBetween(String value1, String value2) {
            addCriterion("SVC_TYPE between", value1, value2, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeNotBetween(String value1, String value2) {
            addCriterion("SVC_TYPE not between", value1, value2, "svcType");
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

        public Criteria andTotalIsNull() {
            addCriterion("TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(BigDecimal value) {
            addCriterion("TOTAL =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(BigDecimal value) {
            addCriterion("TOTAL >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(BigDecimal value) {
            addCriterion("TOTAL <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<BigDecimal> values) {
            addCriterion("TOTAL in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andAdjustIsNull() {
            addCriterion("ADJUST is null");
            return (Criteria) this;
        }

        public Criteria andAdjustIsNotNull() {
            addCriterion("ADJUST is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustEqualTo(BigDecimal value) {
            addCriterion("ADJUST =", value, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustNotEqualTo(BigDecimal value) {
            addCriterion("ADJUST <>", value, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustGreaterThan(BigDecimal value) {
            addCriterion("ADJUST >", value, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ADJUST >=", value, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustLessThan(BigDecimal value) {
            addCriterion("ADJUST <", value, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ADJUST <=", value, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustIn(List<BigDecimal> values) {
            addCriterion("ADJUST in", values, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustNotIn(List<BigDecimal> values) {
            addCriterion("ADJUST not in", values, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADJUST between", value1, value2, "adjust");
            return (Criteria) this;
        }

        public Criteria andAdjustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADJUST not between", value1, value2, "adjust");
            return (Criteria) this;
        }

        public Criteria andDiscIsNull() {
            addCriterion("DISC is null");
            return (Criteria) this;
        }

        public Criteria andDiscIsNotNull() {
            addCriterion("DISC is not null");
            return (Criteria) this;
        }

        public Criteria andDiscEqualTo(BigDecimal value) {
            addCriterion("DISC =", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotEqualTo(BigDecimal value) {
            addCriterion("DISC <>", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscGreaterThan(BigDecimal value) {
            addCriterion("DISC >", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DISC >=", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscLessThan(BigDecimal value) {
            addCriterion("DISC <", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DISC <=", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscIn(List<BigDecimal> values) {
            addCriterion("DISC in", values, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotIn(List<BigDecimal> values) {
            addCriterion("DISC not in", values, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISC between", value1, value2, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISC not between", value1, value2, "disc");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("BALANCE =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("BALANCE <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("BALANCE >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("BALANCE <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("BALANCE in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("BALANCE not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateIsNull() {
            addCriterion("LAST_STATUS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateIsNotNull() {
            addCriterion("LAST_STATUS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateEqualTo(Timestamp value) {
            addCriterion("LAST_STATUS_DATE =", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateNotEqualTo(Timestamp value) {
            addCriterion("LAST_STATUS_DATE <>", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateGreaterThan(Timestamp value) {
            addCriterion("LAST_STATUS_DATE >", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("LAST_STATUS_DATE >=", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateLessThan(Timestamp value) {
            addCriterion("LAST_STATUS_DATE <", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("LAST_STATUS_DATE <=", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateIn(List<Timestamp> values) {
            addCriterion("LAST_STATUS_DATE in", values, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateNotIn(List<Timestamp> values) {
            addCriterion("LAST_STATUS_DATE not in", values, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LAST_STATUS_DATE between", value1, value2, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LAST_STATUS_DATE not between", value1, value2, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("PAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("PAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("PAY_STATUS =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("PAY_STATUS <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("PAY_STATUS >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_STATUS >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("PAY_STATUS <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("PAY_STATUS <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("PAY_STATUS like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("PAY_STATUS not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("PAY_STATUS in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("PAY_STATUS not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("PAY_STATUS between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andLastPayDateIsNull() {
            addCriterion("LAST_PAY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastPayDateIsNotNull() {
            addCriterion("LAST_PAY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastPayDateEqualTo(Timestamp value) {
            addCriterion("LAST_PAY_DATE =", value, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateNotEqualTo(Timestamp value) {
            addCriterion("LAST_PAY_DATE <>", value, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateGreaterThan(Timestamp value) {
            addCriterion("LAST_PAY_DATE >", value, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("LAST_PAY_DATE >=", value, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateLessThan(Timestamp value) {
            addCriterion("LAST_PAY_DATE <", value, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("LAST_PAY_DATE <=", value, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateIn(List<Timestamp> values) {
            addCriterion("LAST_PAY_DATE in", values, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateNotIn(List<Timestamp> values) {
            addCriterion("LAST_PAY_DATE not in", values, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LAST_PAY_DATE between", value1, value2, "lastPayDate");
            return (Criteria) this;
        }

        public Criteria andLastPayDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LAST_PAY_DATE not between", value1, value2, "lastPayDate");
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

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("PROVINCE_CODE like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("PROVINCE_CODE not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("AREA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("AREA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("AREA_CODE =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("AREA_CODE <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("AREA_CODE >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_CODE >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("AREA_CODE <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("AREA_CODE <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("AREA_CODE like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("AREA_CODE not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("AREA_CODE in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("AREA_CODE not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("AREA_CODE between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("AREA_CODE not between", value1, value2, "areaCode");
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