package com.example.hibia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hibia.repository.hibiaRepository;

@Controller
public class BoardController {

	@Autowired
	hibiaRepository hibiaRepository;
	
	@GetMapping(value="/help")
	public String BoarwriteForm() {
		return "help";
	}
	
	@GetMapping(value="/help-post")
	public String BoardListForm() {
		return "help-post";
	}
	  
	@PostMapping("/Post")
	public String write(BoardDto boardDto) {
		boardService.savePost(boardDto);
		return "redirect:/";
	}
}
