package com.example.hibia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibia.domain.Board;
import com.example.hibia.repository.hibiaRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
	hibiaRepository hibiaRepository;
	
	@GetMapping("/boards")
	  public ResponseEntity<List<Board>> getAllBoards(@RequestParam(required = false) String title) {
			  try {
		      List<Board> boards = new ArrayList<Board>();

		      if (title == null)
		        hibiaRepository.findAll().forEach(boards::add);
		      else
		    	  hibiaRepository.findByTitleContaining(title).forEach(boards::add);

		      if (boards.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(boards, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    };
	  }
	
	@GetMapping("/Board/{id}")
	  public ResponseEntity<Board> getBoradById(@PathVariable("id") long id) {
		 Optional<Board> boardData = hibiaRepository.findById(id);

		    if (boardData.isPresent()) {
		      return new ResponseEntity<>(boardData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }


	  @PostMapping("/Boards")
	  public ResponseEntity<Board> createboard(@RequestBody Board Board) {	
		  try {
		      Board _board = hibiaRepository
		          .save(new Board(Board.getTitle(), Board.getDescription(), false));
		      return new ResponseEntity<>(_board, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  @PutMapping("/Board/{id}")
	  public ResponseEntity<Board> updateTutorial(@PathVariable("id") long id, @RequestBody Board tutorial) {
		  Optional<Board> tutorialData = tutorialRepository.findById(id);

		    if (tutorialData.isPresent()) {
		    	Board _tutorial = tutorialData.get();
		      _tutorial.setTitle(tutorial.getTitle());
		      _tutorial.setDescription(tutorial.getDescription());
		      _tutorial.setPublished(tutorial.isPublished());
		      return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }

	  @DeleteMapping("/Board/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
			    try {
			      tutorialRepository.deleteById(id);
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    } catch (Exception e) {
			      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			    }
	  }

	  @DeleteMapping("/Board")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
		  public ResponseEntity<HttpStatus> deleteAllTutorials() {
			    try {
			      hibiaRepository.deleteAll();
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    } catch (Exception e) {
			      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			    }
	  }
}
