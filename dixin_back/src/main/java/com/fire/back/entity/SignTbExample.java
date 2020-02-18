package com.fire.back.entity;

import java.util.ArrayList;
import java.util.List;

public class SignTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SignTbExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSignYearIsNull() {
            addCriterion("sign_year is null");
            return (Criteria) this;
        }

        public Criteria andSignYearIsNotNull() {
            addCriterion("sign_year is not null");
            return (Criteria) this;
        }

        public Criteria andSignYearEqualTo(Integer value) {
            addCriterion("sign_year =", value, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearNotEqualTo(Integer value) {
            addCriterion("sign_year <>", value, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearGreaterThan(Integer value) {
            addCriterion("sign_year >", value, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_year >=", value, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearLessThan(Integer value) {
            addCriterion("sign_year <", value, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearLessThanOrEqualTo(Integer value) {
            addCriterion("sign_year <=", value, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearIn(List<Integer> values) {
            addCriterion("sign_year in", values, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearNotIn(List<Integer> values) {
            addCriterion("sign_year not in", values, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearBetween(Integer value1, Integer value2) {
            addCriterion("sign_year between", value1, value2, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignYearNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_year not between", value1, value2, "signYear");
            return (Criteria) this;
        }

        public Criteria andSignMonthIsNull() {
            addCriterion("sign_month is null");
            return (Criteria) this;
        }

        public Criteria andSignMonthIsNotNull() {
            addCriterion("sign_month is not null");
            return (Criteria) this;
        }

        public Criteria andSignMonthEqualTo(Integer value) {
            addCriterion("sign_month =", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthNotEqualTo(Integer value) {
            addCriterion("sign_month <>", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthGreaterThan(Integer value) {
            addCriterion("sign_month >", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_month >=", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthLessThan(Integer value) {
            addCriterion("sign_month <", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthLessThanOrEqualTo(Integer value) {
            addCriterion("sign_month <=", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthIn(List<Integer> values) {
            addCriterion("sign_month in", values, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthNotIn(List<Integer> values) {
            addCriterion("sign_month not in", values, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthBetween(Integer value1, Integer value2) {
            addCriterion("sign_month between", value1, value2, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_month not between", value1, value2, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignDaysIsNull() {
            addCriterion("sign_days is null");
            return (Criteria) this;
        }

        public Criteria andSignDaysIsNotNull() {
            addCriterion("sign_days is not null");
            return (Criteria) this;
        }

        public Criteria andSignDaysEqualTo(Long value) {
            addCriterion("sign_days =", value, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysNotEqualTo(Long value) {
            addCriterion("sign_days <>", value, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysGreaterThan(Long value) {
            addCriterion("sign_days >", value, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysGreaterThanOrEqualTo(Long value) {
            addCriterion("sign_days >=", value, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysLessThan(Long value) {
            addCriterion("sign_days <", value, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysLessThanOrEqualTo(Long value) {
            addCriterion("sign_days <=", value, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysIn(List<Long> values) {
            addCriterion("sign_days in", values, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysNotIn(List<Long> values) {
            addCriterion("sign_days not in", values, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysBetween(Long value1, Long value2) {
            addCriterion("sign_days between", value1, value2, "signDays");
            return (Criteria) this;
        }

        public Criteria andSignDaysNotBetween(Long value1, Long value2) {
            addCriterion("sign_days not between", value1, value2, "signDays");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSignNumsIsNull() {
            addCriterion("sign_nums is null");
            return (Criteria) this;
        }

        public Criteria andSignNumsIsNotNull() {
            addCriterion("sign_nums is not null");
            return (Criteria) this;
        }

        public Criteria andSignNumsEqualTo(Integer value) {
            addCriterion("sign_nums =", value, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsNotEqualTo(Integer value) {
            addCriterion("sign_nums <>", value, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsGreaterThan(Integer value) {
            addCriterion("sign_nums >", value, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_nums >=", value, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsLessThan(Integer value) {
            addCriterion("sign_nums <", value, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsLessThanOrEqualTo(Integer value) {
            addCriterion("sign_nums <=", value, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsIn(List<Integer> values) {
            addCriterion("sign_nums in", values, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsNotIn(List<Integer> values) {
            addCriterion("sign_nums not in", values, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsBetween(Integer value1, Integer value2) {
            addCriterion("sign_nums between", value1, value2, "signNums");
            return (Criteria) this;
        }

        public Criteria andSignNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_nums not between", value1, value2, "signNums");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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