package com.example.hibia.repository.review;

import com.example.hibia.domain.Item;
import com.example.hibia.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByItem(Item item);
}
