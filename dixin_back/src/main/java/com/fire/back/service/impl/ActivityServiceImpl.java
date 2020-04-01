package com.fire.back.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;

import com.fire.back.common.TimeTools;
import com.fire.back.dao.ActivityUserTbMapper;
import com.fire.back.dao.extend.ExtendActivityTbMapper;
import com.fire.back.dao.extend.ExtendUserTbMapper;
import com.fire.back.entity.ActivityTbExample;
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
	private ExtendUserTbMapper userMapper;
	@Autowired
	private ActivityUserTbMapper activityUserMapper;

	/**
	 * 分页获取活动id name
	 * @param page,size,field,sort,type
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getIdAndNameByPage(int page,int size,String field,String sort,int type)
			throws FileNotFoundException{
		Map<String,Object> params = new HashMap<>();
		String param = " where is_delete=0 and state in (1,2,3) ";
		if(type>-1) param += " and type = "+type;
		param += " order by "+field+" "+sort+" limit "+(page-1)*size+","+size;
		params.put("param", param);
		List<Map<String, Object>> list = activityMapper.getIdAndNameByPage(params);
		return list;
	}

	/**
	 * 获取活动详情
	 * @param activityId,userId
	 * @return
	 */
	@Override
	public Map<String, Object> getInfoById(Long activityId,Long userId){
		activityMapper.addReadNum(activityId);
		ActivityUserTbExample example = new ActivityUserTbExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andActivityIdEqualTo(activityId);
		List<ActivityUserTb> activityUser = activityUserMapper.selectByExample(example);
		Map<String,Object> params = new HashMap<>();
		params.put("id", activityId);
		Map<String,Object> info = activityMapper.getInfoById(params);
		info.put("bodyList", getBodyList(info.get("body")+""));
		if(activityUser != null && activityUser.size() > 0)
			info.put("applyState", 1);//已经报过名
		else
			info.put("applyState", 0);
		return info;
	}
	
	/**
	 * 用户活动报名
	 * @param activityId,userId
	 * @return
	 */
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
		activityMapper.updateByPrimaryKeySelective(activity);
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

	/**
	 * 获取用户报名过的活动
	 * @param userId,flag 0已报名未结束 1已到场
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUserList(Long userId,int flag){
		Map<String,Object> params = new HashMap<>();
//		params.put("activityUserState", flag);
		params.put("extend", " and a.state not in ("+(flag==0?"0,3,4":"0,1,2,4")+")");
		List<Map<String, Object>> list = activityMapper.getUserList(params);
		return list;
	}

	/**
	 * 获取用户已到场的已结束的活动并且没有加过分的
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUserActivityList(Long userId){
		List<Map<String, Object>> list = activityMapper.getUserActivityList(userId);
		return list;
	}
	
	/**
	 * 活动点赞
	 * @param activityId
	 * @return
	 */
	@Override
	public void addGood(Long activityId) {
		activityMapper.addGoodNum(activityId);
	}
	
	/**
	 * 分页获取活动id name
	 * @param page,size,field,sort,type,stime,etime,state
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getListByPage(int page,int size,String field,String sort,
			int type,String stime,String etime,int state,String name){
		Map<String,Object> params = new HashMap<>();
		String param = " where a.is_delete=0 ";
		if(type>-1) param += " and a.type = "+type;
		if(stime.length()>0) {
			stime = TimeTools.getTimeStamp(stime)/1000 +"";
			param += " and a.activity_start_time >="+stime;
		}
		if(etime.length()>0) {
			etime = TimeTools.getCircleStamp(etime)/1000 +"";
			param += " and a.activity_start_time <"+etime;
		}
		if(state>-1) param += " and a.state = "+state;
		if(name.length()>0) {
			param += " and a.title like '%"+name+"%'";
		}
		param += " order by "+field+" "+sort+" limit "+(page-1)*size+","+size;
		params.put("param", param);
		List<Map<String, Object>> list = activityMapper.getListByPage(params);
		return list;
	}
	
	/**
	 * count
	 * @param page,size,field,sort,type,stime,etime,state
	 * @return
	 */
	@Override
	public int getListByPageCount(int type,String stime,String etime,int state,String name){
		Map<String,Object> params = new HashMap<>();
		String param = " where is_delete=0 ";
		if(type>-1) param += " and type = "+type;
		if(stime.length()>0) {
			stime = TimeTools.getTimeStamp(stime)/1000 +"";
			param += " and activity_start_time >="+stime;
		}
		if(etime.length()>0) {
			etime = TimeTools.getCircleStamp(etime)/1000 +"";
			param += " and activity_start_time <"+etime;
		}
		if(state>-1) param += " and state = "+state;
		if(name.length()>0) {
			param += " and title like '%"+name+"%'";
		}
		params.put("param", param);
		int count = activityMapper.getListByPageCount(params);
		return count;
	}

	/**
	 * 获取活动详情
	 * @param activityId
	 * @return
	 */
	@Override
	public Map<String, Object> getInfoById(Long activityId){
		Map<String,Object> params = new HashMap<>();
		params.put("id", activityId);
		Map<String,Object> info = activityMapper.getBackInfoById(params);
		return info;
	}

	@Override
	public void del(String ids) {
		ActivityTbExample example = new ActivityTbExample();
		com.fire.back.entity.ActivityTbExample.Criteria c = example.createCriteria();
		c.andIdEqualTo(Long.parseLong(ids));
		ActivityTbWithBLOBs a = new ActivityTbWithBLOBs();
		a.setIsDelete(1);
		activityMapper.updateByExampleSelective(a, example);
	}
	
	@Override
	public int insertOrUpdate(ActivityTbWithBLOBs activeTb){
		Long now = System.currentTimeMillis()/1000;
		int result = 0;
		String body = activeTb.getBody();
		String picUrls = getPicUrls(body);
		body = body.replace("temp", "");
		activeTb.setBody(body);
		String coverPath = ClassUtils.getDefaultClassLoader().getResource("static/images/cover").getPath();
		String bodyPath = ClassUtils.getDefaultClassLoader().getResource("static/images/body").getPath();
		File coverDir = new File(coverPath);
		File bodyDir = new File(bodyPath);
		if(picUrls.length()>0) {
			for(String picUrl : picUrls.split(",")) {
				String bodyName = picUrl.substring(picUrl.indexOf("body/")+5); 
				File file = new File(bodyDir,bodyName);
				file.renameTo(new File(bodyDir,bodyName.replace("temp", "")));
			}
		}
		String coverUrl = activeTb.getCoverUrl();
		String coverName = coverUrl.substring(coverUrl.indexOf("cover/")+6);
		File file = new File(coverDir,coverName);
		file.renameTo(new File(coverDir,coverName.replace("temp", "")));
		picUrls = picUrls.replace("temp", "");
		coverUrl = coverUrl.replace("temp", "");
		activeTb.setPicUrl(picUrls);
		activeTb.setCoverUrl(coverUrl);
		//新增：先插入 获取id 然后跟更新一样处理 处理封面图片&文本图片&文本内容 拿取图片路径 入库
		if(activeTb.getId()==null) {
			activeTb.setIsDelete(0);
			activeTb.setCreateTime(now);
			result = activityMapper.insertSelective(activeTb);	
		}else {
			activeTb.setUpdateTime(now);
			result = activityMapper.updateByPrimaryKeySelective(activeTb);
		}

		//处理多余图片
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
            		String coverPath = ClassUtils.getDefaultClassLoader().getResource("static/images/cover").getPath();
            		String bodyPath = ClassUtils.getDefaultClassLoader().getResource("static/images/body").getPath();
            		File coverDir = new File(coverPath);
            		File bodyDir = new File(bodyPath);
            		File[] covers = coverDir.listFiles(new MyFilenameFilter("temp."));
            		File[] bodys = bodyDir.listFiles(new MyFilenameFilter("temp."));
            		if(covers.length == 0 && bodys.length == 0) timer.cancel();
            		for(File file : covers) {
            			file.delete();
            		}
            		for(File file : bodys) {
            			file.delete();
            		}
            		timer.cancel();
                } catch (Exception e) {
                	timer.cancel();
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(task, 0);
		return result;
	}
	

	//获取富文本中所有图片url
	private static String getPicUrls(String bodyStr){
		String pics = "";
		while (bodyStr.contains("<p>")) {
			int p1Index = bodyStr.indexOf("<p>");
			int p2Index = bodyStr.indexOf("</p>");
			String pStr = bodyStr.substring(p1Index+3,p2Index);
			//这里可能存在很多图片文字并存的可能
			if(pStr.contains("<img")) {
				while(pStr.contains("<img")) {
					int img1Index = pStr.indexOf("<img");
					int img2Index = pStr.indexOf(">");
					String src = pStr.substring(img1Index+10,img2Index-8);
					pics += src+",";
					pStr = pStr.substring(img2Index+1);
				}
			}
			bodyStr = bodyStr.substring(p2Index+3);
		}
		if(pics.length()>0) pics = pics.substring(0,pics.length()-1);
		return pics;
	}
	
	//转换富文本的内容
	private static List<Map<String,Object>> getBodyList (String bodyStr){
		List<Map<String,Object>> bodyList = new ArrayList<>();
		while (bodyStr.contains("<p>")) {
			int p1Index = bodyStr.indexOf("<p>");
			int p2Index = bodyStr.indexOf("</p>");
			String pStr = bodyStr.substring(p1Index+3,p2Index);
			//这里可能存在很多图片文字并存的可能
			if(!pStr.contains("<img")) {
				pStr = StringEscapeUtils.unescapeHtml4(pStr);
				pStr+="\n";
				Map<String,Object> map = new HashMap<>();
				map.put("textarea", pStr);
				bodyList.add(map);
			}else {
				while(pStr.contains("<img")) {
					int img1Index = pStr.indexOf("<img");
					int img2Index = pStr.indexOf(">");
					if(img1Index>0) {
						Map<String,Object> map = new HashMap<>();
						map.put("textarea", StringEscapeUtils.unescapeHtml4(pStr.substring(0,img1Index)));
						bodyList.add(map);
					}
					String src = pStr.substring(img1Index+10,img2Index-8);
					Map<String,Object> map = new HashMap<>();
					map.put("imgUrl", src);
					bodyList.add(map);
					pStr = pStr.substring(img2Index+1);
				}
				Map<String,Object> map = new HashMap<>();
				map.put("textarea", " \n");
				bodyList.add(map);
			}
			bodyStr = bodyStr.substring(p2Index+3);
		}
		return bodyList;
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