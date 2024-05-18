package com.example.helloworld.helloworld.entity;

import jakarta.persistence.*;
import lombok.*;
//import lombok.Builder;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Users")
@Getter
@Setter
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_id")
    private String emailId;

    public Users() {
    }

    public Users(int userId, String userName, String emailId, String mobileNo) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;

    }

    public Users(int userId, String emailId) {
        this.userId = userId;
        this.emailId = emailId;
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



}
