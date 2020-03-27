package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.controller.web.TestController;
import com.fire.back.entity.MsgTb;
import com.fire.back.service.impl.NoticeServiceImpl;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 2:26
 * @description：小程序通知模块相关功能
 * @version: 1.0
 */
@Controller
public class NoticeController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private NoticeServiceImpl noticeServiceImpl;

    /**
     * create by: 王一悦
     * description: 获取不带通知内容的通知列表根据时间排序
     * create time: 2020/2/25 22:26
     *
     [request, paramMap]
     * @return com.fire.back.common.FireResult
     */
    @PostMapping("wx/notice/getNoticesWithOutContext")
    @ResponseBody
    public FireResult getNoticesWithOutContext(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
        try {
            Integer page = ParamUtil.getInteger(paramMap, "page", 1);
            Integer size = ParamUtil.getInteger(paramMap, "size", 10);
            Integer state = ParamUtil.getInteger(paramMap, "state", 0);
            Integer msgType = ParamUtil.getInteger(paramMap, "msgType", 0);
            Integer isDelete = ParamUtil.getInteger(paramMap, "isDelete", 0);
            List<MsgTb> list = noticeServiceImpl.getMsgsWithOutContent(page, size,"", state, msgType, isDelete,null,null);
            return FireResult.build(1, "数据获取成功", list);
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
    @PostMapping("wx/notice/getNoticeById")
    @ResponseBody
    public FireResult getNoticeById(HttpServletRequest request, @RequestBody Long id) {
        try {
            MsgTb detail = noticeServiceImpl.getMsgDetailById(id);
            return FireResult.build(1, "数据获取成功", detail);
        } catch (Exception e) {
            logger.error("通知详情获取失败",e);
            return FireResult.build(0, "获取信息失败，请稍后再试");
        }
    }
}
