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

        SignTbExample signTbExample = new SignTbExample();
        signTbExample.createCriteria().andUserIdEqualTo(record.getUserId()).andSignYearEqualTo(year)
                .andSignMonthEqualTo(month);
        List<SignTb> list = signMapper.selectByExample(signTbExample);
        if(CheckEmptyUtil.isNotEmpty(list)){
            SignTb sign = list.get(0);
            if(sign!=null){
                long signDays = sign.getSignDays();
                if((signDays&(1<<31-day))>0){
                    return -1;
                }
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
    public int getConsecutiveSign(Long userId) {

        Calendar c =Calendar.getInstance();
        int signYear = c.get(Calendar.YEAR);
        int signMonth = c.get(Calendar.MONTH)+1;
        int d = c.get(Calendar.DATE);

        SignTbExample signTbExample = new SignTbExample();
        signTbExample.createCriteria().andUserIdEqualTo(userId).andSignYearEqualTo(signYear)
                .andSignMonthEqualTo(signMonth);
        List<SignTb> list = signMapper.selectByExample(signTbExample);
        if(CheckEmptyUtil.isEmpty(list)){
            return 0;
        }
        SignTb sign = list.get(0);
        //SignTb sign = signMapper.selectByParams(userId,signYear,signMonth);
        long signDays = sign.getSignDays();
        int count = 0;
        for(int i = d;i>0;i--){
            if((signDays&(1<<31-i))>0){
                count++;
                continue;
            }
            if(i==d)continue;
            break;
        }
        return count;
    }

    @Override
    public List<String> getMonthSignList(Long userId, int signYear, int signMonth) {
        SignTbExample signTbExample = new SignTbExample();
        signTbExample.createCriteria().andUserIdEqualTo(userId).andSignYearEqualTo(signYear)
                .andSignMonthEqualTo(signMonth);
        List<SignTb> list = signMapper.selectByExample(signTbExample);
        if(CheckEmptyUtil.isEmpty(list)){
            return null;
        }
        SignTb sign = list.get(0);
        long signDays = sign.getSignDays();
        String daysString = Integer.toBinaryString((int)signDays);
        while(daysString.length()<31){
            daysString = "0"+daysString;
        }
       return Arrays.asList(daysString.split(""));
       }

    @Override
    public Boolean isTodaySigned(Long userId) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        long day = cal.get(Calendar.DATE);
        SignTbExample signTbExample = new SignTbExample();
        signTbExample.createCriteria().andUserIdEqualTo(userId).andSignYearEqualTo(year)
                .andSignMonthEqualTo(month);
        List<SignTb> list = signMapper.selectByExample(signTbExample);
        if(CheckEmptyUtil.isEmpty(list)) return false;
        SignTb sign = list.get(0);
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

}
