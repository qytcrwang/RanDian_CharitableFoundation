package com.fire.back.dao;

import com.fire.back.entity.ContriProtocolLastTb;
import com.fire.back.entity.ContriProtocolLastTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContriProtocolLastTbMapper {
    long countByExample(ContriProtocolLastTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContriProtocolLastTb record);

    int insertSelective(ContriProtocolLastTb record);

    List<ContriProtocolLastTb> selectByExample(ContriProtocolLastTbExample example);

    ContriProtocolLastTb selectByPrimaryKey(Long id);

    ContriProtocolLastTb selectByUserId(Long userId);

    int updateByExampleSelective(@Param("record") ContriProtocolLastTb record, @Param("example") ContriProtocolLastTbExample example);

    int updateByExample(@Param("record") ContriProtocolLastTb record, @Param("example") ContriProtocolLastTbExample example);

    int updateByPrimaryKeySelective(ContriProtocolLastTb record);

    int updateByUserId(ContriProtocolLastTb record);

    int updateByPrimaryKey(ContriProtocolLastTb record);
}