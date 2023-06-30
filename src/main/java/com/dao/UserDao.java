package com.dao;

import com.model.UserDetails;
import org.hibernate.query.Query;
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
//        int id=0;
//        try {
                int id =(Integer) this.hibernateTemplate.save(userDetails);
//            }catch (DataIntegrityViolationException e){
//                if(e.getCause() instanceof ConstraintViolationException){
//                    ConstraintViolationException constraintViolationException=(ConstraintViolationException) e.getCause();
//                    String constraintName=constraintViolationException.getConstraintName();
//
//                    if("UNIQUE_email".equals(constraintName)){
//                        throw new DuplicateEmailException("The email is already in use");
//                    }else if("UNIQUE_username".equals(constraintName)){
//                        throw new DuplicateUsernameException("The username is already taken");
//                    }
//                }else {
//                    throw e;
//                }
//            }
                return id;

    }

    public UserDetails fetchUser(String username){
        String hqlQuery="FROM UserDetails u where u.username=:username";
        UserDetails userDetails = hibernateTemplate.execute(session -> {
            Query query = session.createQuery(hqlQuery);
            query.setParameter("username","username11111");
            query.setMaxResults(1);
            return (UserDetails) query.uniqueResult();
        });
        System.out.println("Dao :"+userDetails);
        return userDetails;
    }
}
