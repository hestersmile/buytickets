package com.moviepojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMovieTitleIsNull() {
            addCriterion("movie_title is null");
            return (Criteria) this;
        }

        public Criteria andMovieTitleIsNotNull() {
            addCriterion("movie_title is not null");
            return (Criteria) this;
        }

        public Criteria andMovieTitleEqualTo(String value) {
            addCriterion("movie_title =", value, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleNotEqualTo(String value) {
            addCriterion("movie_title <>", value, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleGreaterThan(String value) {
            addCriterion("movie_title >", value, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleGreaterThanOrEqualTo(String value) {
            addCriterion("movie_title >=", value, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleLessThan(String value) {
            addCriterion("movie_title <", value, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleLessThanOrEqualTo(String value) {
            addCriterion("movie_title <=", value, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleLike(String value) {
            addCriterion("movie_title like", value, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleNotLike(String value) {
            addCriterion("movie_title not like", value, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleIn(List<String> values) {
            addCriterion("movie_title in", values, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleNotIn(List<String> values) {
            addCriterion("movie_title not in", values, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleBetween(String value1, String value2) {
            addCriterion("movie_title between", value1, value2, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieTitleNotBetween(String value1, String value2) {
            addCriterion("movie_title not between", value1, value2, "movieTitle");
            return (Criteria) this;
        }

        public Criteria andMovieInfoIsNull() {
            addCriterion("movie_info is null");
            return (Criteria) this;
        }

        public Criteria andMovieInfoIsNotNull() {
            addCriterion("movie_info is not null");
            return (Criteria) this;
        }

        public Criteria andMovieInfoEqualTo(String value) {
            addCriterion("movie_info =", value, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoNotEqualTo(String value) {
            addCriterion("movie_info <>", value, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoGreaterThan(String value) {
            addCriterion("movie_info >", value, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoGreaterThanOrEqualTo(String value) {
            addCriterion("movie_info >=", value, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoLessThan(String value) {
            addCriterion("movie_info <", value, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoLessThanOrEqualTo(String value) {
            addCriterion("movie_info <=", value, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoLike(String value) {
            addCriterion("movie_info like", value, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoNotLike(String value) {
            addCriterion("movie_info not like", value, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoIn(List<String> values) {
            addCriterion("movie_info in", values, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoNotIn(List<String> values) {
            addCriterion("movie_info not in", values, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoBetween(String value1, String value2) {
            addCriterion("movie_info between", value1, value2, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieInfoNotBetween(String value1, String value2) {
            addCriterion("movie_info not between", value1, value2, "movieInfo");
            return (Criteria) this;
        }

        public Criteria andMovieNumIsNull() {
            addCriterion("movie_num is null");
            return (Criteria) this;
        }

        public Criteria andMovieNumIsNotNull() {
            addCriterion("movie_num is not null");
            return (Criteria) this;
        }

        public Criteria andMovieNumEqualTo(Integer value) {
            addCriterion("movie_num =", value, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumNotEqualTo(Integer value) {
            addCriterion("movie_num <>", value, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumGreaterThan(Integer value) {
            addCriterion("movie_num >", value, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie_num >=", value, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumLessThan(Integer value) {
            addCriterion("movie_num <", value, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumLessThanOrEqualTo(Integer value) {
            addCriterion("movie_num <=", value, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumIn(List<Integer> values) {
            addCriterion("movie_num in", values, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumNotIn(List<Integer> values) {
            addCriterion("movie_num not in", values, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumBetween(Integer value1, Integer value2) {
            addCriterion("movie_num between", value1, value2, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieNumNotBetween(Integer value1, Integer value2) {
            addCriterion("movie_num not between", value1, value2, "movieNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumIsNull() {
            addCriterion("movie_temp_num is null");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumIsNotNull() {
            addCriterion("movie_temp_num is not null");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumEqualTo(Integer value) {
            addCriterion("movie_temp_num =", value, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumNotEqualTo(Integer value) {
            addCriterion("movie_temp_num <>", value, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumGreaterThan(Integer value) {
            addCriterion("movie_temp_num >", value, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie_temp_num >=", value, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumLessThan(Integer value) {
            addCriterion("movie_temp_num <", value, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumLessThanOrEqualTo(Integer value) {
            addCriterion("movie_temp_num <=", value, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumIn(List<Integer> values) {
            addCriterion("movie_temp_num in", values, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumNotIn(List<Integer> values) {
            addCriterion("movie_temp_num not in", values, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumBetween(Integer value1, Integer value2) {
            addCriterion("movie_temp_num between", value1, value2, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieTempNumNotBetween(Integer value1, Integer value2) {
            addCriterion("movie_temp_num not between", value1, value2, "movieTempNum");
            return (Criteria) this;
        }

        public Criteria andMovieActorIsNull() {
            addCriterion("movie_actor is null");
            return (Criteria) this;
        }

        public Criteria andMovieActorIsNotNull() {
            addCriterion("movie_actor is not null");
            return (Criteria) this;
        }

        public Criteria andMovieActorEqualTo(String value) {
            addCriterion("movie_actor =", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorNotEqualTo(String value) {
            addCriterion("movie_actor <>", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorGreaterThan(String value) {
            addCriterion("movie_actor >", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorGreaterThanOrEqualTo(String value) {
            addCriterion("movie_actor >=", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorLessThan(String value) {
            addCriterion("movie_actor <", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorLessThanOrEqualTo(String value) {
            addCriterion("movie_actor <=", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorLike(String value) {
            addCriterion("movie_actor like", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorNotLike(String value) {
            addCriterion("movie_actor not like", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorIn(List<String> values) {
            addCriterion("movie_actor in", values, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorNotIn(List<String> values) {
            addCriterion("movie_actor not in", values, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorBetween(String value1, String value2) {
            addCriterion("movie_actor between", value1, value2, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorNotBetween(String value1, String value2) {
            addCriterion("movie_actor not between", value1, value2, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIsNull() {
            addCriterion("movie_time is null");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIsNotNull() {
            addCriterion("movie_time is not null");
            return (Criteria) this;
        }

        public Criteria andMovieTimeEqualTo(Date value) {
            addCriterionForJDBCDate("movie_time =", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("movie_time <>", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("movie_time >", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("movie_time >=", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeLessThan(Date value) {
            addCriterionForJDBCDate("movie_time <", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("movie_time <=", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIn(List<Date> values) {
            addCriterionForJDBCDate("movie_time in", values, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("movie_time not in", values, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("movie_time between", value1, value2, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("movie_time not between", value1, value2, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieImgIsNull() {
            addCriterion("movie_img is null");
            return (Criteria) this;
        }

        public Criteria andMovieImgIsNotNull() {
            addCriterion("movie_img is not null");
            return (Criteria) this;
        }

        public Criteria andMovieImgEqualTo(String value) {
            addCriterion("movie_img =", value, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgNotEqualTo(String value) {
            addCriterion("movie_img <>", value, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgGreaterThan(String value) {
            addCriterion("movie_img >", value, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgGreaterThanOrEqualTo(String value) {
            addCriterion("movie_img >=", value, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgLessThan(String value) {
            addCriterion("movie_img <", value, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgLessThanOrEqualTo(String value) {
            addCriterion("movie_img <=", value, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgLike(String value) {
            addCriterion("movie_img like", value, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgNotLike(String value) {
            addCriterion("movie_img not like", value, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgIn(List<String> values) {
            addCriterion("movie_img in", values, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgNotIn(List<String> values) {
            addCriterion("movie_img not in", values, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgBetween(String value1, String value2) {
            addCriterion("movie_img between", value1, value2, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgNotBetween(String value1, String value2) {
            addCriterion("movie_img not between", value1, value2, "movieImg");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameIsNull() {
            addCriterion("movie_img_name is null");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameIsNotNull() {
            addCriterion("movie_img_name is not null");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameEqualTo(String value) {
            addCriterion("movie_img_name =", value, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameNotEqualTo(String value) {
            addCriterion("movie_img_name <>", value, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameGreaterThan(String value) {
            addCriterion("movie_img_name >", value, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameGreaterThanOrEqualTo(String value) {
            addCriterion("movie_img_name >=", value, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameLessThan(String value) {
            addCriterion("movie_img_name <", value, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameLessThanOrEqualTo(String value) {
            addCriterion("movie_img_name <=", value, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameLike(String value) {
            addCriterion("movie_img_name like", value, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameNotLike(String value) {
            addCriterion("movie_img_name not like", value, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameIn(List<String> values) {
            addCriterion("movie_img_name in", values, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameNotIn(List<String> values) {
            addCriterion("movie_img_name not in", values, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameBetween(String value1, String value2) {
            addCriterion("movie_img_name between", value1, value2, "movieImgName");
            return (Criteria) this;
        }

        public Criteria andMovieImgNameNotBetween(String value1, String value2) {
            addCriterion("movie_img_name not between", value1, value2, "movieImgName");
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