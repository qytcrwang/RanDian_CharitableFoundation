package com.fire.back.service;

import com.fire.back.dao.MsgTbMapper;
import com.fire.back.entity.MsgTb;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 20:28
 * @description：小程序通知相关功能服务
 * @version: 1.0
 */
public interface NoticeService {

    /**
     * create by: 王一悦
     * description: 获取不带通知内容的通知列表根据时间排序
     * create time: 2020/2/25 20:42
     *
     [page, size, state, msg_type, is_delete]
     * @return java.util.List<com.fire.back.entity.MsgTb>
     */
    List<MsgTb> getMsgsWithOutContent(int page,int size,String ltitle,int state,int msgType,int isDelete,Long stime,Long etime);

    int getMsgCount(String ltitle,int state,int msgType,int isDelete,Long stime,Long etime);

    /**
     * create by: 王一悦
     * description: 根据通知id获取通知详情
     * create time: 2020/2/25 20:43
     *
     [id]
     * @return com.fire.back.entity.MsgTb
     */
    MsgTb getMsgDetailById(Long id);

    /**
     * create by: 王一悦
     * description: 添加公告通知
     * create time: 2020/2/29 13:59
     *
     [msgTb]
     * @return java.lang.Boolean
     */
    Boolean addMsg(MsgTb msgTb) throws ParseException;

    /**
     * create by: 王一悦
     * description: 修改公告通知
     * create time: 2020/2/29 14:27
     *
     [msgTb]
     * @return java.lang.Boolean
     */
    Boolean updateMsgById(MsgTb msgTb);

}
