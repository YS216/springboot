package com.study.service;

import java.util.List;

import com.study.dto.Board;

public interface BoardService {
	public List<Board> list();
	public Board detailBoard(String no);
	public int totalRecord();
	public int insertBoard(Board board);
	public int deleteBoard(String no);

}
