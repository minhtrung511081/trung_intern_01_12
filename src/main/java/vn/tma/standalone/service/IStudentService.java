package vn.tma.standalone.service;

import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.entity.StudentEntity;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAll();

    StudentEntity saveTestH2(StudentEntity studentEntity);

//    Object saveEs(Customer customer);

    Object findStudentByEmail(String email);

    StudentDTO editStudent(StudentDTO studentDTO);

    StudentDTO saveStudentReal(StudentDTO studentDTO);

    void deleteStudent(StudentDTO studentDTO);
}
