package com.fire.back.dao;

import com.fire.back.entity.UserTb;
import com.fire.back.entity.UserTbExample;
import java.util.List;

public interface UserTbMapper {
    long countByExample(UserTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    List<UserTb> selectByExample(UserTbExample example);

    UserTb selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}