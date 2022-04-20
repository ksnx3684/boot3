package com.ksnx3684.boot3.member;

import java.lang.reflect.Member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// join form
	@GetMapping("join")
	public ModelAndView join() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/join");
		
		return mv;
	}
	
	// join 기능
	@PostMapping("join")
	public String join(MemberVO memberVO, MultipartFile multipartFile) throws Exception{
		int result = memberService.join(memberVO, multipartFile);
		
		return "redirect:../board/list";
	}
	
	// login form
	@GetMapping("login")
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/login");
		
		return mv;
	}
	
	// login 기능
	@PostMapping("login")
	public String login(Model model, MemberVO memberVO, HttpSession httpSession, HttpServletResponse httpServletResponse) throws Exception{
		
		memberVO = memberService.login(memberVO);
		
		String message = "아이디 또는 비밀번호가 일치하지 않습니다";
		String p = "./login";
		
		if(memberVO != null) {
			httpSession.setAttribute("auth", memberVO);
			message = "로그인 되었습니다";
			p = "../board/list";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", p);
		
		String path = "common/result";
		
		return path;
	}
	
	// logout 기능
	@GetMapping("logout")
	public String logout(HttpSession httpSession) throws Exception{
		httpSession.invalidate();
		
		return "redirect:../";
	}
	
	// mypage form
	@GetMapping("mypage")
	public ModelAndView mypage(MemberVO memberVO, HttpSession httpSession) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		memberVO = (MemberVO)httpSession.getAttribute("auth");
		
		memberVO = memberService.mypage(memberVO);
		
		mv.addObject("mypage", memberVO);
		mv.setViewName("member/mypage");
		
		return mv;
	}
	
	// mypageUpdate form
	@GetMapping("mypageUpdate")
	public ModelAndView mypageUpdate(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/mypageUpdate");
		
		return mv;
	}
	
	// mypageUpdate 기능
	@PostMapping("mypageUpdate")
	public String mypageUpdate(MemberVO memberVO, MultipartFile multipartFile) throws Exception{
		memberVO = new MemberVO(); 
		
		int result = memberService.mypageUpdate(memberVO);
		
		return "redirect:./mypage";
	}
	
	// withdrawal form
	@GetMapping("withdrawal")
	public ModelAndView withdrawal() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/withdrawal");
		
		return mv;
	}
	
	// withdrawal 기능
	@PostMapping("withdrawal")
	public String withdrawal(MemberVO memberVO, HttpSession httpSession) throws Exception{
		int result = memberService.withdrawal(memberVO);
		httpSession.invalidate();
		
		return "redirect:../";
	}
	

}
