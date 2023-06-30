package com.service.impl;

import com.dao.UserDao;
import com.model.UserDetails;
import com.service.LogInService;
import com.utils.PasswordBcrypt;
import com.utils.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Service
public class LogInServiceImpl implements LogInService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public LogInServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder){
        this.userDao=userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails verifyUser(String username, String password) {
        UserDetails userDetails= userDao.fetchUser(username);
        System.out.println(userDetails);
        System.out.println(password);
         if (!(userDetails == null)) {
            if (passwordEncoder.matches(password, userDetails.getPassword())) {
                return userDetails;
             } else {
                return null;
            }
         }else{
                return null;
             }
    }
}
