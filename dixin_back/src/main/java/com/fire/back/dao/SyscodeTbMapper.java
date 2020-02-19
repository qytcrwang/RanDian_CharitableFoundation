package com.fire.back.dao;

import com.fire.back.entity.SyscodeTb;
import com.fire.back.entity.SyscodeTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyscodeTbMapper {
    int countByExample(SyscodeTbExample example);

    int deleteByExample(SyscodeTbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyscodeTb record);

    int insertSelective(SyscodeTb record);

    List<SyscodeTb> selectByExample(SyscodeTbExample example);

    SyscodeTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyscodeTb record, @Param("example") SyscodeTbExample example);

    int updateByExample(@Param("record") SyscodeTb record, @Param("example") SyscodeTbExample example);

    int updateByPrimaryKeySelective(SyscodeTb record);

    int updateByPrimaryKey(SyscodeTb record);
}