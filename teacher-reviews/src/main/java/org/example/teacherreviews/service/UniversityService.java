package org.example.teacherreviews.service;

import lombok.RequiredArgsConstructor;
import org.example.teacherreviews.DAO.UniversityDAO;
import org.example.teacherreviews.DTO.University;
import org.example.teacherreviews.mapper.UniversityMapper;
import org.example.teacherreviews.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityRepository repository;

    public void save(UniversityDAO universityDAO) {
        repository.save(universityDAO);
    }

    public List<University> findAll() {
        return repository.findAll().stream()
                .map(UniversityMapper.INSTANCE::toDTO)
                .toList();
    }
}
