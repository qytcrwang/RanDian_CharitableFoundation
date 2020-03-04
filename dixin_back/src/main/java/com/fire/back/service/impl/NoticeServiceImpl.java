package com.fire.back.service.impl;

import com.fire.back.dao.MsgTbMapper;
import com.fire.back.dao.extend.ExtendMsgTbMapper;
import com.fire.back.entity.MsgTb;
import com.fire.back.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 20:48
 * @description：小程序通知相关功能服务实现
 * @version: 1.0
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private MsgTbMapper msgTbMapper;

    @Autowired
    private ExtendMsgTbMapper extendMsgTbMapper;

    /**
     * create by: 王一悦
     * description: 获取不带通知内容的通知列表根据时间排序
     * create time: 2020/2/25 21:43
     *
     [page, size, state, msgType, isDelete]
     * @return java.util.List<com.fire.back.entity.MsgTb>
     */
    @Override
    public List<MsgTb> getMsgsWithOutContent(int page, int size, int state, int msgType, int isDelete) {
        Map<String,Object> params = new HashMap<>();
        String param = " where m.state = "+state+" and m.msg_type = "+msgType+" and m.is_delete = "+isDelete;
        param += " order by m.time limit "+(page-1)*size+","+size;
        params.put("param", param);
        List<MsgTb> list = extendMsgTbMapper.getMsgsWithOutContent(params);
        return list;
    }

    /**
     * create by: 王一悦
     * description: 根据通知id获取通知详情
     * create time: 2020/2/25 21:43
     *
     [id]
     * @return com.fire.back.entity.MsgTb
     */
    @Override
    public MsgTb getMsgDetailById(Long id) {
        return msgTbMapper.selectByPrimaryKey(id);
    }

    /**
     * create by: 王一悦
     * description: 添加公告通知
     * create time: 2020/2/29 13:59
     *
     [msgTb]
     * @return java.lang.Boolean
     */
    @Override
    public Boolean addMsg(MsgTb msgTb) {
        //添加默认配置数据
        msgDefaultParamUtil(msgTb);
        return msgTbMapper.insert(msgTb)>0;
    }

    /**
     * create by: 王一悦
     * description: 根据id选择性的进行修改属性
     * create time: 2020/2/29 15:14
     *
     [msgTb]
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateMsgById(MsgTb msgTb) {
        return msgTbMapper.updateByPrimaryKeySelective(msgTb)>0;
    }


    /**
     * create by: 王一悦
     * description: 添加通知时数据库默认字段补全方法
     * create time: 2020/2/29 14:25
     *
     [msgTb]
     * @return void
     */
    public void msgDefaultParamUtil(MsgTb msgTb){
        msgTb.setState(1);//公告创建成功后默认是未发布的
        msgTb.setIsDelete(0);//未删除
        msgTb.setIfRead(0);//未读
        msgTb.setCreateTime(System.currentTimeMillis()/1000);//创建时间
    }

}
