package com.fire.back.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fire.back.constant.WxConstant;
import com.fire.back.service.WxPayService;
import com.fire.back.util.WxUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxPayServiceImpl implements WxPayService {


    /**
     * 微信支付step1 创建order
     * @param openid
     * @param amount 订单金额
     * @return
     */
    @Override
    public JSONObject createUnifiedOrder(HttpServletRequest request,String openid, String amount) {
        //设置返回结果JSON
        JSONObject resultJson = new JSONObject();
        try{
            //生成32位随机字符串
            String nonceStr = WxUtils.getRandomStringByLength(32);
            //设置商品名称
            String body = new String(WxConstant.title.getBytes("ISO-8859-1"),"UTF-8");
            //获取本机ip地址
            String spbillCreateIp = WxUtils.getLocalIp(request);
            //创建订单号
            String orderNo = WxUtils.createOrderNo();
            Map<String,String> packageParam = new HashMap<>();
            packageParam.put("appid",WxConstant.appid);
            packageParam.put("mchid",WxConstant.mchid);
            packageParam.put("nonce_str",nonceStr);
            packageParam.put("body",body);
            packageParam.put("out_trade_no",orderNo);
            packageParam.put("total_fee",amount);
            packageParam.put("spbill_create_ip",spbillCreateIp);
            packageParam.put("notify_url",WxConstant.notifyUrl);
            packageParam.put("trade_type",WxConstant.tradeType);
            packageParam.put("openid",openid);

            //出去数组中的空参数和签名参数
            packageParam = WxUtils.paramFilter(packageParam);
            String preStr = WxUtils.createLinkString(packageParam);

            //运用MD5生成签名
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
