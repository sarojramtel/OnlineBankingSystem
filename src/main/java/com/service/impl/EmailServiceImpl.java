package com.service.impl;

import com.model.UserDetails;
import com.service.EmailService;
import com.utils.EmailDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSenderImpl mailSender;

    public EmailServiceImpl(JavaMailSenderImpl javaMailSender){
        this.mailSender = javaMailSender;
    }
    private final String sender="angelsdevila@gmail.com";
    @Override
    public boolean sendEmail(String otp, UserDetails userDetails) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(userDetails.getEmail());
            simpleMailMessage.setText(otp);
            simpleMailMessage.setSubject("OTP-Online Banking System Registration");
            this.mailSender.send(simpleMailMessage);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
