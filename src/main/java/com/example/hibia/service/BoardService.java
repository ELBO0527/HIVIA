package com.example.hibia.service;

import java.util.List;

import com.example.hibia.domain.BoardDTO;

public interface BoardService {
	
	public boolean registerBoard(BoardDTO params);
	
	public BoardDTO getBoardDetail(Long idx);
	
	public boolean deleteBoard(Long idx);
	
	public List<BoardDTO> getBoardList();
}
