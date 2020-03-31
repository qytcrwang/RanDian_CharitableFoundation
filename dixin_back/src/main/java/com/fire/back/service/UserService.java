package com.fire.back.service;

import com.fire.back.entity.UserTb;

import java.util.List;

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

    /**
     * 添加新用户
     * 所有参数可为空，id自动生成
     * @param u
     * @return
     */
    int insertUser(UserTb u);

    /**
     * 根据微信openid获取用户信息
     * @param openid
     * @return
     */
    UserTb getUserInfoByOpenId(String openid);

    /**
     * 根据条件查询数据条数
     * @param user
     * @return
     */
    int selectUsersCount(UserTb user);

    List<UserTb>selectUsersByPage(UserTb user);
}
