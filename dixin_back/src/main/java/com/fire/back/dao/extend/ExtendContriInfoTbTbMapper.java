package com.fire.back.dao.extend;

import com.fire.back.dao.LovePointsTbMapper;
import com.fire.back.dto.GetcontriInfoListParamsDto;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.LovePointsTb;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendContriInfoTbTbMapper extends LovePointsTbMapper {
    List<ContriInfoTb> selectContriInfoByPage(
        @Param("userId") GetcontriInfoListParamsDto paramsDto,
        @Param("page") Integer page,
        @Param("pageSize") Integer pageSize);
}
