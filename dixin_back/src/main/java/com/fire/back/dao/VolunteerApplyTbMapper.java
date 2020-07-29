package com.fire.back.dao;

import com.fire.back.entity.VolunteerApplyTb;
import com.fire.back.entity.VolunteerApplyTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VolunteerApplyTbMapper {
    long countByExample(VolunteerApplyTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VolunteerApplyTb record);

    int insertSelective(VolunteerApplyTb record);

    List<VolunteerApplyTb> selectByExample(VolunteerApplyTbExample example);

    VolunteerApplyTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VolunteerApplyTb record, @Param("example") VolunteerApplyTbExample example);

    int updateByExample(@Param("record") VolunteerApplyTb record, @Param("example") VolunteerApplyTbExample example);

    int updateByPrimaryKeySelective(VolunteerApplyTb record);

    int updateByPrimaryKey(VolunteerApplyTb record);
}