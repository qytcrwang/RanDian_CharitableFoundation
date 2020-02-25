package com.fire.back.dao.extend;

import com.fire.back.dao.SignTbMapper;
import com.fire.back.entity.SignTb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendSignTbMapper extends SignTbMapper {
    int signIn(SignTb record);

    SignTb selectByParams(@Param("userId") Long userId, @Param("signYear") int signYear, @Param("signMonth") int signMonth);
}
