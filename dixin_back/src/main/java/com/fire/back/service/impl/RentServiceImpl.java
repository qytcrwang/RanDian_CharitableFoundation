package com.fire.back.service.impl;

import com.fire.back.dao.RentApplyTbMapper;
import com.fire.back.entity.RentApplyTb;
import com.fire.back.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 0:28
 * @description：小程序租房模块service层实体类
 * @version: 1.0
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentApplyTbMapper rentApplyTbMapper;

    /**
     * create by: 王一悦
     * description: 小程序添加租房申请服务
     * create time: 2020/2/25 2:23
     *
     [rentApplyTb]
     * @return java.lang.Boolean true为申请成功，false为申请失败
     * DataAccessException数据库数据类型异常
     */
    @Override
    public Boolean addRentApply(RentApplyTb rentApplyTb) throws DataAccessException {
        rentDefaultParamUtil(rentApplyTb);
        int insert = rentApplyTbMapper.insert(rentApplyTb);
        return insert>0?true:false;
    }

    /**
     * create by: 王一悦
     * description: 添加申请数据库默认字段补全方法
     * create time: 2020/2/25 2:24
     *
     [rentApplyTb]
     * @return void
     */
    public void rentDefaultParamUtil(RentApplyTb rentApplyTb){
        rentApplyTb.setState(0);
        rentApplyTb.setIsDelete(0);
        rentApplyTb.setCreateTime(System.currentTimeMillis()/1000);
    }
}
