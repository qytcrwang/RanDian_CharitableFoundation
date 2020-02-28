package com.fire.back.dao;

import com.fire.back.entity.LovePointsTb;
import com.fire.back.entity.LovePointsTbExample;
import java.util.List;

public interface LovePointsTbMapper {
    long countByExample(LovePointsTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LovePointsTb record);

    int insertSelective(LovePointsTb record);

    List<LovePointsTb> selectByExample(LovePointsTbExample example);

    LovePointsTb selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LovePointsTb record);

    int updateByPrimaryKey(LovePointsTb record);
}