package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.service.ContriInfoService;
import com.fire.back.util.CheckEmptyUtil;
import javax.annotation.Resource;
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
@RequestMapping("wx/contri-info")
public class ContriInfoController {
  @Resource ContriInfoService contriInfoService;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 捐赠信息提交.
   *
   * @return null
   */
  @PostMapping(value = "/save-contri-info")
  public FireResult saveContriInfo(@RequestBody ContriInfoTb contriInfoTb) {
    if (CheckEmptyUtil.isEmpty(contriInfoTb)) {
      return FireResult.build(0, "入参不能为空");
    }
    try {
      contriInfoService.saveContriInfo(contriInfoTb);
      return FireResult.build(1, "数据获取成功", null);
    } catch (Exception e) {
      logger.error("",e);
      return FireResult.build(0, "获取信息失败，请稍后再试");
    }
  }
}
