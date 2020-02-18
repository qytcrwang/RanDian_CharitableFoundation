package com.fire.back.dao;

import com.fire.back.entity.SignTb;
import com.fire.back.entity.SignTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignTbMapper {
    int countByExample(SignTbExample example);

    int deleteByExample(SignTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SignTb record);

    int insertSelective(SignTb record);

    List<SignTb> selectByExample(SignTbExample example);

    SignTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SignTb record, @Param("example") SignTbExample example);

    int updateByExample(@Param("record") SignTb record, @Param("example") SignTbExample example);

    int updateByPrimaryKeySelective(SignTb record);

    int updateByPrimaryKey(SignTb record);
}