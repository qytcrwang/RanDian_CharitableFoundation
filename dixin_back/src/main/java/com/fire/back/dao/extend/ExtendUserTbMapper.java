package com.fire.back.dao.extend;

import com.fire.back.dao.UserTbMapper;
import com.fire.back.entity.LovePointsTb;
import com.fire.back.entity.UserTb;
import com.fire.back.entity.UserTbExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtendUserTbMapper extends UserTbMapper {

    List<UserTb>selectUsersByPage(UserTb user);
    int selectUsersCount(UserTb user);
    int updateLovePointsByUser(@Param("userId") Long userId,@Param("updateTime") Long updateTime);
    int batchUpdateLovePointsByUser(List<LovePointsTb> list);
}