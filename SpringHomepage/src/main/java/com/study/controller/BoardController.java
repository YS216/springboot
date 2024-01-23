package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.domain.Board;
import com.study.domain.Member;
import com.study.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	private Member loginUser;	// 현재 페이지에서 모두 사용하기 위해 인스턴스 변수로 선언
	
	@GetMapping("/list")
	public String list(@RequestParam(value="nowPage", defaultValue="0") int nowPage,
						HttpSession session,	// 현재 페이지에서 사용하기 위해
						Model model) 
	{
		if(session.getAttribute("loginUser") != null) {
			loginUser = (Member)session.getAttribute("loginUser");
			model.addAttribute("loginUser", loginUser);
		}
														// PageRequest.of(현재페이지, 페이지당 개수[, sort])
		model.addAttribute("boardPage", boardService.list(PageRequest.of(nowPage, 10))) ;
		model.addAttribute("nowPage", nowPage);
		return "board/list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm(Model model) {
		model.addAttribute("loginUser", loginUser);
		return "board/insertForm";
	}
	
	@PostMapping("/insert")
	// @SessionAttribute("loginUser")는 현재 메소드에서만 사용 가능
	public String insertForm(Board board /* @SessionAttribute("loginUser") Member member */) {
		board.setWriter(loginUser.getId());
		boardService.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam("bno") Long bno, Model model) {
		if(loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		model.addAttribute("board", boardService.selectDetail(bno).get());
		return "board/detailForm";
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		boardService.update(board);
		return "redirect:list";
	}
}