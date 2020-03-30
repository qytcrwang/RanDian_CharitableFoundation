package com.fire.back.entity;

import com.fire.back.common.DateUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseEntity implements Serializable {
    private Integer page=1;

    private Integer limit=10;

    private Integer offSet;

    private String startTime;

    private String endTime;

    public Integer getOffSet() {
        return (page-1)*limit;
    }
    public Integer getOffSet(Integer page,Integer pageSize) {
        offSet = (page-1)*pageSize;
        return offSet;
    }
    private Map<String,Object> params;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Date getStartTime() {
        if(startTime==null)
            return null;
        return DateUtil.parseStrToDate(startTime,DateUtil.DATE_FORMAT_YYYY_MM_DD);
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        if(endTime==null)
            return null;
        return DateUtil.parseStrToDate(endTime,DateUtil.DATE_FORMAT_YYYY_MM_DD);
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Map<String, Object> getParams() {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
