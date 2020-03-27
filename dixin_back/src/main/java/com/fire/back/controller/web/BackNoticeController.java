package com.fire.back.controller.web;

import com.fire.back.common.FireResult;
import com.fire.back.common.TimeTools;
import com.fire.back.entity.MsgTb;
import com.fire.back.entity.SyscodeTb;
import com.fire.back.service.SyscodeService;
import com.fire.back.service.impl.NoticeServiceImpl;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/29 15:25
 * @description：后台通知接口
 * @version: 1.0
 */
@RestController
@RequestMapping("/back/notice")
public class BackNoticeController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private NoticeServiceImpl noticeServiceImpl;

    @Autowired
    private SyscodeService syscodeService;

    /**
     * create by: 王一悦
     * description: 添加通知公告
     * create time: 2020/2/29 15:57
     *
     {"title":,"body":,"time":,"msg_type":}     title,body不可为空
     * @return com.fire.back.common.FireResult
     */
    @PostMapping("/addNotice")
    public FireResult addNotice(@RequestBody Map<String,Object> paramMap){
        try {
            MsgTb msgTb = new MsgTb();
            msgTb.setTitle(ParamUtil.getString(paramMap,"title"));
            msgTb.setBody(ParamUtil.getString(paramMap,"body"));
            msgTb.setTime(ParamUtil.getLong(paramMap,"time",System.currentTimeMillis()/1000));
            msgTb.setUpdateTime(System.currentTimeMillis()/1000);
            msgTb.setMsgType(ParamUtil.getInteger(paramMap,"msg_type",0));//默认是公告
            Boolean b = noticeServiceImpl.addMsg(msgTb);
            return b?FireResult.build(1,"添加公告通知成功",null):
                    FireResult.build(0,"添加公告通知失败",null);
        } catch (Exception e) {
            logger.error("添加公告通知异常",e);
            return FireResult.build(0,"添加公告通知异常",null);
        }
    }

    /**
     * create by: 王一悦
     * description: 选择性修改通知公告信息
     * create time: 2020/2/29 16:10
     *
     {"id":,"title":,"body":,"time":,"state":,"if_read":,"is_delete":}  id是不可为空的
     * @return com.fire.back.common.FireResult
     */
    @PostMapping("/updateNoticeById")
    public FireResult updateNoticeById(@RequestBody Map<String,Object> paramMap){
        try {
            if (paramMap.get("id")==null) return FireResult.build(0,"修改公告通知失败",null);
            MsgTb msgTb = new MsgTb();
            msgTb.setId(ParamUtil.getLong(paramMap,"id"));
            msgTb.setTitle(ParamUtil.getString(paramMap,"title",null));
            msgTb.setBody(ParamUtil.getString(paramMap,"body",null));
            msgTb.setTime(ParamUtil.getLong(paramMap,"time",System.currentTimeMillis()/1000));
            msgTb.setState(ParamUtil.getInteger(paramMap,"state",null));
            msgTb.setIfRead(ParamUtil.getInteger(paramMap,"if_read",null));
            msgTb.setUpdateTime(System.currentTimeMillis()/1000);
            msgTb.setIsDelete(ParamUtil.getInteger(paramMap,"is_delete",null));
            Boolean b = noticeServiceImpl.updateMsgById(msgTb);
            return b?FireResult.build(1,"修改公告通知成功",null):
                    FireResult.build(0,"修改公告通知失败",null);
        } catch (Exception e) {
            logger.error("修改公告通知异常",e);
            return FireResult.build(0,"修改公告通知异常",null);
        }
    }

    /**
     * create by: 王一悦
     * description: 获取不带通知内容的通知列表根据时间排序
     * create time: 2020/2/25 22:26
     *
     [request, paramMap]
     * @return com.fire.back.common.FireResult
     */
    @PostMapping("/getNoticesWithOutContext")
    @ResponseBody
    public FireResult getNoticesWithOutContext(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
        Long stime = null;
        Long etime = null;
        try {
            Integer page = ParamUtil.getInteger(paramMap, "page", 1);
            Integer size = ParamUtil.getInteger(paramMap, "limit", 10);
            Integer state = ParamUtil.getInteger(paramMap, "state", -1);
            Integer msgType = ParamUtil.getInteger(paramMap, "msgType", 0);
            Integer isDelete = ParamUtil.getInteger(paramMap, "isDelete", 0);
            String ltitle = ParamUtil.getString(paramMap,"ltitle","");
            if(!(paramMap.get("noticeStime")==null||"".equals(paramMap.get("noticeStime")))){
                stime = TimeTools.getTimeStamp(paramMap.get("noticeStime").toString())/1000;
            }else{
                stime = 0L;
            }
            if(!(paramMap.get("noticeEtime")==null||"".equals(paramMap.get("noticeEtime")))){
                etime = TimeTools.getTimeStamp(paramMap.get("noticeEtime").toString())/1000;
            }else{
                etime = System.currentTimeMillis()/1000;
            }

            List<MsgTb> list = noticeServiceImpl.getMsgsWithOutContent(page, size, ltitle, state, msgType, isDelete,stime,etime);
            //获取总条数
            int count = noticeServiceImpl.getMsgCount(ltitle,state,msgType,isDelete,stime,etime);
            return FireResult.build(1, "数据获取成功", list,count);
        } catch (Exception e) {
            logger.error("通知列表获取失败",e);
            return FireResult.build(0, "获取信息失败，请稍后再试");
        }
    }

    @PostMapping("/getNoticeStateList")
    @ResponseBody
    public FireResult getSelectList() {
        try {
            List<SyscodeTb> stateList = syscodeService.getSyscode("msg_state");
            return FireResult.build(1, "数据获取成功", stateList);
        } catch (Exception e) {
            logger.error("通知列表获取失败",e);
            return FireResult.build(0, "获取信息失败，请稍后再试");
        }
    }

    /**
     * create by: 王一悦
     * description: 根据通知id获取通知详情
     * create time: 2020/2/25 22:27
     *
     [request, id]
     * @return com.fire.back.common.FireResult
     */
    @PostMapping("/getNoticeById")
    @ResponseBody
    public FireResult getNoticeById(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
        try {
            if (paramMap.get("id")==null) return FireResult.build(0,"修改公告通知失败",null);
            MsgTb detail = noticeServiceImpl.getMsgDetailById(ParamUtil.getLong(paramMap,"id"));
            return FireResult.build(1, "数据获取成功", detail);
        } catch (Exception e) {
            logger.error("通知详情获取失败",e);
            return FireResult.build(0, "获取信息失败，请稍后再试");
        }
    }
}
