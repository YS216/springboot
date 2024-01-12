package com.study.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> list();
	public Board detailBoard(String no);
	public int totalRecord();
	public int insertBoard(Board board);
	public int deleteBoard(String no);

}
