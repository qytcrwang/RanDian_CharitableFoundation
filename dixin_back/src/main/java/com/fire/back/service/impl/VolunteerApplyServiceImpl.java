package com.fire.back.service.impl;

import com.fire.back.dao.VolunteerApplyTbMapper;
import com.fire.back.entity.VolunteerApplyTb;
import com.fire.back.service.VolunteerApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private void paramUtils(VolunteerApplyTb volunteerApplyTb){
        volunteerApplyTb.setCreateTime(System.currentTimeMillis()/1000);
        volunteerApplyTb.setIsDelete(0);
        volunteerApplyTb.setStatus(0);
    }
}
