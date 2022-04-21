package com.ksnx3684.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksnx3684.boot3.util.FileManager;
import com.ksnx3684.boot3.util.Pager;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BoardVO> getList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makeNum(boardMapper.getTotalCount(pager));
		
		return boardMapper.getList(pager);
	}
	
	public int setAdd(BoardVO boardVO, MultipartFile [] files) throws Exception{
		System.out.println("Insert 전 : " + boardVO.getNum());
		int result = boardMapper.setAdd(boardVO);
		System.out.println("Insert 후 : " + boardVO.getNum());
		
		if(files != null) {
			
			for(MultipartFile mf : files) {
				
				if(mf.isEmpty()) {
					continue;
				}
				
				// 1. File을 로컬디스크에 저장
				String fileName = fileManager.fileSave(mf, "resources/upload/board/");
				System.out.println(fileName);
				
				// 2. 저장된 정보를 로컬디스크에 저장
				BoardFilesVO boardFilesVO = new BoardFilesVO();
				boardFilesVO.setNum(boardVO.getNum());
				boardFilesVO.setFileName(fileName);
				boardFilesVO.setOriName(mf.getOriginalFilename());
				
				result = boardMapper.setFileAdd(boardFilesVO);
				
			}
		}
		
		
		return result;
	}
	
	public BoardVO getDetail(BoardVO boardVO) throws Exception{
		
		return boardMapper.getDetail(boardVO);
	}
	
	public int setUpdate(BoardVO boardVO) throws Exception{
		return boardMapper.setUpdate(boardVO);
	}
	
	public int setDelete(BoardVO boardVO) throws Exception{
		
		List<BoardFilesVO> list = boardMapper.getFileList(boardVO);
		
		int result = boardMapper.setDelete(boardVO);
		
		for(BoardFilesVO f : list) {
			fileManager.fileRemove("resources/upload/board", f.getFileName());
		}
		
		return result;
	}
	
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception{
		return boardMapper.getFileDetail(boardFilesVO);
	}
}
