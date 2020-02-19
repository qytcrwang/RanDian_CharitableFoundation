package com.fire.back.dao;

import com.fire.back.entity.ActivityTb;
import com.fire.back.entity.ActivityTbExample;
import com.fire.back.entity.ActivityTbWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityTbMapper {
    int countByExample(ActivityTbExample example);

    int deleteByExample(ActivityTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityTbWithBLOBs record);

    int insertSelective(ActivityTbWithBLOBs record);

    List<ActivityTbWithBLOBs> selectByExampleWithBLOBs(ActivityTbExample example);

    List<ActivityTb> selectByExample(ActivityTbExample example);

    ActivityTbWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityTbWithBLOBs record, @Param("example") ActivityTbExample example);

    int updateByExampleWithBLOBs(@Param("record") ActivityTbWithBLOBs record, @Param("example") ActivityTbExample example);

    int updateByExample(@Param("record") ActivityTb record, @Param("example") ActivityTbExample example);

    int updateByPrimaryKeySelective(ActivityTbWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ActivityTbWithBLOBs record);

    int updateByPrimaryKey(ActivityTb record);
}