package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import org.springframework.web.bind.annotation.GetMapping;
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
  /**
   * 轮播图获取接口.
   *
   * @return null
   */
  @GetMapping(value = "/get-img-list")
  public FireResult getImgList() {
    // todo
    return null;
  }
}
