package org.example.teacherreviews.controller;

import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DTO.Teacher;
import org.example.teacherreviews.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService service;

    @GetMapping("/teachers")
    public List<Teacher> all() {
        return service.findAll();
    }
}
