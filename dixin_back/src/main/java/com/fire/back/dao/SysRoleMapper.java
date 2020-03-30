package com.fire.back.dao;

import com.fire.back.entity.SysRole;
import com.fire.back.entity.SysRoleExample;
import java.util.List;

public interface SysRoleMapper {
    long countByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}