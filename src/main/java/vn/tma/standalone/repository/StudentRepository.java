package vn.tma.standalone.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import vn.tma.standalone.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
    StudentEntity findByEmail(String email);
    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM StudentEntity s " +
            "WHERE s.email = ?1")
    Boolean selectExistsEmail(String email);
}
