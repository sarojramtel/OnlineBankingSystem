package com.service;

import com.model.UserDetails;

public interface OtpService {

    String generateOtp();
    boolean verifyOtp(String otp, Long timestamp, UserDetails userDetails);
}
