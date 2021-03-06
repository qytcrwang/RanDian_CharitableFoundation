package com.fire.back.controller.web;

import com.fire.back.common.FireResult;
import com.fire.back.entity.UserTb;
import com.fire.back.service.SignInService;
import com.fire.back.service.UserService;
import com.fire.back.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static com.fire.back.util.ParamUtil.*;

@Controller
@RequestMapping("/back/user")
public class BackUserController extends BaseController{
    final
    UserService us;
    final
    SignInService ss;
    private Logger logger = LoggerFactory.getLogger(BackUserController.class);

    public BackUserController(UserService us, SignInService ss) {
        this.us = us;
        this.ss = ss;
    }


    @GetMapping("/")
    @RequiresPermissions("common:user:view")
    public String index(){
        return "user/user";
    }


    /**
     *
     * @param paramMap ->userId
     * @return data{UserTb}
     */
    @PostMapping("/info")
    @ResponseBody
    @RequiresPermissions("common:user:list")
    public FireResult getUserInfo(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = getLong(paramMap,"userId");
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
    @PostMapping("/update")
    @ResponseBody
    @RequiresPermissions("common:user:edit")
    public FireResult updateUserInfo(@RequestBody  Map<String, Object> paramMap){
        try {
            Long id = getLong(paramMap,"id");
            String idCardNumber = getString(paramMap,"idCardNumber",null);
            String mobile = getString(paramMap,"mobile",null);
            String name = getString(paramMap,"name",null);
            Integer type = getInteger(paramMap,"userType",null);
            Integer state = getInteger(paramMap,"state",null);

            UserTb u = new UserTb();
            u.setId(id);
            u.setIdCardNumber(idCardNumber);
            u.setMobile(mobile);
            u.setName(name);
            u.setType(type);
            u.setState(state);
            u.setComment("update by:"+ShiroUtils.getUserId());
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
    @ResponseBody
    @RequiresPermissions("common:sign:list")
    public FireResult getSignDaysList(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = getLong(paramMap,"userId");
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
     */
    @PostMapping("/getUserInfoByOpenid")
    @ResponseBody
    @RequiresPermissions("common:sign:list")
    public FireResult getUserInfoByOpenid(@RequestBody Map<String,Object> paramMap){

        try {
            String openid = getString(paramMap,"openid");
            UserTb user = us.getUserInfoByOpenId(openid);
            return FireResult.build(1,"用户信息获取成功",user);
        }catch(Exception e){
            logger.error("获取用户信息失败",e);
            return FireResult.build(0, "获取用户信息失败，请稍后再试");
        }
    }

    /**
     * 分页查询用户列表
     * @param user 可选则查询 name,idCardNumber,mobile,state,type,roleId,sex,address,
     *                  orgName,oldName,oldMobile,school,isDelete
     */
    @PostMapping("/list")
    @ResponseBody
    @RequiresPermissions("common:user:list")
    public FireResult getUsersList(@RequestBody UserTb user){
        try {
            user.setName(user.getName()==""?null:user.getName());
            user.setMobile(user.getMobile()==""?null:user.getMobile());
            user.setIsDelete(0);
            List<UserTb> list = us.selectUsersByPage(user);
            int count = us.selectUsersCount(user);
            return FireResult.build(1,"查询用户列表成功",list,count);
        } catch (Exception e) {
            logger.error("用户列表查询异常",e);
            e.printStackTrace();
            return FireResult.build(0,"查询用户列表失败");
        }
    }

    /**
     * 查询指定年份或者指定年份至今的签到总天数
     * queryType 为 1查询当年签到从天数，为2则查询当年至今签到总天数
     * @param paramMap userId year month queryType
     */
    @PostMapping("/getYearSignedSum")
    @ResponseBody
    @RequiresPermissions("common:sign:list")
    public FireResult getYearSignedSum(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = getLong(paramMap, "userId");
            if (userId == null) return FireResult.build(-1, "参数userId为空");
            Integer year = getInteger(paramMap,"year");
            Integer month = getInteger(paramMap,"month");
            Integer queryType = getInteger(paramMap,"queryType");
            Integer sum = 0;
            if(queryType==1){
                sum = ss.getYearSigned(year,month,userId);
            }
            if(queryType==2){
                sum = ss.getTotalYearSigned(year,month,userId);
            }
            return FireResult.build(1,"获取年签到天数成功",sum);
        } catch (Exception e) {
            logger.error("获取年签到天数异常",e);
            return FireResult.build(0,"获取年签到天数异常");
        }
    }
}
