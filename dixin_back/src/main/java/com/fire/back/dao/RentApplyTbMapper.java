package com.fire.back.dao;

import com.fire.back.entity.RentApplyTb;
import com.fire.back.entity.RentApplyTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentApplyTbMapper {
    int countByExample(RentApplyTbExample example);

    int deleteByExample(RentApplyTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RentApplyTb record);

    int insertSelective(RentApplyTb record);

    List<RentApplyTb> selectByExample(RentApplyTbExample example);

    RentApplyTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RentApplyTb record, @Param("example") RentApplyTbExample example);

    int updateByExample(@Param("record") RentApplyTb record, @Param("example") RentApplyTbExample example);

    int updateByPrimaryKeySelective(RentApplyTb record);

    int updateByPrimaryKey(RentApplyTb record);
}