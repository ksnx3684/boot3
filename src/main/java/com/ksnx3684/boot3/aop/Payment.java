package com.ksnx3684.boot3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Payment {
	
	@Around("execution(* com.ksnx3684.boot3.aop.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		// join point 핵심 로직 메서드(bus, subway)
		System.out.println("탑승 전 카드 체크");
		
		Object obj = joinPoint.proceed();
		// obj는 핵심 로직 메서드가 리턴하는 데이터
		
		System.out.println("하차 시 카드 체크");
		
		return obj;
	}
	
//	@AfterReturning("execution(* com.ksnx3684.boot3.aop.Transfer.*())")
//	public void cardCheck() {
//		System.out.println("===== 카드 체크 =====");
//	}
	
//	@Before("execution(* com.ksnx3684.boot3.board.BoardService.get*(..))")
//	public void before() {
//		System.out.println("===== Before =====");
//	}
//	
//	@After("execution(* com.ksnx3684.boot3.board.BoardService.get*(..))")
//	public void after() {
//		System.out.println("After");
//	}
//	
//	@AfterReturning("execution(* com.ksnx3684.boot3.board.BoardService.get*(..))")
//	public void afterReturning() {
//		System.out.println("AfterReturning");
//	}
//	
//	@AfterThrowing("execution(* com.ksnx3684.boot3.board.BoardService.get*(..))")
//	public void afterTrowing() {
//		System.out.println("afterTrowing");
//	}
	
//	@Around("execution(* com.ksnx3684.boot3.board.BoardService.get*(..))")
//	public void around() {
//		System.out.println("Before + After");
//	}

}
