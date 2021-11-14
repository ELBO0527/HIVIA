package com.example.hibia.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibia.domain.BoardDto;
import com.example.hibia.mapper.BoardMapper;
import com.example.hibia.repository.hibiaRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	private hibiaRepository hibiaRepository;
	
	public BoardServiceImpl(hibiaRepository hibiaRepository) {
		this.hibiaRepository = hibiaRepository;
	}
	
	@Transactional
	public void savePost(BoardDto boardDto) {
		return hibiaRepository.save(BoardDto.toEntity()).getId();
	}	
	
}
