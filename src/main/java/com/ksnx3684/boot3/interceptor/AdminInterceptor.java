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
public class AdminInterceptor implements HandlerInterceptor{
	
	@Value("${member.role.admin}")
	private String roleName;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = false;
		
		if(request.getSession().getAttribute("auth") != null) {
			
			// 로그인 한 사용자의 ROLE이 ROLE_ADMIN이라면 true, 아니면 false
			MemberVO memberVO = (MemberVO)request.getSession().getAttribute("auth");
			
			for(RoleVO roleVO : memberVO.getRoleVOs()) {
				if(roleVO.getRoleName().equals(roleName)) {
					check = true;
					break;
				}
			}
			
		}
		
		// check가 false면 거절 : servlet 코드 사용
		// check가 true면 통과
		
		if(!check) {
			// redirect : response.sendRedirect("url주소")
			// forward
			
			// mv.addObject("key", value)
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("path", "../");
			
			// mv.setViewName();
			// Controller를 거치지 않았기 때문에 InternalResourcesView를 받을 수 없다
			// WEB-INF/views 경로와 .jsp까지 직접 작성해야한다
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/loginresult.jsp");
			view.forward(request, response);
		}
		
		
		return check;
		
	}	
}
