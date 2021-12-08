package vn.tma.standalone.service;

import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.entity.StudentEntity;

public interface IStudentService {
    Object getAll();

    StudentEntity saveTestH2(StudentEntity studentEntity);

    Object saveEs(Customer customer);

    Object findStudentByEmail(String email);

    StudentDTO saveStudentReal(StudentDTO studentDTO);
}
