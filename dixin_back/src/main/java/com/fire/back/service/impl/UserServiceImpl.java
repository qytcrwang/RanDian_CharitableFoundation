package com.fire.back.service.impl;

import com.fire.back.dao.UserTbMapper;
import com.fire.back.entity.UserTb;
import com.fire.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return um.updateByPrimaryKeySelective(u);
    }
}
