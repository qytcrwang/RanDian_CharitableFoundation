package com.fire.back.controller.web;

import com.fire.back.common.FireResult;
import com.fire.back.controller.app.UserController;
import com.fire.back.entity.UserTb;
import com.fire.back.service.SignInService;
import com.fire.back.service.UserService;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/back/user")
public class BackUserController {
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
            return result>0?FireResult.build(1,"用户信息更新成功"):FireResult.build(0,"用户信息更新失败");
        }catch(Exception e){
            logger.error("用户信息更新失败",e);
            return FireResult.build(0,"用户信息更新异常，请稍后再试");
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
            return FireResult.build(1, "back签到信息查询成功", list);
        }catch(Exception e){
            return FireResult.build(0, "back签到信息查询失败", null);
        }

    }
    /**
     * 通过微信openid获取用户信息
     * @param paramMap
     * @return
     */
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

    /**
     * 分页查询用户列表
     * @param paramMap 可选则查询 name,idCardNumber,mobile,state,type,roleId,sex,address,
     *                  orgName,oldName,oldMobile,school,isDelete
     */
    @PostMapping("/getUsersByPage")
    public FireResult getsersByPage(@RequestBody Map<String,Object> paramMap){
        try {
            UserTb user  = new UserTb();
            Object field = ParamUtil.getString(paramMap,"field","love_point");
            Integer page = ParamUtil.getInteger(paramMap,"page",1);
            Integer pageSize = ParamUtil.getInteger(paramMap,"pageSize",20);
            String sort = ParamUtil.getString(paramMap,"sort","desc");
            createUserTbParam(paramMap,user);
            List<UserTb> list = us.selectUsersByPage(user,field,sort==null?"desc":sort,page,pageSize);
            return FireResult.build(1,"查询用户列表成功",list);
        } catch (Exception e) {
            logger.error("用户列表查询异常",e);
            e.printStackTrace();
            return FireResult.build(0,"查询用户列表失败",null);
        }
    }
    private  void createUserTbParam(Map<String,Object> paramMap,UserTb user){
        user.setName(ParamUtil.getString(paramMap,"name",null));
        user.setIdCardNumber(ParamUtil.getString(paramMap,"idCardNumber",null));
        user.setMobile(ParamUtil.getString(paramMap,"mobile",null));
        user.setState(ParamUtil.getInteger(paramMap,"state",null));
        user.setType(ParamUtil.getInteger(paramMap,"type",null));
        user.setRoleId(ParamUtil.getLong(paramMap,"roleId",null));
        user.setSex(ParamUtil.getInteger(paramMap,"sex",null));
        user.setAddress(ParamUtil.getString(paramMap,"address",null));
        user.setOrgName(ParamUtil.getString(paramMap,"orgName",null));
        user.setOldName(ParamUtil.getString(paramMap,"oldName",null));
        user.setOldMobile(ParamUtil.getString(paramMap,"oldMobile",null));
        user.setSchool(ParamUtil.getString(paramMap,"school",null));
        user.setIsDelete(ParamUtil.getInteger(paramMap,"isDelete",null));
    }
}