package com.ksnx3684.boot3.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration // Legacy ***-context.xml 역할
public class MessageConfig implements WebMvcConfigurer{

	@Bean // <bean class=""> 객체 생성
	public LocaleResolver localeResolver() {
		
		// 1. Session을 이용하는 방법
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.KOREAN);
		
		// 2. Cookie를 이용하는 방법
//		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//		cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
//		cookieLocaleResolver.setCookieName("lang");
		
		return sessionLocaleResolver;
		// return cookieLocaleResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		// parameter를 받아서 언어를 구분
		// url?lang=en
		
		return localeChangeInterceptor;
	}
	
}
