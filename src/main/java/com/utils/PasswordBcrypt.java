package com.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordBcrypt {
    public String encodePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
    public boolean checkPassword(String password,String encodedPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password,encodedPassword);
    }
}
