package com.ksnx3684.boot3.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	// join
	public int join(MemberVO memberVO) throws Exception;
	
	// memberRole
	public int memberRole(Map<String, String> map) throws Exception;
	
	// joinFile
	public int joinFile(MemberFilesVO memberFilesVO) throws Exception;
	
	// login
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	// mypage
	public MemberVO mypage(MemberVO memberVO) throws Exception;
	
	// mypageUpdate
	public int mypageUpdate(MemberVO memberVO) throws Exception;
	
	// withdrawal
	public int withdrawal(MemberVO memberVO) throws Exception;
}
