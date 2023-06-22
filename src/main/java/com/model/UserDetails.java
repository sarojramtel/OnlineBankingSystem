package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userdetails")
public class UserDetails {

    @Id
    private int userid;
    private String name;
    private String contact;
    private String email;
    private String username;
    private String password;
    private String photo;

    @OneToMany(mappedBy = "userDetails")
    private List<AccountDetails> accountDetails;

    @OneToMany(mappedBy = "userDetails")
    private List<OtpLog> otpLogs;

    public UserDetails(int userId, String name, String contact, String email, String username, String password, String photo) {
        this.userid = userId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.photo = photo;
    }

    public UserDetails() {
    }

    public int getUserId() {
        return userid;
    }

    public void setId(int userId) {
        this.userid = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "userDetails{" +
                "userId=" + userid +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
