package com.example.hibia.controller;

import com.example.hibia.advice.exception.ResourceNotFoundException;
import com.example.hibia.domain.Post;
import com.example.hibia.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String title){
        List<Post> posts = new ArrayList<Post>();

        if ( title == null){
            postRepository.findAll().forEach(posts::add);
        }else{
            postRepository.findByTitleContaining(title).forEach(posts::add);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post){
        Post _post = postRepository.save(new Post(post.getTitle(), post.getContent(), true));
        return new ResponseEntity<>(_post, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> update(@PathVariable("id") Long id,@RequestBody Post post){
        Post _post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no id"+ id));

        _post.setContent(post.getContent());
        _post.setTitle(post.getTitle());
        _post.setPublished(post.isPublished());

        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
