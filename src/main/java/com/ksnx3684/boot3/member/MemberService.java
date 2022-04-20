package com.ksnx3684.boot3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksnx3684.boot3.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private FileManager fileManager;
	
	public int join(MemberVO memberVO , MultipartFile multipartFile) throws Exception{
		int result = memberMapper.join(memberVO);
		
		// 1. 파일을 로컬에 저장
		String fileName = fileManager.fileSave(multipartFile, "resources/upload/member/");
		
		// 2. 정보를 DB에 저장
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFileName(fileName);
		memberFilesVO.setOriName(multipartFile.getOriginalFilename());
		memberMapper.joinFile(memberFilesVO);
		
		return result;
	}
	
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberMapper.login(memberVO);
	}
	
	public MemberVO mypage(MemberVO memberVO) throws Exception{
		return memberMapper.mypage(memberVO);
	}
	
	public int mypageUpdate(MemberVO memberVO) throws Exception{
		return memberMapper.mypageUpdate(memberVO);
	}
	
	public int withdrawal(MemberVO memberVO) throws Exception{
		return memberMapper.withdrawal(memberVO);
	}
}
