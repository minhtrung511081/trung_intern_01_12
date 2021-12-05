package vn.tma.standalone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.tma.standalone.converter.StudentCoverter;
import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.entity.StudentEntity;
import vn.tma.standalone.repository.EsRepository;
import vn.tma.standalone.repository.StudentRepository;
import vn.tma.standalone.service.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCoverter coverter;

    @Autowired
    private EsRepository esRepository;

    @Override
    public Object getAll() {
        Iterable<StudentEntity> entities = studentRepository.findAll();
        List<StudentDTO> dtos = new ArrayList<>();
        for (StudentEntity studentEntity : entities) {
            StudentDTO dto = coverter.toDto(studentEntity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Object save(StudentDTO dto) {
        StudentEntity entity = coverter.toEntity(dto);
        Customer customer = new Customer();
        customer.setName(entity.getName());
        customer.setAddress(entity.getCode());
        StudentEntity  studentEntity=  studentRepository.save(entity);
        customer.setId(String.valueOf(studentEntity.getId()));
        return  esRepository.save(customer);
    }


}
