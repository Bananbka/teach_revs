package org.example.teacherreviews.service;

import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DTO.Teacher;
import org.example.teacherreviews.mapper.TeacherMapper;
import org.example.teacherreviews.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;

    public List<Teacher> findAll() {
        return repository.findAll().stream()
                .map(TeacherMapper.INSTANCE::toDTO)
                .toList();
    }
}
