package com.service;

import com.model.UserDetails;

public interface LogInService {
    UserDetails verifyUser(String username, String password);
}
