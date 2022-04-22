package com.ksnx3684.boot3.product;

import com.ksnx3684.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductFilesVO extends FileVO{
	
	private Long productNum;

}
