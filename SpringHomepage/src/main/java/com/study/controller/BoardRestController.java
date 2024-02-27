package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.domain.Board;
import com.study.repository.BoardRepository;

@RestController
@RequestMapping("/rest")
public class BoardRestController {

	@Autowired
	BoardRepository boardRepository; // 귀찮아서 service안하고 바로 repository로
	
	/*
	@GetMapping("/boards")
	public List<Board> boardAll() {
		return boardRepository.findAll();		
	}
	*/
	
	/*
	// http://localhost:8080/rest/boards?title=
	@GetMapping("/boards")
	public List<Board> boardAll(@RequestParam(value = "title", required=false) String title) {
		
		if(title == null) {
			return boardRepository.findAll();
		} else {			
			return boardRepository.findByTitle(title);
		}
	}
	*/
	
	// http://localhost:8080/rest/boards?title=제목&content=내용
	@GetMapping("/boards") // parameter가 2개 이상
	public List<Board> boardAll(@RequestParam(value="title", required=false) String title, 
								@RequestParam(value="content", required=false) String content) {

		if(title == null && content == null) {
			return boardRepository.findAll();
		} else {			
			return boardRepository.findByTitleOrContent(title, content);
		}
	}
	
	// update
	@PutMapping("/boards/{bno}")
	public Board replaceBoard(@RequestBody Board newBoard, @PathVariable("bno") Long bno) {
		return boardRepository.findById(bno)
							.map(board -> {
								board.setTitle(newBoard.getTitle());
								board.setContent(newBoard.getContent());
								return boardRepository.save(board);		// update
							})
							.orElseGet(()-> {
								newBoard.setBno(bno);
								return boardRepository.save(newBoard);	// insert
							});
	}
	
	// delete
	@DeleteMapping("/boards/{bno}")
	public void deleteBoard(@PathVariable("bno") Long bno) {
		boardRepository.deleteById(bno);
	}
}