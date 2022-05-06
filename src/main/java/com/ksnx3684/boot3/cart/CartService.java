package com.ksnx3684.boot3.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CartService {

	@Autowired
	private CartMapper cartMapper;
	
	public List<CartVO> list(CartVO cartVO) throws Exception{
		return cartMapper.list(cartVO);
	}
	
	public int add(CartVO cartVO) throws Exception{
		return cartMapper.add(cartVO);
	}
}
