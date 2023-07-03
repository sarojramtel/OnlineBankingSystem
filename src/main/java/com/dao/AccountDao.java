package com.dao;

import com.model.AccountDetails;
import com.model.UserDetails;
import net.bytebuddy.asm.Advice;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountDao {

  private HibernateTemplate hibernateTemplate;

  public AccountDao(HibernateTemplate hibernateTemplate) {
    this.hibernateTemplate = hibernateTemplate;
  }

  @Transactional
  public int saveAccount(AccountDetails accountDetails) {

    return ((Integer) hibernateTemplate.save(accountDetails));
  }

  public AccountDetails fetchAccount(UserDetails userDetails) {
    String hqlQuery = "FROM AccountDetails a where a.userDetails.userid=:userid";
    AccountDetails accountDetails =
        hibernateTemplate.execute(
            session -> {
              Query query = session.createQuery(hqlQuery);
              query.setParameter("userid", userDetails.getUserId());
              query.setMaxResults(1);
              return (AccountDetails) query.uniqueResult();
            });
    System.out.println("Dao :" + accountDetails);
    return accountDetails;
  }

  public AccountDetails fetchAccount(String accountnumber) {
    String hqlQuery = "FROM AccountDetails a where a.accountNumber =:accountnum";
    AccountDetails accountDetails =
        hibernateTemplate.execute(
            session -> {
              Query query = session.createQuery(hqlQuery);
              query.setParameter("accountnum", accountnumber);
              query.setMaxResults(1);
              return (AccountDetails) query.uniqueResult();
            });
    System.out.println("Dao :" + accountDetails);
    return accountDetails;
  }

  @Transactional
  public void changeAmount(AccountDetails accountDetails) {
    hibernateTemplate.update(accountDetails);
    System.out.println("check4");
  }
}
