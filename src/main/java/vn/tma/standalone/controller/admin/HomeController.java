package vn.tma.standalone.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "homeControllerOfAdmin")
public class HomeController {
    @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
    public Object homePage() {
        return "page admin";
    }
}
