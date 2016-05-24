package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BmcOutputInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BmcOutputInfoCriteria() {
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

        public Criteria andInfoCodeIsNull() {
            addCriterion("info_code is null");
            return (Criteria) this;
        }

        public Criteria andInfoCodeIsNotNull() {
            addCriterion("info_code is not null");
            return (Criteria) this;
        }

        public Criteria andInfoCodeEqualTo(Long value) {
            addCriterion("info_code =", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeNotEqualTo(Long value) {
            addCriterion("info_code <>", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeGreaterThan(Long value) {
            addCriterion("info_code >", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("info_code >=", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeLessThan(Long value) {
            addCriterion("info_code <", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeLessThanOrEqualTo(Long value) {
            addCriterion("info_code <=", value, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeIn(List<Long> values) {
            addCriterion("info_code in", values, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeNotIn(List<Long> values) {
            addCriterion("info_code not in", values, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeBetween(Long value1, Long value2) {
            addCriterion("info_code between", value1, value2, "infoCode");
            return (Criteria) this;
        }

        public Criteria andInfoCodeNotBetween(Long value1, Long value2) {
            addCriterion("info_code not between", value1, value2, "infoCode");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("service_type like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("service_type not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andTablePrefixIsNull() {
            addCriterion("table_prefix is null");
            return (Criteria) this;
        }

        public Criteria andTablePrefixIsNotNull() {
            addCriterion("table_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andTablePrefixEqualTo(String value) {
            addCriterion("table_prefix =", value, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixNotEqualTo(String value) {
            addCriterion("table_prefix <>", value, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixGreaterThan(String value) {
            addCriterion("table_prefix >", value, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixGreaterThanOrEqualTo(String value) {
            addCriterion("table_prefix >=", value, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixLessThan(String value) {
            addCriterion("table_prefix <", value, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixLessThanOrEqualTo(String value) {
            addCriterion("table_prefix <=", value, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixLike(String value) {
            addCriterion("table_prefix like", value, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixNotLike(String value) {
            addCriterion("table_prefix not like", value, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixIn(List<String> values) {
            addCriterion("table_prefix in", values, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixNotIn(List<String> values) {
            addCriterion("table_prefix not in", values, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixBetween(String value1, String value2) {
            addCriterion("table_prefix between", value1, value2, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePrefixNotBetween(String value1, String value2) {
            addCriterion("table_prefix not between", value1, value2, "tablePrefix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixIsNull() {
            addCriterion("table_postfix is null");
            return (Criteria) this;
        }

        public Criteria andTablePostfixIsNotNull() {
            addCriterion("table_postfix is not null");
            return (Criteria) this;
        }

        public Criteria andTablePostfixEqualTo(String value) {
            addCriterion("table_postfix =", value, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixNotEqualTo(String value) {
            addCriterion("table_postfix <>", value, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixGreaterThan(String value) {
            addCriterion("table_postfix >", value, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixGreaterThanOrEqualTo(String value) {
            addCriterion("table_postfix >=", value, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixLessThan(String value) {
            addCriterion("table_postfix <", value, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixLessThanOrEqualTo(String value) {
            addCriterion("table_postfix <=", value, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixLike(String value) {
            addCriterion("table_postfix like", value, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixNotLike(String value) {
            addCriterion("table_postfix not like", value, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixIn(List<String> values) {
            addCriterion("table_postfix in", values, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixNotIn(List<String> values) {
            addCriterion("table_postfix not in", values, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixBetween(String value1, String value2) {
            addCriterion("table_postfix between", value1, value2, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andTablePostfixNotBetween(String value1, String value2) {
            addCriterion("table_postfix not between", value1, value2, "tablePostfix");
            return (Criteria) this;
        }

        public Criteria andOutputTypeIsNull() {
            addCriterion("output_type is null");
            return (Criteria) this;
        }

        public Criteria andOutputTypeIsNotNull() {
            addCriterion("output_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutputTypeEqualTo(String value) {
            addCriterion("output_type =", value, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeNotEqualTo(String value) {
            addCriterion("output_type <>", value, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeGreaterThan(String value) {
            addCriterion("output_type >", value, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeGreaterThanOrEqualTo(String value) {
            addCriterion("output_type >=", value, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeLessThan(String value) {
            addCriterion("output_type <", value, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeLessThanOrEqualTo(String value) {
            addCriterion("output_type <=", value, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeLike(String value) {
            addCriterion("output_type like", value, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeNotLike(String value) {
            addCriterion("output_type not like", value, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeIn(List<String> values) {
            addCriterion("output_type in", values, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeNotIn(List<String> values) {
            addCriterion("output_type not in", values, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeBetween(String value1, String value2) {
            addCriterion("output_type between", value1, value2, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputTypeNotBetween(String value1, String value2) {
            addCriterion("output_type not between", value1, value2, "outputType");
            return (Criteria) this;
        }

        public Criteria andOutputNameIsNull() {
            addCriterion("output_name is null");
            return (Criteria) this;
        }

        public Criteria andOutputNameIsNotNull() {
            addCriterion("output_name is not null");
            return (Criteria) this;
        }

        public Criteria andOutputNameEqualTo(String value) {
            addCriterion("output_name =", value, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameNotEqualTo(String value) {
            addCriterion("output_name <>", value, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameGreaterThan(String value) {
            addCriterion("output_name >", value, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameGreaterThanOrEqualTo(String value) {
            addCriterion("output_name >=", value, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameLessThan(String value) {
            addCriterion("output_name <", value, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameLessThanOrEqualTo(String value) {
            addCriterion("output_name <=", value, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameLike(String value) {
            addCriterion("output_name like", value, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameNotLike(String value) {
            addCriterion("output_name not like", value, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameIn(List<String> values) {
            addCriterion("output_name in", values, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameNotIn(List<String> values) {
            addCriterion("output_name not in", values, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameBetween(String value1, String value2) {
            addCriterion("output_name between", value1, value2, "outputName");
            return (Criteria) this;
        }

        public Criteria andOutputNameNotBetween(String value1, String value2) {
            addCriterion("output_name not between", value1, value2, "outputName");
            return (Criteria) this;
        }

        public Criteria andKeySeqIsNull() {
            addCriterion("key_seq is null");
            return (Criteria) this;
        }

        public Criteria andKeySeqIsNotNull() {
            addCriterion("key_seq is not null");
            return (Criteria) this;
        }

        public Criteria andKeySeqEqualTo(String value) {
            addCriterion("key_seq =", value, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqNotEqualTo(String value) {
            addCriterion("key_seq <>", value, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqGreaterThan(String value) {
            addCriterion("key_seq >", value, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqGreaterThanOrEqualTo(String value) {
            addCriterion("key_seq >=", value, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqLessThan(String value) {
            addCriterion("key_seq <", value, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqLessThanOrEqualTo(String value) {
            addCriterion("key_seq <=", value, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqLike(String value) {
            addCriterion("key_seq like", value, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqNotLike(String value) {
            addCriterion("key_seq not like", value, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqIn(List<String> values) {
            addCriterion("key_seq in", values, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqNotIn(List<String> values) {
            addCriterion("key_seq not in", values, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqBetween(String value1, String value2) {
            addCriterion("key_seq between", value1, value2, "keySeq");
            return (Criteria) this;
        }

        public Criteria andKeySeqNotBetween(String value1, String value2) {
            addCriterion("key_seq not between", value1, value2, "keySeq");
            return (Criteria) this;
        }

        public Criteria andSeqNameIsNull() {
            addCriterion("seq_name is null");
            return (Criteria) this;
        }

        public Criteria andSeqNameIsNotNull() {
            addCriterion("seq_name is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNameEqualTo(String value) {
            addCriterion("seq_name =", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameNotEqualTo(String value) {
            addCriterion("seq_name <>", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameGreaterThan(String value) {
            addCriterion("seq_name >", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameGreaterThanOrEqualTo(String value) {
            addCriterion("seq_name >=", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameLessThan(String value) {
            addCriterion("seq_name <", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameLessThanOrEqualTo(String value) {
            addCriterion("seq_name <=", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameLike(String value) {
            addCriterion("seq_name like", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameNotLike(String value) {
            addCriterion("seq_name not like", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameIn(List<String> values) {
            addCriterion("seq_name in", values, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameNotIn(List<String> values) {
            addCriterion("seq_name not in", values, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameBetween(String value1, String value2) {
            addCriterion("seq_name between", value1, value2, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameNotBetween(String value1, String value2) {
            addCriterion("seq_name not between", value1, value2, "seqName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Timestamp value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Timestamp value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Timestamp value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Timestamp value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Timestamp> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Timestamp> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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