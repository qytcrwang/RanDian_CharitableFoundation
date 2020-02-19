package com.fire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	
	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 为了调试方便，直接返回true
		return true;
	}

	/**
	 * 跨域设置。不再在这里处理，放在ResponseInterceptor拦截器里边单独处理，因为有些接口不进行签名验证，不会走这个过滤器。
	 *
	 * @param request
	 * @param response
	 */
//	private void setResponse(HttpServletRequest request, HttpServletResponse response) {
//		response.setContentType("application/json; charset=utf-8");
//		String originHeader = request.getHeader("Origin");
//		response.setHeader("Access-Control-Allow-Origin", originHeader);
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "0");
//		response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("XDomainRequestAllowed", "1");
//		
//		String method= request.getMethod();
//		if (method.equals("OPTIONS")){
//			response.setStatus(200);
//		}
//	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
//		System.out.println("返回视图或String之前的处理");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("返回视图或String之前的处理");
	}
}
