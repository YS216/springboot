package com.study.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.domain.Board;
import com.study.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;

	public Page<Board> list(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	public Board insert(Board board) {
		return boardRepository.save(board);	
	}

	public Optional<Board> selectDetail(Long bno) {
		return boardRepository.findById(bno)
								.map(board-> {
									board.setCount(board.getCount() + 1);
									return boardRepository.save(board);
								});
		
	}

	public Board update(Board board) {
		// update시에는 영속성안에 board의 정보가 들어 있어야 한다
		Board rboard = boardRepository.findById(board.getBno()).get();
		rboard.setTitle(board.getTitle());
		rboard.setContent(board.getContent());
		
		return boardRepository.save(rboard);
	}
}
