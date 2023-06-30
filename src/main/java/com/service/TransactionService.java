package com.service;

import com.model.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    String transact(UserDetails userDetails,String to);
}
