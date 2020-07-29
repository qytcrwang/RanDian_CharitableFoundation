package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.VolunteerApplyTb;
import com.fire.back.service.VolunteerApplyService;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/wx/volunteer")
public class VolunteerApplyController {

    @Autowired
    VolunteerApplyService vs;

    private Logger logger = LoggerFactory.getLogger(VolunteerApplyController.class);

    @RequestMapping("/apply")
    public FireResult apply(@RequestBody Map<String,Object> param){
        try {
            Long userId = ParamUtil.getLong(param,"userId");
            String name = ParamUtil.getString(param,"name");
            String mobile = ParamUtil.getString(param,"mobile");
            String gender = ParamUtil.getString(param,"gender");
            String address = ParamUtil.getString(param,"address");

            VolunteerApplyTb volunteerApplyTb = new VolunteerApplyTb();
            volunteerApplyTb.setUserId(userId);
            volunteerApplyTb.setMobile(mobile);
            volunteerApplyTb.setName(name);
            volunteerApplyTb.setAddress(address);
            if("男".equals(gender)){
                volunteerApplyTb.setGender(1);
            }else{
                volunteerApplyTb.setGender(0);
            }
            vs.saveVolunteerApply(volunteerApplyTb);
            return FireResult.build(1,"申请成功",null);
        }catch (Exception e){
            logger.info("义工申请失败",e);
            return FireResult.build(0,"申请失败",null);
        }
    }
}
