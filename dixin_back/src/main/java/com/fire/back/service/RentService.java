package com.fire.back.service;

import com.fire.back.entity.RentApplyTb;

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
}
