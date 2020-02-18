package com.fire.back.entity;

import java.util.ArrayList;
import java.util.List;

public class HonourTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HonourTbExample() {
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

        public Criteria andHonourNameIsNull() {
            addCriterion("honour_name is null");
            return (Criteria) this;
        }

        public Criteria andHonourNameIsNotNull() {
            addCriterion("honour_name is not null");
            return (Criteria) this;
        }

        public Criteria andHonourNameEqualTo(String value) {
            addCriterion("honour_name =", value, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameNotEqualTo(String value) {
            addCriterion("honour_name <>", value, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameGreaterThan(String value) {
            addCriterion("honour_name >", value, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameGreaterThanOrEqualTo(String value) {
            addCriterion("honour_name >=", value, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameLessThan(String value) {
            addCriterion("honour_name <", value, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameLessThanOrEqualTo(String value) {
            addCriterion("honour_name <=", value, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameLike(String value) {
            addCriterion("honour_name like", value, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameNotLike(String value) {
            addCriterion("honour_name not like", value, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameIn(List<String> values) {
            addCriterion("honour_name in", values, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameNotIn(List<String> values) {
            addCriterion("honour_name not in", values, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameBetween(String value1, String value2) {
            addCriterion("honour_name between", value1, value2, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourNameNotBetween(String value1, String value2) {
            addCriterion("honour_name not between", value1, value2, "honourName");
            return (Criteria) this;
        }

        public Criteria andHonourProofIsNull() {
            addCriterion("honour_proof is null");
            return (Criteria) this;
        }

        public Criteria andHonourProofIsNotNull() {
            addCriterion("honour_proof is not null");
            return (Criteria) this;
        }

        public Criteria andHonourProofEqualTo(String value) {
            addCriterion("honour_proof =", value, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofNotEqualTo(String value) {
            addCriterion("honour_proof <>", value, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofGreaterThan(String value) {
            addCriterion("honour_proof >", value, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofGreaterThanOrEqualTo(String value) {
            addCriterion("honour_proof >=", value, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofLessThan(String value) {
            addCriterion("honour_proof <", value, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofLessThanOrEqualTo(String value) {
            addCriterion("honour_proof <=", value, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofLike(String value) {
            addCriterion("honour_proof like", value, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofNotLike(String value) {
            addCriterion("honour_proof not like", value, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofIn(List<String> values) {
            addCriterion("honour_proof in", values, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofNotIn(List<String> values) {
            addCriterion("honour_proof not in", values, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofBetween(String value1, String value2) {
            addCriterion("honour_proof between", value1, value2, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourProofNotBetween(String value1, String value2) {
            addCriterion("honour_proof not between", value1, value2, "honourProof");
            return (Criteria) this;
        }

        public Criteria andHonourTimeIsNull() {
            addCriterion("honour_time is null");
            return (Criteria) this;
        }

        public Criteria andHonourTimeIsNotNull() {
            addCriterion("honour_time is not null");
            return (Criteria) this;
        }

        public Criteria andHonourTimeEqualTo(Long value) {
            addCriterion("honour_time =", value, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeNotEqualTo(Long value) {
            addCriterion("honour_time <>", value, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeGreaterThan(Long value) {
            addCriterion("honour_time >", value, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("honour_time >=", value, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeLessThan(Long value) {
            addCriterion("honour_time <", value, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeLessThanOrEqualTo(Long value) {
            addCriterion("honour_time <=", value, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeIn(List<Long> values) {
            addCriterion("honour_time in", values, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeNotIn(List<Long> values) {
            addCriterion("honour_time not in", values, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeBetween(Long value1, Long value2) {
            addCriterion("honour_time between", value1, value2, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourTimeNotBetween(Long value1, Long value2) {
            addCriterion("honour_time not between", value1, value2, "honourTime");
            return (Criteria) this;
        }

        public Criteria andHonourStateIsNull() {
            addCriterion("honour_state is null");
            return (Criteria) this;
        }

        public Criteria andHonourStateIsNotNull() {
            addCriterion("honour_state is not null");
            return (Criteria) this;
        }

        public Criteria andHonourStateEqualTo(Integer value) {
            addCriterion("honour_state =", value, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateNotEqualTo(Integer value) {
            addCriterion("honour_state <>", value, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateGreaterThan(Integer value) {
            addCriterion("honour_state >", value, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("honour_state >=", value, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateLessThan(Integer value) {
            addCriterion("honour_state <", value, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateLessThanOrEqualTo(Integer value) {
            addCriterion("honour_state <=", value, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateIn(List<Integer> values) {
            addCriterion("honour_state in", values, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateNotIn(List<Integer> values) {
            addCriterion("honour_state not in", values, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateBetween(Integer value1, Integer value2) {
            addCriterion("honour_state between", value1, value2, "honourState");
            return (Criteria) this;
        }

        public Criteria andHonourStateNotBetween(Integer value1, Integer value2) {
            addCriterion("honour_state not between", value1, value2, "honourState");
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