package com.fire.back.service.impl;

import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.common.CommonUtil;
import com.fire.back.service.ImgService;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class ImgServiceImpl implements ImgService {

  private static final String URL_HTTP = "http://";
  private static final String SERVICE_PORT = "server.port";
  private static final String IMG_DIR = "/images/first/";

  @Override
  public List<String> getImgList() {
    try {
      File cover = ResourceUtils.getFile("classpath:static/images/first");
      File[] files = cover.listFiles();
      List<String> imgList = new ArrayList<>();
      if (CheckEmptyUtil.isNotEmpty(files)) {
        for (File file : files) {
          imgList.add(
              URL_HTTP + InetAddress.getLocalHost().getHostAddress() + ":" + CommonUtil
                  .getValue(SERVICE_PORT) + IMG_DIR + file.getName());
        }
      }
      return imgList;
    } catch (FileNotFoundException | UnknownHostException e) {
      e.printStackTrace();
    }
    return null;
  }
}