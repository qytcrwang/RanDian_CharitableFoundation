package com.fire.back.dto;

import com.fire.back.entity.SysUser;


public class SysUserExtend extends SysUser {

    private String[] roles;

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public boolean isAdmin(){
        return isAdmin(getUserId());
    }
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }
}
