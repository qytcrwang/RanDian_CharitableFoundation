package com.fire.back.service.impl;

import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.dao.SysUserMapper;
import com.fire.back.dao.extend.ExtendSysUserMapper;
import com.fire.back.dto.SysUserExtend;
import com.fire.back.entity.SysUser;
import com.fire.back.entity.SysUserExample;
import com.fire.back.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    ExtendSysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getSysUsersByParams(SysUser user) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria =  example.createCriteria();
        if(CheckEmptyUtil.isNotEmpty(user.getLoginName()))
            criteria.andLoginNameLike("%"+user.getLoginName()+"%");
        if(CheckEmptyUtil.isNotEmpty(user.getPhonenumber()))
            criteria.andPhonenumberLike("%"+user.getPhonenumber()+"%");
        if(user.getStartTime()!=null&&user.getEndTime()!=null)
            criteria.andCreateTimeBetween(user.getStartTime(),user.getEndTime());
        if(CheckEmptyUtil.isNotEmpty(user.getStatus()))
            criteria.andStatusEqualTo(user.getStatus());
        criteria.andDelFlagEqualTo("0");
        int start = (user.getPage()-1)*user.getLimit();
        example.setOrderByClause("create_time asc limit "+start+","+user.getLimit());
        return sysUserMapper.selectByExample(example);
    }

    @Override
    public int getSysUserCountByParams(SysUser user) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria =  example.createCriteria();
        if(CheckEmptyUtil.isNotEmpty(user.getLoginName()))
            criteria.andLoginNameLike("%"+user.getLoginName()+"%");
        if(CheckEmptyUtil.isNotEmpty(user.getPhonenumber()))
            criteria.andPhonenumberLike("%"+user.getPhonenumber()+"%");
        if(user.getStartTime()!=null&&user.getEndTime()!=null)
            criteria.andCreateTimeBetween(user.getStartTime(),user.getEndTime());
        if(CheckEmptyUtil.isNotEmpty(user.getStatus()))
            criteria.andStatusEqualTo(user.getStatus());
        return (int)sysUserMapper.countByExample(example);
    }


    @Override
    public boolean addSysUser(SysUser user) {
        return sysUserMapper.insertSelective(user)>0;
    }

    @Override
    public boolean updateSysUser(SysUser user) {
        return sysUserMapper.updateByPrimaryKeySelective(user)>0;
    }

    @Override
    public boolean deleteSysUserById(Long userId) {
        return sysUserMapper.deleteByPrimaryKey(userId)>0;
    }

    @Override
    public SysUser getSysUserInfoById(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public SysUser getSysUserByLoginName(String loginName) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andLoginNameLike(loginName);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public SysUserExtend getSysUserMenusByLoginName(String loginName) {
        return sysUserMapper.getSysUserListByName(loginName);
    }
}
