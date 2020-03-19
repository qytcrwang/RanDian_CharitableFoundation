package com.fire.back.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.fire.back.entity.ActivityTbWithBLOBs;

/**
 * 
 * @Title: ActivityService.java
 * @Description: TODO(描述)
 * @author Dragon
 * @date 2020-02-21 10:40:12
 */
public interface ActivityService {
	List<Map<String, Object>> getIdAndNameByPage(int page,int size,String field,String sort,int type) 
			throws FileNotFoundException;
	Map<String, Object> getInfoById(Long activityId,Long userId);
	Map<String, Object> applyActivity(Long activityId,Long userId);
	List<Map<String, Object>> getUserList(Long userId,int flag);
	void addGood(Long activityId);
	List<Map<String, Object>> getListByPage(int page,int size,String field,String sort,
			int type,String stime,String etime,int state);
	int getListByPageCount(int type,String stime,String etime,int state);
	Map<String, Object> getInfoById(Long activityId);
	int insertOrUpdate(ActivityTbWithBLOBs activeTb);
}
