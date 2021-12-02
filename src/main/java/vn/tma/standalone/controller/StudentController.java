package vn.tma.standalone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.tma.standalone.dto.StudentDTO;
import vn.tma.standalone.service.IStudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/student")
    public Object getAll() {
        return studentService.getAll();
    }

    @PostMapping("/student")
    public Object save(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }



}
