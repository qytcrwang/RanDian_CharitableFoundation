/**  
 * @Title: ExtendActivityTbMapper.java
 * @Description: TODO(描述)
 * @author Dragon
 * @date 2020-02-21 10:52:03 
 */
package com.fire.back.dao.extend;

import java.util.List;
import java.util.Map;

import com.fire.back.dao.ActivityTbMapper;

/**  
 * @Title: ExtendActivityTbMapper.java
 * @Description: TODO(描述)
 * @author Dragon
 * @date 2020-02-21 10:52:03 
 */
public interface ExtendActivityTbMapper extends ActivityTbMapper {
    List<Map<String, Object>> getIdAndNameByPage(Map<String,Object> params);
    Map<String, Object> getInfoById(Map<String,Object> params);
    Map<String, Object> getNamesAndNumsById(Map<String,Object> params);
    List<Map<String, Object>> getUserList(Map<String,Object> params);
    void addReadNum(Long id);
    void addGoodNum(Long id);
}
