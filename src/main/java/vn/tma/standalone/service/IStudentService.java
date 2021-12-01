package vn.tma.standalone.service;

import vn.tma.standalone.dto.StudentDTO;

public interface IStudentService {
    Object getAll();

    Object save(StudentDTO dto);
}
