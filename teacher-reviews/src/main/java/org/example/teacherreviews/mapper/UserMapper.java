package org.example.teacherreviews.mapper;

import org.example.teacherreviews.DAO.UserDAO;
import org.example.teacherreviews.DTO.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDTO(UserDAO userDAO);
    UserDAO toDAO(User user);
}
