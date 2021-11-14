package com.example.hibia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.hibia.domain.BoardDto;

@Mapper
public interface BoardMapper {

	public int insertBoard(BoardDto params);

	public BoardDto selectBoardDetail(Long idx);

	public int updateBoard(BoardDto params);

	public int deleteBoard(Long idx);

	public List<BoardDto> selectBoardList();

	public int selectBoardTotalCount();

}