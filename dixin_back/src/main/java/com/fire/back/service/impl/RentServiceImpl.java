package com.fire.back.service.impl;

import com.fire.back.dao.extend.ExtendRentApplyTbMapper;
import com.fire.back.entity.RentApplyTb;
import com.fire.back.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 0:28
 * @description：小程序租房模块service层实体类
 * @version: 1.0
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private ExtendRentApplyTbMapper rentApplyTbMapper;

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
        return rentApplyTbMapper.insert(rentApplyTb)>0;
    }

    /**
     *create by:刘云龙
     * description:条件查询 租房申请列表 分页返回结果
     * param RentApplyTb,page,pageSize,field,sort
     * @return java.util.List<RentApplyTb>
     */
    @Override
    public List<RentApplyTb> getRentApplyByPage(RentApplyTb rent, Integer page, Integer pageSize, String field, String sort) {
        return rentApplyTbMapper.getRentApplyByPage(rent,(page-1)*pageSize,pageSize,field,sort);
    }

    /**
     * create by:刘云龙
     * description：根据rentid获取rent详情
     * @param rentId
     * @return RentApplyTb
     */
    @Override
    public RentApplyTb getRentApplyById(Long rentId) {
        return rentApplyTbMapper.selectByPrimaryKey(rentId);
    }

    /**
     * create by:刘云龙
     * description：更新申请信息
     * param RentApplyTb rent
     * @return 布尔值 true表示成功，false表示失败
     */
    @Override
    public Boolean updateRentApplyTb(RentApplyTb rent) {
        rent.setUpdateTime(System.currentTimeMillis()/1000);
        return rentApplyTbMapper.updateByPrimaryKeySelective(rent)>0;
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
