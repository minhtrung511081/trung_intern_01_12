package vn.tma.standalone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.tma.standalone.service.ICollegeService;

@RestController

public class CollegeController {

    @Autowired
    private ICollegeService collegeService;

    @GetMapping("/college")
    public Object getColege(){
        return collegeService.getAll();
    }
}
