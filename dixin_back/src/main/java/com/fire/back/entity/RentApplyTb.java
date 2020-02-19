package com.fire.back.entity;

public class RentApplyTb {
    private Long id;

    private Long userId;

    private String school;

    private String major;

    private String jobIntension;

    private Integer hopeSalary;

    private Integer state;

    private Long applyTime;

    private Long sentTime;

    private Double sentAmount;

    private String sentProof;

    private Integer jobState;

    private String companyName;

    private Integer isDelete;

    private String companyAddress;

    private String position;

    private String rejectReason;

    private Long createTime;

    private Long updateTime;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getJobIntension() {
        return jobIntension;
    }

    public void setJobIntension(String jobIntension) {
        this.jobIntension = jobIntension == null ? null : jobIntension.trim();
    }

    public Integer getHopeSalary() {
        return hopeSalary;
    }

    public void setHopeSalary(Integer hopeSalary) {
        this.hopeSalary = hopeSalary;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    public Long getSentTime() {
        return sentTime;
    }

    public void setSentTime(Long sentTime) {
        this.sentTime = sentTime;
    }

    public Double getSentAmount() {
        return sentAmount;
    }

    public void setSentAmount(Double sentAmount) {
        this.sentAmount = sentAmount;
    }

    public String getSentProof() {
        return sentProof;
    }

    public void setSentProof(String sentProof) {
        this.sentProof = sentProof == null ? null : sentProof.trim();
    }

    public Integer getJobState() {
        return jobState;
    }

    public void setJobState(Integer jobState) {
        this.jobState = jobState;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}