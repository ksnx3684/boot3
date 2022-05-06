package com.ksnx3684.boot3.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

	// list
	public List<CartVO> list(CartVO cartVO) throws Exception;
	
	// add
	public int add(CartVO cartVO) throws Exception;
}
