package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.controller.web.TestController;
import com.fire.back.entity.RentApplyTb;
import com.fire.back.service.RentService;
import com.fire.back.service.impl.RentServiceImpl;
import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 0:08
 * @description：小程序租房模块相关功能
 *      添加租房申请
 * @version: 1.0$
 */
@Controller
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
    @PostMapping("wx/rent/addRentApply")
    @ResponseBody
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
}
