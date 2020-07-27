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
import java.util.SortedMap;
import java.util.TreeMap;

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
        //生成订单号
        String orderNo = WxUtils.createOrderNo();

        logger.info("【小程序支付】统一下单开始，订单编号:"+orderNo);

        //查询用户信息
        UserTb user = userTbMapper.selectByPrimaryKey(userId);
        if(null == user || StringUtils.isEmpty(user.getOpenId())){
            return FireResult.build(0,"用户不存在",null);
        }
        String openid = user.getOpenId();
        try{
            //调用微信统一下单接口
            Map<String,String> resMap = wxUnifieldOrder(amount,openid,orderNo);
            //获取请求结果
            String returnCode = (String)resMap.get("return_code");
            //保存请求记录
            this.addTradeInfo(orderNo,amount,userId,openid,returnCode);

            //给移动端返回参数
            SortedMap<String,String> response = new TreeMap<>();
            if(WxConstant.SUCCESS.equals(returnCode) && WxConstant.SUCCESS.equals(resMap.get("result_code"))){
                response.put("appId",WxConstant.appid);
                response.put("timeStamp",new Long(System.currentTimeMillis()).toString());
                response.put("nonceStr",WxUtils.getRandomStringByLength(32));
                response.put("package","prepay_id="+resMap.get("prepay_id"));
                response.put("signType","MD5");
                response.put("sign",WxUtils.createSign(response,WxConstant.mchkey));
                response.put("returnCode","SUCCESS");
                response.put("returnMsg","OK");
                logger.info("【小程序支付】统一下单成功，返回参数：" + response);
                return FireResult.build(1,"统一下单成功",response);
            }else{
                //请求失败
                return FireResult.build(0,"统一下单失败",null);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 微信小程序支付-统一下单
     * @param payAmount     支付金额
     * @param openid        用户的openid
     * @param orderNo       订单号
     * @return
     * @throws Exception
     */
    private Map<String,String> wxUnifieldOrder(String payAmount,String openid,String orderNo) throws Exception{
        //封装参数
        SortedMap<String,String> paramMap = new TreeMap<>();
        paramMap.put("appid",WxConstant.appid);
        paramMap.put("mch_id",WxConstant.mchid);
        paramMap.put("nonce_str",WxUtils.getRandomStringByLength(32));
        paramMap.put("body",WxConstant.companyName);
        paramMap.put("out_trade_no",orderNo);
        paramMap.put("total_fee",WxUtils.changeY2F(payAmount));
        paramMap.put("spbill_create_ip",WxUtils.getLocalIp());
        paramMap.put("notify_url",WxConstant.notifyUrl);
        paramMap.put("trade_type",WxConstant.tradeType);
        paramMap.put("openid",openid);
        //设置签名
        paramMap.put("sign",WxUtils.createSign(paramMap,WxConstant.mchkey));
        //将参数转化成xml格式
        String xmlParam = WxUtils.mapToXml(paramMap);
        //请求微信后台  获取预支付id
        String result = WxUtils.httpRequest(WxConstant.payUrl,"POST",xmlParam);
        logger.info("【微信支付】 统一下单请求结果：" + result);
        //返回map结果
        return WxUtils.xmlToMap(result);
    }

    /**
     * 保存微信支付下单记录
     * @param orderNo
     * @param payAmount
     * @param userId
     * @param openid
     * @param returnCode
     * @return
     */
    private int addTradeInfo(String orderNo,String payAmount,Long userId,String openid,String returnCode){
        WxPayTrade tradeInfo = new WxPayTrade();
        tradeInfo.setUserId(userId);
        tradeInfo.setOutTradeNo(orderNo);
        tradeInfo.setOpenId(openid);
        tradeInfo.setTotalFee(payAmount);
        tradeInfo.setStatus(returnCode);
        tradeInfo.setCreateTime(System.currentTimeMillis()/1000);
        return wxPayTradeMapper.insertSelective(tradeInfo);
    }
}
