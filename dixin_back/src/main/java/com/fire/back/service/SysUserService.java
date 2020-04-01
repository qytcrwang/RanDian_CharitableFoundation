package com.fire.back.service;

import com.fire.back.dto.SysUserExtend;
import com.fire.back.entity.SysUser;
import java.util.List;

public interface SysUserService {

    List<SysUser> getSysUsersByParams(SysUser user);

    int getSysUserCountByParams(SysUser user);

    boolean addSysUser(SysUser user);

    boolean updateSysUser(SysUser user);

    boolean deleteSysUserById(Long userId);

    SysUser getSysUserInfoById(Long userId);

    SysUser getSysUserByLoginName(String loginName);

    SysUserExtend getSysUserMenusByLoginName(String loginName);
}
