package com.dao;

import com.model.OtpLog;
import com.model.UserDetails;
import com.service.OtpService;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OtpDao {

    private HibernateTemplate hibernateTemplate;

    public OtpDao(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate= hibernateTemplate;
    }
    public boolean checkOtp(String otp,Long submittedTimestamp,UserDetails userDetails){
        System.out.println("otp:"+otp+"  "+submittedTimestamp);
        System.out.println(userDetails);
        String hqlQuery = "FROM OtpLog o WHERE o.userDetails.userid=:userId";
        OtpLog otpLog = hibernateTemplate.execute(session -> {
            Query query = session.createQuery(hqlQuery);
            query.setParameter("userId",userDetails.getUserId());
            query.setMaxResults(1);
            return (OtpLog) query.uniqueResult();
        });
//        OtpLog otpLog=this.hibernateTemplate.get(OtpLog.class,userDetails.getUserId());


        Long generatedTime= Long.parseLong(otpLog.getOtpTimestamp());
        int userId =otpLog.getUserDetails().getUserId();

        if(userId==userDetails.getUserId()){
            if (!(submittedTimestamp>(generatedTime+120)||submittedTimestamp<generatedTime)){
                if(otp.matches(otpLog.getOtp())){
                return true;
                }
            } else{
                System.out.println("Time expired");
                    return false;

            }
        }
        return  false;

    }

    @Transactional
    public int saveOtp(OtpLog otpLog,UserDetails userDetails){
            int i =(Integer) this.hibernateTemplate.save(otpLog);
            return i;
    }
}
