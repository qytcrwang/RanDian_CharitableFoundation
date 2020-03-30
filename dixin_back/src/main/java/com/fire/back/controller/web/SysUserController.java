package com.fire.back.controller.web;

import com.fire.back.common.FireResult;
import com.fire.back.dto.SysUserExtend;
import com.fire.back.entity.SysUser;
import com.fire.back.service.SysUserService;
import com.fire.back.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/back/sysUser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/")
    public String sysUserPage(){
        return "user/sysUser";
    }
    @PostMapping("/list")
    @ResponseBody
    public FireResult getSysUserList(@RequestBody SysUser user) {
        try {
            List<SysUser> list = sysUserService.getSysUsersByParams(user);
            int count  = sysUserService.getSysUserCountByParams(user);
            return FireResult.build(1,"查询用户列表成功",list,count);
        } catch (Exception e) {
            e.printStackTrace();
            return FireResult.build(0,"查询用户列表失败",null);

        }
    }
    @PostMapping("/update")
    @ResponseBody
    public FireResult updateSysUser(@RequestBody SysUser user){
        try {
            if(SysUserExtend.isAdmin(user.getUserId()))
                return FireResult.build(0,"不允许修改超级管理员信息");
            user.setUpdateTime(new Date());
            user.setLoginName(null);
            user.setPassword(null);
            sysUserService.updateSysUser(user);
            return FireResult.build(1,"修改管理员信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return FireResult.build(0,"修改管理员信息失败");
        }
    }
    @PostMapping("/reset")
    @ResponseBody
    public FireResult resetPassword(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = ParamUtil.getLong(paramMap,"userId",null);
            if(SysUserExtend.isAdmin(userId)){
                return FireResult.build(0,"不允许修改超级管理员信息");
            }
            String password = ParamUtil.getString(paramMap,"password",null);
            SysUser user = new SysUser();
            user.setUserId(userId);
            //TODO 加密
            user.setPassword(password);
            sysUserService.updateSysUser(user);
            return FireResult.build(1,"重置密码成功");
        } catch (Exception e) {
            e.printStackTrace();
            return FireResult.build(0,"重置密码失败");
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public FireResult addSysUser(@RequestBody SysUser user){
        try {
            Date date = new Date();
            user.setUpdateTime(date);
            user.setCreateTime(date);
            //TODO 密码加密
            if(sysUserService.getSysUserByLoginName(user.getLoginName())!=null){
                return FireResult.build(0,"该登录名已存在");
            }
            sysUserService.addSysUser(user);
            return FireResult.build(1,"添加管理员信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return FireResult.build(0,"添加管理员信息失败");
        }
    }

    @PostMapping("/del")
    @ResponseBody
    public FireResult delSysUser(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = ParamUtil.getLong(paramMap,"userId",null);
            if(SysUserExtend.isAdmin(userId))
                return FireResult.build(0,"不允许删除超级管理员");
            SysUser user = new SysUser();
            user.setUserId(userId);
            user.setDelFlag("2");
            sysUserService.updateSysUser(user);
            return FireResult.build(1,"删除管理员信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return FireResult.build(0,"删除管理员信息失败");
        }
    }

    @PostMapping("/getUserInfo")
    @ResponseBody
    public FireResult getUserInfo(@RequestBody Map<String,Object> paramMap){
        try {
            Long userId = ParamUtil.getLong(paramMap,"userId",null);
            SysUser user = sysUserService.getSysUserInfoById(userId);
            return FireResult.build(1,"获取管理员信息成功",user);
        } catch (Exception e) {
            e.printStackTrace();
            return FireResult.build(0,"获取管理员信息失败");
        }

    }

}
