package iuh.edu.vn.www_week04_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping(value="/")
    public String index() {
        return "home";
    }
}
