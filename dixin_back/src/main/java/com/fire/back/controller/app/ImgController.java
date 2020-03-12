package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.service.ImgService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 轮播图相关接口.
 *
 * @author 王凯
 * @since 2020/2/25 14:56
 */
@RestController
@RequestMapping("wx/img")
public class ImgController {
  @Resource ImgService imgService;

  /**
   * 轮播图获取接口.
   *
   * @return null
   */
  @PostMapping(value = "/getImgList")
  public FireResult getImgList() {
    List<String> imgList = imgService.getImgList();
    return FireResult.build(1, "数据获取成功", imgList);
  }
}
