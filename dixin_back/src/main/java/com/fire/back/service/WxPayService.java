package com.fire.back.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

public interface WxPayService {

    public JSONObject createUnifiedOrder(HttpServletRequest request,String openid, String amount);
}
