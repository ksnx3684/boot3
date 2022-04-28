package com.ksnx3684.boot3.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ksnx3684.boot3.member.MemberVO;
import com.ksnx3684.boot3.member.RoleVO;

@Component
public class BoardInterceptor implements HandlerInterceptor{
	
	@Value("${member.role.member}")
	private String roleName;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = false;
		
		if(request.getSession().getAttribute("auth") != null) {
			
			MemberVO memberVO = (MemberVO)request.getSession().getAttribute("auth");
			
			for(RoleVO roleVO : memberVO.getRoleVOs()) {
				if(roleVO.getRoleName().equals(roleName)) {
					check = true;
					break;
				}
			}
			
		}
		
		if(!check) {
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("path", "../member/login");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/loginresult.jsp");
			view.forward(request, response);
		}
		
		return check;
		
	}
}
