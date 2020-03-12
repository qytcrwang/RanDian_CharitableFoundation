package com.fire.back.service.impl;

import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.dao.extend.ExtendSignTbMapper;
import com.fire.back.entity.SignTb;
import com.fire.back.entity.SignTbExample;
import com.fire.back.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    ExtendSignTbMapper signMapper;

    @Override
    public int signIn(SignTb record) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        long day = cal.get(Calendar.DATE);
        SignTb sign = getSignTbByTime(record.getUserId(),year,month);
        if(sign!=null){
            long signDays = sign.getSignDays();
            if((signDays&(1<<31-day))>0){
                return -1;
            }
        }
        record.setSignYear(year);
        record.setSignMonth(month);
        record.setSignDays(day);
        record.setSignNums(1);
        record.setCreateTime(System.currentTimeMillis()/1000);
        record.setUpdateTime(System.currentTimeMillis()/1000);
        record.setIsDelete(0);
        return signMapper.signIn(record);
    }



    @Override
    public List<String> getMonthSignList(Long userId, int signYear, int signMonth) {
        SignTb sign = getSignTbByTime(userId,signYear,signMonth);
        if(sign == null)return null;
        long signDays = sign.getSignDays();
        String daysString = Integer.toBinaryString((int)signDays);
        while(daysString.length()<31){
            daysString = "0"+daysString;
        }
       return Arrays.asList( daysString.substring(0,getMaxDayByYearMonth(signYear,signMonth)).split(""));
       }

    @Override
    public Boolean isTodaySigned(Long userId) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        long day = cal.get(Calendar.DATE);
        SignTb sign = getSignTbByTime(userId,year,month);
        if(sign == null)return false;
        long signDays = sign.getSignDays();
        return (signDays&(1<<31-day))>0;
    }

    @Override
    public Integer getYearSigned(int year,int month,Long userId) {
        return signMapper.selectYearSigned(userId,year,month);
    }

    @Override
    public Integer getTotalYearSigned(int year,int month,Long userId) {
        return signMapper.selectTotalYearSigned(userId,year,month);
    }

    /**
     * 获取指定月份最大天数
     * @param year
     * @param month
     * @return
     */
    private  int getMaxDayByYearMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        return calendar.getActualMaximum(Calendar.DATE);
    }

    @Override
    public SignTb getSignTbByTime(Long userId,int signYear,int signMonth){
        SignTbExample signTbExample = new SignTbExample();
        signTbExample.createCriteria().andUserIdEqualTo(userId).andSignYearEqualTo(signYear)
                .andSignMonthEqualTo(signMonth);
        List<SignTb> list = signMapper.selectByExample(signTbExample);
        if(CheckEmptyUtil.isEmpty(list)){
            return null;
        }
        return list.get(0);

    }

}
