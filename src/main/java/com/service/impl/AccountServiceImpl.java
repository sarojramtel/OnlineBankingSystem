package com.service.impl;

import com.dao.AccountDao;
import com.model.AccountDetails;
import com.model.UserDetails;
import com.service.AccountService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {
    private String accountNumber;

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao){
        this.accountDao= accountDao;
    }

    public AccountDetails createAccount(UserDetails userDetails,String accountType){
        AccountDetails accountDetails = new AccountDetails();
        accountNumber=generateAccountNumber(userDetails);
        accountDetails.setAccountNumber(accountNumber);
        accountDetails.setBalance("5000");
        accountDetails.setAccountType(accountType);
        accountDetails.setUserDetails(userDetails);
        accountDao.saveAccount(accountDetails);

        return accountDetails;

    }



    public String generateAccountNumber(UserDetails userDetails){
        Random random = new Random();
        StringBuilder accNum = new StringBuilder();
        for (int i=0;i<7;i++){
            accNum.append(random.nextInt(10));
        }
        int len=String.valueOf(userDetails.getUserId()).length();
        for (int i=0;i<(3-len);i++){
            accNum.append(0);
        }
        accountNumber=(accNum.append(userDetails.getUserId())).toString();

        return accountNumber;
    }

    public AccountDetails fetchAccountDetails(UserDetails userDetails){
        AccountDetails accountDetails = new AccountDetails();
        accountDetails=accountDao.fetchAccount(userDetails);
        return accountDetails;
    }


}
