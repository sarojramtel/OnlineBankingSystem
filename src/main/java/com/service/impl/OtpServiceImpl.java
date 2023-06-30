package com.service.impl;

import com.dao.OtpDao;
import com.model.UserDetails;
import com.service.OtpService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {

    private OtpDao otpDao;
    public OtpServiceImpl(OtpDao otpDao1){
        this.otpDao = otpDao1;
    }
    private static final int otpLength = 6;
    public String generateOtp(){
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for(int i=0;i<otpLength;i++){
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    @Override
    public boolean verifyOtp(String otp,Long timestamp,UserDetails userDetails) {
        boolean result = otpDao.checkOtp(otp,timestamp,userDetails);
        System.out.println(result);
        return result;
    }
}
