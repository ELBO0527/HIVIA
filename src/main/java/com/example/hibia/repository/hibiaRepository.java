package com.example.hibia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibia.domain.BoardDto;

public interface hibiaRepository extends JpaRepository<BoardDto, Long>{
	List<BoardDto> findByTitleContaining(String title);
}
