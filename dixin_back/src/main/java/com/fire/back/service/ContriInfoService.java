package com.fire.back.service;

import com.fire.back.entity.ContriInfoTb;

/**
 * 捐赠信息相关Service.
 *
 * @author 王凯
 * @since 2020/2/22 18:34
 */

public interface ContriInfoService {
  /**
   * 捐赠信息提交.
   *
   * @param contriInfoTb 入参
   * @return
   */
  Boolean saveContriInfo(ContriInfoTb contriInfoTb);

  /**
   * 捐赠状态更新.
   *
   * @param contriInfoTb 入参
   * @return
   */
  Boolean updateContriStatus(ContriInfoTb contriInfoTb);
}
