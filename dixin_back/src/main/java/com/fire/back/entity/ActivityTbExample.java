package com.fire.back.entity;

import java.util.ArrayList;
import java.util.List;

public class ActivityTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityTbExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeIsNull() {
            addCriterion("activity_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeIsNotNull() {
            addCriterion("activity_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeEqualTo(Long value) {
            addCriterion("activity_start_time =", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeNotEqualTo(Long value) {
            addCriterion("activity_start_time <>", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeGreaterThan(Long value) {
            addCriterion("activity_start_time >", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_start_time >=", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeLessThan(Long value) {
            addCriterion("activity_start_time <", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("activity_start_time <=", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeIn(List<Long> values) {
            addCriterion("activity_start_time in", values, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeNotIn(List<Long> values) {
            addCriterion("activity_start_time not in", values, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeBetween(Long value1, Long value2) {
            addCriterion("activity_start_time between", value1, value2, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("activity_start_time not between", value1, value2, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIsNull() {
            addCriterion("activity_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIsNotNull() {
            addCriterion("activity_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeEqualTo(Long value) {
            addCriterion("activity_end_time =", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotEqualTo(Long value) {
            addCriterion("activity_end_time <>", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeGreaterThan(Long value) {
            addCriterion("activity_end_time >", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_end_time >=", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeLessThan(Long value) {
            addCriterion("activity_end_time <", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("activity_end_time <=", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIn(List<Long> values) {
            addCriterion("activity_end_time in", values, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotIn(List<Long> values) {
            addCriterion("activity_end_time not in", values, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeBetween(Long value1, Long value2) {
            addCriterion("activity_end_time between", value1, value2, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("activity_end_time not between", value1, value2, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeIsNull() {
            addCriterion("sign_start_time is null");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeIsNotNull() {
            addCriterion("sign_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeEqualTo(Long value) {
            addCriterion("sign_start_time =", value, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeNotEqualTo(Long value) {
            addCriterion("sign_start_time <>", value, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeGreaterThan(Long value) {
            addCriterion("sign_start_time >", value, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("sign_start_time >=", value, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeLessThan(Long value) {
            addCriterion("sign_start_time <", value, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("sign_start_time <=", value, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeIn(List<Long> values) {
            addCriterion("sign_start_time in", values, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeNotIn(List<Long> values) {
            addCriterion("sign_start_time not in", values, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeBetween(Long value1, Long value2) {
            addCriterion("sign_start_time between", value1, value2, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("sign_start_time not between", value1, value2, "signStartTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeIsNull() {
            addCriterion("sign_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeIsNotNull() {
            addCriterion("sign_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeEqualTo(Long value) {
            addCriterion("sign_end_time =", value, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeNotEqualTo(Long value) {
            addCriterion("sign_end_time <>", value, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeGreaterThan(Long value) {
            addCriterion("sign_end_time >", value, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("sign_end_time >=", value, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeLessThan(Long value) {
            addCriterion("sign_end_time <", value, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("sign_end_time <=", value, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeIn(List<Long> values) {
            addCriterion("sign_end_time in", values, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeNotIn(List<Long> values) {
            addCriterion("sign_end_time not in", values, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeBetween(Long value1, Long value2) {
            addCriterion("sign_end_time between", value1, value2, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andSignEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("sign_end_time not between", value1, value2, "signEndTime");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNull() {
            addCriterion("read_num is null");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNotNull() {
            addCriterion("read_num is not null");
            return (Criteria) this;
        }

        public Criteria andReadNumEqualTo(Long value) {
            addCriterion("read_num =", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotEqualTo(Long value) {
            addCriterion("read_num <>", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThan(Long value) {
            addCriterion("read_num >", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThanOrEqualTo(Long value) {
            addCriterion("read_num >=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThan(Long value) {
            addCriterion("read_num <", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThanOrEqualTo(Long value) {
            addCriterion("read_num <=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIn(List<Long> values) {
            addCriterion("read_num in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotIn(List<Long> values) {
            addCriterion("read_num not in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumBetween(Long value1, Long value2) {
            addCriterion("read_num between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotBetween(Long value1, Long value2) {
            addCriterion("read_num not between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumIsNull() {
            addCriterion("good_num is null");
            return (Criteria) this;
        }

        public Criteria andGoodNumIsNotNull() {
            addCriterion("good_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNumEqualTo(Long value) {
            addCriterion("good_num =", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumNotEqualTo(Long value) {
            addCriterion("good_num <>", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumGreaterThan(Long value) {
            addCriterion("good_num >", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumGreaterThanOrEqualTo(Long value) {
            addCriterion("good_num >=", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumLessThan(Long value) {
            addCriterion("good_num <", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumLessThanOrEqualTo(Long value) {
            addCriterion("good_num <=", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumIn(List<Long> values) {
            addCriterion("good_num in", values, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumNotIn(List<Long> values) {
            addCriterion("good_num not in", values, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumBetween(Long value1, Long value2) {
            addCriterion("good_num between", value1, value2, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumNotBetween(Long value1, Long value2) {
            addCriterion("good_num not between", value1, value2, "goodNum");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andIfSendIsNull() {
            addCriterion("if_send is null");
            return (Criteria) this;
        }

        public Criteria andIfSendIsNotNull() {
            addCriterion("if_send is not null");
            return (Criteria) this;
        }

        public Criteria andIfSendEqualTo(Integer value) {
            addCriterion("if_send =", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendNotEqualTo(Integer value) {
            addCriterion("if_send <>", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendGreaterThan(Integer value) {
            addCriterion("if_send >", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendGreaterThanOrEqualTo(Integer value) {
            addCriterion("if_send >=", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendLessThan(Integer value) {
            addCriterion("if_send <", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendLessThanOrEqualTo(Integer value) {
            addCriterion("if_send <=", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendIn(List<Integer> values) {
            addCriterion("if_send in", values, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendNotIn(List<Integer> values) {
            addCriterion("if_send not in", values, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendBetween(Integer value1, Integer value2) {
            addCriterion("if_send between", value1, value2, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendNotBetween(Integer value1, Integer value2) {
            addCriterion("if_send not between", value1, value2, "ifSend");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIsNull() {
            addCriterion("activity_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIsNotNull() {
            addCriterion("activity_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTimeEqualTo(Integer value) {
            addCriterion("activity_time =", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotEqualTo(Integer value) {
            addCriterion("activity_time <>", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeGreaterThan(Integer value) {
            addCriterion("activity_time >", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_time >=", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeLessThan(Integer value) {
            addCriterion("activity_time <", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeLessThanOrEqualTo(Integer value) {
            addCriterion("activity_time <=", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIn(List<Integer> values) {
            addCriterion("activity_time in", values, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotIn(List<Integer> values) {
            addCriterion("activity_time not in", values, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeBetween(Integer value1, Integer value2) {
            addCriterion("activity_time between", value1, value2, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_time not between", value1, value2, "activityTime");
            return (Criteria) this;
        }

        public Criteria andApplyNumsIsNull() {
            addCriterion("apply_nums is null");
            return (Criteria) this;
        }

        public Criteria andApplyNumsIsNotNull() {
            addCriterion("apply_nums is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNumsEqualTo(Integer value) {
            addCriterion("apply_nums =", value, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsNotEqualTo(Integer value) {
            addCriterion("apply_nums <>", value, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsGreaterThan(Integer value) {
            addCriterion("apply_nums >", value, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_nums >=", value, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsLessThan(Integer value) {
            addCriterion("apply_nums <", value, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsLessThanOrEqualTo(Integer value) {
            addCriterion("apply_nums <=", value, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsIn(List<Integer> values) {
            addCriterion("apply_nums in", values, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsNotIn(List<Integer> values) {
            addCriterion("apply_nums not in", values, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsBetween(Integer value1, Integer value2) {
            addCriterion("apply_nums between", value1, value2, "applyNums");
            return (Criteria) this;
        }

        public Criteria andApplyNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_nums not between", value1, value2, "applyNums");
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