package com.hisense.entity;

import java.math.BigDecimal;

public class OrderTb {
    private Long id;

    private Long comid;

    private Long uin;

    private Long berthsecId;

    private Long createTime;

    private Long endTime;

    private BigDecimal receivable;

    private BigDecimal receipts;

    private Integer couponType;

    private String couponCode;

    private BigDecimal couponAmount;

    private Long paymentTime;

    private Integer state;

    private Integer payType;

    private Long chargeId;

    private String carNumber;

    private Long inPassid;

    private Long outPassid;

    private String orderUuid;

    private BigDecimal prepaid;

    private String berthnumber;

    private Integer flag;

    private Integer carIntype;

    private Integer repeatFlag;

    private String invoicecode;

    private String carinimageurl;

    private String caroutimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getComid() {
        return comid;
    }

    public void setComid(Long comid) {
        this.comid = comid;
    }

    public Long getUin() {
        return uin;
    }

    public void setUin(Long uin) {
        this.uin = uin;
    }

    public Long getBerthsecId() {
        return berthsecId;
    }

    public void setBerthsecId(Long berthsecId) {
        this.berthsecId = berthsecId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getReceivable() {
        return receivable;
    }

    public void setReceivable(BigDecimal receivable) {
        this.receivable = receivable;
    }

    public BigDecimal getReceipts() {
        return receipts;
    }

    public void setReceipts(BigDecimal receipts) {
        this.receipts = receipts;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Long getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Long paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getChargeId() {
        return chargeId;
    }

    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public Long getInPassid() {
        return inPassid;
    }

    public void setInPassid(Long inPassid) {
        this.inPassid = inPassid;
    }

    public Long getOutPassid() {
        return outPassid;
    }

    public void setOutPassid(Long outPassid) {
        this.outPassid = outPassid;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid == null ? null : orderUuid.trim();
    }

    public BigDecimal getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(BigDecimal prepaid) {
        this.prepaid = prepaid;
    }

    public String getBerthnumber() {
        return berthnumber;
    }

    public void setBerthnumber(String berthnumber) {
        this.berthnumber = berthnumber == null ? null : berthnumber.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getCarIntype() {
        return carIntype;
    }

    public void setCarIntype(Integer carIntype) {
        this.carIntype = carIntype;
    }

    public Integer getRepeatFlag() {
        return repeatFlag;
    }

    public void setRepeatFlag(Integer repeatFlag) {
        this.repeatFlag = repeatFlag;
    }

    public String getInvoicecode() {
        return invoicecode;
    }

    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode == null ? null : invoicecode.trim();
    }

    public String getCarinimageurl() {
        return carinimageurl;
    }

    public void setCarinimageurl(String carinimageurl) {
        this.carinimageurl = carinimageurl == null ? null : carinimageurl.trim();
    }

    public String getCaroutimageurl() {
        return caroutimageurl;
    }

    public void setCaroutimageurl(String caroutimageurl) {
        this.caroutimageurl = caroutimageurl == null ? null : caroutimageurl.trim();
    }
}