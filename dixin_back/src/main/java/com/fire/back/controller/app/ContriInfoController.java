package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.ContriProtocolTb;
import com.fire.back.service.ContriInfoService;
import com.fire.back.common.CheckEmptyUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

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
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 捐赠信息提交.
   *
   * @return null
   */
  @PostMapping(value = "/saveContriInfo")
  public FireResult saveContriInfo(@RequestBody ContriInfoTb contriInfoTb) {
    if (CheckEmptyUtil.isEmpty(contriInfoTb)) {
      return FireResult.build(0, "入参不能为空");
    }
    try {
      long infoId = contriInfoService.saveContriInfo(contriInfoTb);
      if(infoId != 0){
          logger.info("已新增捐赠信息，id:"+infoId);
          //新增协议信息
          /*boolean result = contriProtocolService.saveContriProtocolTb(contriProtocolTb);
          if(result){
              return FireResult.build(1, "捐赠成功", null);
          }else{
              return FireResult.build(0, "捐赠信息错误，请稍后再试");
          }*/
          return FireResult.build(0, "提交捐赠信息失败，请稍后再试");
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
