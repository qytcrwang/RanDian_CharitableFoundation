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

  /**
   * 捐赠信息提交.
   *
   * @param contriInfoTb 入参
   * @return
   */
  @Override
  public Boolean saveContriInfo(ContriInfoTb contriInfoTb) {
    int i = contriInfoTbMapper.insert(contriInfoTb);
    return i == 1;
  }
}
