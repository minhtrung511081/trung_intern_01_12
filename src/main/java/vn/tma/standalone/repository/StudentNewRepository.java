package vn.tma.standalone.repository;

import vn.tma.standalone.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentNewRepository extends BaseRepository<StudentEntity, Long> {
    public Optional<StudentEntity> findStudentByEmail(String email);

    public List<StudentEntity> getAllBy();
}
