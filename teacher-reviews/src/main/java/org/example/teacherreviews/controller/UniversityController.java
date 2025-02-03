package org.example.teacherreviews.controller;

import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DTO.University;
import org.example.teacherreviews.service.UniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService service;

    @GetMapping
    public List<University> all() {
        return service.findAll();
    }
}
