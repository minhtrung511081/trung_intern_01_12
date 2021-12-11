package vn.tma.standalone.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.tma.standalone.converter.StudentCoverter;
import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.entity.CollegeEntity;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.entity.StudentEntity;
import vn.tma.standalone.exception.BadRequestException;
import vn.tma.standalone.repository.CollegeRepository;
import vn.tma.standalone.repository.StudentNewRepository;
import vn.tma.standalone.repository.StudentRepository;
import vn.tma.standalone.service.IStudentService;

@NoArgsConstructor
@Service
public class StudentService implements IStudentService {

    private StudentRepository studentRepository;

    private StudentCoverter studentCoverter;

    private CollegeRepository collegeRepository;

    private StudentNewRepository studentNewRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public StudentService(StudentRepository studentRepository,
                          StudentCoverter studentCoverter,
                          CollegeRepository collegeRepository,
                          StudentNewRepository studentNewRepository
                          ) {
        this.studentRepository = studentRepository;
        this.studentCoverter = studentCoverter;
        this.collegeRepository = collegeRepository;
        this.studentNewRepository = studentNewRepository;
    }

    @Override
    public List<StudentDTO> getAll() {
        Iterable<StudentEntity> entities = studentRepository.findAll();
        List<StudentDTO> dtos = new ArrayList<>();
        for (StudentEntity studentEntity : entities) {
            StudentDTO dto = modelMapper.map(studentEntity, StudentDTO.class);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Object findStudentByEmail(String email) {
        Optional<StudentEntity> studentEntity = studentNewRepository.findStudentByEmail(email);
        return studentEntity;
    }

    @Override
    public StudentDTO editStudent(StudentDTO studentDTO) {
        CollegeEntity collegeEntity = collegeRepository.findByCode(studentDTO.getCodeCollege());
        if(studentDTO.getId()!=null){
            Optional<StudentEntity> studentEntity = studentRepository.findById(studentDTO.getId());
            studentEntity.get().setCollegeid(collegeEntity);

            StudentEntity newEntity = studentCoverter.toEntity(studentEntity.get(), studentDTO);

            StudentEntity studentEntityResult = studentRepository.save(newEntity);
            return modelMapper.map(studentEntityResult, StudentDTO.class);
        }
        return null;
    }



    @Override
    @Transactional
    public StudentDTO saveStudentReal(StudentDTO studentDTO) {
        Boolean existsEmail = studentRepository.selectExistsEmail(studentDTO.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + studentDTO.getEmail() + " taken");
        }
        StudentEntity studentEntity = modelMapper.map(studentDTO, StudentEntity.class);
        studentEntity.setCollegeid(collegeRepository.findByCode(studentDTO.getCodeCollege()));

        StudentEntity studentEntity1 = studentRepository.save(studentEntity);
        StudentDTO studentDTO1 = modelMapper.map(studentEntity1,StudentDTO.class);
        return  studentDTO1;
    }

    @Override
    public void deleteStudent(StudentDTO studentDTO) {
        List<Long> longs = new ArrayList<>();
        for (Long id: studentDTO.getIds()) {
            Optional<StudentEntity> studentEntity = studentRepository.findById(id);
            if(studentEntity.isPresent()){
                longs.add(id);
            }
        }
        studentRepository.deleteAllById(longs);
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


//    @Override
//    public Object saveEs(Customer customer){
//        return esRepository.save(customer);
//    }

}
