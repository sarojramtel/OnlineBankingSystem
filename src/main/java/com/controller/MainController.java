package com.controller;

import com.model.AccountDetails;
import com.model.UserDetails;
import com.service.TransactionService;
import com.service.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;

@Controller
public class MainController {

    private SignUpImpl signUpImpl;
    private OtpServiceImpl otpService;
    private UserDetails userDetailsTemp;
    private LogInServiceImpl logInService;
    private AccountServiceImpl accountService;
    private TransactionServiceImpl transactionService;
    public MainController(SignUpImpl s,OtpServiceImpl otpService1,LogInServiceImpl logInService1,AccountServiceImpl accountService,TransactionServiceImpl transactionService){

        this.signUpImpl = s;
        this.otpService=otpService1;
        this.logInService= logInService1;
        this.accountService=accountService;
        this.transactionService=transactionService;
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
        userDetailsTemp=userDetails;
        if(userDetails==null){
            model.addAttribute("error","Invalid Credentials");
            return "login";
        }else {
            model.addAttribute("userName",userDetails.getName());
            AccountDetails accountDetails = accountService.fetchAccountDetails(userDetails);
            model.addAttribute("accountNum",accountDetails.getAccountNumber());
            model.addAttribute("accountType",accountDetails.getAccountType());
            model.addAttribute("balance",accountDetails.getBalance());
            return "dashboard";
        }
    }

    @RequestMapping(path = "/accountcreation",method = RequestMethod.POST)
    public String accountGeneration(@RequestParam(name ="accountType") String accountType,Model model){
        AccountDetails accountDetails = accountService.createAccount(this.userDetailsTemp,accountType);
        System.out.println(accountDetails);
        return "login";
    }

    @RequestMapping(path = "/sendmoney",method = RequestMethod.POST)
    public String transactAmount(@RequestParam(name = "accountnumber") String accountnumber,@RequestParam(name = "amount") String amount,Model model){
        String status = transactionService.transact(userDetailsTemp,accountnumber,amount);
        if("success".matches(status)){
            model.addAttribute("confirm","Transaction successful!");
            AccountDetails accountDetails = accountService.fetchAccountDetails(userDetailsTemp);
            model.addAttribute("balance",accountDetails.getBalance());
        }
        return "dashboard";
    }

}
