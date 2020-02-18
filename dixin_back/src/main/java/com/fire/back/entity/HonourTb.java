package com.fire.back.entity;

public class HonourTb {
    private Long id;

    private Long userId;

    private String honourName;

    private String honourProof;

    private Long honourTime;

    private Integer honourState;

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

    public String getHonourName() {
        return honourName;
    }

    public void setHonourName(String honourName) {
        this.honourName = honourName == null ? null : honourName.trim();
    }

    public String getHonourProof() {
        return honourProof;
    }

    public void setHonourProof(String honourProof) {
        this.honourProof = honourProof == null ? null : honourProof.trim();
    }

    public Long getHonourTime() {
        return honourTime;
    }

    public void setHonourTime(Long honourTime) {
        this.honourTime = honourTime;
    }

    public Integer getHonourState() {
        return honourState;
    }

    public void setHonourState(Integer honourState) {
        this.honourState = honourState;
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