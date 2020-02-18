package com.fire.back.dao;

import com.fire.back.entity.ActivityUserTb;
import com.fire.back.entity.ActivityUserTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityUserTbMapper {
    int countByExample(ActivityUserTbExample example);

    int deleteByExample(ActivityUserTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityUserTb record);

    int insertSelective(ActivityUserTb record);

    List<ActivityUserTb> selectByExample(ActivityUserTbExample example);

    ActivityUserTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityUserTb record, @Param("example") ActivityUserTbExample example);

    int updateByExample(@Param("record") ActivityUserTb record, @Param("example") ActivityUserTbExample example);

    int updateByPrimaryKeySelective(ActivityUserTb record);

    int updateByPrimaryKey(ActivityUserTb record);
}