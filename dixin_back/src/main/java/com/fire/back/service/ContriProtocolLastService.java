package com.fire.back.service;

import com.fire.back.entity.ContriProtocolLastTb;

/**
 * 用户捐赠协议最近一次信息Service.
 *
 * @author 高俊
 * @since 2020/4/10 18:34
 */

public interface ContriProtocolLastService {
  /**
   * 用户捐赠协议最近一次信息提交
   *
   * @param contriProtocolLastTb 入参
   * @return
   */
  boolean saveContriProtocolLastTb(ContriProtocolLastTb contriProtocolLastTb);

  /**
   * 用户捐赠协议最近一次信息更新.
   *
   * @param contriProtocolLastTb 入参
   * @return
   */
  Boolean updateContriProtocolLast(ContriProtocolLastTb contriProtocolLastTb);

  /**
   * 根据用户id获取最近一次的协议信息
   */
  ContriProtocolLastTb getLastInfoByUserId(Long userId);
}
