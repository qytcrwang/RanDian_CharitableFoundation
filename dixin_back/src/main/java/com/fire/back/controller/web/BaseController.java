package com.fire.back.controller.web;

import com.alibaba.fastjson.JSONObject;
import com.fire.back.common.FireResult;
import com.fire.back.util.WebUtilsPro;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseController {
    /**
     * 登录认证异常
     */
    //@ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    public String authenticationException(HttpServletRequest request, HttpServletResponse response) {
        if (WebUtilsPro.isAjaxRequest(request)) {
            // 输出JSON
            writeJson(FireResult.build(0,"未登录"), response);
            return null;
        } else {
            return "redirect:/";
        }
    }

    /**
     * 权限异常
     */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
        if (WebUtilsPro.isAjaxRequest(request)) {
            // 输出JSON
            writeJson(FireResult.build(0,"您的权限不足"), response);
            return null;
        } else {
            return "redirect:/err403";
        }
    }

    /**
     * 输出JSON
     * @param response
     * @author SHANHY
     * @create 2017年4月4日
     */
    private void writeJson(Object o, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.write(JSONObject.toJSONString(o));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
