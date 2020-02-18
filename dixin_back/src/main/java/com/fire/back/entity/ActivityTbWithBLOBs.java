package com.fire.back.entity;

public class ActivityTbWithBLOBs extends ActivityTb {
    private String body;

    private String applyNames;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public String getApplyNames() {
        return applyNames;
    }

    public void setApplyNames(String applyNames) {
        this.applyNames = applyNames == null ? null : applyNames.trim();
    }
}