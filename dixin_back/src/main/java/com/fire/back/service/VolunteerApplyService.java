package com.fire.back.service;

import com.fire.back.common.FireResult;
import com.fire.back.dto.ContriInfoListParamsDto;
import com.fire.back.dto.ContriInfoResultDto;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.VolunteerApplyTb;

import java.util.List;

/**
 * 义工申请相关Service.
 *
 * @author 高俊
 * @since 2020/7/29 18:34
 */

public interface VolunteerApplyService {
  /**
   * 义工申请信息提交.
   *
   * @param volunteerApplyTb 入参
   * @return
   */
  boolean saveVolunteerApply(VolunteerApplyTb volunteerApplyTb);

  VolunteerApplyTb getVolunteerInfoByUserId(Long userId);

}
