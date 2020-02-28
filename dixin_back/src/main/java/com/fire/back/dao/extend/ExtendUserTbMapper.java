package com.fire.back.dao.extend;

import com.fire.back.dao.UserTbMapper;
import com.fire.back.entity.UserTb;
import com.fire.back.entity.UserTbExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtendUserTbMapper extends UserTbMapper {

    List<UserTb>selectUsersByPage(@Param("user") UserTb user,
                                  @Param("field") Object Field,
                                  @Param("sort") String sort,
                                  @Param("start") Integer start,
                                  @Param("pageSize") Integer pageSize);
    int updateLovePointsByUser(@Param("userId") Long userId);
}