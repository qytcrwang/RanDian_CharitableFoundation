package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.util.ParamUtil;
import com.fire.back.util.WxUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("/wx/login")
    public FireResult wxLogin(@RequestBody Map<String,Object> paramMap){
        //前端传过来的code
        String userCode = ParamUtil.getString(paramMap,"userCode",null);

        //过滤userCode = null
        if(userCode == null){
            return FireResult.build(0,"登陆异常");
        }
        //使用code换取session_key
        Map<String,Object> wxResult = WxUtils.getSessionKey(userCode);

        if(wxResult == null){
            return FireResult.build(0,"登陆异常");
        }
        //检测获取到的openid在数据库中是否存在

        return null;
    }
}
