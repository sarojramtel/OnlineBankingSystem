package com.service.impl;

import com.dao.OtpDao;
import com.dao.UserDao;
//import com.exceptions.DuplicateDataException;
import com.model.OtpLog;
import com.model.UserDetails;
import com.service.OtpService;
import com.service.SignUp;
import com.utils.PasswordBcrypt;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class SignUpImpl implements SignUp {

    private UserDao userDao;
    private OtpService otpService;
    private OtpDao otpDao;
    private EmailServiceImpl emailService;
    public SignUpImpl( UserDao userDao1,OtpService otpService,EmailServiceImpl emailService,OtpDao otpDao){
        this.userDao = userDao1;
        this.otpService = otpService;
        this.emailService = emailService;
        this.otpDao=otpDao;
    }
//    public SignUpImpl(){}

    @Override
    public int createUser(UserDetails userDetails) {

        PasswordBcrypt passwordBcrypt = new PasswordBcrypt();
        String encodedPassword = passwordBcrypt.encodePassword(userDetails.getPassword());
        userDetails.setPassword(encodedPassword);

        OtpLog otpLog = new OtpLog();

        int i=0;
        try {
           i= userDao.saveUser(userDetails);
            System.out.println(i);
        }catch (Exception e) {
            String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
            System.out.println("Custom Message:"+message);
            throw new DataIntegrityViolationException(message);
        }

        String otp = otpService.generateOtp();

        Long generatedTime = (System.currentTimeMillis()/1000);
        System.out.println(otp);

        boolean status= emailService.sendEmail(otp,userDetails);
        System.out.println(status);

        otpLog.setOtp(otp);
        otpLog.setOtpTimestamp(generatedTime.toString());
        otpLog.setUserDetails(userDetails);

        if(status){
            otpDao.saveOtp(otpLog,userDetails);
            return i;
        }
        else {
            System.out.println("Failed to send mail");
            return i;
        }

    }
}
