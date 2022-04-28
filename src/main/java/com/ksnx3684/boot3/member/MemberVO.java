package com.ksnx3684.boot3.member;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {

	private String id;
	private Long pw;
	private String name;
	private String email;
	private String phone;
	
	private MemberFilesVO memberFilesVO;
	
	private List<RoleVO> roleVOs;
	
}
