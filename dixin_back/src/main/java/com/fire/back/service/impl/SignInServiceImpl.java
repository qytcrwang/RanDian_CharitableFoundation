package com.fire.back.service.impl;

import com.fire.back.dao.extend.ExtendSignTbMapper;
import com.fire.back.entity.SignTb;
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
        record.setSignYear(year);
        record.setSignMonth(month);
        record.setSignDays(day);
        record.setSignNums(1);
        record.setCreateTime(System.currentTimeMillis());
        record.setUpdateTime(System.currentTimeMillis());
        record.setIsDelete(0);
        return signMapper.signIn(record);
    }

    @Override
    public int getConsecutiveSign(Long userId) {

        Calendar c =Calendar.getInstance();
        int signYear = c.get(Calendar.YEAR);
        int signMonth = c.get(Calendar.MONTH)+1;
        int d = c.get(Calendar.DATE);
        SignTb sign = signMapper.selectByParams(userId,signYear,signMonth);
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
        SignTb sign = signMapper.selectByParams(userId,signYear,signMonth);
        long signDays = sign.getSignDays();
        String daysString = Integer.toBinaryString((int)signDays);
        while(daysString.length()<31){
            daysString = "0"+daysString;
        }
       return Arrays.asList(daysString.split(""));
       }
}
