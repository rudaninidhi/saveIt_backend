package com.example.helloworld.helloworld.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Income")
public class Income implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int income_id;
    private String income_category;
    private String income_description;
    private Date income_date;
    private int income;
    private int user_id;

    public Income(int income_id, String income_category, String income_description, Date income_date, int income, int user_id) {
        this.income_id = income_id;
        this.income_category = income_category;
        this.income_description = income_description;
        this.income_date = income_date;
        this.income = income;
        this.user_id = user_id;
    }

    public int getIncome_id() {
        return income_id;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public String getIncome_category() {
        return income_category;
    }

    public void setIncome_category(String income_category) {
        this.income_category = income_category;
    }

    public String getIncome_description() {
        return income_description;
    }

    public void setIncome_description(String income_description) {
        this.income_description = income_description;
    }

    public Date getIncome_date() {
        return income_date;
    }

    public void setIncome_date(Date income_date) {
        this.income_date = income_date;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Income() {
    }

    public void setAmount(double v) {
    }
}
