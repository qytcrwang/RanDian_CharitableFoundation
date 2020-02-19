package com.fire.back.entity;

public class ActivityTb {
    private Long id;

    private String title;

    private String address;

    private Long activityStartTime;

    private Long activityEndTime;

    private Long signStartTime;

    private Long signEndTime;

    private Long readNum;

    private Long goodNum;

    private String picUrl;

    private Integer state;

    private Integer type;

    private Integer ifSend;

    private Integer activityTime;

    private Integer applyNums;

    private Integer isDelete;

    private Long createTime;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Long activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Long getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Long activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Long getSignStartTime() {
        return signStartTime;
    }

    public void setSignStartTime(Long signStartTime) {
        this.signStartTime = signStartTime;
    }

    public Long getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(Long signEndTime) {
        this.signEndTime = signEndTime;
    }

    public Long getReadNum() {
        return readNum;
    }

    public void setReadNum(Long readNum) {
        this.readNum = readNum;
    }

    public Long getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Long goodNum) {
        this.goodNum = goodNum;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIfSend() {
        return ifSend;
    }

    public void setIfSend(Integer ifSend) {
        this.ifSend = ifSend;
    }

    public Integer getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Integer activityTime) {
        this.activityTime = activityTime;
    }

    public Integer getApplyNums() {
        return applyNums;
    }

    public void setApplyNums(Integer applyNums) {
        this.applyNums = applyNums;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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