package com.ksnx3684.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ksnx3684.boot3.util.FileManager;
import com.ksnx3684.boot3.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
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
	
	public int update(ProductVO productVO, MultipartFile[] files) throws Exception{
		
		int result = productMapper.update(productVO);
		
		if(files != null) {
			for(MultipartFile multipartFile : files) {
				if(multipartFile.isEmpty()) {
					continue;
				}
				ProductFilesVO productFilesVO = new ProductFilesVO();
				String fileName = fileManager.fileSave(multipartFile, "/resources/upload/product/");
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(multipartFile.getOriginalFilename());
				productFilesVO.setProductNum(productVO.getProductNum());
				result = productMapper.addFile(productFilesVO);
			}
		}
		
		return result;
	}
	
	public int fileDelete(ProductFilesVO productFilesVO) throws Exception{
		
		// DB에서 조회
		productFilesVO = productMapper.fileDetail(productFilesVO);
		
		// HDD에서 삭제
		// boolean result = fileManger.fileDelete(productFilesVO.getFileName(), "/resources/upload/product/");
				
		//DB 삭제
		// if(result) {
		//		productMapper.setFileDelete(productFilesVO);
		// }
		
		int check = productMapper.fileDelete(productFilesVO);
		if(check > 0) {
			boolean result = fileManager.fileRemove("/resources/upload/product/", productFilesVO.getFileName());
		}
		
		return check;
	}
	
	public int delete(ProductVO productVO) throws Exception{
		return productMapper.delete(productVO);
	}
			
}
