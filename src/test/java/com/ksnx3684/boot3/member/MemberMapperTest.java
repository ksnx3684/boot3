package com.ksnx3684.boot3.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;

	//@Test
	void joinTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("TEST");
		memberVO.setPw(1L);
		memberVO.setName("NAME");
		memberVO.setEmail("EMAIL");
		memberVO.setPhone("1111");
		int result = memberMapper.join(memberVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void loginTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("TEST");
		memberVO.setPw(1L);
		
		memberVO = memberMapper.login(memberVO);
		
		assertNotNull(memberVO);
	}
	
	//@Test
	void mypageTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("TEST");
		
		memberVO = memberMapper.mypage(memberVO);
		
		assertNotNull(memberVO);		
	}
	
	//@Test
	void mypageUpdateTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("TEST");
		
		memberVO.setName("updateName");
		memberVO.setEmail("updateEmail");
		memberVO.setPhone("updatePhone");
		
		int result = memberMapper.mypageUpdate(memberVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void withdrawalTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("TEST");
		
		int result = memberMapper.withdrawal(memberVO);
		
		assertEquals(1, result);
	}

}
