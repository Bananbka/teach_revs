package org.example.teacherreviews.repository;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.example.teacherreviews.DAO.ReviewDAO;
import org.example.teacherreviews.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDAO, Integer> {

    @NonNull
    ReviewDAO findById(int id);

    @NonNull
    List<ReviewDAO> findAll();

    @NonNull
    ReviewDAO findByUser(UserDAO userId);

    @NonNull
    ReviewDAO findByTeacherId(int teacherId);

    @NonNull
    <S extends ReviewDAO> S save(@NonNull S review);

    @Transactional
    void deleteById(int id);

    @Override
    boolean existsById(@NonNull Integer id);
}
