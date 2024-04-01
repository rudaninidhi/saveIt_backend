package com.example.helloworld.helloworld.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "mobile_no")
    private String mobileNo;

    public Users() {
    }

    public Users(int userId, String userName, String emailId, String mobileNo) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
