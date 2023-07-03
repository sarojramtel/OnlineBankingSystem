package com.service.impl;

import com.dao.AccountDao;
import com.dao.TransactionDao;
import com.model.AccountDetails;
import com.model.TransactionLog;
import com.model.UserDetails;
import com.service.TransactionService;
import com.utils.TransactionStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionServiceImpl implements TransactionService {

  private AccountDao accountDao;
  private TransactionDao transactionDao;

  public TransactionServiceImpl(AccountDao accountDao, TransactionDao transactionDao) {
    this.accountDao = accountDao;
    this.transactionDao = transactionDao;
  }

  @Override
  public boolean transact(UserDetails userDetails, String toAccNum, String amount) {
    TransactionStatus add = addBalance(toAccNum, amount);
    String checkSt=checkStatus(add);
    System.out.println(checkSt);
    System.out.println("Transact :"+userDetails);
    TransactionStatus reduced = reduceBalance(userDetails, amount);
    String checkSt2=checkStatus(reduced);
    System.out.println(checkSt2);
    return (reduced.isStatus() && add.isStatus());
  }

  public TransactionStatus reduceBalance(UserDetails userDetails, String amount) {
    System.out.println("reduce check1: "+userDetails);
    AccountDetails accountDetails = accountDao.fetchAccount(userDetails);
    if (Objects.isNull(accountDetails)) {
      throw new RuntimeException("Failed to fetch account");
    }
    double balance = Double.parseDouble(accountDetails.getBalance());
    String newBalance = String.valueOf(balance - Double.parseDouble(amount));
    accountDetails.setBalance(newBalance);
    TransactionStatus transactionStatus = new TransactionStatus();

    try {
      accountDao.changeAmount(accountDetails);
      transactionStatus.setStatus(true);
      transactionStatus.setChangeIndex(0);
    } catch (Exception e) {
      transactionStatus.setStatus(false);
      transactionStatus.setChangeIndex(0);
    }
    return transactionStatus;
  }

  public TransactionStatus addBalance(String accountnumber, String amount) {
    AccountDetails accountDetails = accountDao.fetchAccount(accountnumber);
    System.out.println("Transaction Status AddBalance");
    TransactionStatus transactionStatus = new TransactionStatus();
    if (accountDetails == null) {
      System.out.println("check 1");
      transactionStatus.setUserFound(false);
      transactionStatus.setStatus(false);
      transactionStatus.setChangeIndex(1);
      return transactionStatus;
    }
    double balance = Double.parseDouble(accountDetails.getBalance());
    String newBalance = String.valueOf(balance + Double.parseDouble(amount));
    System.out.println("Add(New Balance)" + newBalance);
    accountDetails.setBalance(newBalance);

    try {
      System.out.println("check 2");
      accountDao.changeAmount(accountDetails);
      transactionStatus.setStatus(true);
      transactionStatus.setChangeIndex(1);
      System.out.println("Add amount" + transactionStatus);
      return transactionStatus;
    } catch (Exception e) {
      System.out.println("check 3");
      transactionStatus.setStatus(false);
      transactionStatus.setChangeIndex(1);
      return transactionStatus;
    }
  }

  public String checkStatus(TransactionStatus transactionStatus) {
    if (transactionStatus.getChangeIndex() == 0) {
      if (transactionStatus.isUserFound()) {
        if (transactionStatus.isStatus()) {
          return "Amount Reduced";
        } else {
          return "Reduction Failed";

        }
      } else {
        return "Reduction user not found";
      }

    } else if (transactionStatus.getChangeIndex() == 1) {
      if (transactionStatus.isUserFound()) {
        if (transactionStatus.isStatus()) {
          return "Amount Added";
        } else {
          return "Addition Failed";

        }
      } else {
        return "Addition user not found";
      }
    } else {
      return "Unknown Error";

    }
  }
}
