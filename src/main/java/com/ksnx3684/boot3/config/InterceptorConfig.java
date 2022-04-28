package com.ksnx3684.boot3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ksnx3684.boot3.interceptor.AdminInterceptor;
import com.ksnx3684.boot3.interceptor.BoardInterceptor;
import com.ksnx3684.boot3.interceptor.SellerInterceptor;
import com.ksnx3684.boot3.interceptor.WriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private SellerInterceptor sellerInterceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Autowired
	private BoardInterceptor boardInterceptor;

	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 적용할 Interceptor를 등록
		registry.addInterceptor(sellerInterceptor)
		// Interceptor를 사용할 URL을 메서드 체이닝으로 추가
				.addPathPatterns("/product/manage")
				.addPathPatterns("/product/add");
		// 제외할 URL
		//		.excludePathPatterns("")
		
		// 추가로 다른 Interceptor 등록
		registry.addInterceptor(adminInterceptor)
				.addPathPatterns("/admin/manage");
		
		registry.addInterceptor(boardInterceptor)
				.addPathPatterns("/board/*")
				.excludePathPatterns("/board/list");
		
		registry.addInterceptor(writerCheckInterceptor)
				.addPathPatterns("/board/update")
				.addPathPatterns("/board/delete");
		
	}
	
}
