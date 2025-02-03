package org.example.teacherreviews.service;

import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DTO.User;
import org.example.teacherreviews.mapper.UserMapper;
import org.example.teacherreviews.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll().stream()
                .map(UserMapper.INSTANCE::toDTO)
                .toList();
    }
}
