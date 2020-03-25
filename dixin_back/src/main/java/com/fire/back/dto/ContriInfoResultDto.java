package com.fire.back.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 * 后台获取捐赠列表入参.
 *
 * @author 王凯
 * @since 2020/3/18 14:43
 */
@Data
public class ContriInfoResultDto {
  private Long id;

  private Long userId;

  private String name;

  private BigDecimal contriAmount;

  private String contriThings;

  private Long contriTime;

  private String mobile;

  private String orgName;

  private String orgRName;

  private String contriProof;

  private Integer contriType;

  private Long updateTime;

  private Integer isDelete;

  private Integer contriState;

  private Integer ifStamp;

  private Long createTime;

  private Integer contriValue;
}
