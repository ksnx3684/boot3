package com.ksnx3684.boot3.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ksnx3684.boot3.member.MemberVO;

//@RestController // 모든 메서드에 @ResponseBody가 있으면 이를 생략하고 선언 
@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;

	@GetMapping("/cart/{pn}")
	@ResponseBody
	// 타입을 맞춰야한다. 객체 타입으로는 바로 보낼 수가 없다
	public List<CartVO> list(@PathVariable Long pn, HttpSession session) throws Exception{
	
		System.out.println("PN : " + pn);
		MemberVO memberVO = (MemberVO)session.getAttribute("auth");
		
		CartVO cartVO = new CartVO();
		cartVO.setId(memberVO.getId());
		
		List<CartVO> list = cartService.list(cartVO);
		
		return list;
	}
	
	@DeleteMapping("/cart/{cartNum}")
	public ModelAndView delete(@PathVariable Long cartNum) throws Exception{
		
		System.out.println("cartNum : " + cartNum);
		return null;
	}
	
	@PostMapping("/cart/{productNum}/{count}")
	@ResponseBody
	public int add(HttpSession session, @PathVariable Long productNum, @PathVariable Long count) throws Exception{
		System.out.println("productNum : " + productNum);
		System.out.println("count : " + count);
		
		MemberVO memberVO = (MemberVO)session.getAttribute("auth");
		CartVO cartVO = new CartVO();
		
		cartVO.setId(memberVO.getId());
		cartVO.setProductNum(productNum);
		cartVO.setCount(count);
		
		int result = cartService.add(cartVO);
		System.out.println("result : " + result);
		return result;
	}
}
