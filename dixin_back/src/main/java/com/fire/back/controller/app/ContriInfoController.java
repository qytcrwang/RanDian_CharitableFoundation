package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.ContriProtocolLastTb;
import com.fire.back.entity.ContriProtocolTb;
import com.fire.back.service.ContriInfoService;
import com.fire.back.common.CheckEmptyUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.fire.back.service.ContriProtocolLastService;
import com.fire.back.service.impl.ContriProtocolServiceImpl;
import com.fire.back.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 捐赠信息提交相关接口.
 *
 * @author 王凯
 * @since 2020/2/22 18:33
 */
@RestController
@RequestMapping("wx/contriInfo")
public class ContriInfoController {
  @Resource ContriInfoService contriInfoService;
  @Resource ContriProtocolServiceImpl contriProtocolService;
  @Resource ContriProtocolLastService contriProtocolLastService;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 捐赠信息提交.
   *
   * @return null
   */
  @PostMapping(value = "/saveContriInfo")
  public FireResult saveContriInfo(@RequestBody Map<String,Object> paramMap) {
    Long userId = ParamUtil.getLong(paramMap,"userId",null);
    Integer contriType = ParamUtil.getInteger(paramMap,"contriType",-1);
    Double contriAmount = ParamUtil.getDouble(paramMap,"contriAmount");
    if (CheckEmptyUtil.isEmpty(userId)) {
      return FireResult.build(0, "入参不能为空");
    }
    ContriInfoTb contriInfoTb = new ContriInfoTb();
    contriInfoTb.setUserId(userId);
    contriInfoTb.setContriType(contriType);
    contriInfoTb.setContriAmount(new BigDecimal(contriAmount));
    //获取协议数据
    String partyA = ParamUtil.getString(paramMap,"partyA");
    String partyAUnit = ParamUtil.getString(paramMap,"partyAUnit");
    String partyALegal = ParamUtil.getString(paramMap,"partyALegal");
    String partyALink = ParamUtil.getString(paramMap,"partyALink");
    String partyAPosition = ParamUtil.getString(paramMap,"partyAPosition");
    String partyALinkPhone = ParamUtil.getString(paramMap,"partyALinkPhone");
    String userFor = ParamUtil.getString(paramMap,"userFor");
    String partyASignTime = ParamUtil.getString(paramMap,"partyASignTime");
    String partyBSignTime = ParamUtil.getString(paramMap,"partyBSignTime");
    String content = ParamUtil.getString(paramMap,"content");
    String contentComment = ParamUtil.getString(paramMap,"contentComment");
    ContriProtocolTb contriProtocolTb = new ContriProtocolTb();
    contriProtocolTb.setPartyA(partyA);
    contriProtocolTb.setPartyALegal(partyALegal);
    contriProtocolTb.setPartyAUnit(partyAUnit);
    contriProtocolTb.setPartyALink(partyALink);
    contriProtocolTb.setPartyALinkPhone(partyALinkPhone);
    contriProtocolTb.setUserFor(userFor);
    contriProtocolTb.setPartyASignTime(partyASignTime);
    contriProtocolTb.setPartyBSignTime(partyBSignTime);
    contriProtocolTb.setPartyAPosition(partyAPosition);
    contriProtocolTb.setContent(content);
    contriProtocolTb.setContentComment(contentComment);
    try {
      boolean contriInfoResult = contriInfoService.saveContriInfo(contriInfoTb);
      if(contriInfoResult){
          contriProtocolTb.setInfoTbId(contriInfoTb.getId());
          //新增协议信息
          boolean result = contriProtocolService.saveContriProtocolTb(contriProtocolTb);
          //保存最后一次捐赠协议信息
          ContriProtocolLastTb contriProtocolLastTb = new ContriProtocolLastTb();
          contriProtocolLastTb.setUserId(userId);
          contriProtocolLastTb.setPartyA(partyA);
          contriProtocolLastTb.setPartyAPosition(partyAPosition);
          contriProtocolLastTb.setPartyALegal(partyALegal);
          contriProtocolLastTb.setPartyAUnit(partyAUnit);
          contriProtocolLastTb.setPartyALink(partyALink);
          contriProtocolLastTb.setPartyALinkPhone(partyALinkPhone);
          contriProtocolLastTb.setUserFor(userFor);
          if(contriProtocolLastService.getLastInfoByUserId(userId) != null){
              contriProtocolLastService.updateContriProtocolLast(contriProtocolLastTb);
          }else{
              contriProtocolLastService.saveContriProtocolLastTb(contriProtocolLastTb);
          }
          if(result){

              return FireResult.build(1, "捐赠成功", null);
          }else{
              return FireResult.build(0, "捐赠信息错误，请稍后再试");
          }
      }else{
          return FireResult.build(0, "提交捐赠信息失败，请稍后再试");
      }
    } catch (Exception e) {
      logger.error("", e);
      return FireResult.build(0, "保存失败，请稍后再试");
    }
  }

  /**
   * 捐赠状态更新.
   *
   * @return null
   */
  @PostMapping(value = "/updateContriStatus")
  public FireResult updateContriStatus(@RequestBody ContriInfoTb contriInfoTb) {
    if (CheckEmptyUtil.isEmpty(contriInfoTb)) {
      return FireResult.build(0, "入参不能为空");
    }
    try {
      Boolean b = contriInfoService.updateContriStatus(contriInfoTb);
      if (b) {
        return FireResult.build(1, "更新成功", null);
      } else {
        return FireResult.build(0, "更新失败，请稍后再试");
      }
    } catch (Exception e) {
      logger.error("", e);
      return FireResult.build(0, "更新失败，请稍后再试");
    }
  }

    /**
     * 获取用户最后一次协议数据信息
     * @param paramMap
     * @return
     */
  @PostMapping(value = "/getLastProtocolInfo")
  public FireResult getLastProtocolInfo(@RequestBody Map<String,Object> paramMap){
      Long userId = ParamUtil.getLong(paramMap,"userId",-1L);
      if(CheckEmptyUtil.isEmpty(userId)){
          return FireResult.build(0,"入参不能为空");
      }
      ContriProtocolLastTb contriProtocolLastTb = null;
      try {
          contriProtocolLastTb = contriProtocolLastService.getLastInfoByUserId(userId);
          return FireResult.build(1,"协议数据获取成功",contriProtocolLastTb);
      }catch (Exception e){
          logger.error("",e);
          return FireResult.build(0,"获取信息失败，请稍后再试");
      }
  }
  /**
   * 我的捐赠信息查询.
   *
   * @return null
   */
  @PostMapping(value = "/getSelfContriInfo")
  public FireResult getSelfContriInfo(@RequestBody Map<String, Object> paramMap) {
    Long userId = ParamUtil.getLong(paramMap, "userId", -1L);
    Map<String, List<ContriInfoTb>> info = new HashMap<>();
    if (CheckEmptyUtil.isEmpty(userId)) {
      return FireResult.build(0, "入参不能为空");
    }
    try {
      List<ContriInfoTb> ongoingList = contriInfoService.getSelfContriInfoByStatus(userId,0);
      List<ContriInfoTb> completedList = contriInfoService.getSelfContriInfoByStatus(userId,1);
      info.put("ongoingList",ongoingList);
      info.put("completedList",completedList);
      return FireResult.build(1, "数据获取成功", info);
    } catch (Exception e) {
      logger.error("", e);
      return FireResult.build(0, "获取信息失败，请稍后再试");
    }
  }
}
