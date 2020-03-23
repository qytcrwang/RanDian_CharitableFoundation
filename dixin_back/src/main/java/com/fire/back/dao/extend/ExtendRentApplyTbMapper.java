package com.fire.back.dao.extend;

import com.fire.back.dao.RentApplyTbMapper;
import com.fire.back.dto.RentListParamsDto;
import com.fire.back.entity.RentApplyTb;
import com.fire.back.entity.RentApplyTbExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtendRentApplyTbMapper extends RentApplyTbMapper {

    List<RentApplyTb> getRentApplyByPage(@Param("rent") RentApplyTb rent,
                                         @Param("start") Integer start,
                                         @Param("pageSize") Integer PageSize,
                                         @Param("field") String field,
                                         @Param("sort") String sort);

    /**
     * description   :  select all info
     *
     * @param rent
     * @return       : java.util.List<com.fire.back.entity.RentApplyTb>
     * @exception    :
     * @date         : 2020/3/19 10:18 PM
     * @author       : Killian
     */
    List<RentApplyTb> getRentApplyByPage2(@Param("rent") RentListParamsDto rent);



}