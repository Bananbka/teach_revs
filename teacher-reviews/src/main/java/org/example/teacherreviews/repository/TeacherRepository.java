package org.example.teacherreviews.repository;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.example.teacherreviews.DAO.TeacherDAO;
import org.example.teacherreviews.DAO.TeacherDAO;
import org.example.teacherreviews.DAO.UniversityDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherDAO, Integer> {

    @NonNull
    TeacherDAO findById(int id);

    @NonNull
    List<TeacherDAO> findAll();

    /* Change universityId to int (trouble of API) */
    @NonNull
    TeacherDAO findByUniversity(UniversityDAO university);

    @NonNull
    <S extends TeacherDAO> S save(@NonNull S review);

    @Transactional
    void deleteById(int id);

    @Override
    boolean existsById(@NonNull Integer id);
}
