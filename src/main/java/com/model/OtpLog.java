package com.model;

import javax.persistence.*;

@Entity
@Table(name = "otplog")
public class OtpLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sn;
    private String otp;
    private String otpTimestamp;

    @ManyToOne
    private UserDetails userDetails;

    public OtpLog(int sn, String otp, String otpTimestamp, UserDetails userDetails) {
        this.sn = sn;
        this.otp = otp;
        this.otpTimestamp = otpTimestamp;
        this.userDetails = userDetails;
    }

    public OtpLog() {
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getOtpTimestamp() {
        return otpTimestamp;
    }

    public void setOtpTimestamp(String otpTimestamp) {
        this.otpTimestamp = otpTimestamp;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "OtpLog{" +
                "sn=" + sn +
                ", otp='" + otp + '\'' +
                '}';
    }
}
