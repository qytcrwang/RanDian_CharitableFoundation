package com.fire.back.controller.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fire.back.common.FireResult;
import com.fire.back.entity.ActivityTbWithBLOBs;
import com.fire.back.entity.SyscodeTb;
import com.fire.back.service.ActivityService;
import com.fire.back.service.SyscodeService;
import com.fire.back.util.ParamUtil;

/**  
 * @Title: ActivityController.java
 * @Description: 后端公益活动
 * @author Dragon
 * @date 2020-02-21 10:35:14 
 */
@RequestMapping("back/activity/")
@RestController
public class BackActivityController {
	
	private Logger logger = LoggerFactory.getLogger(BackActivityController.class);
	
	@Autowired
	private ActivityService service;
	@Autowired
	private SyscodeService syscodeService;
	
	@PostMapping("getList")
	@ResponseBody
	public FireResult getList(@RequestBody Map<String, Object> paramMap) {
		try {
			Integer page = ParamUtil.getInteger(paramMap, "page", 1);
			Integer size = ParamUtil.getInteger(paramMap, "size", 10);
			String field = ParamUtil.getString(paramMap, "field", "id");
			String sort = ParamUtil.getString(paramMap, "sort", "asc");
			Integer type = ParamUtil.getInteger(paramMap, "type", -1);
			String stime = ParamUtil.getString(paramMap, "stime", "");
			String etime = ParamUtil.getString(paramMap, "etime", "");
			int state = ParamUtil.getInteger(paramMap, "state", -1);
			String aname = ParamUtil.getString(paramMap, "aname", "").trim();
			List<Map<String,Object>> list = service.getListByPage(page, size, field, sort, type, stime, etime, state,aname);
			int count = service.getListByPageCount(type, stime, etime, state,aname);
			return FireResult.build(1, "数据获取成功", list,count);
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
	
	@PostMapping("getUserActivityList")
	@ResponseBody
	public FireResult getUserActivityList(@RequestBody Map<String, Object> paramMap) {
		try {
			Long userId = ParamUtil.getLong(paramMap, "userId", -1L);
			List<Map<String,Object>> info = service.getUserActivityList(userId);
			return FireResult.build(1, "数据获取成功",info);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}

	@PostMapping("insertOrUpdate")
	@ResponseBody
	public FireResult insertOrUpdate(@RequestBody ActivityTbWithBLOBs 
			activeTb,HttpServletRequest request) {
		try {
			service.insertOrUpdate(activeTb);
			return FireResult.build(1, "操作成功！");
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "操作失败，请稍后再试");
		}
	}

	@PostMapping("del")
	@ResponseBody
	public FireResult del(@RequestBody Map<String, Object> paramMap) {
		try {
			service.del(paramMap.get("ids")+"");
			return FireResult.build(1, "操作成功！");
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "操作失败，请稍后再试");
		}
	}

	@PostMapping("getSelect")
	@ResponseBody
	public FireResult getSelect() {
		try {
			List<SyscodeTb> typeList = syscodeService.getSyscode("activity_type");
			List<SyscodeTb> stateList = syscodeService.getSyscode("activity_state");
			Map<String,Object> selectData = new HashMap<>();
			selectData.put("typeList", typeList);
			selectData.put("stateList", stateList);
			return FireResult.build(1, "获取成功",selectData);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "操作失败，请稍后再试");
		}
	}
	
	@PostMapping("saveImage")
	@ResponseBody
	public Map<String,Object> saveImage(@RequestParam("file") MultipartFile file,HttpServletRequest req) {
		//后期换成配置文件中读取域名
		String ip = req.getServerName();
		int port = req.getServerPort();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		Map<String,Object> returnMap = new HashMap<>();
		try {
//			System.out.println(file.getOriginalFilename());
			String picPath = ClassUtils.getDefaultClassLoader().getResource("static/images/body").getPath();
//			System.out.println(picPath);
			String oldName = file.getOriginalFilename();
			File newFile = new File(picPath,uuid+"temp"+oldName.substring(oldName.indexOf(".")));
			BufferedOutputStream out = new BufferedOutputStream(    
                    new FileOutputStream(newFile));    
//            System.out.println(file.getName());  
            out.write(file.getBytes());    
            out.flush();    
            out.close();   
            String url = "http://"+ip+":"+port+"/images/body/"+newFile.getName();
//            System.out.println(newFile.getName());
//            System.out.println(newFile.getAbsolutePath());

    		returnMap.put("code", 0);
    		returnMap.put("msg", "添加成功");
    		Map<String,Object> picMap = new HashMap<>();
    		picMap.put("src", url);
    		picMap.put("title", "");
    		returnMap.put("data", picMap);
			return returnMap;
		} catch (Exception e) {
			logger.error("",e);
    		returnMap.put("code", 1);
    		returnMap.put("msg", "图片过大");
			return returnMap;
		}
	}
	
	@PostMapping("saveCoverImage")
	@ResponseBody
	public Map<String,Object> saveCoverImage(@RequestParam("file") MultipartFile file,HttpServletRequest req) {
		//后期换成配置文件中读取域名
		String ip = req.getServerName();
		int port = req.getServerPort();String uuid = UUID.randomUUID().toString().replace("-", "");
		Map<String,Object> returnMap = new HashMap<>();
		try {
//			System.out.println(file.getOriginalFilename());
			String picPath = ClassUtils.getDefaultClassLoader().getResource("static/images/cover").getPath();
//			System.out.println(picPath);
			String oldName = file.getOriginalFilename();
			File newFile = new File(picPath,uuid+"temp"+oldName.substring(oldName.indexOf(".")));
			BufferedOutputStream out = new BufferedOutputStream(    
                    new FileOutputStream(newFile));    
//            System.out.println(file.getName());  
            out.write(file.getBytes());    
            out.flush();    
            out.close();   
            String url = "http://"+ip+":"+port+"/images/cover/"+newFile.getName();
//            System.out.println(newFile.getName());
//            System.out.println(newFile.getAbsolutePath());

    		returnMap.put("code", 0);
    		returnMap.put("msg", "添加成功");
    		Map<String,Object> picMap = new HashMap<>();
    		picMap.put("src", url);
    		picMap.put("title", "");
    		returnMap.put("data", picMap);
			return returnMap;
		} catch (Exception e) {
			logger.error("",e);
    		returnMap.put("code", 1);
    		returnMap.put("msg", "图片过大");
			return returnMap;
		}
	}
}
