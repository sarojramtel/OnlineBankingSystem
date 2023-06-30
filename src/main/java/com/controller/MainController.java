package com.controller;

import com.model.AccountDetails;
import com.model.UserDetails;
import com.service.LogInService;
import com.service.impl.AccountServiceImpl;
import com.service.impl.LogInServiceImpl;
import com.service.impl.OtpServiceImpl;
//import com.service.impl.SignUpImpl;
import com.service.impl.SignUpImpl;
import com.utils.PasswordBcrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MainController {

    private SignUpImpl signUpImpl;
    private OtpServiceImpl otpService;
    private UserDetails userDetailsTemp;
    private LogInServiceImpl logInService;
    private AccountServiceImpl accountService;
    public MainController(SignUpImpl s,OtpServiceImpl otpService1,LogInServiceImpl logInService1,AccountServiceImpl accountService){

        this.signUpImpl = s;
        this.otpService=otpService1;
        this.logInService= logInService1;
        this.accountService=accountService;
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

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @RequestMapping(path = "/processform",method = RequestMethod.POST)
    public String signUp(@ModelAttribute UserDetails userDetails, Model model){
            this.signUpImpl.createUser(userDetails);
            this.userDetailsTemp = userDetails;
            return "otpVerify";
    }

    @RequestMapping(path = "/verifyotp",method = RequestMethod.POST)
    public String verifyOtp(@RequestParam(name = "otp") String otp,Model model){
        Long submittedTime = System.currentTimeMillis()/1000;
        boolean check = this.otpService.verifyOtp(otp,submittedTime,this.userDetailsTemp);
        if(check){
                    return "createaccount";
        }else {
            model.addAttribute("wrong","Wrong OTP");
            return "otpVerify";
        }
    }

    @RequestMapping(path = "/loginform",method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model){
        System.out.println(password);
        UserDetails userDetails = this.logInService.verifyUser(username,password);
        if(userDetails==null){
            model.addAttribute("error","Invalid Credentials");
            return "login";
        }else {
            model.addAttribute("userName",userDetails.getName());
            return "dashboard";
        }
    }

    @RequestMapping(path = "/accountcreation",method = RequestMethod.POST)
    public String accountGeneration(@RequestParam(name ="accountType") String accountType,Model model){
        AccountDetails accountDetails = accountService.createAccount(this.userDetailsTemp,accountType);
        System.out.println(accountDetails);
        return "login";
    }

}
