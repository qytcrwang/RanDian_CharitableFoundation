package com.fire.back.dto;

import com.fire.back.entity.SysMenu;
import com.fire.back.entity.SysRole;

import java.util.List;

public class SysRoleParamdto extends SysRole {

    private long[] menuIds;

    private List<SysMenu> sysMenuList;

    public long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(long[] menuIds) {
        this.menuIds = menuIds;
    }

    public List<SysMenu> getSysMenuList() {
        return sysMenuList;
    }

    public void setSysMenuList(List<SysMenu> sysMenuList) {
        this.sysMenuList = sysMenuList;
    }

    public boolean isAdmin(){
        return isAdmin(getRoleId());
    }

    public static boolean isAdmin(Long roleId)
    {
        return roleId != null && 1L == roleId;
    }

}
