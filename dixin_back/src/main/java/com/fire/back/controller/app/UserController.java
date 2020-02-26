package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.SignTb;
import com.fire.back.entity.UserTb;
import com.fire.back.service.SignInService;
import com.fire.back.service.UserService;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
public class UserController {

    @Autowired
    UserService us;
    @Autowired
    SignInService ss;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     *
     * @param  session
     * @return data{UserTb}
     */
    @GetMapping("/getUserInfo")
    public FireResult getUserInfo(HttpSession session){
        try {
            UserTb u  = (UserTb)session.getAttribute("user");
            if(u==null||u.getId()==null)
                return FireResult.build(-1, "用户信息缺失，请重新登录");
            UserTb user =us.getUserInfobByPrimaryKey(u.getId());
            return FireResult.build(1,"用户信息获取成功",user);
        }catch(Exception e){
            logger.error("获取用户信息失败",e);
            return FireResult.build(0, "获取用户信息失败，请稍后再试");
        }
    }
    /**
     * 更新用户信息
     * @param  paramMap,idCardNumber,mobile，name
     * @return data{null}
     */
    @PostMapping("/updateUserInfo")
    public FireResult updateUserInfo(HttpSession session,@RequestBody  Map<String, Object> paramMap){
        try {
            //后期将改为session拿取id
            Long id = ParamUtil.getLong(paramMap,"id");
            String idCardNumber = ParamUtil.getString(paramMap,"idCardNumber",null);
            String mobile = ParamUtil.getString(paramMap,"mobile",null);
            String name = ParamUtil.getString(paramMap,"name",null);
            UserTb u = new UserTb();
            u.setId(id);
            u.setIdCardNumber(idCardNumber);
            u.setMobile(mobile);
            u.setName(name);
            int result = us.UpdateUserInfo(u);
            UserTb user =us.getUserInfobByPrimaryKey(u.getId());
            session.setAttribute("user",user);
            return result>0?FireResult.build(1,"用户信息更新成功"):FireResult.build(0,"用户信息更新失败");
        }catch(Exception e){
            logger.error("用户信息更新失败",e);
           return FireResult.build(0,"用户信息更新异常，请稍后再试");
        }
    }

    /**
     * 用户签到操作
     * @param session
     * @return data{null}
     */
    @GetMapping("/userSingIn")
    public FireResult signIn(HttpSession session){
        try {
            UserTb u = (UserTb) session.getAttribute("user");
           // if (u == null || u.getId() == null)
             //   return FireResult.build(-1, "用户信息缺失，请重新登录");
            //=====此处判断如果是学生，有无学生认证

            SignTb s = new SignTb();
            //s.setUserId(u.getId());
            //s.setType(u.getType());//用户类型
            //以下为测试信息
            s.setUserId(1l);
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
     * @param session
     * @return data{List<String>}
     */
    @GetMapping("/getSignDaysList")
    public FireResult getSignDaysList(HttpSession session){
        try {
            UserTb u = (UserTb) session.getAttribute("user");
            if (u == null || u.getId() == null)
                return FireResult.build(-1, "用户信息缺失，请重新登录");
            Calendar cal = Calendar.getInstance();
            Long userId = u.getId();
            int signYear = cal.get(Calendar.YEAR);
            int signMonth = cal.get(Calendar.MONTH) + 1;
            List<String> list = ss.getMonthSignList(userId, signYear, signMonth);
            return FireResult.build(1, "签到信息查询成功", list);
        }catch(Exception e){
            return FireResult.build(0, "签到信息查询失败", null);
        }

    }

    /**
     * 连续签到天数
     * @param session
     * @return data{Integer}
     */
    @GetMapping("/getConsecutiveSign")
    public FireResult getConsecutiveSign(HttpSession session){
        try {
            UserTb u = (UserTb) session.getAttribute("user");
            if (u == null || u.getId() == null)
                return FireResult.build(-1, "用户信息缺失，请重新登录");
            int daysCount = ss.getConsecutiveSign(u.getId());
            return FireResult.build(1, "连续签到天数查询成功", daysCount);
        }catch(Exception e){
            return FireResult.build(0, "签连续签到天数查询失败", null);
        }

    }

    @PostMapping("/getUserInfoByOpenid")
    public FireResult getUserInfoByOpenid(@RequestBody Map<String,Object> paramMap){

        try {
            String openid = ParamUtil.getString(paramMap,"openid");
            UserTb user = us.getUserInfoByOpenId(openid);
            return FireResult.build(1,"用户信息获取成功",user);
        }catch(Exception e){
            logger.error("获取用户信息失败",e);
            return FireResult.build(0, "获取用户信息失败，请稍后再试");
        }

    }
}
