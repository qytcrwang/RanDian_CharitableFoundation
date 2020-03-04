package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.service.ContriInfoService;
import com.fire.back.common.CheckEmptyUtil;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
      Boolean b = contriInfoService.saveContriInfo(contriInfoTb);
      if (b) {
        return FireResult.build(1, "保存成功", null);
      } else {
        return FireResult.build(0, "保存失败，请稍后再试");
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
  @GetMapping(value = "/getSelfContriInfo")
  public FireResult getSelfContriInfo(@RequestParam("userId") Long userId) {
    if (CheckEmptyUtil.isEmpty(userId)) {
      return FireResult.build(0, "入参不能为空");
    }
    try {
      List<ContriInfoTb> resultList = contriInfoService.getSelfContriInfo(userId);
      return FireResult.build(1, "数据获取成功", resultList);
    } catch (Exception e) {
      logger.error("", e);
      return FireResult.build(0, "获取信息失败，请稍后再试");
    }
  }
}
