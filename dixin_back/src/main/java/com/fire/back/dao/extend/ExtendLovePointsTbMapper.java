package com.fire.back.dao.extend;

import com.fire.back.dao.LovePointsTbMapper;
import com.fire.back.entity.LovePointsTb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExtendLovePointsTbMapper extends LovePointsTbMapper {
    List<LovePointsTb> selectLovePointsByPage(@Param("lovePoint") LovePointsTb lp,
                                              @Param("start") Integer start,
                                              @Param("pageSize") Integer pageSize);
}