package com.fire.back.util;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Map;

/**
 * 微信工具类
 * create by gao
 */
public class WxUtils {

    //appid
    private final static String appid = "wxff90e7e036f52868";
    //appsecret
    private final static String appSecret = "03bc5adc632d40feb9f74280e0ff8f93";
    private static String loginUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appSecret+"&grant_type=authorization_code&js_code=";

    /**
     * 使用用户code从微信换取sessionKey和openid
     * 返回结果组装成map
     * @param code
     * @return
     */
    public static Map<String,Object> getSessionKey(String code){
        if(StringUtils.isNullOrEmpty(code)){
            loginUrl = loginUrl + code;
            //返回结果map
            Map<String,Object> resultMap = null;
            try{
                //构建client
                HttpClient client = HttpClientBuilder.create().build();
                //构建一个get请求
                HttpGet get = new HttpGet(loginUrl.toString());
                //发送get请求
                HttpResponse res = client.execute(get);
                //获取返回entity
                HttpEntity resEntity = res.getEntity();
                String resContent = EntityUtils.toString(resEntity);
                System.out.println(resContent);
                //把信息封装成JSON
                JSONObject resJson = JSONObject.parseObject(resContent);
                //把信息封装成map
                resultMap = JsonUtils.parseJSON2Map(resJson);
            }catch (Exception e){
                e.printStackTrace();
            }
            return resultMap;
        }else{
            return null;
        }
    }
}
