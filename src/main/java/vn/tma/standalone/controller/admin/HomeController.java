package vn.tma.standalone.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

    @GetMapping("/admin/home")
    public Object homePage() {
        return "admin";
    }

}
