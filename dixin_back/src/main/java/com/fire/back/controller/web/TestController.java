package com.fire.back.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fire.back.common.FireResult;
import com.fire.back.util.ParamUtil;
/**
 * 
 * @author dragon
 * 可依照getInfo规范开发 接口统一返回FireResult
 * Feb 18, 2020
 */
@Controller
public class TestController {
	private Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/test1")
	public String test1() {
		return "index";
	}

	@RequestMapping("/getInfo")
	@ResponseBody
	public FireResult getInfo(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
		try {
			Double param1 = ParamUtil.getDouble(paramMap, "param1", 0.00);
			Long param2 = ParamUtil.getLong(paramMap, "param2", 0L);
			Integer param3 = ParamUtil.getInteger(paramMap, "param3", 16);
			String param4 = ParamUtil.getString(paramMap, "param4", "规范示例");
			Map<String,Object> shili = new HashMap<>();
			shili.put("a", param1);
			shili.put("b", param2);
			shili.put("c", param3);
			shili.put("d", param4);
			return FireResult.build(1, "数据获取成功", shili);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}
}
