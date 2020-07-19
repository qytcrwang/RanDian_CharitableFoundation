package com.fire.back.dao;

import com.fire.back.entity.ContriProtocolTb;
import com.fire.back.entity.ContriProtocolTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContriProtocolTbMapper {
    long countByExample(ContriProtocolTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContriProtocolTb record);

    int insertSelective(ContriProtocolTb record);

    List<ContriProtocolTb> selectByExample(ContriProtocolTbExample example);

    ContriProtocolTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContriProtocolTb record, @Param("example") ContriProtocolTbExample example);

    int updateByExample(@Param("record") ContriProtocolTb record, @Param("example") ContriProtocolTbExample example);

    int updateByPrimaryKeySelective(ContriProtocolTb record);

    int updateByPrimaryKey(ContriProtocolTb record);
}