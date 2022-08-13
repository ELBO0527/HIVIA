package com.example.hibia.controller;

import com.example.hibia.domain.Cart;
import com.example.hibia.domain.Review;
import com.example.hibia.dto.ReviewDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.service.ItemService;
import com.example.hibia.service.ResponseService;
import com.example.hibia.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final ResponseService responseService;

    @GetMapping("/{itemName}/reviews")
    public ListResult<Review> reviews(@PathVariable String itemName){
        return responseService.getListResult(reviewService.findAllReviews(itemName));
    }

    @PostMapping(value = "/{itemName}")
    public SingleResult postReview(@PathVariable String itemName, @RequestBody ReviewDTO reviewDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        System.out.println(uid);
        return responseService.getSingleResult(reviewService.writeReview(itemName,uid,reviewDTO));
    }

    @GetMapping(value = "/{id}")
    public SingleResult viewReview(@PathVariable Long id){
        return responseService.getSingleResult(reviewService.findReview(id));
    }

    @PutMapping(value = "/{id}")
    public SingleResult updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO){
                                     //@Valid @ModelAttribute ReviewDTO reviewDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        return responseService.getSingleResult(reviewService.updateReview(id,uid,reviewDTO));
    }

    @DeleteMapping(value = "/{id}")
    public CommonResult deleteReview(@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        reviewService.DeleteReview(id,uid);
        return responseService.getSuccessResult();
    }
}