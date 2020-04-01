package com.fire.back.service;

import com.fire.back.common.LayTree;
import com.fire.back.dto.SysRoleParamdto;
import com.fire.back.entity.SysMenu;
import com.fire.back.entity.SysRole;
import com.fire.back.entity.SysUser;

import java.util.List;

public interface SysRoleService {

    boolean addSysRole(SysRoleParamdto role);

    boolean updateSysRoleMenu(SysRoleParamdto role);

    boolean updateSysRole(SysRole role);

    boolean deleteSysRole(Long roleId);

    boolean checkRoleByRoleKey(String roleKey,Long roleId);

    boolean checkRoleByRoleName(String roleName,Long roleId);

    boolean checkRoleUserByRoleId(Long roleId);

    SysRole getSysRoleById(Long roleId);

    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色对象
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<LayTree> roleMenuTreeData(Long roleId, Long userId);

    List<SysMenu> selectMenuAll(Long userId);

    List<SysRole> getRoleListByParams(SysRole role);

    int getRoleCountByParams(SysRole role);

    List<SysRole> getRolesBySysUserId(Long userId);

    List<SysUser>  getUsersBySysRole(Long roleId,String loginName,String phonenumber,int status,int page,int limit);

    int  getUsersCountBySysRole(Long roleId,String loginName,String phonenumber,int status);


    int insertUserRole(Long userId,Long roleId);

    int deleteUserRole(Long userId,Long roleId);


}
