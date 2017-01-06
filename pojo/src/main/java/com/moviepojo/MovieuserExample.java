package com.moviepojo;

import java.util.ArrayList;
import java.util.List;

public class MovieuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieuserExample() {
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

        public Criteria andMemailIsNull() {
            addCriterion("memail is null");
            return (Criteria) this;
        }

        public Criteria andMemailIsNotNull() {
            addCriterion("memail is not null");
            return (Criteria) this;
        }

        public Criteria andMemailEqualTo(String value) {
            addCriterion("memail =", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailNotEqualTo(String value) {
            addCriterion("memail <>", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailGreaterThan(String value) {
            addCriterion("memail >", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailGreaterThanOrEqualTo(String value) {
            addCriterion("memail >=", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailLessThan(String value) {
            addCriterion("memail <", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailLessThanOrEqualTo(String value) {
            addCriterion("memail <=", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailLike(String value) {
            addCriterion("memail like", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailNotLike(String value) {
            addCriterion("memail not like", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailIn(List<String> values) {
            addCriterion("memail in", values, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailNotIn(List<String> values) {
            addCriterion("memail not in", values, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailBetween(String value1, String value2) {
            addCriterion("memail between", value1, value2, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailNotBetween(String value1, String value2) {
            addCriterion("memail not between", value1, value2, "memail");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordIsNull() {
            addCriterion("muserpassword is null");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordIsNotNull() {
            addCriterion("muserpassword is not null");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordEqualTo(String value) {
            addCriterion("muserpassword =", value, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordNotEqualTo(String value) {
            addCriterion("muserpassword <>", value, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordGreaterThan(String value) {
            addCriterion("muserpassword >", value, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("muserpassword >=", value, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordLessThan(String value) {
            addCriterion("muserpassword <", value, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordLessThanOrEqualTo(String value) {
            addCriterion("muserpassword <=", value, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordLike(String value) {
            addCriterion("muserpassword like", value, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordNotLike(String value) {
            addCriterion("muserpassword not like", value, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordIn(List<String> values) {
            addCriterion("muserpassword in", values, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordNotIn(List<String> values) {
            addCriterion("muserpassword not in", values, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordBetween(String value1, String value2) {
            addCriterion("muserpassword between", value1, value2, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMuserpasswordNotBetween(String value1, String value2) {
            addCriterion("muserpassword not between", value1, value2, "muserpassword");
            return (Criteria) this;
        }

        public Criteria andMusernameIsNull() {
            addCriterion("musername is null");
            return (Criteria) this;
        }

        public Criteria andMusernameIsNotNull() {
            addCriterion("musername is not null");
            return (Criteria) this;
        }

        public Criteria andMusernameEqualTo(String value) {
            addCriterion("musername =", value, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameNotEqualTo(String value) {
            addCriterion("musername <>", value, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameGreaterThan(String value) {
            addCriterion("musername >", value, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameGreaterThanOrEqualTo(String value) {
            addCriterion("musername >=", value, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameLessThan(String value) {
            addCriterion("musername <", value, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameLessThanOrEqualTo(String value) {
            addCriterion("musername <=", value, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameLike(String value) {
            addCriterion("musername like", value, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameNotLike(String value) {
            addCriterion("musername not like", value, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameIn(List<String> values) {
            addCriterion("musername in", values, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameNotIn(List<String> values) {
            addCriterion("musername not in", values, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameBetween(String value1, String value2) {
            addCriterion("musername between", value1, value2, "musername");
            return (Criteria) this;
        }

        public Criteria andMusernameNotBetween(String value1, String value2) {
            addCriterion("musername not between", value1, value2, "musername");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNull() {
            addCriterion("login_type is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNotNull() {
            addCriterion("login_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeEqualTo(Integer value) {
            addCriterion("login_type =", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotEqualTo(Integer value) {
            addCriterion("login_type <>", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThan(Integer value) {
            addCriterion("login_type >", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_type >=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThan(Integer value) {
            addCriterion("login_type <", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThanOrEqualTo(Integer value) {
            addCriterion("login_type <=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIn(List<Integer> values) {
            addCriterion("login_type in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotIn(List<Integer> values) {
            addCriterion("login_type not in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeBetween(Integer value1, Integer value2) {
            addCriterion("login_type between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("login_type not between", value1, value2, "loginType");
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