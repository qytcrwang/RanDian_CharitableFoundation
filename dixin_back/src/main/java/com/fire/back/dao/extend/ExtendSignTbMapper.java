package com.fire.back.dao.extend;

import com.fire.back.dao.SignTbMapper;
import com.fire.back.entity.SignTb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendSignTbMapper extends SignTbMapper {
    /**
     * 签到操作，记录为每用户每个月一条数据
     * @param record
     * @return
     */
    int signIn(SignTb record);

    /**
     * 获取用户年签到总天数
     * @param userId
     * @param year
     * @return
     */
    int selectYearSigned (@Param("userId") Long userId, @Param("year") int year,@Param("month") int month);

    /**
     * 获取用户指定年份至今签到总天数
     * @param userId
     * @param year
     * @return
     */
    int selectTotalYearSigned(@Param("userId") Long userId, @Param("year") int year,@Param("month") int month);
}
