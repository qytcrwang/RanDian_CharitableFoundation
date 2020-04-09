package com.fire.back.entity;

import java.util.Date;

public class ContriProtocolTb {
    private Long id;

    private Long infoTbId;

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

    private Integer protocolType;

    private String content;

    private String contentComment;

    private String userFor;

    private String partyBSignTime;

    private String partyASignTime;

    private Integer isCreatePdf;

    private Integer isDelete;

    private Date updateTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInfoTbId() {
        return infoTbId;
    }

    public void setInfoTbId(Long infoTbId) {
        this.infoTbId = infoTbId;
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

    public Integer getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(Integer protocolType) {
        this.protocolType = protocolType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getContentComment() {
        return contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment == null ? null : contentComment.trim();
    }

    public String getUserFor() {
        return userFor;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor == null ? null : userFor.trim();
    }

    public String getPartyBSignTime() {
        return partyBSignTime;
    }

    public void setPartyBSignTime(String partyBSignTime) {
        this.partyBSignTime = partyBSignTime == null ? null : partyBSignTime.trim();
    }

    public String getPartyASignTime() {
        return partyASignTime;
    }

    public void setPartyASignTime(String partyASignTime) {
        this.partyASignTime = partyASignTime == null ? null : partyASignTime.trim();
    }

    public Integer getIsCreatePdf() {
        return isCreatePdf;
    }

    public void setIsCreatePdf(Integer isCreatePdf) {
        this.isCreatePdf = isCreatePdf;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}