package com.fire.back.dao;

import com.fire.back.entity.SysMenu;
import com.fire.back.entity.SysMenuExample;
import java.util.List;

public interface SysMenuMapper {
    long countByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}