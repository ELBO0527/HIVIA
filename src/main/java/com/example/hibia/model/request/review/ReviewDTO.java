package com.example.hibia.model.request.review;

import lombok.Data;

@Data
public class ReviewDTO {

    private String author;
    private String content;
    private int stars;
}
