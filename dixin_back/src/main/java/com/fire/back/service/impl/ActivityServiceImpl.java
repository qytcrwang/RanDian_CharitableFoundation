package com.fire.back.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.fire.back.common.CommonUtil;
import com.fire.back.dao.ActivityUserTbMapper;
import com.fire.back.dao.UserTbMapper;
import com.fire.back.dao.extend.ExtendActivityTbMapper;
import com.fire.back.entity.ActivityTbWithBLOBs;
import com.fire.back.entity.ActivityUserTb;
import com.fire.back.entity.ActivityUserTbExample;
import com.fire.back.entity.ActivityUserTbExample.Criteria;
import com.fire.back.entity.UserTb;
import com.fire.back.service.ActivityService;
@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ExtendActivityTbMapper activityMapper;
	@Autowired
	private UserTbMapper userMapper;
	@Autowired
	private ActivityUserTbMapper activityUserMapper;

	/**
	 * 分页获取活动id name
	 * @param page,size,field,sort
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getIdAndNameByPage(int page,int size,String field,String sort) 
			throws FileNotFoundException{
		Map<String,Object> params = new HashMap<>();
		String param = "order by "+field+" "+sort+" limit "+(page-1)+","+size;
		params.put("param", param);
		List<Map<String, Object>> list = activityMapper.getIdAndNameByPage(params);
		for(Map<String, Object> map : list) {
			Long id = Long.parseLong(map.get("id")+"");
			File cover= ResourceUtils.getFile("classpath:static/images/cover");
			File[] files = cover.listFiles(new MyFilenameFilter(id+"."));
			if(files != null && files.length > 0)
			map.put("url", "http://127.0.0.1:"+CommonUtil.getValue("server.port")
			+CommonUtil.getValue("server.servlet-path")+"/images/cover/"+files[0].getName());
		}
		return list;
	}
	
	/**
	 * 获取活动详情
	 * @param id
	 * @return
	 */
	@Override
	public Map<String, Object> getInfoById(Long activityId,Long userId){
		ActivityUserTbExample example = new ActivityUserTbExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andActivityIdEqualTo(activityId);
		List<ActivityUserTb> activityUser = activityUserMapper.selectByExample(example);
		Map<String,Object> params = new HashMap<>();
		params.put("id", activityId);
		Map<String,Object> info = activityMapper.getInfoById(params);
		if(activityUser != null && activityUser.size() > 0)
			info.put("applyState", 1);//已经报过名
		else 
			info.put("applyState", 0);
		return info;
	}
	@Transactional
	@Override
	public Map<String, Object> applyActivity(Long activityId,Long userId) {
		Map<String,Object> returnMap = new HashMap<>();
		UserTb user = userMapper.selectByPrimaryKey(userId);
		Map<String,Object> params = new HashMap<>();
		params.put("id", activityId);
		Map<String,Object> activityMap = activityMapper.getNamesAndNumsById(params);
		ActivityTbWithBLOBs activity = new ActivityTbWithBLOBs();
		activity.setId(activityId);
		String newNames = activityMap.get("apply_names")+","+user.getName();
		if(newNames.startsWith(",")) newNames = newNames.substring(1);
		activity.setApplyNames(newNames);
		int newNums = Integer.parseInt(activityMap.get("apply_nums")+"")+1;
		activity.setApplyNums(newNums);
		activity.setUpdateTime(System.currentTimeMillis()/1000);
		activityMapper.updateByPrimaryKeyWithBLOBs(activity);
		ActivityUserTb activityUser = new ActivityUserTb();
		activityUser.setActivityId(activityId);
		activityUser.setUserId(userId);
		activityUser.setCreateTime(System.currentTimeMillis()/1000);
		activityUser.setIsDelete(0);
		activityUser.setState(0);
		activityUserMapper.insertSelective(activityUser);
		returnMap.put("names", newNames);
		returnMap.put("nums", newNums);
		return returnMap;
	}
	
	//flag 0已报名未结束 1已到场
	@Override
	public List<Map<String, Object>> getUserList(Long userId,int flag){
		Map<String,Object> params = new HashMap<>();
		params.put("activityUserState", flag);
		params.put("extend", " and a.state not in ("+(flag==0?"3,4":"4")+")");
		List<Map<String, Object>> list = activityMapper.getUserList(params);
		return list;
	}
}


class MyFilenameFilter implements FilenameFilter {
	// type为需要过滤的条件，比如如果type=".jpg"，则只能返回后缀为jpg的文件
	private String type;
 
	public MyFilenameFilter(String type) {
		this.type = type;
	}
	
	@Override
	// 返回true的文件则合格
	public boolean accept(File dir, String name) {
		// 这里如果需要使用文件的功能，则需要先进行封装
		File file = new File(dir,name);
		
		return name.startsWith(type) && file.isFile();
	}
}