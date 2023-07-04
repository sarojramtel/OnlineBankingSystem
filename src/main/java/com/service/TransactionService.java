package com.service;

import com.model.UserDetails;
import com.utils.TransactionStatus;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

  String  transact(UserDetails userDetails, String to, String amount);

  TransactionStatus reduceBalance(UserDetails userDetails, String amount);

  TransactionStatus addBalance(String accountnumber, String amount);
}
