package com.example.WebProject.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}

