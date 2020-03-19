package com.fire.back.dto;

import com.fire.back.entity.RentApplyTb;
import lombok.Data;

/**
 * @description   :  rent
 * @author        :  Killian
 * @createDate    :  2020/3/19 10:20 PM
 * @updateUser    :  Killian
 * @updateDate    :  2020/3/19 10:20 PM
 * @updateRemark  :
 * @version       :  1.0
 */
@Data
public class RentListParamsDto extends RentApplyTb {

  private Integer page;

  private Integer limit;

  private Integer offSet;

  public Integer getOffSet(Integer page,Integer limit) {
    offSet = (page-1)*limit;
    return offSet;
  }

}
