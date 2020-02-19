package com.fire.back.dao;

import com.fire.back.entity.MsgTb;
import com.fire.back.entity.MsgTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgTbMapper {
    int countByExample(MsgTbExample example);

    int deleteByExample(MsgTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgTb record);

    int insertSelective(MsgTb record);

    List<MsgTb> selectByExample(MsgTbExample example);

    MsgTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MsgTb record, @Param("example") MsgTbExample example);

    int updateByExample(@Param("record") MsgTb record, @Param("example") MsgTbExample example);

    int updateByPrimaryKeySelective(MsgTb record);

    int updateByPrimaryKey(MsgTb record);
}