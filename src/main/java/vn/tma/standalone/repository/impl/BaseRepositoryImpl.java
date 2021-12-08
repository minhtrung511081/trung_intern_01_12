package vn.tma.standalone.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import vn.tma.standalone.entity.QStudentEntity;
import vn.tma.standalone.repository.BaseRepository;

import javax.persistence.EntityManager;

public class BaseRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {
    EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    protected  final QStudentEntity studentEntity = QStudentEntity.studentEntity;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em=em;
        this.jpaQueryFactory=new JPAQueryFactory(em);
    }

    @Override
    public T findByIdMandatory(ID id) throws IllegalArgumentException {
        return findById(id)
                .orElseThrow(()->new IllegalArgumentException("entity not found with id "+id));
    }
}
