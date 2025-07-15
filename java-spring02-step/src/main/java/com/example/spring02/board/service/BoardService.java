package com.example.spring02.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring02.board.model.dto.BoardVO;

public interface BoardService {
	public void create(BoardVO vo) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public void increaseViewCount(int bno, HttpSession session) throws Exception;
}
