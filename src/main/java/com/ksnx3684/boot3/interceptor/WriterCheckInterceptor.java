package com.ksnx3684.boot3.interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ksnx3684.boot3.board.BoardMapper;
import com.ksnx3684.boot3.board.BoardVO;
import com.ksnx3684.boot3.member.MemberVO;

@Component
public class WriterCheckInterceptor implements HandlerInterceptor{
	
	@Autowired
	private BoardMapper boardMapper;
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("auth");
//		
//		Map<String, Object> map = modelAndView.getModel();
//		
//		BoardVO boardVO = (BoardVO)map.get("dto");
//		
//		if(!boardVO.getWriter().equals(memberVO.getId())) {
//			// modelAndView.setViewName("redirect:./list");
//			modelAndView.addObject("message", "작성자만 가능합니다");
//			modelAndView.addObject("path", "./list");
//			modelAndView.setViewName("common/loginresult");
//		}
//		
//	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String method = request.getMethod();
		System.out.println(method);
		
		String num = request.getParameter("num");
		
		// 작성자와 로그인 한 사용자의 id가 일치하면 통과, 불일치 시 리스트 페이지로 리다이렉트
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Long.parseLong(num));
		boardVO = boardMapper.getDetail(boardVO);
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("auth");
		String user = memberVO.getId();
		
		if(boardVO.getWriter().equals(user)) {
			return true;
		}
		
		request.setAttribute("message", "권한이 없습니다");
		request.setAttribute("path", "../board/list");
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/loginresult.jsp");
		view.forward(request, response);
		
		return false;
	}

}
