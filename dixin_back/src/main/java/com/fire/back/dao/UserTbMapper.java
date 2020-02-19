package com.fire.back.dao;

import com.fire.back.entity.UserTb;
import com.fire.back.entity.UserTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTbMapper {
    int countByExample(UserTbExample example);

    int deleteByExample(UserTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    List<UserTb> selectByExample(UserTbExample example);

    UserTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTb record, @Param("example") UserTbExample example);

    int updateByExample(@Param("record") UserTb record, @Param("example") UserTbExample example);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}