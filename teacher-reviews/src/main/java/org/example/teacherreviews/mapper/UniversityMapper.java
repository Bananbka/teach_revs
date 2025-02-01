package org.example.teacherreviews.mapper;

import org.example.teacherreviews.DAO.UniversityDAO;
import org.example.teacherreviews.DTO.University;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversityMapper {
    UniversityMapper INSTANCE = Mappers.getMapper(UniversityMapper.class);

    University toDTO(UniversityDAO universityDAO);
    UniversityDAO toDAO(University university);
}
