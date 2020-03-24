package com.fire.back.dao.extend;

import com.fire.back.dto.ContriInfoListParamsDto;
import com.fire.back.dto.ContriInfoResultDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendContriInfoTbMapper {
  List<ContriInfoResultDto> selectContriInfoByPage(
      @Param("paramsDto") ContriInfoListParamsDto paramsDto);

  Integer getCount(@Param("paramsDto") ContriInfoListParamsDto paramsDto);
}
