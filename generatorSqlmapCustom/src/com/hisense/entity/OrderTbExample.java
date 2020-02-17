package com.hisense.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderTbExample() {
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

        public Criteria andComidIsNull() {
            addCriterion("comid is null");
            return (Criteria) this;
        }

        public Criteria andComidIsNotNull() {
            addCriterion("comid is not null");
            return (Criteria) this;
        }

        public Criteria andComidEqualTo(Long value) {
            addCriterion("comid =", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidNotEqualTo(Long value) {
            addCriterion("comid <>", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidGreaterThan(Long value) {
            addCriterion("comid >", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidGreaterThanOrEqualTo(Long value) {
            addCriterion("comid >=", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidLessThan(Long value) {
            addCriterion("comid <", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidLessThanOrEqualTo(Long value) {
            addCriterion("comid <=", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidIn(List<Long> values) {
            addCriterion("comid in", values, "comid");
            return (Criteria) this;
        }

        public Criteria andComidNotIn(List<Long> values) {
            addCriterion("comid not in", values, "comid");
            return (Criteria) this;
        }

        public Criteria andComidBetween(Long value1, Long value2) {
            addCriterion("comid between", value1, value2, "comid");
            return (Criteria) this;
        }

        public Criteria andComidNotBetween(Long value1, Long value2) {
            addCriterion("comid not between", value1, value2, "comid");
            return (Criteria) this;
        }

        public Criteria andUinIsNull() {
            addCriterion("uin is null");
            return (Criteria) this;
        }

        public Criteria andUinIsNotNull() {
            addCriterion("uin is not null");
            return (Criteria) this;
        }

        public Criteria andUinEqualTo(Long value) {
            addCriterion("uin =", value, "uin");
            return (Criteria) this;
        }

        public Criteria andUinNotEqualTo(Long value) {
            addCriterion("uin <>", value, "uin");
            return (Criteria) this;
        }

        public Criteria andUinGreaterThan(Long value) {
            addCriterion("uin >", value, "uin");
            return (Criteria) this;
        }

        public Criteria andUinGreaterThanOrEqualTo(Long value) {
            addCriterion("uin >=", value, "uin");
            return (Criteria) this;
        }

        public Criteria andUinLessThan(Long value) {
            addCriterion("uin <", value, "uin");
            return (Criteria) this;
        }

        public Criteria andUinLessThanOrEqualTo(Long value) {
            addCriterion("uin <=", value, "uin");
            return (Criteria) this;
        }

        public Criteria andUinIn(List<Long> values) {
            addCriterion("uin in", values, "uin");
            return (Criteria) this;
        }

        public Criteria andUinNotIn(List<Long> values) {
            addCriterion("uin not in", values, "uin");
            return (Criteria) this;
        }

        public Criteria andUinBetween(Long value1, Long value2) {
            addCriterion("uin between", value1, value2, "uin");
            return (Criteria) this;
        }

        public Criteria andUinNotBetween(Long value1, Long value2) {
            addCriterion("uin not between", value1, value2, "uin");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdIsNull() {
            addCriterion("berthsec_id is null");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdIsNotNull() {
            addCriterion("berthsec_id is not null");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdEqualTo(Long value) {
            addCriterion("berthsec_id =", value, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdNotEqualTo(Long value) {
            addCriterion("berthsec_id <>", value, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdGreaterThan(Long value) {
            addCriterion("berthsec_id >", value, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("berthsec_id >=", value, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdLessThan(Long value) {
            addCriterion("berthsec_id <", value, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdLessThanOrEqualTo(Long value) {
            addCriterion("berthsec_id <=", value, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdIn(List<Long> values) {
            addCriterion("berthsec_id in", values, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdNotIn(List<Long> values) {
            addCriterion("berthsec_id not in", values, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdBetween(Long value1, Long value2) {
            addCriterion("berthsec_id between", value1, value2, "berthsecId");
            return (Criteria) this;
        }

        public Criteria andBerthsecIdNotBetween(Long value1, Long value2) {
            addCriterion("berthsec_id not between", value1, value2, "berthsecId");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Long value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Long value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Long value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Long value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Long> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Long> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Long value1, Long value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNull() {
            addCriterion("receivable is null");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNotNull() {
            addCriterion("receivable is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableEqualTo(BigDecimal value) {
            addCriterion("receivable =", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotEqualTo(BigDecimal value) {
            addCriterion("receivable <>", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThan(BigDecimal value) {
            addCriterion("receivable >", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable >=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThan(BigDecimal value) {
            addCriterion("receivable <", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable <=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableIn(List<BigDecimal> values) {
            addCriterion("receivable in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotIn(List<BigDecimal> values) {
            addCriterion("receivable not in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable not between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceiptsIsNull() {
            addCriterion("receipts is null");
            return (Criteria) this;
        }

        public Criteria andReceiptsIsNotNull() {
            addCriterion("receipts is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptsEqualTo(BigDecimal value) {
            addCriterion("receipts =", value, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsNotEqualTo(BigDecimal value) {
            addCriterion("receipts <>", value, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsGreaterThan(BigDecimal value) {
            addCriterion("receipts >", value, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receipts >=", value, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsLessThan(BigDecimal value) {
            addCriterion("receipts <", value, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receipts <=", value, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsIn(List<BigDecimal> values) {
            addCriterion("receipts in", values, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsNotIn(List<BigDecimal> values) {
            addCriterion("receipts not in", values, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receipts between", value1, value2, "receipts");
            return (Criteria) this;
        }

        public Criteria andReceiptsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receipts not between", value1, value2, "receipts");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(Integer value) {
            addCriterion("coupon_type =", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(Integer value) {
            addCriterion("coupon_type <>", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(Integer value) {
            addCriterion("coupon_type >", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_type >=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(Integer value) {
            addCriterion("coupon_type <", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_type <=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<Integer> values) {
            addCriterion("coupon_type in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<Integer> values) {
            addCriterion("coupon_type not in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type not between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIsNull() {
            addCriterion("coupon_code is null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIsNotNull() {
            addCriterion("coupon_code is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeEqualTo(String value) {
            addCriterion("coupon_code =", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotEqualTo(String value) {
            addCriterion("coupon_code <>", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThan(String value) {
            addCriterion("coupon_code >", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_code >=", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThan(String value) {
            addCriterion("coupon_code <", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThanOrEqualTo(String value) {
            addCriterion("coupon_code <=", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLike(String value) {
            addCriterion("coupon_code like", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotLike(String value) {
            addCriterion("coupon_code not like", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIn(List<String> values) {
            addCriterion("coupon_code in", values, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotIn(List<String> values) {
            addCriterion("coupon_code not in", values, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeBetween(String value1, String value2) {
            addCriterion("coupon_code between", value1, value2, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotBetween(String value1, String value2) {
            addCriterion("coupon_code not between", value1, value2, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNull() {
            addCriterion("coupon_amount is null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNotNull() {
            addCriterion("coupon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountEqualTo(BigDecimal value) {
            addCriterion("coupon_amount =", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotEqualTo(BigDecimal value) {
            addCriterion("coupon_amount <>", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThan(BigDecimal value) {
            addCriterion("coupon_amount >", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_amount >=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThan(BigDecimal value) {
            addCriterion("coupon_amount <", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_amount <=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIn(List<BigDecimal> values) {
            addCriterion("coupon_amount in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotIn(List<BigDecimal> values) {
            addCriterion("coupon_amount not in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_amount between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_amount not between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Long value) {
            addCriterion("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Long value) {
            addCriterion("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Long value) {
            addCriterion("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Long value) {
            addCriterion("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Long value) {
            addCriterion("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Long> values) {
            addCriterion("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Long> values) {
            addCriterion("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Long value1, Long value2) {
            addCriterion("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Long value1, Long value2) {
            addCriterion("payment_time not between", value1, value2, "paymentTime");
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

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andChargeIdIsNull() {
            addCriterion("charge_id is null");
            return (Criteria) this;
        }

        public Criteria andChargeIdIsNotNull() {
            addCriterion("charge_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargeIdEqualTo(Long value) {
            addCriterion("charge_id =", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotEqualTo(Long value) {
            addCriterion("charge_id <>", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdGreaterThan(Long value) {
            addCriterion("charge_id >", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("charge_id >=", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdLessThan(Long value) {
            addCriterion("charge_id <", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdLessThanOrEqualTo(Long value) {
            addCriterion("charge_id <=", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdIn(List<Long> values) {
            addCriterion("charge_id in", values, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotIn(List<Long> values) {
            addCriterion("charge_id not in", values, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdBetween(Long value1, Long value2) {
            addCriterion("charge_id between", value1, value2, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotBetween(Long value1, Long value2) {
            addCriterion("charge_id not between", value1, value2, "chargeId");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andInPassidIsNull() {
            addCriterion("in_passid is null");
            return (Criteria) this;
        }

        public Criteria andInPassidIsNotNull() {
            addCriterion("in_passid is not null");
            return (Criteria) this;
        }

        public Criteria andInPassidEqualTo(Long value) {
            addCriterion("in_passid =", value, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidNotEqualTo(Long value) {
            addCriterion("in_passid <>", value, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidGreaterThan(Long value) {
            addCriterion("in_passid >", value, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidGreaterThanOrEqualTo(Long value) {
            addCriterion("in_passid >=", value, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidLessThan(Long value) {
            addCriterion("in_passid <", value, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidLessThanOrEqualTo(Long value) {
            addCriterion("in_passid <=", value, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidIn(List<Long> values) {
            addCriterion("in_passid in", values, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidNotIn(List<Long> values) {
            addCriterion("in_passid not in", values, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidBetween(Long value1, Long value2) {
            addCriterion("in_passid between", value1, value2, "inPassid");
            return (Criteria) this;
        }

        public Criteria andInPassidNotBetween(Long value1, Long value2) {
            addCriterion("in_passid not between", value1, value2, "inPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidIsNull() {
            addCriterion("out_passid is null");
            return (Criteria) this;
        }

        public Criteria andOutPassidIsNotNull() {
            addCriterion("out_passid is not null");
            return (Criteria) this;
        }

        public Criteria andOutPassidEqualTo(Long value) {
            addCriterion("out_passid =", value, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidNotEqualTo(Long value) {
            addCriterion("out_passid <>", value, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidGreaterThan(Long value) {
            addCriterion("out_passid >", value, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidGreaterThanOrEqualTo(Long value) {
            addCriterion("out_passid >=", value, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidLessThan(Long value) {
            addCriterion("out_passid <", value, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidLessThanOrEqualTo(Long value) {
            addCriterion("out_passid <=", value, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidIn(List<Long> values) {
            addCriterion("out_passid in", values, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidNotIn(List<Long> values) {
            addCriterion("out_passid not in", values, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidBetween(Long value1, Long value2) {
            addCriterion("out_passid between", value1, value2, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOutPassidNotBetween(Long value1, Long value2) {
            addCriterion("out_passid not between", value1, value2, "outPassid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidIsNull() {
            addCriterion("order_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOrderUuidIsNotNull() {
            addCriterion("order_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUuidEqualTo(String value) {
            addCriterion("order_uuid =", value, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidNotEqualTo(String value) {
            addCriterion("order_uuid <>", value, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidGreaterThan(String value) {
            addCriterion("order_uuid >", value, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidGreaterThanOrEqualTo(String value) {
            addCriterion("order_uuid >=", value, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidLessThan(String value) {
            addCriterion("order_uuid <", value, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidLessThanOrEqualTo(String value) {
            addCriterion("order_uuid <=", value, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidLike(String value) {
            addCriterion("order_uuid like", value, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidNotLike(String value) {
            addCriterion("order_uuid not like", value, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidIn(List<String> values) {
            addCriterion("order_uuid in", values, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidNotIn(List<String> values) {
            addCriterion("order_uuid not in", values, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidBetween(String value1, String value2) {
            addCriterion("order_uuid between", value1, value2, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andOrderUuidNotBetween(String value1, String value2) {
            addCriterion("order_uuid not between", value1, value2, "orderUuid");
            return (Criteria) this;
        }

        public Criteria andPrepaidIsNull() {
            addCriterion("prepaid is null");
            return (Criteria) this;
        }

        public Criteria andPrepaidIsNotNull() {
            addCriterion("prepaid is not null");
            return (Criteria) this;
        }

        public Criteria andPrepaidEqualTo(BigDecimal value) {
            addCriterion("prepaid =", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidNotEqualTo(BigDecimal value) {
            addCriterion("prepaid <>", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidGreaterThan(BigDecimal value) {
            addCriterion("prepaid >", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prepaid >=", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidLessThan(BigDecimal value) {
            addCriterion("prepaid <", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prepaid <=", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidIn(List<BigDecimal> values) {
            addCriterion("prepaid in", values, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidNotIn(List<BigDecimal> values) {
            addCriterion("prepaid not in", values, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prepaid between", value1, value2, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prepaid not between", value1, value2, "prepaid");
            return (Criteria) this;
        }

        public Criteria andBerthnumberIsNull() {
            addCriterion("berthnumber is null");
            return (Criteria) this;
        }

        public Criteria andBerthnumberIsNotNull() {
            addCriterion("berthnumber is not null");
            return (Criteria) this;
        }

        public Criteria andBerthnumberEqualTo(String value) {
            addCriterion("berthnumber =", value, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberNotEqualTo(String value) {
            addCriterion("berthnumber <>", value, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberGreaterThan(String value) {
            addCriterion("berthnumber >", value, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberGreaterThanOrEqualTo(String value) {
            addCriterion("berthnumber >=", value, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberLessThan(String value) {
            addCriterion("berthnumber <", value, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberLessThanOrEqualTo(String value) {
            addCriterion("berthnumber <=", value, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberLike(String value) {
            addCriterion("berthnumber like", value, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberNotLike(String value) {
            addCriterion("berthnumber not like", value, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberIn(List<String> values) {
            addCriterion("berthnumber in", values, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberNotIn(List<String> values) {
            addCriterion("berthnumber not in", values, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberBetween(String value1, String value2) {
            addCriterion("berthnumber between", value1, value2, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andBerthnumberNotBetween(String value1, String value2) {
            addCriterion("berthnumber not between", value1, value2, "berthnumber");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andCarIntypeIsNull() {
            addCriterion("car_inType is null");
            return (Criteria) this;
        }

        public Criteria andCarIntypeIsNotNull() {
            addCriterion("car_inType is not null");
            return (Criteria) this;
        }

        public Criteria andCarIntypeEqualTo(Integer value) {
            addCriterion("car_inType =", value, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeNotEqualTo(Integer value) {
            addCriterion("car_inType <>", value, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeGreaterThan(Integer value) {
            addCriterion("car_inType >", value, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_inType >=", value, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeLessThan(Integer value) {
            addCriterion("car_inType <", value, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeLessThanOrEqualTo(Integer value) {
            addCriterion("car_inType <=", value, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeIn(List<Integer> values) {
            addCriterion("car_inType in", values, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeNotIn(List<Integer> values) {
            addCriterion("car_inType not in", values, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeBetween(Integer value1, Integer value2) {
            addCriterion("car_inType between", value1, value2, "carIntype");
            return (Criteria) this;
        }

        public Criteria andCarIntypeNotBetween(Integer value1, Integer value2) {
            addCriterion("car_inType not between", value1, value2, "carIntype");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagIsNull() {
            addCriterion("repeat_flag is null");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagIsNotNull() {
            addCriterion("repeat_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagEqualTo(Integer value) {
            addCriterion("repeat_flag =", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagNotEqualTo(Integer value) {
            addCriterion("repeat_flag <>", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagGreaterThan(Integer value) {
            addCriterion("repeat_flag >", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("repeat_flag >=", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagLessThan(Integer value) {
            addCriterion("repeat_flag <", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagLessThanOrEqualTo(Integer value) {
            addCriterion("repeat_flag <=", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagIn(List<Integer> values) {
            addCriterion("repeat_flag in", values, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagNotIn(List<Integer> values) {
            addCriterion("repeat_flag not in", values, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagBetween(Integer value1, Integer value2) {
            addCriterion("repeat_flag between", value1, value2, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("repeat_flag not between", value1, value2, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeIsNull() {
            addCriterion("invoicecode is null");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeIsNotNull() {
            addCriterion("invoicecode is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeEqualTo(String value) {
            addCriterion("invoicecode =", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeNotEqualTo(String value) {
            addCriterion("invoicecode <>", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeGreaterThan(String value) {
            addCriterion("invoicecode >", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeGreaterThanOrEqualTo(String value) {
            addCriterion("invoicecode >=", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeLessThan(String value) {
            addCriterion("invoicecode <", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeLessThanOrEqualTo(String value) {
            addCriterion("invoicecode <=", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeLike(String value) {
            addCriterion("invoicecode like", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeNotLike(String value) {
            addCriterion("invoicecode not like", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeIn(List<String> values) {
            addCriterion("invoicecode in", values, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeNotIn(List<String> values) {
            addCriterion("invoicecode not in", values, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeBetween(String value1, String value2) {
            addCriterion("invoicecode between", value1, value2, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeNotBetween(String value1, String value2) {
            addCriterion("invoicecode not between", value1, value2, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlIsNull() {
            addCriterion("carinimageurl is null");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlIsNotNull() {
            addCriterion("carinimageurl is not null");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlEqualTo(String value) {
            addCriterion("carinimageurl =", value, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlNotEqualTo(String value) {
            addCriterion("carinimageurl <>", value, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlGreaterThan(String value) {
            addCriterion("carinimageurl >", value, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlGreaterThanOrEqualTo(String value) {
            addCriterion("carinimageurl >=", value, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlLessThan(String value) {
            addCriterion("carinimageurl <", value, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlLessThanOrEqualTo(String value) {
            addCriterion("carinimageurl <=", value, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlLike(String value) {
            addCriterion("carinimageurl like", value, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlNotLike(String value) {
            addCriterion("carinimageurl not like", value, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlIn(List<String> values) {
            addCriterion("carinimageurl in", values, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlNotIn(List<String> values) {
            addCriterion("carinimageurl not in", values, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlBetween(String value1, String value2) {
            addCriterion("carinimageurl between", value1, value2, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCarinimageurlNotBetween(String value1, String value2) {
            addCriterion("carinimageurl not between", value1, value2, "carinimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlIsNull() {
            addCriterion("caroutimageurl is null");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlIsNotNull() {
            addCriterion("caroutimageurl is not null");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlEqualTo(String value) {
            addCriterion("caroutimageurl =", value, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlNotEqualTo(String value) {
            addCriterion("caroutimageurl <>", value, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlGreaterThan(String value) {
            addCriterion("caroutimageurl >", value, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlGreaterThanOrEqualTo(String value) {
            addCriterion("caroutimageurl >=", value, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlLessThan(String value) {
            addCriterion("caroutimageurl <", value, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlLessThanOrEqualTo(String value) {
            addCriterion("caroutimageurl <=", value, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlLike(String value) {
            addCriterion("caroutimageurl like", value, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlNotLike(String value) {
            addCriterion("caroutimageurl not like", value, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlIn(List<String> values) {
            addCriterion("caroutimageurl in", values, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlNotIn(List<String> values) {
            addCriterion("caroutimageurl not in", values, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlBetween(String value1, String value2) {
            addCriterion("caroutimageurl between", value1, value2, "caroutimageurl");
            return (Criteria) this;
        }

        public Criteria andCaroutimageurlNotBetween(String value1, String value2) {
            addCriterion("caroutimageurl not between", value1, value2, "caroutimageurl");
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