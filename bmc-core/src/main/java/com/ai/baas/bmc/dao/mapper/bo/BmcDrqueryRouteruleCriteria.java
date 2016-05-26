package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class BmcDrqueryRouteruleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BmcDrqueryRouteruleCriteria() {
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

        public Criteria andServicetypeIsNull() {
            addCriterion("serviceType is null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIsNotNull() {
            addCriterion("serviceType is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypeEqualTo(String value) {
            addCriterion("serviceType =", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotEqualTo(String value) {
            addCriterion("serviceType <>", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThan(String value) {
            addCriterion("serviceType >", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("serviceType >=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThan(String value) {
            addCriterion("serviceType <", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThanOrEqualTo(String value) {
            addCriterion("serviceType <=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLike(String value) {
            addCriterion("serviceType like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotLike(String value) {
            addCriterion("serviceType not like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeIn(List<String> values) {
            addCriterion("serviceType in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotIn(List<String> values) {
            addCriterion("serviceType not in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeBetween(String value1, String value2) {
            addCriterion("serviceType between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotBetween(String value1, String value2) {
            addCriterion("serviceType not between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andTableidIsNull() {
            addCriterion("Tableid is null");
            return (Criteria) this;
        }

        public Criteria andTableidIsNotNull() {
            addCriterion("Tableid is not null");
            return (Criteria) this;
        }

        public Criteria andTableidEqualTo(String value) {
            addCriterion("Tableid =", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotEqualTo(String value) {
            addCriterion("Tableid <>", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidGreaterThan(String value) {
            addCriterion("Tableid >", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidGreaterThanOrEqualTo(String value) {
            addCriterion("Tableid >=", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLessThan(String value) {
            addCriterion("Tableid <", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLessThanOrEqualTo(String value) {
            addCriterion("Tableid <=", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLike(String value) {
            addCriterion("Tableid like", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotLike(String value) {
            addCriterion("Tableid not like", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidIn(List<String> values) {
            addCriterion("Tableid in", values, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotIn(List<String> values) {
            addCriterion("Tableid not in", values, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidBetween(String value1, String value2) {
            addCriterion("Tableid between", value1, value2, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotBetween(String value1, String value2) {
            addCriterion("Tableid not between", value1, value2, "tableid");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
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