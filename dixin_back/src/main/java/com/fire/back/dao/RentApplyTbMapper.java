package com.fire.back.dao;

import com.fire.back.entity.RentApplyTb;
import com.fire.back.entity.RentApplyTbExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentApplyTbMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RentApplyTb record);

    int insertSelective(RentApplyTb record);

    List<RentApplyTb> selectByExample(RentApplyTbExample example);

    RentApplyTb selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RentApplyTb record);

    int updateByPrimaryKey(RentApplyTb record);
}