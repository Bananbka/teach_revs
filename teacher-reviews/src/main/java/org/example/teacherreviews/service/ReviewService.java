package org.example.teacherreviews.service;

import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DTO.Review;
import org.example.teacherreviews.mapper.ReviewMapper;
import org.example.teacherreviews.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;

    public List<Review> findAll() {
        return repository.findAll().stream()
                .map(ReviewMapper.INSTANCE::toDTO)
                .toList();
    }

    public List<Review> findByTeacherId(int teacherId) {
        return repository.findByTeacherId(teacherId).stream()
                .map(ReviewMapper.INSTANCE::toDTO)
                .toList();
    }
}
