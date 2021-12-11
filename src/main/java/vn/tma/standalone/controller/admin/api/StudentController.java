package vn.tma.standalone.controller.admin.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import vn.tma.standalone.converter.StudentCoverter;
import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.service.IStudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private IStudentService studentService;

    private StudentCoverter studentCoverter;

    public StudentController(IStudentService studentService,
                             StudentCoverter studentCoverter){
        this.studentService = studentService;
        this.studentCoverter = studentCoverter;
    }

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public StudentDTO getAll() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setListResult(studentService.getAll());

        return studentDTO;
    }

    @PostMapping
    public Object saveReal(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudentReal(studentDTO);
    }

    @PutMapping
    public StudentDTO EditStudent(@RequestBody StudentDTO studentDTO){
        return studentService.editStudent(studentDTO);
    }

    @DeleteMapping
    public void deleteStudent(@RequestBody StudentDTO studentDTO){
        studentService.deleteStudent(studentDTO);
    }


}
