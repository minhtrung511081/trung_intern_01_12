package vn.tma.standalone.repository;

import org.springframework.data.repository.CrudRepository;

import vn.tma.standalone.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

}
