package com.model;

import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "userdetails",uniqueConstraints = {@UniqueConstraint(name = "UNIQUE_email",columnNames = {"email"}),
                                                 @UniqueConstraint(name = "UNIQUE_username",columnNames = {"username"}),
                                                 @UniqueConstraint(name = "UNIQUE_contact",columnNames = {"contact"})})
public class UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userid;
    private String name;
    private String contact;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;
    private String photo;

    @OneToMany(mappedBy = "userDetails",cascade = CascadeType.ALL)
    private List<AccountDetails> accountDetails;

    @OneToMany(mappedBy = "userDetails",cascade = CascadeType.ALL)
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
