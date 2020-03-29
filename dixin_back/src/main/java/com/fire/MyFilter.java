package com.fire;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;

/**
 * 过滤器
 */
// 无需添加@Component注解，在启动类添加@ServletComponentScan注解后，会自动将带有@WebFilter的注解进行注入！
@WebFilter(urlPatterns = "/*", filterName = "myFilter")
// 指定过滤器的执行顺序,值越大越靠后执行
@Order(1)
public class MyFilter implements Filter {
	private static List<String> excludePath = new ArrayList<>();
	static {
		excludePath.add("back/activity/saveImage");//富文本上传
		excludePath.add("back/activity/saveCoverImage");//封面图片上传
	}
	
	@Override
    public void destroy() {
		
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        String uri = ((HttpServletRequest) request).getRequestURI();
//        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        if(ifExclude(uri)) {
        	try {
                chain.doFilter(request, response);
			} catch (Exception e) {
	            PrintWriter out = response.getWriter();
	            response.setContentType("application/json; charset=utf-8");  
	            out.print("{\"code\": 1,\"msg\": \"文件不能超过10240K\" }");
	            out.flush();
			}
            return ;
        }
        if(request instanceof HttpServletRequest) {
            requestWrapper = new RequestWrapper((HttpServletRequest) request);
        }
        //获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        // 在chain.doFiler方法中传递新的request对象
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    	
    }
    
    private boolean ifExclude(String uri) {
    	for(String path : excludePath) {
    		if(uri.endsWith(path)) return true;
    	}
    	return false;
    }
}