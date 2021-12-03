package vn.tma.standalone.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.entity.StudentEntity;

import java.util.List;

public interface StudentEsRepository extends ElasticsearchRepository<Customer,String> {
    List<Customer> findByName(String name);
}
