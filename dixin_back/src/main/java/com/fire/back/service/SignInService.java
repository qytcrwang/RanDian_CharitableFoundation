package com.fire.back.service;

import com.fire.back.entity.SignTb;

import java.util.List;

public interface SignInService {

    int signIn(SignTb record);

    //获取当前连续签到天数
    int getConsecutiveSign(Long userId);

    //得到指定月份签到列表
    List<String> getMonthSignList(Long userId, int signYear, int signMonth);
}
