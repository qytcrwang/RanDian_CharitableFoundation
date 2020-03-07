package com.fire.back.service;

import com.fire.back.entity.ContriInfoTb;
import java.util.List;

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

  /**
   * 我的捐赠信息查询.
   *
   * @param userId 入参
   * @return
   */
  List<ContriInfoTb> getSelfContriInfo(Long userId);

  /**
   * 我的捐赠信息查询.
   * status 0 待核实
   * status 1 已完成
   * @param userId
   * @param status
   * @return
   */
  List<ContriInfoTb> getSelfContriInfoByStatus(Long userId,int status);

  /**
   * 获取捐赠详情.
   *
   * @param contriInfoId 入参
   * @return
   */
  ContriInfoTb getContriInfoDetail(Long contriInfoId);
}
