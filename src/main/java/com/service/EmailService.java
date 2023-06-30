package com.service;

import com.model.UserDetails;

public interface EmailService {

    boolean sendEmail(String otp, UserDetails userDetails);
}
