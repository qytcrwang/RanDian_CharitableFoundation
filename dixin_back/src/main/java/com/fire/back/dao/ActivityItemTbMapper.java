package com.fire.back.dao;

import com.fire.back.entity.ActivityItemTb;
import com.fire.back.entity.ActivityItemTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityItemTbMapper {
    int countByExample(ActivityItemTbExample example);

    int deleteByExample(ActivityItemTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityItemTb record);

    int insertSelective(ActivityItemTb record);

    List<ActivityItemTb> selectByExample(ActivityItemTbExample example);

    ActivityItemTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityItemTb record, @Param("example") ActivityItemTbExample example);

    int updateByExample(@Param("record") ActivityItemTb record, @Param("example") ActivityItemTbExample example);

    int updateByPrimaryKeySelective(ActivityItemTb record);

    int updateByPrimaryKey(ActivityItemTb record);
}