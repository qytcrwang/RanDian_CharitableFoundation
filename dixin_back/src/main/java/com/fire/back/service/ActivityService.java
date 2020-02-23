package com.fire.back.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Title: ActivityService.java
 * @Description: TODO(描述)
 * @author Dragon
 * @date 2020-02-21 10:40:12
 */
public interface ActivityService {
	public List<Map<String, Object>> getIdAndNameByPage(int page,int size,String field,String sort,int type) 
			throws FileNotFoundException;
	public Map<String, Object> getInfoById(Long activityId,Long userId);
	public Map<String, Object> applyActivity(Long activityId,Long userId);
	public List<Map<String, Object>> getUserList(Long userId,int flag);
	public void addGood(Long activityId);
}
