package com.fire.back.dao;

import com.fire.back.entity.SysRoleMenuExample;
import com.fire.back.entity.SysRoleMenuKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMenuMapper {
    long countByExample(SysRoleMenuExample example);

    int deleteByPrimaryKey(SysRoleMenuKey key);

    int insert(SysRoleMenuKey record);

    int insertSelective(SysRoleMenuKey record);

    List<SysRoleMenuKey> selectByExample(SysRoleMenuExample example);
}