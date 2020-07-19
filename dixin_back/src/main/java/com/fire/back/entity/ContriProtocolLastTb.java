package com.fire.back.entity;

public class ContriProtocolLastTb {
    private Long id;

    private Long userId;

    private String partyA;

    private String partyAUnit;

    private String partyAPosition;

    private String partyALegal;

    private String partyALink;

    private String partyALinkPhone;

    private String partyB;

    private String partyBPosition;

    private String partyBLegal;

    private String partyBLink;

    private String partyBLinkPhone;

    private String userFor;

    private Long updateTime;

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

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA == null ? null : partyA.trim();
    }

    public String getPartyAUnit() {
        return partyAUnit;
    }

    public void setPartyAUnit(String partyAUnit) {
        this.partyAUnit = partyAUnit == null ? null : partyAUnit.trim();
    }

    public String getPartyAPosition() {
        return partyAPosition;
    }

    public void setPartyAPosition(String partyAPosition) {
        this.partyAPosition = partyAPosition == null ? null : partyAPosition.trim();
    }

    public String getPartyALegal() {
        return partyALegal;
    }

    public void setPartyALegal(String partyALegal) {
        this.partyALegal = partyALegal == null ? null : partyALegal.trim();
    }

    public String getPartyALink() {
        return partyALink;
    }

    public void setPartyALink(String partyALink) {
        this.partyALink = partyALink == null ? null : partyALink.trim();
    }

    public String getPartyALinkPhone() {
        return partyALinkPhone;
    }

    public void setPartyALinkPhone(String partyALinkPhone) {
        this.partyALinkPhone = partyALinkPhone == null ? null : partyALinkPhone.trim();
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB == null ? null : partyB.trim();
    }

    public String getPartyBPosition() {
        return partyBPosition;
    }

    public void setPartyBPosition(String partyBPosition) {
        this.partyBPosition = partyBPosition == null ? null : partyBPosition.trim();
    }

    public String getPartyBLegal() {
        return partyBLegal;
    }

    public void setPartyBLegal(String partyBLegal) {
        this.partyBLegal = partyBLegal == null ? null : partyBLegal.trim();
    }

    public String getPartyBLink() {
        return partyBLink;
    }

    public void setPartyBLink(String partyBLink) {
        this.partyBLink = partyBLink == null ? null : partyBLink.trim();
    }

    public String getPartyBLinkPhone() {
        return partyBLinkPhone;
    }

    public void setPartyBLinkPhone(String partyBLinkPhone) {
        this.partyBLinkPhone = partyBLinkPhone == null ? null : partyBLinkPhone.trim();
    }

    public String getUserFor() {
        return userFor;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor == null ? null : userFor.trim();
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}