package com.ksnx3684.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ksnx3684.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public ModelAndView list(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<ProductVO> list = productService.list(pager);
		mv.addObject("product", list);
		mv.addObject("pager", pager);
		mv.setViewName("product/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView add() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("product/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView add(ProductVO productVO, MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		for(MultipartFile f : files) {
			System.out.println(f.getOriginalFilename());
			System.out.println(f.getSize());
		}
		
		int result = productService.add(productVO, files);
		
		mv.addObject("result", result);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView detail(ProductVO productVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		productVO = productService.detail(productVO);
		
		mv.addObject("productDetail", productVO);
		mv.setViewName("product/detail");
		
		return mv;
	}
	
	@GetMapping("ajaxList")
	public ModelAndView ajaxList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<ProductVO> list = productService.list(pager);
		
		mv.addObject("ajaxList", list);
		mv.addObject("pager", pager);
		mv.setViewName("common/productList");
		
		return mv;
	}
}
