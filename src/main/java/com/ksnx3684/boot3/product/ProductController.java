package com.ksnx3684.boot3.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ksnx3684.boot3.member.MemberVO;
import com.ksnx3684.boot3.util.FileManager;
import com.ksnx3684.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "product";
	}
	
	@GetMapping("list")
	public ModelAndView list(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<ProductVO> list = productService.list(pager);
		mv.addObject("list", list);
		mv.addObject("pager", pager);
		mv.setViewName("product/list");
		
		return mv;
	}
	
	@GetMapping("ajaxList")
	public ModelAndView ajaxList(HttpSession session, Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("auth");
		pager.setId(memberVO.getId());
		
		List<ProductVO> list = productService.list(pager);
		
		mv.addObject("ajaxList", list);
		mv.addObject("pager", pager);
		mv.setViewName("product/ajaxList");
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView add(@ModelAttribute ProductVO productVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("product/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView add(@Valid ProductVO productVO, BindingResult bindingResult, MultipartFile[] files, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("product/add");
			return mv;
		}
		
		MemberVO memberVO = (MemberVO)session.getAttribute("auth");
		productVO.setId(memberVO.getId());
		
		int result = productService.add(productVO, files);
		
//		mv.addObject("result", result);
//		mv.setViewName("common/result");
		mv.setViewName("product/list");
		
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView detail(ProductVO productVO) throws Exception{
		// 모든 구매자가 보는 페이지
		ModelAndView mv = new ModelAndView();
		
		productVO = productService.detail(productVO);
		
		mv.addObject("vo", productVO);
		mv.setViewName("product/detail");
		
		return mv;
	}
	
	
	@GetMapping("manage")
	public ModelAndView manage(HttpSession session, Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("auth");
		pager.setId(memberVO.getId());
		List<ProductVO> list = productService.list(pager);
		
//		System.out.println(list.get(0).getId());
		mv.setViewName("product/manage");
		return mv;
	}
	
	
	@GetMapping("manageDetail")
	public ModelAndView manageDetail(ProductVO productVO) throws Exception{
		// 판매자가 보는 페이지
		ModelAndView mv = new ModelAndView();
		
		productVO = productService.detail(productVO);
		
		mv.addObject("vo", productVO);
		mv.setViewName("product/manageDetail");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView update(ProductVO productVO) throws Exception{
		ModelAndView mv = new ModelAndView();

		productVO = productService.detail(productVO);
		
		mv.addObject("vo", productVO);
		mv.setViewName("product/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView update(ProductVO productVO, MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = productService.update(productVO, files);
		
		if(result > 0) {
			mv.setViewName("redirect:../product/manage");
		} else {
			mv.addObject("message", "업데이트 실패");
			mv.addObject("path", "./manageDetail?productNum="+productVO.getProductNum());
			mv.setViewName("common/loginresult");
		}
		
		return mv;
	}
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(ProductFilesVO productFilesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = productService.fileDelete(productFilesVO);
		
		mv.setViewName("common/result");
		mv.addObject("result", result);
		
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView delete(ProductVO productVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = productService.delete(productVO);
		
		mv.setViewName("redirect:../product/list");
		
		return mv;
	}
	
}
