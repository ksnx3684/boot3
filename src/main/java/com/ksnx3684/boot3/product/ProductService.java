package com.ksnx3684.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksnx3684.boot3.util.FileManager;
import com.ksnx3684.boot3.util.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private FileManager fileManager;

	public List<ProductVO> list(Pager pager) throws Exception{
		pager.makeRow();
		pager.makeNum(productMapper.totalCount(pager));
		
		return productMapper.list(pager);
	}
	
	public int add(ProductVO productVO, MultipartFile[] files) throws Exception{
		
		int result = productMapper.add(productVO);
		
		if(files != null) {
			
			for(MultipartFile mf : files) {
				
				if(mf.isEmpty()) {
					continue;
				}
				
				String fileName = fileManager.fileSave(mf, "resources/upload/product");
				
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(mf.getOriginalFilename());
				
				result = productMapper.addFile(productFilesVO);
				
			}
			
		}
		
		return result;
	}
	
	public ProductVO detail(ProductVO productVO) throws Exception{
		return productMapper.detail(productVO);
	}
}
