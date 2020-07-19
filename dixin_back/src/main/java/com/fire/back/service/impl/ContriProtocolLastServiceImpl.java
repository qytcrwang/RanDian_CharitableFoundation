package com.fire.back.service.impl;

import com.fire.back.common.DateUtil;
import com.fire.back.constant.ProtocolConstant;
import com.fire.back.dao.ContriProtocolLastTbMapper;
import com.fire.back.dao.ContriProtocolTbMapper;
import com.fire.back.dao.extend.ExtendContriInfoTbMapper;
import com.fire.back.entity.ContriProtocolLastTb;
import com.fire.back.entity.ContriProtocolTb;
import com.fire.back.service.ContriProtocolLastService;
import com.fire.back.service.ContriProtocolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户捐赠协议最近一次协议信息.
 *
 * @author 高俊
 * @since 2020/4/13 18:35
 */
@Service
public class ContriProtocolLastServiceImpl implements ContriProtocolLastService {

  @Resource
  ContriProtocolLastTbMapper contriProtocolLastTbMapper;

  @Override
  public boolean saveContriProtocolLastTb(ContriProtocolLastTb contriProtocolLastTb) {
      contriProtocolDefaultParamUtil(contriProtocolLastTb);
    int i = contriProtocolLastTbMapper.insertSelective(contriProtocolLastTb);
    return i == 1;
  }

    /**
     * 根据用户id更新最近一次协议数据数据
     * @param contriProtocolLastTb 入参
     * @return
     */
  @Override
  public Boolean updateContriProtocolLast(ContriProtocolLastTb contriProtocolLastTb) {
      contriProtocolLastTb.setUpdateTime(System.currentTimeMillis() / 1000);
    int i = contriProtocolLastTbMapper.updateByUserId(contriProtocolLastTb);
    return i == 1;
  }

    /**
     * 获取用户最近一次协议信息
     * @param userId
     * @return
     */
    @Override
    public ContriProtocolLastTb getLastInfoByUserId(Long userId) {
        return contriProtocolLastTbMapper.selectByUserId(userId);
    }


    /**
   * 用户捐赠协议最近一次信息补全方法.
   *
   * @param contriProtocolLastTb 入参
   */
  private void contriProtocolDefaultParamUtil(ContriProtocolLastTb contriProtocolLastTb) {
    contriProtocolLastTb.setPartyB(ProtocolConstant.PARTYB);
    contriProtocolLastTb.setPartyBLegal(ProtocolConstant.PARTYB_LEGAL);
    contriProtocolLastTb.setPartyBLink(ProtocolConstant.PARTYB_LINK);
    contriProtocolLastTb.setPartyBLinkPhone(ProtocolConstant.PARTYB_LINK_PHONE);
    contriProtocolLastTb.setPartyBPosition(ProtocolConstant.PARTYB_POSTION);
    contriProtocolLastTb.setCreateTime(System.currentTimeMillis() / 1000);
  }
}
