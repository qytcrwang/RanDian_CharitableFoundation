package com.hisense.dao;

import com.hisense.entity.OrderTb;
import com.hisense.entity.OrderTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderTbMapper {
    int countByExample(OrderTbExample example);

    int deleteByExample(OrderTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderTb record);

    int insertSelective(OrderTb record);

    List<OrderTb> selectByExample(OrderTbExample example);

    OrderTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderTb record, @Param("example") OrderTbExample example);

    int updateByExample(@Param("record") OrderTb record, @Param("example") OrderTbExample example);

    int updateByPrimaryKeySelective(OrderTb record);

    int updateByPrimaryKey(OrderTb record);
}