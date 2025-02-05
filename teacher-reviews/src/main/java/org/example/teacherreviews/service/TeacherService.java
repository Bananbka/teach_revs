package org.example.teacherreviews.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DAO.TeacherDAO;
import org.example.teacherreviews.DTO.Teacher;
import org.example.teacherreviews.exceptions.MissingFieldException;
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
    public void update(TeacherDAO teacher) {
        int id = teacher.getId();
        if (repository.existsById(id)) {
            repository.save(teacher);
        } else {
            throw new MissingFieldException("Couldn't update! Teacher with id=" + id + " already exists!");
        }
    }
    public void updateTraitsById(JsonNode traits, int id) {
        if (repository.existsById(id)) {
            repository.updateTraitsById(traits.toString(), id);
        } else {
            throw new MissingFieldException("Couldn't update! Teacher with id=" + id + " already exists!");
        }
    }
}
