package com.ksnx3684.boot3.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void detailTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		boardVO = boardMapper.getDetail(boardVO);
		
		System.out.println(boardVO.toString());
		
		assertNotNull(boardVO);
	}
	
	@Test
	void listTest() throws Exception{
		List<BoardVO> list = boardMapper.getList();
		
		assertNotEquals(0, list.size());
	}
	
	//@Test
	void insertTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("TEST");
		boardVO.setWriter("TEST");
		boardVO.setContents("TEST");
		
		int result = boardMapper.setAdd(boardVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void updateTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("TEST UPDATE");
		boardVO.setContents("TEST UPDATE");
		boardVO.setNum(3L);
		
		int result = boardMapper.setUpdate(boardVO);
				
		assertEquals(1, result);
	}
	
	//@Test
	void deleteTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4L);
		
		int result = boardMapper.setDelete(boardVO);
		
		assertEquals(1, result);
	}

}
