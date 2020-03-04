package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.SignTb;
import com.fire.back.entity.UserTb;
import com.fire.back.service.SignInService;
import com.fire.back.service.UserService;
import com.fire.back.util.ParamUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @Title: UserController.java
 * @Description: 小程序用户信息
 * @author CloudDragon
 * @date 2020-02-23 10:35:14
 */
@RestController
@RequestMapping("/wx/user")
public class UserController {

    @Autowired
    UserService us;
    @Autowired
    SignInService ss;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     *
     * @param paramMap ->userId
     * @return data{UserTb}
     */
    @PostMapping("/getUserInfo")
    public FireResult getUserInfo(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = ParamUtil.getLong(paramMap,"userId");
            UserTb user =us.getUserInfobByPrimaryKey(userId);
            return FireResult.build(1,"用户信息获取成功",user);
        }catch(Exception e){
            logger.error("获取用户信息失败",e);
            return FireResult.build(0, "获取用户信息失败，请稍后再试");
        }
    }
    /**
     * 更新用户信息
     * @param  paramMap ->idCardNumber,mobile，name
     * @return data{null}
     */
    @PostMapping("/updateUserInfo")
    public FireResult updateUserInfo(@RequestBody  Map<String, Object> paramMap){
        try {
            Long id = ParamUtil.getLong(paramMap,"userId");
            String idCardNumber = ParamUtil.getString(paramMap,"idCardNumber",null);
            String mobile = ParamUtil.getString(paramMap,"mobile",null);
            String name = ParamUtil.getString(paramMap,"name",null);
            Integer type = ParamUtil.getInteger(paramMap,"userType",null);
            UserTb u = new UserTb();
            u.setId(id);
            u.setIdCardNumber(idCardNumber);
            u.setMobile(mobile);
            u.setName(name);
            u.setType(type);
            int result = us.UpdateUserInfo(u);
            return result>0?FireResult.build(1,"用户信息更新成功"):FireResult.build(0,"用户信息更新失败");
        }catch(Exception e){
            logger.error("用户信息更新失败",e);
           return FireResult.build(0,"用户信息更新异常，请稍后再试");
        }
    }

    /**
     * 用户签到操作
     * @param paramMap ->userId
     * @return data{null}
     */
    @PostMapping("/userSingIn")
    public FireResult signIn(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = ParamUtil.getLong(paramMap,"userId");

            //=====此处判断如果是学生，有无学生认证

            SignTb s = new SignTb();
            //s.setUserId(u.getId());
            //s.setType(u.getType());//用户类型
            //以下为测试信息
            s.setUserId(userId);
            s.setType(3);
            //以上为测试信息

           int result = ss.signIn(s);
            return result>0?FireResult.build(1,"签到成功"):FireResult.build(0,"请勿重复签到");

        }catch(Exception e){
            logger.error("签到异常",e);
            return FireResult.build(0,"签到出现异常，请稍后再试");
        }
    }

    /**
     * 获取用户当月签到信息列表
     * @param paramMap ->userId
     * @return data{List<String>}
     */
    @PostMapping("/getSignDaysList")
    public FireResult getSignDaysList(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = ParamUtil.getLong(paramMap,"userId");
            Calendar cal = Calendar.getInstance();
            int signYear = cal.get(Calendar.YEAR);
            int signMonth = cal.get(Calendar.MONTH) + 1;
            List<String> list = ss.getMonthSignList(userId, signYear, signMonth);
            return FireResult.build(1, "签到信息查询成功", list);
        }catch(Exception e){
            logger.error("获取月签到信息异常",e);
            return FireResult.build(0, "签到信息查询异常", null);
        }

    }

    /**
     * 至今为止连续签到天数
     * @param paramMap ->userId
     * @return data{Integer}
     */
    @PostMapping("/getConsecutiveSign")
    public FireResult getConsecutiveSign(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = ParamUtil.getLong(paramMap,"userId");
            int daysCount = ss.getConsecutiveSign(userId);
            return FireResult.build(1, "连续签到天数查询成功", daysCount);
        }catch(Exception e){
            return FireResult.build(0, "签连续签到天数查询失败", null);
        }
    }

    /**
     * 查看当日是否已签到
     * @param paramMap userId
     * @return 返回 data true为已签到，返回false为未签到
     */
    @PostMapping("/isTodaySigned")
    public FireResult isTodaySigned(@RequestBody Map<String,Object> paramMap) {

        try {
            Long userId = ParamUtil.getLong(paramMap, "userId");
            if (userId == null) return FireResult.build(0, "用户id为为空");
            Boolean result = ss.isTodaySigned(userId);
            return result ? FireResult.build(1, "已签到",true) : FireResult.build(1, "未签到",false);
        } catch (Exception e) {
            logger.error("查询当日是否签到异常", e);
            return FireResult.build(0, "查询当日是否签到异常");
        }
    }
}
