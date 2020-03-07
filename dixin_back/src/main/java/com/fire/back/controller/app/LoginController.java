package com.fire.back.controller.app;

import com.fire.back.common.FireResult;
import com.fire.back.entity.UserTb;
import com.fire.back.service.UserService;
import com.fire.back.util.ParamUtil;
import com.fire.back.util.WxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * 登陆controller
 * create by gao
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 微信登陆
     * @param paramMap
     * @return
     */
    @PostMapping("/wx/login")
    public FireResult wxLogin(@RequestBody Map<String,Object> paramMap){
        //返回参数
        FireResult result = new FireResult();
        //前端传过来的code
        String userCode = ParamUtil.getString(paramMap,"code",null);
        //过滤userCode = null
        if(userCode == null){
            return FireResult.build(0,"登陆异常");
        }
        //使用code换取session_key
        WxUtils wxUtils = new WxUtils();
        Map<String,Object> wxResult = wxUtils.getSessionKey(userCode);

        if(wxResult == null){
            return FireResult.build(0,"登陆异常");
        }
        //检测获取到的openid在数据库中是否存在
        UserTb user = userService.getUserInfoByOpenId(wxResult.get("openid").toString());
        if(user != null){
            //非第一次登录，不需要开户动作
            result.setData(user);
            result.setMsg("登陆成功");
            result.setStatus(1);
        }else{
            //首次登陆，需要先创建一个user用户
            UserTb newUser = new UserTb();
            newUser.setOpenId(wxResult.get("openid").toString());
            newUser.setRegTime(new Date().getTime());
            newUser.setLoveFund(new Double(0));
            newUser.setLovePoint(0);
            userService.insertUser(newUser);
            result.setStatus(1);
            result.setMsg("登陆成功");
            result.setData(newUser);
        }
        return result;
    }
}
