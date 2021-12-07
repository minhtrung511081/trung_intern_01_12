package vn.tma.standalone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import vn.tma.standalone.entity.CollegeEntity;

public interface CollegeRepository extends JpaRepository<CollegeEntity, Long> {
    CollegeEntity findCollegeEntityByCode(String code);
    CollegeEntity findByCode(String code);
}
