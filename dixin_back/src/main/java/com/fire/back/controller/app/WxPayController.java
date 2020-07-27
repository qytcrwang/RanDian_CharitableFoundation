package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.MsgTb;
import com.fire.back.service.WxPayService;
import com.fire.back.service.impl.WxPayServiceImpl;
import com.fire.back.util.ParamUtil;
import com.fire.back.util.WxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * 微信支付相关接口
 * create by gao 2020/06/12
 */
@RestController
@RequestMapping(value = "/wx/pay")
public class WxPayController {

    private Logger logger = LoggerFactory.getLogger(WxPayController.class);

    @Autowired
    private WxPayServiceImpl wxPayService;

    /**
     * 创建微信支付账单
     * @param request
     * @param paramMap
     * @return
     */
    @PostMapping("/createOrder")
    @ResponseBody
    public FireResult createWxPayOrder(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
        try {
            Long userId = ParamUtil.getLong(paramMap, "userid", 0L);
            String amount = ParamUtil.getString(paramMap,"contriAmount","0");
            FireResult result = wxPayService.createUnifiedOrder(request,userId,amount);
            return result;
        } catch (Exception e) {
            logger.error("通知列表获取失败",e);
            return FireResult.build(0, "获取信息失败，请稍后再试");
        }
    }


    @PostMapping("/notify")
    public void notify(HttpServletRequest request, HttpServletResponse response) throws Exception{
        InputStream inputStream =  request.getInputStream();
        //获取请求输入流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        outputStream.close();
        inputStream.close();

        Map<String,String> map = WxUtils.xmlToMap(new String(outputStream.toByteArray(),"utf-8"));
        logger.info("【小程序支付】支付回调参数：" + map);
        //业务处理逻辑
        String resXml = wxPayService.wxNotify(map);
        response.getWriter().println(resXml);
    }
}
