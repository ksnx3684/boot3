package com.ksnx3684.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ksnx3684.boot3.util.FileManager;
import com.ksnx3684.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "board";
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> list = boardService.getList(pager);
		
		mv.addObject("list", list);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public String setAdd(BoardVO boardVO, MultipartFile [] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = boardService.setAdd(boardVO, files);
		
		return "redirect:./list";
	}

	@GetMapping("detail")
	public ModelAndView getDetail(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardVO = boardService.getDetail(boardVO);
		
		mv.addObject("detail", boardVO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@GetMapping("update")
	public String setUpdate(Model model, BoardVO boardVO) throws Exception {
		boardVO = boardService.getDetail(boardVO);
		
		model.addAttribute("dto", boardVO);
		
		return "board/update";
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = boardService.setUpdate(boardVO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardVO boardVO, BoardFilesVO boardFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = boardService.setDelete(boardVO);
		
		result = boardService.setFileDelete(boardVO, boardFilesVO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFilesVO boardFilesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardFilesVO = boardService.getFileDetail(boardFilesVO);
		
		// 속성명은 fileDown 클래스에서 사용하는 이름과 동일하게
		mv.addObject("fileVO", boardFilesVO);
		
		// Bean(클래스)의 이름과 동일하게
		mv.setViewName("fileDown");
		
		return mv;
	}
}
