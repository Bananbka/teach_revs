package org.example.teacherreviews.mapper;

import org.example.teacherreviews.DAO.TeacherDAO;
import org.example.teacherreviews.DTO.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher toDTO(TeacherDAO teacherDAO);
    TeacherDAO toDAO(Teacher teacher);
}
