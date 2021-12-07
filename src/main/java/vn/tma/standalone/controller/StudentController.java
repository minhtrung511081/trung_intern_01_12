package vn.tma.standalone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import vn.tma.standalone.converter.StudentCoverter;
import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.entity.StudentEntity;
import vn.tma.standalone.repository.EsRepository;
import vn.tma.standalone.service.IStudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private StudentCoverter studentCoverter;

    @Autowired
    private EsRepository esRepository;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/student")
    public Object getAll() {
        Object students = studentService.getAll();
        if(students!=null){
            logger.info("{}",students);
        }


        return students;
    }

    @PostMapping("/studentTest")
    public Object save(@RequestBody StudentDTO studentDTO) {
        StudentEntity studentEntity = studentCoverter.toEntity(studentDTO);
        return studentService.saveTestH2(studentEntity);
    }

    @PostMapping("/student")
    public Object saveReal(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudentReal(studentDTO);
    }


    @PostMapping(value = "/es")
    public Object saveEs(@RequestBody Customer customer){
        return studentService.saveEs(customer);
    }

    @GetMapping(value = "/es")
    public Object getEs(@RequestParam String id){
        Object user = esRepository.findById(id);
        if(user!=null){
            logger.info("user found : {}",user);
            return user;
        }else{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("User Not Found with ID : {}",id);
            }
            return new Customer();
        }
    }

    @GetMapping(value = "/esall")
    public Object getEsAll(){
        return esRepository.findAll();
    }

}
