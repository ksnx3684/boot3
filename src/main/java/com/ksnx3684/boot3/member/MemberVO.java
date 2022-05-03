package com.ksnx3684.boot3.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {

	@NotBlank
	private String id;
	private String checkId;
	@Size(min = 3, max = 12, message = "pw는 3글자 이상 12글자 이하입니다")
	private String pw;
	private String checkPw;
	@NotBlank
	private String name;
	@Email(message = "이메일을 형식에 맞게 입력하세요")
	@NotBlank
	private String email;
	@NotBlank(message = "전화번호를 입력하세요")
	private String phone;
	
	private MemberFilesVO memberFilesVO;
	
	private List<RoleVO> roleVOs;
	
}
