package com.fire.back.service.impl;

import com.fire.back.dao.VolunteerApplyTbMapper;
import com.fire.back.entity.VolunteerApplyTb;
import com.fire.back.entity.VolunteerApplyTbExample;
import com.fire.back.service.VolunteerApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerApplyServiceImpl implements VolunteerApplyService {

    @Autowired
    private VolunteerApplyTbMapper vt;

    @Override
    public boolean saveVolunteerApply(VolunteerApplyTb volunteerApplyTb) {
        paramUtils(volunteerApplyTb);
        vt.insertSelective(volunteerApplyTb);
        return false;
    }

    @Override
    public VolunteerApplyTb getVolunteerInfoByUserId(Long userId) {
        VolunteerApplyTbExample volunteerApplyTbExample = new VolunteerApplyTbExample();
        volunteerApplyTbExample.createCriteria().andUserIdEqualTo(userId);
        List<VolunteerApplyTb> result = vt.selectByExample(volunteerApplyTbExample);
        if(result != null && result.size() > 0){
            return result.get(0);
        }
        return null;
    }

    private void paramUtils(VolunteerApplyTb volunteerApplyTb){
        volunteerApplyTb.setCreateTime(System.currentTimeMillis()/1000);
        volunteerApplyTb.setIsDelete(0);
        volunteerApplyTb.setStatus(0);
    }
}
