package com.fire.back.controller.web;

import com.fire.back.common.FireResult;
import com.fire.back.entity.MsgTb;
import com.fire.back.service.impl.NoticeServiceImpl;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            msgTb.setTime(ParamUtil.getLong(paramMap,"time",null));
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
}
