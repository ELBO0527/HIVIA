package com.example.hibia.service.review;


import com.example.hibia.advice.exception.CNotOwnerException;
import com.example.hibia.advice.exception.CResourceNotExistException;
import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.Item;
import com.example.hibia.domain.Review;
import com.example.hibia.domain.User;
import com.example.hibia.model.request.review.ReviewDTO;
import com.example.hibia.repository.review.ReviewRepository;
import com.example.hibia.repository.user.UserRepository;
import com.example.hibia.service.item.ItemService;
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

    public Review writeReview(String itemname, String name, ReviewDTO reviewDTO){
        Item item = itemService.findItem(itemname);
        Review review = new Review(userRepository.findByUsername(name).orElseThrow(CUserNotFoundException::new),item,
                reviewDTO.getAuthor(), reviewDTO.getContent(), reviewDTO.getStars());

        return reviewRepository.save(review);
    }

    public Review updateReview(long id, String uid, ReviewDTO reviewDTO){
        Review review = findReview(id);
        User user = review.getUser();
        if(!uid.equals(user.getEmail()))
            throw new CNotOwnerException();

        review.setReview(reviewDTO.getAuthor(), reviewDTO.getContent(), reviewDTO.getStars());

        return review;
    }

    public boolean DeleteReview(long id,String uid){
        Review review = findReview(id);
        User user = review.getUser();
        if(!uid.equals(user.getEmail()))
            throw new CNotOwnerException();
        reviewRepository.delete(review);
        return true;
    }
}
