package com.fire.back.dto;

import lombok.Data;

/**
 * 后台获取捐赠列表入参.
 *
 * @author 王凯
 * @since 2020/3/18 14:43
 */
@Data
public class GetcontriInfoListParamsDto {
  private Long userId;

  private Integer currentPage;

  private Integer page;

  private Integer pageSize;
}
