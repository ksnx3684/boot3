package com.ksnx3684.boot3.product;

import java.util.List;

import lombok.Data;

@Data
public class ProductVO {

	private Long productNum;
	private String productName;
	private Long productPrice;
	private Long productCount;
	private String productDetail;
	private String id;
	private Integer sale;
	
	private List<ProductFilesVO> productFilesVOs;
	
}
