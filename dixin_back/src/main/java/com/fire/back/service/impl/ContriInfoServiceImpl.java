package com.fire.back.service.impl;

import com.fire.back.dao.ContriInfoTbMapper;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.ContriInfoTbExample;
import com.fire.back.service.ContriInfoService;
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
    int i = contriInfoTbMapper.insertSelective(contriInfoTb);
    return i == 1;
  }

  @Override
  public Boolean updateContriStatus(ContriInfoTb contriInfoTb) {
    int i = contriInfoTbMapper.updateByPrimaryKeySelective(contriInfoTb);
    return i == 1;
  }

  @Override
  public ContriInfoTb getSelfContriInfo(Long userId) {
    return contriInfoTbMapper.selectByPrimaryKey(userId);
  }
}
