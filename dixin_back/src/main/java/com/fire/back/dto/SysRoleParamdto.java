package com.fire.back.dto;

import com.fire.back.entity.SysRole;

public class SysRoleParamdto extends SysRole {

    private long[] menuIds;

    public long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(long[] menuIds) {
        this.menuIds = menuIds;
    }
    public boolean isAdmin(){
        return isAdmin(getRoleId());
    }
    public static boolean isAdmin(Long roleId)
    {
        return roleId != null && 1L == roleId;
    }

}
