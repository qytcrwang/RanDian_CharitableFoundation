package com.fire.back.service;

import com.fire.back.entity.ContriProtocolTb;

/**
 * 用户捐赠协议相关Service.
 *
 * @author 高俊
 * @since 2020/4/10 18:34
 */

public interface ContriProtocolService {
  /**
   * 用户捐赠协议信息提交
   *
   * @param contriProtocolTb 入参
   * @return
   */
  boolean saveContriProtocolTb(ContriProtocolTb contriProtocolTb);

  /**
   * 用户捐赠协议信息更新.
   *
   * @param contriProtocolTb 入参
   * @return
   */
  Boolean updateContriProtocolStatus(ContriProtocolTb contriProtocolTb);

}
