package com.fire.back.service;

import com.fire.back.entity.UserTb;

public interface UserService {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    UserTb getUserInfobByPrimaryKey(Long id);

    /**
     * 根据用户id更新用户信息
     * @param u
     * @return
     */
    int UpdateUserInfo(UserTb u);
}
