package com.fire.back.controller.web;

import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.common.FireResult;
import com.fire.back.entity.RentApplyTb;
import com.fire.back.service.impl.RentServiceImpl;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author ：刘云龙
 * @date ：Created in 2020/3/3
 * @description：后台租房模块相关功能
 * @version: 1.0$
 */
@RequestMapping("/back/rent")
@RestController
public class BackRentController {

    private Logger logger = LoggerFactory.getLogger(BackRentController.class);

    @Autowired
    private RentServiceImpl rentServiceImpl;


    /**
     * create by: 刘云龙
     * description: 后台修改租房申请接口 可用于数据修改，审核
     * create time: 2020/3/03 2:22
     * param: [rentApplyTb]
     * @return com.fire.back.common.FireResult
     */
    @PostMapping("/updateRent")
    public FireResult updateRent(@RequestBody RentApplyTb rentApplyTb){
        if (CheckEmptyUtil.isEmpty(rentApplyTb)) {
            return FireResult.build(0, "入参不能为空");
        }
        try {
            Boolean b = rentServiceImpl.updateRentApplyTb(rentApplyTb);
            return b?FireResult.build(1, "租房申请更新成功"):FireResult.build(0, "租房申请更新失败");
        } catch (Exception e) {
            logger.error("前端传输数据类型错误", e);
            return FireResult.build(0, "数据类型有误");
        }
    }
    /**
     * create by: 刘云龙
     * description: 根据id获取租房申请详情
     * create time: 2020/3/03 2:22
     * param: [rentId]
     * @return com.fire.back.common.FireResult[RentApplyTb]
     */
    @PostMapping("/getRentInfoById")
    public FireResult getRentInfoById(@RequestBody Map<String,Object> paramMap){
        Long rentId = ParamUtil.getLong(paramMap,"id",null);
        if(rentId==null){
            return FireResult.build(0,"参数异常");
        }
        try {
            RentApplyTb rent = rentServiceImpl.getRentApplyById(rentId);
            return FireResult.build(1,"租房申请查询成功",rent);

        } catch (Exception e) {
            logger.error("查询租房申请异常",e);
            return FireResult.build(0, "查询租房申请异常");
        }
    }

    /**
     * create by: 刘云龙
     * description: 根据条件查询 租房申请
     * create time: 2020/3/03 2:22
     * param: [userId,school,major,jobIntension,salary,state,jobState,idDelete,page,pageSize,field,sort]
     * @return com.fire.back.common.FireResult[RentApplyTb]
     */
    @PostMapping("/getRentByPage")
    public FireResult getRentByPage(@RequestBody Map<String,Object> paramMap){
        try {
            RentApplyTb r = new RentApplyTb();
            r.setUserId(ParamUtil.getLong(paramMap,"userId",null));
            r.setSchool(ParamUtil.getString(paramMap,"school",null));
            r.setMajor(ParamUtil.getString(paramMap,"major",null));
            r.setJobIntension(ParamUtil.getString(paramMap,"jobIntension",null));
            r.setHopeSalary(ParamUtil.getInteger(paramMap,"salary",null));
            r.setState(ParamUtil.getInteger(paramMap,"state",null));
            r.setJobState(ParamUtil.getInteger(paramMap,"jobState",null));
            r.setIsDelete(ParamUtil.getInteger(paramMap,"idDelete",null));
            Integer page = ParamUtil.getInteger(paramMap, "page",1);
            Integer pageSize = ParamUtil.getInteger(paramMap, "pageSize",20);
            String field = ParamUtil.getString(paramMap, "field","apply_time");
            String sort = ParamUtil.getString(paramMap, "sort","asc");
            List<RentApplyTb>list =  rentServiceImpl.getRentApplyByPage(r,page,pageSize,field,sort);
            return FireResult.build(1,"租房申请列表查询成功",list);
        } catch (Exception e) {
            logger.error("租房申请列表查询异常");
            return FireResult.build(1,"租房申请列表查询异常",null);
        }


    }

}
