package com.fire.back.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fire.back.common.FireResult;
import com.fire.back.constant.WxConstant;
import com.fire.back.dao.UserTbMapper;
import com.fire.back.dao.WxPayTradeMapper;
import com.fire.back.entity.UserTb;
import com.fire.back.entity.WxPayTrade;
import com.fire.back.service.WxPayService;
import com.fire.back.util.StringUtils;
import com.fire.back.util.WxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxPayServiceImpl implements WxPayService {

    private Logger logger = LoggerFactory.getLogger(WxPayServiceImpl.class);

    @Autowired
    WxPayTradeMapper wxPayTradeMapper;
    @Autowired
    UserTbMapper userTbMapper;
    /**
     * 微信支付step1 创建order
     * @param userId
     * @param amount 订单金额
     * @return
     */
    @Override
    public FireResult createUnifiedOrder(HttpServletRequest request, Long userId, String amount) {
        //查询用户信息
        UserTb user = userTbMapper.selectByPrimaryKey(userId);
        if(null == user || StringUtils.isEmpty(user.getOpenId())){
            return FireResult.build(0,"用户不存在",null);
        }
        String openid = user.getOpenId();
        try{
            //生成32位随机字符串
            String nonceStr = WxUtils.getRandomStringByLength(32);
            //设置商品名称
            String body = new String(WxConstant.title.getBytes("ISO-8859-1"),"UTF-8");
            //获取本机ip地址
            String spbillCreateIp = WxUtils.getLocalIp(request);
            //创建订单号
            String orderNo = WxUtils.createOrderNo();
            //转换订单金额单位为分
            String totalFee = WxUtils.changeY2F(amount);

            Map<String,String> stParam = new HashMap<>();
            stParam.put("appid",WxConstant.appid);
            stParam.put("mchid",WxConstant.mchid);
            stParam.put("nonce_str",nonceStr);
            stParam.put("body",body);
            stParam.put("out_trade_no",orderNo);
            stParam.put("total_fee",amount);
            stParam.put("spbill_create_ip",spbillCreateIp);
            stParam.put("notify_url",WxConstant.notifyUrl);
            stParam.put("trade_type",WxConstant.tradeType);
            stParam.put("openid",openid);

            //出去数组中的空参数和签名参数
            stParam = WxUtils.paramFilter(stParam);
            String preStr = WxUtils.createLinkString(stParam);

            //运用MD5生成签名
            String stSign = WxUtils.sign(preStr,WxConstant.mchkey,"utf-8").toUpperCase();
            logger.info("============第一次签名：" + stSign + "===============");
            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml version='1.0' encoding='gbk'>" + "<appid>" + WxConstant.appid + "</appid>"
                    + "<body><![CDATA[" + body + "]]></body>"
                    + "<mch_id>" + WxConstant.mchid + "</mch_id>"
                    + "<nonce_str>" + nonceStr + "</nonce_str>"
                    + "<notify_url>" + WxConstant.notifyUrl + "</notify_url>"
                    + "<openid>" + openid + "</openid>"
                    + "<out_trade_no>" + orderNo + "</out_trade_no>"
                    + "<spill_create_ip>" + spbillCreateIp+ "</spill_create_ip>"
                    + "<total_fee>" + totalFee + "</total_fee>"
                    + "<trade_type>" + WxConstant.tradeType+ "</trade_type>"
                    + "<sign>" + stSign + "</sign>"
                    + "</xml>";
            logger.info("调用统一下单接口，请求参数xml:" + xml);
            //发起统一下单请求，并接受返回的结果
            String result = WxUtils.httpRequest(WxConstant.payUrl,"POST",xml);
            logger.info("调用统一下单接口，返回结果xml:" + result);
            //将返回结果存在map中
            Map map = WxUtils.xmlToMap(result);
            //获取请求结果
            String returnCode = (String)map.get("return_code");
            //保存请求结果
            WxPayTrade tradeInfo = new WxPayTrade();
            tradeInfo.setUserId(userId);
            tradeInfo.setOutTradeNo(orderNo);
            tradeInfo.setOpenId(openid);
            tradeInfo.setSpbillCreateIp(spbillCreateIp);
            tradeInfo.setTotalFee(totalFee);
            tradeInfo.setStSign(stSign);
            tradeInfo.setNonceStr(nonceStr);
            tradeInfo.setStatus(returnCode);
            tradeInfo.setCreateTime(System.currentTimeMillis()/1000);

            //给移动端返回参数
            Map<String,Object> response = new HashMap<>();
            if(WxConstant.SUCCESS.equals(returnCode)){
                //获取交易结果
                String resultCode = (String)map.get("result_code");
                tradeInfo.setResultCode(resultCode);
                if(WxConstant.SUCCESS.equals(resultCode)){
                    //获取预订单信息
                    String prepayId = (String)map.get("prepay_id");
                    response.put("nonceStr",nonceStr);
                    response.put("package","prepay_id="+prepayId);
                    //需使用String类型的时间戳，否则前端会报错
                    String timestamp = System.currentTimeMillis()/1000 + "";
                    response.put("tiemstamp",timestamp);

                    Map<String,String> ndParam = new HashMap<>();
                    ndParam.put("appid",WxConstant.appid);
                    ndParam.put("nonceStr",nonceStr);
                    ndParam.put("package","prepay_id=" + prepayId);
                    ndParam.put("signType",WxConstant.signType);
                    ndParam.put("timestamp",timestamp);

                    ndParam = WxUtils.paramFilter(ndParam);
                    String ndStr = WxUtils.createLinkString(ndParam);
                    //再次签名
                    String ndSign = WxUtils.sign(ndStr,WxConstant.mchkey,"utf-8").toUpperCase();
                    logger.info("============第二次签名：" + ndSign + "===============");
                    response.put("paySign",ndSign);

                    tradeInfo.setNdSign(ndSign);
                    tradeInfo.setPrepayId(prepayId);
                    return FireResult.build(1,"订单已提交",response);
                }else{
                    //交易错误
                    String errorCode = (String)map.get("error_code");
                    String errorCodeDes = (String)map.get("error_code_des");
                    tradeInfo.setErrorCode(errorCode);
                    tradeInfo.setErrorMsg(errorCodeDes);
                }
            }else{
                //请求失败
                String returnMsg = (String)map.get("return_msg");
                tradeInfo.setReturnMsg(returnMsg);
            }
            wxPayTradeMapper.insertSelective(tradeInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
