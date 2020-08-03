package com.fire.back.service;

import com.fire.back.common.ExecuteResult;
import com.fire.back.dto.RentListParamsDto;
import com.fire.back.entity.RentApplyTb;

import java.util.List;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 0:08
 * @description：小程序租房模块service层接口
 * @version: 1.0
 */
public interface RentService {
    /**
     * create by: 王一悦
     * description: 添加租房申请
     * create time: 2020/2/25 0:25
     * param: RentApplyTb

     * @return 布尔值 true表示成功，false表示失败
     */
    Boolean addRentApply(RentApplyTb rentApplyTb);

    /**
     *create by:刘云龙
     * description:条件查询 租房申请列表 分页返回结果
     * param RentApplyTb,page,pageSize,field,sort
     * @return java.util.List<RentApplyTb>
     */
    List<RentApplyTb> getRentApplyByPage(RentApplyTb rent,Integer page,Integer pageSize,String field, String sort);

    /**
     * create by:刘云龙
     * description：根据rentid获取rent详情
     * @param rentId
     * @return RentApplyTb
     */
    RentApplyTb getRentApplyById(Long rentId);

    /**
     * create by:刘云龙
     * description：更新申请信息
     * param RentApplyTb rent
     * @return 布尔值 true表示成功，false表示失败
     */
    Boolean updateRentApplyTb(RentApplyTb rent);

    /**
     * description   :  select all
     *
     * @param paramsDto
     * @return       : com.fire.back.common.ExecuteResult<java.util.List<com.fire.back.entity.RentApplyTb>>
     * @exception    :
     * @date         : 2020/3/19 10:21 PM
     * @author       : Killian
     */
    ExecuteResult<List<RentApplyTb>> getRentApplyTbList(RentListParamsDto paramsDto);

    int delete(Long id);

    Boolean updateStatus(RentApplyTb rentApplyTb);
}
