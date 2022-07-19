package com.example.hibia.service;


import com.example.hibia.advice.exception.CNotOwnerException;
import com.example.hibia.advice.exception.CResourceNotExistException;
import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.Item;
import com.example.hibia.domain.Review;
import com.example.hibia.domain.User;
import com.example.hibia.dto.ReviewDTO;
import com.example.hibia.repository.ReviewRepository;
import com.example.hibia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ItemService itemService;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public List<Review> findAllReviews(String itemName){
        return reviewRepository.findByItem(itemService.findItem(itemName));
    }

    public Review findReview(long id){
        return reviewRepository.findById(id).orElseThrow(CResourceNotExistException::new);
    }

    public Review writeReview(String name, String email, ReviewDTO reviewDTO){
        Item item = itemService.findItem(name);
        Review review = new Review(userRepository.findByUsername(email).orElseThrow(CUserNotFoundException::new),item,
                reviewDTO.getAuthor(), reviewDTO.getContent(), reviewDTO.getStars());

        return reviewRepository.save(review);
    }

    public Review updateReview(long id, String uid, ReviewDTO reviewDTO){
        Review review = findReview(id);
        User user = review.getUser();
        if(!uid.equals(user.getEmail()))
            new CNotOwnerException();

        review.setReview(reviewDTO.getAuthor(), reviewDTO.getContent(), reviewDTO.getStars());

        return review;
    }

    public boolean DeleteReview(long id,String uid){
        Review review = findReview(id);
        User user = review.getUser();
        if(!uid.equals(user.getEmail()))
            new CNotOwnerException();
        reviewRepository.delete(review);
        return true;
    }
}
