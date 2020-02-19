package com.fire;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	
//	@Bean
//    public LoginInterceptor apiInterceptor(){
//        return new LoginInterceptor();
//    }
	/**
	 * 注册 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 设置拦截的路径、不拦截的路径、优先级等等
		/*registry.addInterceptor(new LoginInterceptor(comPartnerInfoService)).addPathPatterns("/**");*/
		// 跨域设置
		registry.addInterceptor(new ResponseInterceptor()).addPathPatterns("/protocol").addPathPatterns("/logout");
	}

	// 解决中文乱码问题
	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(responseBodyConverter());
		// 这里必须加上加载默认转换器，不然bug玩死人，并且该bug目前在网络上似乎没有解决方案
		// 百度，谷歌，各大论坛等。你可以试试去掉。
		addDefaultHttpMessageConverters(converters);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}

	// 静态资源处理
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
				.addResourceLocations("classpath:/resources/").addResourceLocations("file:" + "./config/");
		super.addResourceHandlers(registry);
	}

}
