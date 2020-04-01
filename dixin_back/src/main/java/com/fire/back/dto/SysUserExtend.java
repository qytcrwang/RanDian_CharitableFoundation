package com.fire.back.dto;

import com.fire.back.entity.SysUser;
import java.util.List;


public class SysUserExtend extends SysUser {

    private String[] roles;

    private List<SysRoleParamdto> sysRoleList;

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public List<SysRoleParamdto> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRoleParamdto> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    public boolean isAdmin(){
        return isAdmin(getUserId());
    }
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }
}
