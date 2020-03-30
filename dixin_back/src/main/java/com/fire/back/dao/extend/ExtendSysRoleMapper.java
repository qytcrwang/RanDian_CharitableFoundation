package com.fire.back.dao.extend;

import com.fire.back.dao.SysRoleMapper;
import com.fire.back.entity.SysMenu;
import com.fire.back.entity.SysRole;
import com.fire.back.entity.SysRoleMenuKey;
import com.fire.back.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtendSysRoleMapper extends SysRoleMapper {
    List<SysRole> selectSysRoleBySysUser(Long userId);

    List<SysUser> getUsersBySysRole(@Param("roleId") long roleId,
                                    @Param("loginName") String loginName,
                                    @Param("phonenumber") String phonenumber,
                                    @Param("status") int status,
                                    @Param("offset")int offset,
                                    @Param("limit")int limit);

    int getUsersCountBySysRole(@Param("roleId") long roleId,
                                    @Param("loginName") String loginName,
                                    @Param("phonenumber") String phonenumber,
                                    @Param("status") int status);
    int batchRoleMenu(List<SysRoleMenuKey> roleMenuList);

    /**
     * 通过角色ID删除角色和菜单关联
     *
     * @param roleId 角色ID
     * @return 结果
     */
    int deleteRoleMenuByRoleId(Long roleId);

    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<String> selectMenuTree(Long roleId);

    /**
     * 查询系统所有菜单（含按钮）
     *
     * @return 菜单列表
     */
    List<SysMenu> selectMenuAll();

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<SysMenu> selectMenuAllByUserId(Long userId);

    int insertRole(SysRole role);

    int insertUserRole(@Param("userId") Long userId,@Param("roleId")Long roleId);

    int deleteUserRole(@Param("userId") Long userId,@Param("roleId")Long roleId);
}
