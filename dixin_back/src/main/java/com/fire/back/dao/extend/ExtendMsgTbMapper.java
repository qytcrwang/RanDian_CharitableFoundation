package com.fire.back.dao.extend;

import com.fire.back.entity.MsgTb;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：王一悦
 * @date ：Created in 2020/2/25 20:57
 * @description：MsgTbMapper子类
 * @version: 1.0
 */
@Repository
public interface ExtendMsgTbMapper {
    List<MsgTb> getMsgsWithOutContent(String ltitle,Integer state,Integer msgType,Integer isDelete,Long stime,Long etime,Integer start,Integer size);
    int getMsgCount(String ltitle,Integer state,Integer msgType,Integer isDelete,Long stime,Long etime);
}
