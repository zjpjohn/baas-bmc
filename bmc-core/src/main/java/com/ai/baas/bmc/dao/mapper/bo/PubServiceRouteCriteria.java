package com.ai.baas.bmc.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class PubServiceRouteCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public PubServiceRouteCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRouteTypeIsNull() {
            addCriterion("route_type is null");
            return (Criteria) this;
        }

        public Criteria andRouteTypeIsNotNull() {
            addCriterion("route_type is not null");
            return (Criteria) this;
        }

        public Criteria andRouteTypeEqualTo(String value) {
            addCriterion("route_type =", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeNotEqualTo(String value) {
            addCriterion("route_type <>", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeGreaterThan(String value) {
            addCriterion("route_type >", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("route_type >=", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeLessThan(String value) {
            addCriterion("route_type <", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeLessThanOrEqualTo(String value) {
            addCriterion("route_type <=", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeLike(String value) {
            addCriterion("route_type like", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeNotLike(String value) {
            addCriterion("route_type not like", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeIn(List<String> values) {
            addCriterion("route_type in", values, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeNotIn(List<String> values) {
            addCriterion("route_type not in", values, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeBetween(String value1, String value2) {
            addCriterion("route_type between", value1, value2, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeNotBetween(String value1, String value2) {
            addCriterion("route_type not between", value1, value2, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteParamsIsNull() {
            addCriterion("route_params is null");
            return (Criteria) this;
        }

        public Criteria andRouteParamsIsNotNull() {
            addCriterion("route_params is not null");
            return (Criteria) this;
        }

        public Criteria andRouteParamsEqualTo(String value) {
            addCriterion("route_params =", value, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsNotEqualTo(String value) {
            addCriterion("route_params <>", value, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsGreaterThan(String value) {
            addCriterion("route_params >", value, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsGreaterThanOrEqualTo(String value) {
            addCriterion("route_params >=", value, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsLessThan(String value) {
            addCriterion("route_params <", value, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsLessThanOrEqualTo(String value) {
            addCriterion("route_params <=", value, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsLike(String value) {
            addCriterion("route_params like", value, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsNotLike(String value) {
            addCriterion("route_params not like", value, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsIn(List<String> values) {
            addCriterion("route_params in", values, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsNotIn(List<String> values) {
            addCriterion("route_params not in", values, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsBetween(String value1, String value2) {
            addCriterion("route_params between", value1, value2, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteParamsNotBetween(String value1, String value2) {
            addCriterion("route_params not between", value1, value2, "routeParams");
            return (Criteria) this;
        }

        public Criteria andRouteClassIsNull() {
            addCriterion("route_class is null");
            return (Criteria) this;
        }

        public Criteria andRouteClassIsNotNull() {
            addCriterion("route_class is not null");
            return (Criteria) this;
        }

        public Criteria andRouteClassEqualTo(String value) {
            addCriterion("route_class =", value, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassNotEqualTo(String value) {
            addCriterion("route_class <>", value, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassGreaterThan(String value) {
            addCriterion("route_class >", value, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassGreaterThanOrEqualTo(String value) {
            addCriterion("route_class >=", value, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassLessThan(String value) {
            addCriterion("route_class <", value, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassLessThanOrEqualTo(String value) {
            addCriterion("route_class <=", value, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassLike(String value) {
            addCriterion("route_class like", value, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassNotLike(String value) {
            addCriterion("route_class not like", value, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassIn(List<String> values) {
            addCriterion("route_class in", values, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassNotIn(List<String> values) {
            addCriterion("route_class not in", values, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassBetween(String value1, String value2) {
            addCriterion("route_class between", value1, value2, "routeClass");
            return (Criteria) this;
        }

        public Criteria andRouteClassNotBetween(String value1, String value2) {
            addCriterion("route_class not between", value1, value2, "routeClass");
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