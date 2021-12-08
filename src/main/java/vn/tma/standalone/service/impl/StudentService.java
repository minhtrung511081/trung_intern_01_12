package vn.tma.standalone.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.tma.standalone.converter.StudentCoverter;
import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.entity.StudentEntity;
import vn.tma.standalone.exception.BadRequestException;
import vn.tma.standalone.repository.CollegeRepository;
import vn.tma.standalone.repository.EsRepository;
import vn.tma.standalone.repository.StudentNewRepository;
import vn.tma.standalone.repository.StudentRepository;
import vn.tma.standalone.service.IStudentService;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class StudentService implements IStudentService {

    private StudentRepository studentRepository;

    private StudentCoverter studentCoverter;

    private CollegeRepository collegeRepository;

    @Autowired
    private StudentNewRepository studentNewRepository;

    @Autowired
    private EsRepository esRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          StudentCoverter studentCoverter,
                          CollegeRepository collegeRepository
                          ) {
        this.studentRepository = studentRepository;
        this.studentCoverter = studentCoverter;
        this.collegeRepository = collegeRepository;
    }

    @Override
    public Object getAll() {
        Iterable<StudentEntity> entities = studentRepository.findAll();
        List<StudentDTO> dtos = new ArrayList<>();
        for (StudentEntity studentEntity : entities) {
            StudentDTO dto = studentCoverter.toDto(studentEntity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public StudentEntity saveTestH2(StudentEntity studentEntity) {
        Boolean existsEmail = studentRepository.selectExistsEmail(studentEntity.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + studentEntity.getEmail() + " taken");
        }
        return  studentRepository.save(studentEntity);
    }


    @Override
    public Object saveEs(Customer customer){
        return esRepository.save(customer);
    }

    @Override
    @Transactional
    public Object findStudentByEmail(String email) {
        Optional<StudentEntity> studentEntity = studentNewRepository.findStudentByEmail(email);
        return studentEntity;
    }

    @Override
    @Transactional
    public StudentDTO saveStudentReal(StudentDTO studentDTO) {
        Boolean existsEmail = studentRepository.selectExistsEmail(studentDTO.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + studentDTO.getEmail() + " taken");
        }
        StudentEntity studentEntity = studentCoverter.toEntity(studentDTO);
        studentEntity.setCollegeid(collegeRepository.findByCode(studentDTO.getCodeCollege()));

        return  studentCoverter.toDto(studentRepository.save(studentEntity));
    }



}
