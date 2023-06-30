package com.service;

import com.model.AccountDetails;
import com.model.UserDetails;

public interface AccountService {

    String generateAccountNumber(UserDetails userDetails);
    AccountDetails createAccount(UserDetails userDetails,String accountType);
}
