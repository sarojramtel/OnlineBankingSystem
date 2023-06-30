package com.service.impl;

import com.model.UserDetails;
import com.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public String transact(UserDetails userDetails, String to) {
        return null;
    }
}
