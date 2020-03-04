package com.fire.back.service.impl;

import com.fire.back.dao.ContriInfoTbMapper;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.ContriInfoTbExample;
import com.fire.back.service.ContriInfoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 捐赠信息相关Service相关实现.
 *
 * @author 王凯
 * @since 2020/2/22 18:35
 */
@Service
public class ContriInfoServiceImpl implements ContriInfoService {

  @Resource ContriInfoTbMapper contriInfoTbMapper;

  @Override
  public Boolean saveContriInfo(ContriInfoTb contriInfoTb) {
    contriDefaultParamUtil(contriInfoTb);
    int i = contriInfoTbMapper.insertSelective(contriInfoTb);
    return i == 1;
  }

  @Override
  public Boolean updateContriStatus(ContriInfoTb contriInfoTb) {
    contriInfoTb.setUpdateTime(System.currentTimeMillis()/1000);
    int i = contriInfoTbMapper.updateByPrimaryKeySelective(contriInfoTb);
    return i == 1;
  }

  @Override
  public List<ContriInfoTb> getSelfContriInfo(Long userId) {
    ContriInfoTbExample contriInfoTbExample = new ContriInfoTbExample();
    contriInfoTbExample.createCriteria().andUserIdEqualTo(userId);
    return contriInfoTbMapper.selectByExample(contriInfoTbExample);
  }

  /**
   * 获取捐赠详情.
   *
   * @param contriInfoId 入参
   * @return
   */
  @Override
  public ContriInfoTb getContriInfoDetail(Long contriInfoId) {
    return contriInfoTbMapper.selectByPrimaryKey(contriInfoId);
  }

  /**
   * 捐赠信息补全方法.
   *
   * @param contriInfoTb 入参
   */
  private void contriDefaultParamUtil(ContriInfoTb contriInfoTb){
    contriInfoTb.setIsDelete(0);
    contriInfoTb.setContriTime(System.currentTimeMillis()/1000);
    contriInfoTb.setCreateTime(System.currentTimeMillis()/1000);
  }
}
