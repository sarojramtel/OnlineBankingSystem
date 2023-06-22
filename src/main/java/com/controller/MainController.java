package com.controller;

import com.model.UserDetails;
import com.service.impl.SignUpImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private SignUpImpl signUpImpl;
    public MainController(SignUpImpl s){
        this.signUpImpl = s;
    }
//    public MainController(){}

    @RequestMapping("/home")
    public String homepage(){
        return "index";
    }

    @RequestMapping("/signup")
    public String  register(){
        return "signup";
    }

    @RequestMapping(path = "/processform",method = RequestMethod.POST)
    public String signUp(@ModelAttribute UserDetails userdetails, Model model){
//        System.out.println(userdetails);
//        model.addAttribute("email",email);
//        userdetails.setEmail(email);
        this.signUpImpl.createUser(userdetails);
        return "signup";
    }
}
