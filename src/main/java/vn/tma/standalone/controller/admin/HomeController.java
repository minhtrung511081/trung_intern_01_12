package vn.tma.standalone.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.tma.standalone.repository.EsRepository;

@RestController(value = "homeControllerOfAdmin")
public class HomeController {

    @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
    public Object homePage() {
        return "page admin";
    }

}
