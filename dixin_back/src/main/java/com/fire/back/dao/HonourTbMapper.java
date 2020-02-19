package com.fire.back.dao;

import com.fire.back.entity.HonourTb;
import com.fire.back.entity.HonourTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HonourTbMapper {
    int countByExample(HonourTbExample example);

    int deleteByExample(HonourTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HonourTb record);

    int insertSelective(HonourTb record);

    List<HonourTb> selectByExample(HonourTbExample example);

    HonourTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HonourTb record, @Param("example") HonourTbExample example);

    int updateByExample(@Param("record") HonourTb record, @Param("example") HonourTbExample example);

    int updateByPrimaryKeySelective(HonourTb record);

    int updateByPrimaryKey(HonourTb record);
}