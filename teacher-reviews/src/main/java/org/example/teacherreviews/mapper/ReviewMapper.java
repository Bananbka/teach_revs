package org.example.teacherreviews.mapper;

import org.example.teacherreviews.DAO.ReviewDAO;
import org.example.teacherreviews.DTO.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review toDTO(ReviewDAO reviewDAO);
    ReviewDAO toDAO(Review review);
}
