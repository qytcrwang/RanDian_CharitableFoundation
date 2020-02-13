package com.fire;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
@Configuration
@ComponentScan("com.fire")
@MapperScan({"com.fire.back.dao"})
@ServletComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * 解决低版本 IE 浏览器 ResponseBody 返回 json 的时候提示下载问题 
	 * @return
	 */
	@Bean
	public FastJsonHttpMessageConverter getFastJsonHttpMessageConverter() {
		//1.需要定义一个convert转换消息的对象;
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		//2处理ie浏览器保存数据时出现下载json数据问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.TEXT_PLAIN);
		//3.在convert中添加配置信息.
		fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
		return fastJsonHttpMessageConverter;
	} 
	
	// 添加Filter注入过滤器，现修改为@WebFilter注解形式注入，见MyFilter
	/*@Bean
	public FilterRegistrationBean httpServletRequestReplacedRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
		registration.setName("myFilter");
		registration.setOrder(1);
		return registration;
	}*/
	
	/**
	 * 设置Session超时时间。
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(1800);	//单位：秒，根据需要进行修改
			}
		};
	}
}
