package com.ruiyang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ruiyang.interceptor.RequestInterceptor;

@Configuration
public class RequestWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns 用于添加拦截规则
	    // excludePathPatterns 用户排除拦截
		//addPathPatterns("/**")对所有请求都拦截，但是排除了/others和/login请求的拦截
	    registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/*").excludePathPatterns("/login","/others");
		super.addInterceptors(registry);
	}
}
