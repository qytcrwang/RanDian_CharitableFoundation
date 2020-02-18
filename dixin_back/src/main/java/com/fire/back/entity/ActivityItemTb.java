package com.fire.back.entity;

import java.math.BigDecimal;

public class ActivityItemTb {
    private Long id;

    private Long activityId;

    private String itemName;

    private BigDecimal itemAmount;

    private String itemProof;

    private String itemFollow;

    private Long createTime;

    private Long updateTime;

    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(BigDecimal itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getItemProof() {
        return itemProof;
    }

    public void setItemProof(String itemProof) {
        this.itemProof = itemProof == null ? null : itemProof.trim();
    }

    public String getItemFollow() {
        return itemFollow;
    }

    public void setItemFollow(String itemFollow) {
        this.itemFollow = itemFollow == null ? null : itemFollow.trim();
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