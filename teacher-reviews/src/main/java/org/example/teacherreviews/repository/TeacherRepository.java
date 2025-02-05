package org.example.teacherreviews.repository;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.example.teacherreviews.DAO.TeacherDAO;
import org.example.teacherreviews.DAO.UniversityDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherDAO, Integer> {

    @NonNull
    TeacherDAO findById(int id);

    @NonNull
    List<TeacherDAO> findAll();

    @NonNull
    TeacherDAO findByUniversity(UniversityDAO university);

    @NonNull
    <S extends TeacherDAO> S save(@NonNull S teacher);

    @Query(value = "UPDATE teachers SET traits = CAST(:traits AS json) WHERE id = :id", nativeQuery = true)
    @Modifying
    @Transactional
    void updateTraitsById(@Param("traits") String traits, @Param("id") int id);

    @Transactional
    void deleteById(int id);

    @Override
    boolean existsById(@NonNull Integer id);
}
