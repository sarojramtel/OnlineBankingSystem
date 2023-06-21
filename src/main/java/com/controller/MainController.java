package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String homepage(){
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
