/**  
 * @Title: ActivityController.java
 * @Description: TODO(描述)
 * @author Dragon
 * @date 2020-02-21 10:35:14 
 */
package com.fire.back.controller.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fire.back.common.FireResult;
import com.fire.back.entity.ActivityTbWithBLOBs;
import com.fire.back.service.ActivityService;
import com.fire.back.util.ParamUtil;

/**  
 * @Title: ActivityController.java
 * @Description: 后端公益活动
 * @author Dragon
 * @date 2020-02-21 10:35:14 
 */
@RequestMapping("back/activity/")
@RestController
public class ActivityController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private ActivityService service;
	
	@PostMapping("getList")
	@ResponseBody
	public FireResult getList(@RequestBody Map<String, Object> paramMap) {
		try {
			Integer page = ParamUtil.getInteger(paramMap, "page", 1);
			Integer size = ParamUtil.getInteger(paramMap, "size", 10);
			String field = ParamUtil.getString(paramMap, "field", "id");
			String sort = ParamUtil.getString(paramMap, "param4", "asc");
			Integer type = ParamUtil.getInteger(paramMap, "param4", -1);
			String stime = ParamUtil.getString(paramMap, "stime", "");
			String etime = ParamUtil.getString(paramMap, "etime", "");
			int state = ParamUtil.getInteger(paramMap, "state", -1);
			List<Map<String,Object>> list = service.getListByPage(page, size, field, sort, type, stime, etime, state);
			return FireResult.build(1, "数据获取成功", list);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}
	

	@PostMapping("getInfo")
	@ResponseBody
	public FireResult getInfo(@RequestBody Map<String, Object> paramMap) {
		try {
			Long id = ParamUtil.getLong(paramMap, "id", -1L);
			Map<String, Object> info = service.getInfoById(id);
			return FireResult.build(1, "数据获取成功", info);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}
	

	@PostMapping("insertOrUpdate")
	@ResponseBody
	public FireResult insertOrUpdate(ActivityTbWithBLOBs activeTb) {
		try {
			
			return FireResult.build(1, "点赞成功");
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "操作失败，请稍后再试");
		}
	}
	
}
