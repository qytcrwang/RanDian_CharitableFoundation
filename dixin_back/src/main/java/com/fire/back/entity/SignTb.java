package com.fire.back.entity;

public class SignTb {
    private Long id;

    private Long userId;

    private Integer signYear;

    private Integer signMonth;

    private Long signDays;

    private Integer type;

    private Integer signNums;

    private Long createTime;

    private Long updateTime;

    private Integer isDelete;

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

    public Integer getSignYear() {
        return signYear;
    }

    public void setSignYear(Integer signYear) {
        this.signYear = signYear;
    }

    public Integer getSignMonth() {
        return signMonth;
    }

    public void setSignMonth(Integer signMonth) {
        this.signMonth = signMonth;
    }

    public Long getSignDays() {
        return signDays;
    }

    public void setSignDays(Long signDays) {
        this.signDays = signDays;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSignNums() {
        return signNums;
    }

    public void setSignNums(Integer signNums) {
        this.signNums = signNums;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}