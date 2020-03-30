package com.fire.back.dao;

import com.fire.back.entity.SysUserRoleExample;
import com.fire.back.entity.SysUserRoleKey;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysUserRoleMapper {
    long countByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);

    List<SysUserRoleKey> selectByExample(SysUserRoleExample example);
}