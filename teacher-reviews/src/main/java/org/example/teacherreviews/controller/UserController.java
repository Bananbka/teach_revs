package org.example.teacherreviews.controller;

import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DTO.User;
import org.example.teacherreviews.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public List<User> all() {
        return service.findAll();
    }
}
