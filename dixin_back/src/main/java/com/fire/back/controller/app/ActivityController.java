/**  
 * @Title: ActivityController.java
 * @Description: TODO(描述)
 * @author Dragon
 * @date 2020-02-21 10:35:14 
 */
package com.fire.back.controller.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fire.back.common.FireResult;
import com.fire.back.controller.web.TestController;
import com.fire.back.service.ActivityService;
import com.fire.back.util.ParamUtil;

/**  
 * @Title: ActivityController.java
 * @Description: 小程序公益活动
 * @author Dragon
 * @date 2020-02-21 10:35:14 
 */
@Controller
public class ActivityController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private ActivityService service;
	
	/*
	 * 公益活动列表
	 * 当前页码page 每页大小size 排序字段field 正序or反序sort
	 */
	@PostMapping("wx/activity/getList")
	@ResponseBody
	public FireResult getList(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
		try {
			Integer page = ParamUtil.getInteger(paramMap, "page", 1);
			Integer size = ParamUtil.getInteger(paramMap, "size", 10);
			String field = ParamUtil.getString(paramMap, "field", "id");
			String sort = ParamUtil.getString(paramMap, "param4", "asc");
			Integer type = ParamUtil.getInteger(paramMap, "param4", -1);
			List<Map<String,Object>> list = service.getIdAndNameByPage(page, size, field, sort, type);
			return FireResult.build(1, "数据获取成功", list);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}
	

	@PostMapping("wx/activity/getInfo")
	@ResponseBody
	public FireResult getInfo(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
		try {
			Long id = ParamUtil.getLong(paramMap, "id", -1L);
			Long userId = ParamUtil.getLong(paramMap, "userId", -1L);
			Map<String, Object> info = service.getInfoById(id,userId);
			return FireResult.build(1, "数据获取成功", info);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}
	

	@PostMapping("wx/activity/applyActivity")
	@ResponseBody
	public FireResult applyActivity(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
		try {
			Long id = ParamUtil.getLong(paramMap, "id", -1L);
			Long userId = ParamUtil.getLong(paramMap, "userId", -1L);
			Map<String, Object> info = service.applyActivity(id, userId);
			return FireResult.build(1, "报名成功",info);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}
	
	//已报名  已到场
	@PostMapping("wx/activity/getUserList")
	@ResponseBody
	public FireResult getUserList(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
		try {
			Long userId = ParamUtil.getLong(paramMap, "userId", -1L);
			Map<String, List<Map<String,Object>>> info = new HashMap<>();
			info.put("0", service.getUserList(userId, 0));
			info.put("1", service.getUserList(userId, 1));
			return FireResult.build(1, "数据获取成功",info);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}
}