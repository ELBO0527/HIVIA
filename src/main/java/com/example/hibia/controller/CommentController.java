package com.example.hibia.controller;

import com.example.hibia.advice.exception.ResourceNotFoundException;
import com.example.hibia.domain.Comment;
import com.example.hibia.repository.CommentRepository;
import com.example.hibia.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class CommentController {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> findAll(@PathVariable(value = "postId") Long postId){

        if (!postRepository.existsById(postId)){
            throw new ResourceNotFoundException("Not found"+postId);
        }

        List<Comment> comments = commentRepository.findBypostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> findOne(@PathVariable(value = "id") Long id){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not foudn" + id));

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Comment> create(@PathVariable("postId") Long postId ,@RequestBody Comment commentRequest){
        Comment comment = postRepository.findById(postId).map(post -> {
            commentRequest.setPost(post);
            return commentRepository.save(commentRequest);
        }).orElseThrow(()-> new ResourceNotFoundException("not not " + postId));

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<Comment> update(@PathVariable("id") Long id,@RequestBody Comment commentRequest){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("바보"+id));

        comment.setContent(comment.getContent());

        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Comment> delete(@PathVariable("id") Long id){
        commentRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping("/posts/{postId}/comments")
//        public ResponseEntity<List<Comment>> deleteAll(@PathVariable(value = "postId") Long postId){
//            if(!postRepository.existsById(postId)) {
//                throw new ResourceNotFoundException("not found"+ postId);
//            }
//
//            commentRepository.deleteByTutorialId(postId);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }



}
