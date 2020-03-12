package com.fire.back.service;

import com.fire.back.entity.SignTb;

import java.util.List;

public interface SignInService {

    /**
     * 签到信息，参数获取用户id,自动获取系统当前日期
     * @param record
     * @return
     */
    int signIn(SignTb record);

    /**
     *获取指定月份签到情况列表
     * @param userId
     * @param signYear
     * @param signMonth
     * @return List<String>==>["0","1"...]
     */
    List<String> getMonthSignList(Long userId, int signYear, int signMonth);

    /**
     * 判断进入是否已签到
     * @param userId
     * @return
     */
    Boolean isTodaySigned(Long userId);

    /**
     * 获取指定年份签到总天数
     * @param year
     * @param userId
     * @return
     */
    Integer getYearSigned(int year,int month,Long userId);

    /**
     * 获取指定年份至今签到总天数
     * @param year
     * @param userId
     * @return
     */
    Integer getTotalYearSigned(int year,int month,Long userId);

    /**
     * 获取指定月份签到详情
     * @param signYear
     * @param userId
     * @Param signMonth
     * @return
     */
    SignTb getSignTbByTime(Long userId,int signYear,int signMonth);
}
