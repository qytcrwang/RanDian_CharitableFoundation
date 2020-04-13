package com.fire.back.entity;

import java.util.ArrayList;
import java.util.List;

public class ContriProtocolLastTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContriProtocolLastTbExample() {
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

        public Criteria andPartyAIsNull() {
            addCriterion("party_a is null");
            return (Criteria) this;
        }

        public Criteria andPartyAIsNotNull() {
            addCriterion("party_a is not null");
            return (Criteria) this;
        }

        public Criteria andPartyAEqualTo(String value) {
            addCriterion("party_a =", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotEqualTo(String value) {
            addCriterion("party_a <>", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAGreaterThan(String value) {
            addCriterion("party_a >", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAGreaterThanOrEqualTo(String value) {
            addCriterion("party_a >=", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALessThan(String value) {
            addCriterion("party_a <", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALessThanOrEqualTo(String value) {
            addCriterion("party_a <=", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALike(String value) {
            addCriterion("party_a like", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotLike(String value) {
            addCriterion("party_a not like", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAIn(List<String> values) {
            addCriterion("party_a in", values, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotIn(List<String> values) {
            addCriterion("party_a not in", values, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyABetween(String value1, String value2) {
            addCriterion("party_a between", value1, value2, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotBetween(String value1, String value2) {
            addCriterion("party_a not between", value1, value2, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitIsNull() {
            addCriterion("party_a_unit is null");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitIsNotNull() {
            addCriterion("party_a_unit is not null");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitEqualTo(String value) {
            addCriterion("party_a_unit =", value, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitNotEqualTo(String value) {
            addCriterion("party_a_unit <>", value, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitGreaterThan(String value) {
            addCriterion("party_a_unit >", value, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitGreaterThanOrEqualTo(String value) {
            addCriterion("party_a_unit >=", value, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitLessThan(String value) {
            addCriterion("party_a_unit <", value, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitLessThanOrEqualTo(String value) {
            addCriterion("party_a_unit <=", value, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitLike(String value) {
            addCriterion("party_a_unit like", value, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitNotLike(String value) {
            addCriterion("party_a_unit not like", value, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitIn(List<String> values) {
            addCriterion("party_a_unit in", values, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitNotIn(List<String> values) {
            addCriterion("party_a_unit not in", values, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitBetween(String value1, String value2) {
            addCriterion("party_a_unit between", value1, value2, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAUnitNotBetween(String value1, String value2) {
            addCriterion("party_a_unit not between", value1, value2, "partyAUnit");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionIsNull() {
            addCriterion("party_a_position is null");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionIsNotNull() {
            addCriterion("party_a_position is not null");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionEqualTo(String value) {
            addCriterion("party_a_position =", value, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionNotEqualTo(String value) {
            addCriterion("party_a_position <>", value, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionGreaterThan(String value) {
            addCriterion("party_a_position >", value, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionGreaterThanOrEqualTo(String value) {
            addCriterion("party_a_position >=", value, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionLessThan(String value) {
            addCriterion("party_a_position <", value, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionLessThanOrEqualTo(String value) {
            addCriterion("party_a_position <=", value, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionLike(String value) {
            addCriterion("party_a_position like", value, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionNotLike(String value) {
            addCriterion("party_a_position not like", value, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionIn(List<String> values) {
            addCriterion("party_a_position in", values, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionNotIn(List<String> values) {
            addCriterion("party_a_position not in", values, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionBetween(String value1, String value2) {
            addCriterion("party_a_position between", value1, value2, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyAPositionNotBetween(String value1, String value2) {
            addCriterion("party_a_position not between", value1, value2, "partyAPosition");
            return (Criteria) this;
        }

        public Criteria andPartyALegalIsNull() {
            addCriterion("party_a_legal is null");
            return (Criteria) this;
        }

        public Criteria andPartyALegalIsNotNull() {
            addCriterion("party_a_legal is not null");
            return (Criteria) this;
        }

        public Criteria andPartyALegalEqualTo(String value) {
            addCriterion("party_a_legal =", value, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalNotEqualTo(String value) {
            addCriterion("party_a_legal <>", value, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalGreaterThan(String value) {
            addCriterion("party_a_legal >", value, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalGreaterThanOrEqualTo(String value) {
            addCriterion("party_a_legal >=", value, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalLessThan(String value) {
            addCriterion("party_a_legal <", value, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalLessThanOrEqualTo(String value) {
            addCriterion("party_a_legal <=", value, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalLike(String value) {
            addCriterion("party_a_legal like", value, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalNotLike(String value) {
            addCriterion("party_a_legal not like", value, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalIn(List<String> values) {
            addCriterion("party_a_legal in", values, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalNotIn(List<String> values) {
            addCriterion("party_a_legal not in", values, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalBetween(String value1, String value2) {
            addCriterion("party_a_legal between", value1, value2, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALegalNotBetween(String value1, String value2) {
            addCriterion("party_a_legal not between", value1, value2, "partyALegal");
            return (Criteria) this;
        }

        public Criteria andPartyALinkIsNull() {
            addCriterion("party_a_link is null");
            return (Criteria) this;
        }

        public Criteria andPartyALinkIsNotNull() {
            addCriterion("party_a_link is not null");
            return (Criteria) this;
        }

        public Criteria andPartyALinkEqualTo(String value) {
            addCriterion("party_a_link =", value, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkNotEqualTo(String value) {
            addCriterion("party_a_link <>", value, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkGreaterThan(String value) {
            addCriterion("party_a_link >", value, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkGreaterThanOrEqualTo(String value) {
            addCriterion("party_a_link >=", value, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkLessThan(String value) {
            addCriterion("party_a_link <", value, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkLessThanOrEqualTo(String value) {
            addCriterion("party_a_link <=", value, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkLike(String value) {
            addCriterion("party_a_link like", value, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkNotLike(String value) {
            addCriterion("party_a_link not like", value, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkIn(List<String> values) {
            addCriterion("party_a_link in", values, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkNotIn(List<String> values) {
            addCriterion("party_a_link not in", values, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkBetween(String value1, String value2) {
            addCriterion("party_a_link between", value1, value2, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkNotBetween(String value1, String value2) {
            addCriterion("party_a_link not between", value1, value2, "partyALink");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneIsNull() {
            addCriterion("party_a_link_phone is null");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneIsNotNull() {
            addCriterion("party_a_link_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneEqualTo(String value) {
            addCriterion("party_a_link_phone =", value, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneNotEqualTo(String value) {
            addCriterion("party_a_link_phone <>", value, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneGreaterThan(String value) {
            addCriterion("party_a_link_phone >", value, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("party_a_link_phone >=", value, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneLessThan(String value) {
            addCriterion("party_a_link_phone <", value, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("party_a_link_phone <=", value, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneLike(String value) {
            addCriterion("party_a_link_phone like", value, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneNotLike(String value) {
            addCriterion("party_a_link_phone not like", value, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneIn(List<String> values) {
            addCriterion("party_a_link_phone in", values, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneNotIn(List<String> values) {
            addCriterion("party_a_link_phone not in", values, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneBetween(String value1, String value2) {
            addCriterion("party_a_link_phone between", value1, value2, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyALinkPhoneNotBetween(String value1, String value2) {
            addCriterion("party_a_link_phone not between", value1, value2, "partyALinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBIsNull() {
            addCriterion("party_b is null");
            return (Criteria) this;
        }

        public Criteria andPartyBIsNotNull() {
            addCriterion("party_b is not null");
            return (Criteria) this;
        }

        public Criteria andPartyBEqualTo(String value) {
            addCriterion("party_b =", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotEqualTo(String value) {
            addCriterion("party_b <>", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBGreaterThan(String value) {
            addCriterion("party_b >", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBGreaterThanOrEqualTo(String value) {
            addCriterion("party_b >=", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLessThan(String value) {
            addCriterion("party_b <", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLessThanOrEqualTo(String value) {
            addCriterion("party_b <=", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLike(String value) {
            addCriterion("party_b like", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotLike(String value) {
            addCriterion("party_b not like", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBIn(List<String> values) {
            addCriterion("party_b in", values, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotIn(List<String> values) {
            addCriterion("party_b not in", values, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBBetween(String value1, String value2) {
            addCriterion("party_b between", value1, value2, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotBetween(String value1, String value2) {
            addCriterion("party_b not between", value1, value2, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionIsNull() {
            addCriterion("party_b_position is null");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionIsNotNull() {
            addCriterion("party_b_position is not null");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionEqualTo(String value) {
            addCriterion("party_b_position =", value, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionNotEqualTo(String value) {
            addCriterion("party_b_position <>", value, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionGreaterThan(String value) {
            addCriterion("party_b_position >", value, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionGreaterThanOrEqualTo(String value) {
            addCriterion("party_b_position >=", value, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionLessThan(String value) {
            addCriterion("party_b_position <", value, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionLessThanOrEqualTo(String value) {
            addCriterion("party_b_position <=", value, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionLike(String value) {
            addCriterion("party_b_position like", value, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionNotLike(String value) {
            addCriterion("party_b_position not like", value, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionIn(List<String> values) {
            addCriterion("party_b_position in", values, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionNotIn(List<String> values) {
            addCriterion("party_b_position not in", values, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionBetween(String value1, String value2) {
            addCriterion("party_b_position between", value1, value2, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBPositionNotBetween(String value1, String value2) {
            addCriterion("party_b_position not between", value1, value2, "partyBPosition");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalIsNull() {
            addCriterion("party_b_legal is null");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalIsNotNull() {
            addCriterion("party_b_legal is not null");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalEqualTo(String value) {
            addCriterion("party_b_legal =", value, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalNotEqualTo(String value) {
            addCriterion("party_b_legal <>", value, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalGreaterThan(String value) {
            addCriterion("party_b_legal >", value, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalGreaterThanOrEqualTo(String value) {
            addCriterion("party_b_legal >=", value, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalLessThan(String value) {
            addCriterion("party_b_legal <", value, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalLessThanOrEqualTo(String value) {
            addCriterion("party_b_legal <=", value, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalLike(String value) {
            addCriterion("party_b_legal like", value, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalNotLike(String value) {
            addCriterion("party_b_legal not like", value, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalIn(List<String> values) {
            addCriterion("party_b_legal in", values, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalNotIn(List<String> values) {
            addCriterion("party_b_legal not in", values, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalBetween(String value1, String value2) {
            addCriterion("party_b_legal between", value1, value2, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLegalNotBetween(String value1, String value2) {
            addCriterion("party_b_legal not between", value1, value2, "partyBLegal");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkIsNull() {
            addCriterion("party_b_link is null");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkIsNotNull() {
            addCriterion("party_b_link is not null");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkEqualTo(String value) {
            addCriterion("party_b_link =", value, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkNotEqualTo(String value) {
            addCriterion("party_b_link <>", value, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkGreaterThan(String value) {
            addCriterion("party_b_link >", value, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkGreaterThanOrEqualTo(String value) {
            addCriterion("party_b_link >=", value, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkLessThan(String value) {
            addCriterion("party_b_link <", value, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkLessThanOrEqualTo(String value) {
            addCriterion("party_b_link <=", value, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkLike(String value) {
            addCriterion("party_b_link like", value, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkNotLike(String value) {
            addCriterion("party_b_link not like", value, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkIn(List<String> values) {
            addCriterion("party_b_link in", values, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkNotIn(List<String> values) {
            addCriterion("party_b_link not in", values, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkBetween(String value1, String value2) {
            addCriterion("party_b_link between", value1, value2, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkNotBetween(String value1, String value2) {
            addCriterion("party_b_link not between", value1, value2, "partyBLink");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneIsNull() {
            addCriterion("party_b_link_phone is null");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneIsNotNull() {
            addCriterion("party_b_link_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneEqualTo(String value) {
            addCriterion("party_b_link_phone =", value, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneNotEqualTo(String value) {
            addCriterion("party_b_link_phone <>", value, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneGreaterThan(String value) {
            addCriterion("party_b_link_phone >", value, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("party_b_link_phone >=", value, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneLessThan(String value) {
            addCriterion("party_b_link_phone <", value, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("party_b_link_phone <=", value, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneLike(String value) {
            addCriterion("party_b_link_phone like", value, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneNotLike(String value) {
            addCriterion("party_b_link_phone not like", value, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneIn(List<String> values) {
            addCriterion("party_b_link_phone in", values, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneNotIn(List<String> values) {
            addCriterion("party_b_link_phone not in", values, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneBetween(String value1, String value2) {
            addCriterion("party_b_link_phone between", value1, value2, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andPartyBLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("party_b_link_phone not between", value1, value2, "partyBLinkPhone");
            return (Criteria) this;
        }

        public Criteria andUserForIsNull() {
            addCriterion("user_for is null");
            return (Criteria) this;
        }

        public Criteria andUserForIsNotNull() {
            addCriterion("user_for is not null");
            return (Criteria) this;
        }

        public Criteria andUserForEqualTo(String value) {
            addCriterion("user_for =", value, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForNotEqualTo(String value) {
            addCriterion("user_for <>", value, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForGreaterThan(String value) {
            addCriterion("user_for >", value, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForGreaterThanOrEqualTo(String value) {
            addCriterion("user_for >=", value, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForLessThan(String value) {
            addCriterion("user_for <", value, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForLessThanOrEqualTo(String value) {
            addCriterion("user_for <=", value, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForLike(String value) {
            addCriterion("user_for like", value, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForNotLike(String value) {
            addCriterion("user_for not like", value, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForIn(List<String> values) {
            addCriterion("user_for in", values, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForNotIn(List<String> values) {
            addCriterion("user_for not in", values, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForBetween(String value1, String value2) {
            addCriterion("user_for between", value1, value2, "userFor");
            return (Criteria) this;
        }

        public Criteria andUserForNotBetween(String value1, String value2) {
            addCriterion("user_for not between", value1, value2, "userFor");
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