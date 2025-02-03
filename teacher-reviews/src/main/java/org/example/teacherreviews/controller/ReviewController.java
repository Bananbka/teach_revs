package org.example.teacherreviews.controller;

import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DTO.Review;
import org.example.teacherreviews.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @GetMapping("/reviews")
    public List<Review> all() {
        return service.findAll();
    }


}
