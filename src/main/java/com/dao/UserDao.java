package com.dao;

import com.model.UserDetails;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {
    private HibernateTemplate hibernateTemplate;

    public UserDao(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }
//    public UserDao(){}

    @Transactional
    public int saveUser(UserDetails userDetails){
        System.out.println(userDetails);
        this.hibernateTemplate.clear();
        int id =(Integer) this.hibernateTemplate.save(userDetails);
        System.out.println("test2");
        return id;

    }
}
