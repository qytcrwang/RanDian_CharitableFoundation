package com.fire;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * 过滤器
 */
// 无需添加@Component注解，在启动类添加@ServletComponentScan注解后，会自动将带有@WebFilter的注解进行注入！
@WebFilter(urlPatterns = "/*", filterName = "myFilter")
// 指定过滤器的执行顺序,值越大越靠后执行
@Order(1)
public class MyFilter implements Filter {
	@Override
    public void destroy() {
		
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
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
}