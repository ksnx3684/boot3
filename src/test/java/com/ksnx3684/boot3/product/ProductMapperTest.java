package com.ksnx3684.boot3.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ksnx3684.boot3.util.Pager;

@SpringBootTest
class ProductMapperTest {
	
	@Autowired
	private ProductMapper productMapper;

	//@Test
	void listTest() throws Exception{
		Pager pager = new Pager();
		
		List<ProductVO> list = productMapper.list(pager);
		
		assertNotNull(list);
	}
	
	//@Test
	void addTest() throws Exception{
		ProductVO productVO = new ProductVO();
		
		productVO.setProductName("TEST");
		productVO.setProductPrice(10000L);
		productVO.setProductCount(10L);
		productVO.setProductDetail("TESTDetail");
		
		int result = productMapper.add(productVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void addFileTest() throws Exception{
		ProductFilesVO productFilesVO = new ProductFilesVO();
		
		productFilesVO.setProductNum(1L);
		productFilesVO.setFileName("TEST");
		productFilesVO.setOriName("TEST");
		
		int result = productMapper.addFile(productFilesVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void detailTest() throws Exception{
		ProductVO productVO = new ProductVO();
		productVO.setProductNum(1L);
		
		productVO = productMapper.detail(productVO);
		
		assertNotNull(productVO);
	}

}
