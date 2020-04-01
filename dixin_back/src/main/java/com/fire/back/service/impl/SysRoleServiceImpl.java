package com.fire.back.service.impl;

import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.common.LayTree;
import com.fire.back.dao.SysUserRoleMapper;
import com.fire.back.dao.extend.ExtendSysRoleMapper;
import com.fire.back.dto.SysRoleParamdto;
import com.fire.back.dto.SysUserExtend;
import com.fire.back.entity.*;
import com.fire.back.service.SysRoleService;
import com.fire.back.util.ShiroUtils;
import com.fire.back.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private ExtendSysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    @Transactional
    public boolean addSysRole(SysRoleParamdto role) {
        sysRoleMapper.insertRole(role);
        return insertRoleMenu(role)>0;
    }

    /**
     * 新增角色菜单信息
     *
     * @param role 角色对象
     */
    public int insertRoleMenu(SysRoleParamdto role)
    {
        int rows = 1;
        // 新增用户与角色管理
        List<SysRoleMenuKey> list = new ArrayList<SysRoleMenuKey>();
        if(role.getMenuIds()==null){
            return 0;
        }
        for (Long menuId : role.getMenuIds())
        {
            SysRoleMenuKey rm = new SysRoleMenuKey();
            rm.setRoleId(role.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0)
            rows = sysRoleMapper.batchRoleMenu(list);
        return rows;
    }

    @Override
    @Transactional
    public boolean updateSysRoleMenu(SysRoleParamdto role) {
        sysRoleMapper.updateByPrimaryKeySelective(role);
        sysRoleMapper.deleteRoleMenuByRoleId(role.getRoleId());
        return insertRoleMenu(role)>0;
    }

    @Override
    public boolean updateSysRole(SysRole role) {
        return sysRoleMapper.updateByPrimaryKeySelective(role)>0;
    }

    @Override
    public boolean deleteSysRole(Long roleId) {
        SysRole role = sysRoleMapper.selectByPrimaryKey(roleId);
        role.setDelFlag("1");
        role.setUpdateBy(ShiroUtils.getUserId()+":"+ShiroUtils.getLoginName());
        return sysRoleMapper.updateByPrimaryKeySelective(role)>0;
    }

    @Override
    public boolean checkRoleByRoleKey(String roleKey,Long roleId) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleKeyEqualTo(roleKey).andDelFlagEqualTo("0");
        if(roleId!=null)
            criteria.andRoleIdNotEqualTo(roleId);
        List<SysRole> list = sysRoleMapper.selectByExample(example);
        return list.size()>0;
    }

    @Override
    public boolean checkRoleUserByRoleId(Long roleId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<SysUserRoleKey> list = sysUserRoleMapper.selectByExample(example);
        return list.size()>0;
    }

    @Override
    public boolean checkRoleByRoleName(String roleName,Long roleId) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo(roleName).andDelFlagEqualTo("0");
        if(roleId!=null)
            criteria.andRoleIdNotEqualTo(roleId);
        List<SysRole> list = sysRoleMapper.selectByExample(example);
        return list.size()>0;
    }

    @Override
    public SysRole getSysRoleById(Long roleId) {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<LayTree> roleMenuTreeData(Long roleId, Long userId) {

        List<LayTree> trees = new ArrayList<>();
        List<SysMenu> menuList = selectMenuAll(userId);
        if (StringUtils.isNotNull(roleId))
        {
            List<String> roleMenuList = sysRoleMapper.selectMenuTree(roleId);
            trees = initLayTree(menuList, roleMenuList, 0l);
        }
        else
        {
            trees = initLayTree(menuList, null, 0l);
        }
        return trees;
    }
    /**
     * 查询菜单集合
     *
     * @return 所有菜单信息
     */
    @Override
    public List<SysMenu> selectMenuAll(Long userId)
    {
        List<SysMenu> menuList = null;
        if (SysUserExtend.isAdmin(userId))
        {
            menuList = sysRoleMapper.selectMenuAll();
        }
        else
        {
            menuList = sysRoleMapper.selectMenuAllByUserId(userId);
        }
        return menuList;
    }

    /**
     * 对象转菜单树
     *
     * @param menuList 菜单列表
     * @param roleMenuList 角色已存在菜单列表
     * @param menuId 第一层节点父id
     * @return 树结构列表
     */
    List<LayTree> initLayTree(List<SysMenu> menuList,List<String> roleMenuList,Long menuId){
        List<LayTree> childrenList = new ArrayList<>();
        boolean isCheck = StringUtils.isNotNull(roleMenuList);
        for(int i = 0;i<menuList.size();){
            SysMenu menu = menuList.get(i);
            if(menu.getParentId()==menuId){
                LayTree children = new LayTree(menu);
                menuList.remove(i);
                if(hasChildren(menuList,children.getId())){
                    children.setChildren(initLayTree(menuList,roleMenuList,children.getId()));
                }else{
                    if (isCheck)
                    {
                        children.setChecked(roleMenuList.contains(menu.getMenuId() + menu.getPerms()));
                    }
                }
                childrenList.add(children);
            }else{
                i++;
            }
        }
        return childrenList;
    }
    boolean hasChildren(List<SysMenu> menuList,Long menuId){
        for(SysMenu m:menuList){
            if(m.getParentId()==menuId)
                return true;
        }
        return false;
    }



    public String transMenuName(SysMenu menu, boolean permsFlag)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getMenuName());
        if (permsFlag)
        {
            sb.append("<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + menu.getPerms() + "</font>");
        }
        return sb.toString();
    }


    @Override
    public List<SysRole> getRoleListByParams(SysRole role) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo("0");
        if(CheckEmptyUtil.isNotEmpty(role.getRoleName()))
            criteria.andRoleNameLike("%"+role.getRoleName()+"%");
        if(CheckEmptyUtil.isNotEmpty(role.getRoleKey()))
            criteria.andRoleKeyLike("%"+role.getRoleKey()+"%");
        if(CheckEmptyUtil.isNotEmpty(role.getStatus()))
            criteria.andStatusEqualTo(role.getStatus());
        if(CheckEmptyUtil.isNotEmpty(role.getStartTime())&&CheckEmptyUtil.isNotEmpty(role.getEndTime()))
            criteria.andCreateTimeBetween(role.getStartTime(),role.getEndTime());
        example.setOrderByClause("create_time asc limit "+role.getOffSet()+","+role.getLimit());
        return sysRoleMapper.selectByExample(example);
    }

    @Override
    public int getRoleCountByParams(SysRole role) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo("0");
        if(CheckEmptyUtil.isNotEmpty(role.getRoleName()))
            criteria.andRoleNameLike("%"+role.getRoleName()+"%");
        if(CheckEmptyUtil.isNotEmpty(role.getRoleKey()))
            criteria.andRoleKeyLike("%"+role.getRoleKey()+"%");
        if(CheckEmptyUtil.isNotEmpty(role.getStatus()))
            criteria.andStatusEqualTo(role.getStatus());
        if(CheckEmptyUtil.isNotEmpty(role.getStartTime())&&CheckEmptyUtil.isNotEmpty(role.getEndTime()))
            criteria.andCreateTimeBetween(role.getStartTime(),role.getEndTime());
        return (int)sysRoleMapper.countByExample(example);
    }

    @Override
    public List<SysRole> getRolesBySysUserId(Long userId) {
        return sysRoleMapper.selectSysRoleBySysUser(userId);
    }

    @Override
    public List<SysUser> getUsersBySysRole(Long roleId,String loginName,String phonenumber,int status,int page,int limit) {
        return sysRoleMapper.getUsersBySysRole(roleId,loginName,phonenumber,status,(page-1)*limit,limit);
    }

    @Override
    public int getUsersCountBySysRole(Long roleId,String loginName,String phonenumber,int status) {
        return sysRoleMapper.getUsersCountBySysRole(roleId,loginName,phonenumber,status);
    }

    @Override
    public int insertUserRole(Long userId,Long roleId){
        return sysRoleMapper.insertUserRole(userId,roleId);
    }

    @Override
    public int deleteUserRole(Long userId,Long roleId){
        return sysRoleMapper.deleteUserRole(userId,roleId);
    }

}
