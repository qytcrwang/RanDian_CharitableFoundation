package com.fire.back.dao;

import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.ContriInfoTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContriInfoTbMapper {
    int countByExample(ContriInfoTbExample example);

    int deleteByExample(ContriInfoTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContriInfoTb record);

    int insertSelective(ContriInfoTb record);

    List<ContriInfoTb> selectByExample(ContriInfoTbExample example);

    ContriInfoTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContriInfoTb record, @Param("example") ContriInfoTbExample example);

    int updateByExample(@Param("record") ContriInfoTb record, @Param("example") ContriInfoTbExample example);

    int updateByPrimaryKeySelective(ContriInfoTb record);

    int updateByPrimaryKey(ContriInfoTb record);
}