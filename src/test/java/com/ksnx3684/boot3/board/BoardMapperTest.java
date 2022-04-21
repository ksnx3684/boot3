package com.ksnx3684.boot3.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ksnx3684.boot3.util.Pager;

@SpringBootTest
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	//@Test
	void detailTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		boardVO = boardMapper.getDetail(boardVO);
		
		System.out.println(boardVO.toString());
		
		assertNotNull(boardVO);
	}
	
	//@Test
	void listTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardVO> list = boardMapper.getList(pager);
		
		assertEquals(10, list.size());
	}
	
	@Test
	void insertTest() throws Exception{
		
		for(int i = 0; i < 100; i++) {
			if(i % 10 == 0) {
				Thread.sleep(1000);
			}
			
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("TEST" + i);
			boardVO.setWriter("TEST" + i);
			boardVO.setContents("TEST" + i);
			
			int result = boardMapper.setAdd(boardVO);
			
		}
		
		System.out.println("Finish");
		
//		assertEquals(1, result);
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
	
	//@Test
	void insertFileTest() throws Exception{
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileName("TEST");
		boardFilesVO.setOriName("TEST");
		boardFilesVO.setNum(3L);
		
		int result = boardMapper.setFileAdd(boardFilesVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void deleteFileTest() throws Exception{
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setNum(3L);
		
		int result = boardMapper.setFileDelete(boardFilesVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void detailFileTest() throws Exception{
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setNum(3L);
		boardFilesVO = boardMapper.getFileDetail(boardFilesVO);
		
		assertNotNull(boardFilesVO);
	}
	
	//@Test
	void listFileTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		List<BoardFilesVO> list = boardMapper.getFileList(boardVO);
		
		assertNotEquals(0, list.size());
	}

}
