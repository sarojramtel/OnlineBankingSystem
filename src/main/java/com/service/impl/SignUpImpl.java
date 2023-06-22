package com.service.impl;

import com.dao.UserDao;
import com.model.UserDetails;
import com.service.SignUp;
import com.utils.PasswordBcrypt;
import org.springframework.stereotype.Service;

@Service
public class SignUpImpl implements SignUp {

    private UserDao userDao;
    public SignUpImpl( UserDao userDao1){
        this.userDao = userDao1;
    }
//    public SignUpImpl(){}

    @Override
    public int createUser(UserDetails userDetails) {
        PasswordBcrypt passwordBcrypt = new PasswordBcrypt();
        String encodedPassword = passwordBcrypt.encodePassword(userDetails.getPassword());
        userDetails.setPassword(encodedPassword);
        int i = userDao.saveUser(userDetails);
        return i;
    }
}
