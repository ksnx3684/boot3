package com.ksnx3684.boot3.member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public ModelAndView join(@ModelAttribute MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/join");
		
		return mv;
	}
	
	// join 기능
	@PostMapping("join")
	public String join(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile multipartFile) throws Exception{
		
//		if(bindingResult.hasErrors()) {
//			return "member/join";
//		}
		
		// 사용자 정의 검증 메서드 호출
		if(memberService.memberError(memberVO, bindingResult)) {
			return "member/join";
		}
		
		int result = memberService.join(memberVO, multipartFile);
		
		return "redirect:../board/list";
	}
	
	// login form
	@GetMapping("login")
	public ModelAndView login(@ModelAttribute MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
//		mv.addObject("vo", new MemberVO());
		mv.setViewName("member/login");
		
		return mv;
	}
	
	// login 기능
	@PostMapping("login")
	public String login(MemberVO memberVO, Model model, HttpSession httpSession, HttpServletResponse httpServletResponse) throws Exception{
		
//		if(bindingResult.hasErrors()) {
//			return "member/login";
//		}
		
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
		
		String path = "common/loginresult";
		
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
	
	@GetMapping("findId")
	public ModelAndView findId() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/findId");
		return mv;
	}
	
	@PostMapping("findId")
	public ModelAndView findId(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.findId(memberVO);
		mv.addObject("find", memberVO);
		mv.setViewName("member/findIdResult");
		return mv;
	}
	

}
