package com.fire.back.service.impl;

import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.common.DateUtil;
import com.fire.back.common.FireResult;
import com.fire.back.constant.ProtocolConstant;
import com.fire.back.dao.ContriInfoTbMapper;
import com.fire.back.dao.ContriProtocolTbMapper;
import com.fire.back.dao.extend.ExtendContriInfoTbMapper;
import com.fire.back.dto.ContriInfoListParamsDto;
import com.fire.back.dto.ContriInfoResultDto;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.ContriInfoTbExample;
import com.fire.back.entity.ContriProtocolTb;
import com.fire.back.service.ContriInfoService;
import com.fire.back.service.ContriProtocolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户捐赠协议相关Service相关实现.
 *
 * @author 高俊
 * @since 2020/4/10 18:35
 */
@Service
public class ContriProtocolServiceImpl implements ContriProtocolService {

  @Resource
  ContriProtocolTbMapper contriProtocolTbMapper;
  @Resource
  ExtendContriInfoTbMapper extendContriInfoTbMapper;

  @Override
  public boolean saveContriProtocolTb(ContriProtocolTb contriProtocolTb) {
      contriProtocolDefaultParamUtil(contriProtocolTb);
    int i = contriProtocolTbMapper.insertSelective(contriProtocolTb);
    return i == 1;
  }

  @Override
  public Boolean updateContriProtocolStatus(ContriProtocolTb contriProtocolTb) {
      contriProtocolTb.setUpdateTime(System.currentTimeMillis() / 1000);
    int i = contriProtocolTbMapper.updateByPrimaryKeySelective(contriProtocolTb);
    return i == 1;
  }

  /**
   * 用户捐赠协议信息补全方法.
   *
   * @param contriProtocolTb 入参
   */
  private void contriProtocolDefaultParamUtil(ContriProtocolTb contriProtocolTb) {
    contriProtocolTb.setIsDelete(0);
    contriProtocolTb.setIsCreatePdf(0);
    contriProtocolTb.setPartyB(ProtocolConstant.PARTYB);
    contriProtocolTb.setPartyBLegal(ProtocolConstant.PARTYB_LEGAL);
    contriProtocolTb.setPartyBLink(ProtocolConstant.PARTYB_LINK);
    contriProtocolTb.setPartyBLinkPhone(ProtocolConstant.PARTYB_LINK_PHONE);
    contriProtocolTb.setPartyBPosition(ProtocolConstant.PARTYB_POSTION);
    contriProtocolTb.setPartyASignTime(DateUtil.parseDateToStr(new Date(),DateUtil.DATE_TIME_FORMAT_YYYY年MM月DD日));
    contriProtocolTb.setPartyBSignTime(DateUtil.parseDateToStr(new Date(),DateUtil.DATE_TIME_FORMAT_YYYY年MM月DD日));
    contriProtocolTb.setCreateTime(System.currentTimeMillis() / 1000);
    contriProtocolTb.setUpdateTime(System.currentTimeMillis() / 1000);
  }
}
