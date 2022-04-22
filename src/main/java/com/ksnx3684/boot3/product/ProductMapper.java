package com.ksnx3684.boot3.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ksnx3684.boot3.util.Pager;

@Mapper
public interface ProductMapper {

	// list
	public List<ProductVO> list(Pager pager) throws Exception;
	
	// totalCount
	public Long totalCount(Pager pager) throws Exception;
	
	// add
	public int add(ProductVO productVO) throws Exception;
	
	// addFile
	public int addFile(ProductFilesVO productFilesVO) throws Exception;
	
	// detail
	public ProductVO detail(ProductVO productVO) throws Exception;
}
