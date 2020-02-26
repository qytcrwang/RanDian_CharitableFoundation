package com.fire.back.service.impl;

import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.dao.UserTbMapper;
import com.fire.back.entity.UserTb;
import com.fire.back.entity.UserTbExample;
import com.fire.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserTbMapper um;

    @Override
    public UserTb getUserInfobByPrimaryKey(Long id) {
        return um.selectByPrimaryKey(id);
    }

    @Override
    public int UpdateUserInfo(UserTb u) {
        u.setUpdateTime(System.currentTimeMillis()/1000);
        return um.updateByPrimaryKeySelective(u);
    }

    @Override
    public int insertUser(UserTb u) {
        return um.insertSelective(UserDefaultParamUtil(u));
    }

    @Override
    public UserTb getUserInfoByOpenId(String openid) {
        UserTbExample userTbExample = new UserTbExample();
        userTbExample.createCriteria().andOpenIdEqualTo(openid);
        List<UserTb> list = um.selectByExample(userTbExample);
        if(CheckEmptyUtil.isEmpty(list))return null;
        return list.get(0);
    }

    private UserTb UserDefaultParamUtil(UserTb u){
        u.setUpdateTime(System.currentTimeMillis()/1000);
        u.setUpdateTime(System.currentTimeMillis()/1000);
        u.setIsDelete(0);
        return u;
    }
}
