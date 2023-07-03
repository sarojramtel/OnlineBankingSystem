package com.dao;

import com.model.AccountDetails;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDao {

        private HibernateTemplate hibernateTemplate;

        public TransactionDao(HibernateTemplate hibernateTemplate){
            this.hibernateTemplate=hibernateTemplate;
        }
}
