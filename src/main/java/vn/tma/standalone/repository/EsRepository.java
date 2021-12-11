package vn.tma.standalone.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.entity.StudentEntity;

import java.awt.print.Book;
import java.util.List;

@NoRepositoryBean
public interface EsRepository extends ElasticsearchRepository<Customer,String> {

}
