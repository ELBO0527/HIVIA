package com.example.hibia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibia.domain.Board;

public interface hibiaRepository extends JpaRepository<Board, Long>{
	List<Board> findByTitleContaining(String title);
}
