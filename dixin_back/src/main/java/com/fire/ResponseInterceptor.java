package com.fire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ResponseInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(ResponseInterceptor.class);

	/**
	 * 跨域设置。addHeader的操作放在nginx里边，这里边只处理返回不等于200 OK的特殊情况。
	 *
	 * @param request
	 * @param response
	 */
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//	    httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//	    httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
//	    httpServletResponse.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
	 
	    String method= httpServletRequest.getMethod();
	    if (method.equals("OPTIONS")){
	    	System.out.println(method);
	        httpServletResponse.setStatus(200);
	        return false;
	    }
	    return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
