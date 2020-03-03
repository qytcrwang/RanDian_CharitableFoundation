package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.controller.web.TestController;
import com.fire.back.entity.RentApplyTb;
import com.fire.back.service.impl.RentServiceImpl;
import com.fire.back.common.CheckEmptyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 0:08
 * @description：小程序租房模块相关功能
 * @version: 1.0$
 */
@RequestMapping("/wx/rent")
@RestController
public class RentController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RentServiceImpl rentServiceImpl;

    /**
     * create by: 王一悦
     * description: 小程序添加租房申请接口
     * create time: 2020/2/25 2:22
     *
     [request, rentApplyTb]
     * @return com.fire.back.common.FireResult
     */
    @PostMapping("/addRentApply")
    public FireResult addRentApply(HttpServletRequest request, @RequestBody RentApplyTb rentApplyTb) {
        if (CheckEmptyUtil.isEmpty(rentApplyTb)) {
            return FireResult.build(0, "入参不能为空");
        }
        try {
            Boolean b = rentServiceImpl.addRentApply(rentApplyTb);
            return b?FireResult.build(1, "租房申请添加成功"):FireResult.build(0, "租房申请添加失败");
        } catch (Exception e) {
            logger.error("前端传输数据类型错误", e);
            return FireResult.build(0, "数据类型有误");
        }
    }
    /**
     * create by: 刘云龙
     * description: 后台修改租房申请接口 可用于数据修改，审核
     * create time: 2020/2/25 2:22
     *
     [request, rentApplyTb]
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

}
