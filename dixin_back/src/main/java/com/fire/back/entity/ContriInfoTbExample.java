package com.fire.back.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ContriInfoTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContriInfoTbExample() {
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

        public Criteria andContriAmountIsNull() {
            addCriterion("contri_amount is null");
            return (Criteria) this;
        }

        public Criteria andContriAmountIsNotNull() {
            addCriterion("contri_amount is not null");
            return (Criteria) this;
        }

        public Criteria andContriAmountEqualTo(BigDecimal value) {
            addCriterion("contri_amount =", value, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountNotEqualTo(BigDecimal value) {
            addCriterion("contri_amount <>", value, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountGreaterThan(BigDecimal value) {
            addCriterion("contri_amount >", value, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contri_amount >=", value, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountLessThan(BigDecimal value) {
            addCriterion("contri_amount <", value, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contri_amount <=", value, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountIn(List<BigDecimal> values) {
            addCriterion("contri_amount in", values, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountNotIn(List<BigDecimal> values) {
            addCriterion("contri_amount not in", values, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contri_amount between", value1, value2, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contri_amount not between", value1, value2, "contriAmount");
            return (Criteria) this;
        }

        public Criteria andContriThingsIsNull() {
            addCriterion("contri_things is null");
            return (Criteria) this;
        }

        public Criteria andContriThingsIsNotNull() {
            addCriterion("contri_things is not null");
            return (Criteria) this;
        }

        public Criteria andContriThingsEqualTo(String value) {
            addCriterion("contri_things =", value, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsNotEqualTo(String value) {
            addCriterion("contri_things <>", value, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsGreaterThan(String value) {
            addCriterion("contri_things >", value, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsGreaterThanOrEqualTo(String value) {
            addCriterion("contri_things >=", value, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsLessThan(String value) {
            addCriterion("contri_things <", value, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsLessThanOrEqualTo(String value) {
            addCriterion("contri_things <=", value, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsLike(String value) {
            addCriterion("contri_things like", value, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsNotLike(String value) {
            addCriterion("contri_things not like", value, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsIn(List<String> values) {
            addCriterion("contri_things in", values, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsNotIn(List<String> values) {
            addCriterion("contri_things not in", values, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsBetween(String value1, String value2) {
            addCriterion("contri_things between", value1, value2, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriThingsNotBetween(String value1, String value2) {
            addCriterion("contri_things not between", value1, value2, "contriThings");
            return (Criteria) this;
        }

        public Criteria andContriTimeIsNull() {
            addCriterion("contri_time is null");
            return (Criteria) this;
        }

        public Criteria andContriTimeIsNotNull() {
            addCriterion("contri_time is not null");
            return (Criteria) this;
        }

        public Criteria andContriTimeEqualTo(Long value) {
            addCriterion("contri_time =", value, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeNotEqualTo(Long value) {
            addCriterion("contri_time <>", value, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeGreaterThan(Long value) {
            addCriterion("contri_time >", value, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("contri_time >=", value, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeLessThan(Long value) {
            addCriterion("contri_time <", value, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeLessThanOrEqualTo(Long value) {
            addCriterion("contri_time <=", value, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeIn(List<Long> values) {
            addCriterion("contri_time in", values, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeNotIn(List<Long> values) {
            addCriterion("contri_time not in", values, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeBetween(Long value1, Long value2) {
            addCriterion("contri_time between", value1, value2, "contriTime");
            return (Criteria) this;
        }

        public Criteria andContriTimeNotBetween(Long value1, Long value2) {
            addCriterion("contri_time not between", value1, value2, "contriTime");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameIsNull() {
            addCriterion("org_r_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgRNameIsNotNull() {
            addCriterion("org_r_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgRNameEqualTo(String value) {
            addCriterion("org_r_name =", value, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameNotEqualTo(String value) {
            addCriterion("org_r_name <>", value, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameGreaterThan(String value) {
            addCriterion("org_r_name >", value, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_r_name >=", value, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameLessThan(String value) {
            addCriterion("org_r_name <", value, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameLessThanOrEqualTo(String value) {
            addCriterion("org_r_name <=", value, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameLike(String value) {
            addCriterion("org_r_name like", value, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameNotLike(String value) {
            addCriterion("org_r_name not like", value, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameIn(List<String> values) {
            addCriterion("org_r_name in", values, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameNotIn(List<String> values) {
            addCriterion("org_r_name not in", values, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameBetween(String value1, String value2) {
            addCriterion("org_r_name between", value1, value2, "orgRName");
            return (Criteria) this;
        }

        public Criteria andOrgRNameNotBetween(String value1, String value2) {
            addCriterion("org_r_name not between", value1, value2, "orgRName");
            return (Criteria) this;
        }

        public Criteria andContriProofIsNull() {
            addCriterion("contri_proof is null");
            return (Criteria) this;
        }

        public Criteria andContriProofIsNotNull() {
            addCriterion("contri_proof is not null");
            return (Criteria) this;
        }

        public Criteria andContriProofEqualTo(String value) {
            addCriterion("contri_proof =", value, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofNotEqualTo(String value) {
            addCriterion("contri_proof <>", value, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofGreaterThan(String value) {
            addCriterion("contri_proof >", value, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofGreaterThanOrEqualTo(String value) {
            addCriterion("contri_proof >=", value, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofLessThan(String value) {
            addCriterion("contri_proof <", value, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofLessThanOrEqualTo(String value) {
            addCriterion("contri_proof <=", value, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofLike(String value) {
            addCriterion("contri_proof like", value, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofNotLike(String value) {
            addCriterion("contri_proof not like", value, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofIn(List<String> values) {
            addCriterion("contri_proof in", values, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofNotIn(List<String> values) {
            addCriterion("contri_proof not in", values, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofBetween(String value1, String value2) {
            addCriterion("contri_proof between", value1, value2, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriProofNotBetween(String value1, String value2) {
            addCriterion("contri_proof not between", value1, value2, "contriProof");
            return (Criteria) this;
        }

        public Criteria andContriTypeIsNull() {
            addCriterion("contri_type is null");
            return (Criteria) this;
        }

        public Criteria andContriTypeIsNotNull() {
            addCriterion("contri_type is not null");
            return (Criteria) this;
        }

        public Criteria andContriTypeEqualTo(Integer value) {
            addCriterion("contri_type =", value, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeNotEqualTo(Integer value) {
            addCriterion("contri_type <>", value, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeGreaterThan(Integer value) {
            addCriterion("contri_type >", value, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("contri_type >=", value, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeLessThan(Integer value) {
            addCriterion("contri_type <", value, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeLessThanOrEqualTo(Integer value) {
            addCriterion("contri_type <=", value, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeIn(List<Integer> values) {
            addCriterion("contri_type in", values, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeNotIn(List<Integer> values) {
            addCriterion("contri_type not in", values, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeBetween(Integer value1, Integer value2) {
            addCriterion("contri_type between", value1, value2, "contriType");
            return (Criteria) this;
        }

        public Criteria andContriTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("contri_type not between", value1, value2, "contriType");
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

        public Criteria andContriStateIsNull() {
            addCriterion("contri_state is null");
            return (Criteria) this;
        }

        public Criteria andContriStateIsNotNull() {
            addCriterion("contri_state is not null");
            return (Criteria) this;
        }

        public Criteria andContriStateEqualTo(Integer value) {
            addCriterion("contri_state =", value, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateNotEqualTo(Integer value) {
            addCriterion("contri_state <>", value, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateGreaterThan(Integer value) {
            addCriterion("contri_state >", value, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("contri_state >=", value, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateLessThan(Integer value) {
            addCriterion("contri_state <", value, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateLessThanOrEqualTo(Integer value) {
            addCriterion("contri_state <=", value, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateIn(List<Integer> values) {
            addCriterion("contri_state in", values, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateNotIn(List<Integer> values) {
            addCriterion("contri_state not in", values, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateBetween(Integer value1, Integer value2) {
            addCriterion("contri_state between", value1, value2, "contriState");
            return (Criteria) this;
        }

        public Criteria andContriStateNotBetween(Integer value1, Integer value2) {
            addCriterion("contri_state not between", value1, value2, "contriState");
            return (Criteria) this;
        }

        public Criteria andIfStampIsNull() {
            addCriterion("if_stamp is null");
            return (Criteria) this;
        }

        public Criteria andIfStampIsNotNull() {
            addCriterion("if_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andIfStampEqualTo(Integer value) {
            addCriterion("if_stamp =", value, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampNotEqualTo(Integer value) {
            addCriterion("if_stamp <>", value, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampGreaterThan(Integer value) {
            addCriterion("if_stamp >", value, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampGreaterThanOrEqualTo(Integer value) {
            addCriterion("if_stamp >=", value, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampLessThan(Integer value) {
            addCriterion("if_stamp <", value, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampLessThanOrEqualTo(Integer value) {
            addCriterion("if_stamp <=", value, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampIn(List<Integer> values) {
            addCriterion("if_stamp in", values, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampNotIn(List<Integer> values) {
            addCriterion("if_stamp not in", values, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampBetween(Integer value1, Integer value2) {
            addCriterion("if_stamp between", value1, value2, "ifStamp");
            return (Criteria) this;
        }

        public Criteria andIfStampNotBetween(Integer value1, Integer value2) {
            addCriterion("if_stamp not between", value1, value2, "ifStamp");
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

        public Criteria andContriValueIsNull() {
            addCriterion("contri_value is null");
            return (Criteria) this;
        }

        public Criteria andContriValueIsNotNull() {
            addCriterion("contri_value is not null");
            return (Criteria) this;
        }

        public Criteria andContriValueEqualTo(Integer value) {
            addCriterion("contri_value =", value, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueNotEqualTo(Integer value) {
            addCriterion("contri_value <>", value, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueGreaterThan(Integer value) {
            addCriterion("contri_value >", value, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("contri_value >=", value, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueLessThan(Integer value) {
            addCriterion("contri_value <", value, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueLessThanOrEqualTo(Integer value) {
            addCriterion("contri_value <=", value, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueIn(List<Integer> values) {
            addCriterion("contri_value in", values, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueNotIn(List<Integer> values) {
            addCriterion("contri_value not in", values, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueBetween(Integer value1, Integer value2) {
            addCriterion("contri_value between", value1, value2, "contriValue");
            return (Criteria) this;
        }

        public Criteria andContriValueNotBetween(Integer value1, Integer value2) {
            addCriterion("contri_value not between", value1, value2, "contriValue");
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