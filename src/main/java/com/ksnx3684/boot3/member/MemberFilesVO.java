package com.ksnx3684.boot3.member;

import com.ksnx3684.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MemberFilesVO extends FileVO{

	private String id;
	
}
