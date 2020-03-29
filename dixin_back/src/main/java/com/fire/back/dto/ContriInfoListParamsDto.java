package com.fire.back.dto;

import lombok.Data;

/**
 * 后台获取捐赠列表入参.
 *
 * @author 王凯
 * @since 2020/3/18 14:43
 */
@Data
public class ContriInfoListParamsDto {
  private Long userId;

  private Long contriInfoId;

  private Long startTime;

  private Long endTime;

  private Integer page;

  private Integer limit;

  private Integer offSet;

  private String userName;

  private Integer contriState;

  public Integer getOffSet(Integer page,Integer limit) {
    offSet = (page-1)*limit;
    return offSet;
  }
}
