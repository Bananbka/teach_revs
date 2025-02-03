package org.example.teacherreviews.repository;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.example.teacherreviews.DAO.UniversityDAO;
import org.example.teacherreviews.DAO.UniversityDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityDAO, Integer> {
   
    @NonNull
    UniversityDAO findById(int id);

    @NonNull
    List<UniversityDAO> findAll();

    @NonNull
    UniversityDAO findByRegion(String region);

    @NonNull
    <S extends UniversityDAO> S save(@NonNull S review);

    @Transactional
    void deleteById(int id);

    @Override
    boolean existsById(@NonNull Integer id);
}
