package com.fire.back.dao;

import com.fire.back.entity.WxPayTrade;
import com.fire.back.entity.WxPayTradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxPayTradeMapper {
    long countByExample(WxPayTradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxPayTrade record);

    int insertSelective(WxPayTrade record);

    List<WxPayTrade> selectByExample(WxPayTradeExample example);

    WxPayTrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxPayTrade record, @Param("example") WxPayTradeExample example);

    int updateByExample(@Param("record") WxPayTrade record, @Param("example") WxPayTradeExample example);

    int updateByPrimaryKeySelective(WxPayTrade record);

    int updateByPrimaryKey(WxPayTrade record);
}