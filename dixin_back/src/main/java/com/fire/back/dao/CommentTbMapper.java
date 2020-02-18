package com.fire.back.dao;

import com.fire.back.entity.CommentTb;
import com.fire.back.entity.CommentTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentTbMapper {
    int countByExample(CommentTbExample example);

    int deleteByExample(CommentTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentTb record);

    int insertSelective(CommentTb record);

    List<CommentTb> selectByExample(CommentTbExample example);

    CommentTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentTb record, @Param("example") CommentTbExample example);

    int updateByExample(@Param("record") CommentTb record, @Param("example") CommentTbExample example);

    int updateByPrimaryKeySelective(CommentTb record);

    int updateByPrimaryKey(CommentTb record);
}