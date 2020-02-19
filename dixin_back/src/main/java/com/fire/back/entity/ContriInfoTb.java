package com.fire.back.entity;

import java.math.BigDecimal;

public class ContriInfoTb {
    private Long id;

    private Long userId;

    private BigDecimal contriAmount;

    private String contriThings;

    private Long contriTime;

    private String mobile;

    private String orgName;

    private String orgRName;

    private String contriProof;

    private Integer contriType;

    private Long updateTime;

    private Integer isDelete;

    private Integer contriState;

    private Integer ifStamp;

    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getContriAmount() {
        return contriAmount;
    }

    public void setContriAmount(BigDecimal contriAmount) {
        this.contriAmount = contriAmount;
    }

    public String getContriThings() {
        return contriThings;
    }

    public void setContriThings(String contriThings) {
        this.contriThings = contriThings == null ? null : contriThings.trim();
    }

    public Long getContriTime() {
        return contriTime;
    }

    public void setContriTime(Long contriTime) {
        this.contriTime = contriTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgRName() {
        return orgRName;
    }

    public void setOrgRName(String orgRName) {
        this.orgRName = orgRName == null ? null : orgRName.trim();
    }

    public String getContriProof() {
        return contriProof;
    }

    public void setContriProof(String contriProof) {
        this.contriProof = contriProof == null ? null : contriProof.trim();
    }

    public Integer getContriType() {
        return contriType;
    }

    public void setContriType(Integer contriType) {
        this.contriType = contriType;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getContriState() {
        return contriState;
    }

    public void setContriState(Integer contriState) {
        this.contriState = contriState;
    }

    public Integer getIfStamp() {
        return ifStamp;
    }

    public void setIfStamp(Integer ifStamp) {
        this.ifStamp = ifStamp;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}