package vn.tma.standalone.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.tma.standalone.entity.Customer;
import vn.tma.standalone.repository.StudentEsRepository;

@RestController(value = "homeControllerOfAdmin")
public class HomeController {

    @Autowired
    private StudentEsRepository studentEsRepository;

    @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
    public Object homePage() {
        return "page admin";
    }

    @RequestMapping("/es")
    public Object getEs(){
        studentEsRepository.findAll().forEach(c -> System.out.println(c));
        return "hello";
    }
}
