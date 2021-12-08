package vn.tma.standalone.repository.impl;

import vn.tma.standalone.entity.StudentEntity;
import vn.tma.standalone.repository.StudentNewRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class StudentNewRepositoryImpl extends BaseRepositoryImpl<StudentEntity, Long> implements StudentNewRepository {

    public StudentNewRepositoryImpl(EntityManager em) {
        super(StudentEntity.class, em);
    }

    @Override
    public Optional<StudentEntity> findStudentByEmail(String email) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(studentEntity)
                        .from(studentEntity)
                        .where(studentEntity.email.equalsIgnoreCase(email))
                        .fetchFirst());
    }

    @Override
    public List<StudentEntity> getAllBy() {
        return jpaQueryFactory.select(studentEntity)
                .from(studentEntity).fetch();
    }
}
