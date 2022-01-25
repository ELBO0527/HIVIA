package com.example.hibia.repository;

import com.example.hibia.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByPublished(boolean published);

    List<Post> findByTitleContaining(String title);
}