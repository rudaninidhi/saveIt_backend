package com.example.helloworld.helloworld.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Budget")
public class Budget implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int budget_id;

    private int budget_category_id;
    private double amount;
    private Date start_date;
    private Date end_date;
    private String budget_description;
    private int user_id;
    public Budget() {
    }
    public Budget(int budget_id, int budget_category_id, double amount, Date start_date, Date end_date, String budget_description, int user_id) {
        this.budget_id = budget_id;
        this.budget_category_id = budget_category_id;
        this.amount = amount;
        this.start_date = start_date;
        this.end_date = end_date;
        this.budget_description = budget_description;
        this.user_id = user_id;
    }

    public int getBudget_id() {
        return budget_id;
    }

    public void setBudget_id(int budget_id) {
        this.budget_id = budget_id;
    }

    public int getBudget_category() {
        return budget_category_id;
    }

    public void setBudget_category(int budget_category) {
        this.budget_category_id = budget_category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getBudget_description() {
        return budget_description;
    }

    public void setBudget_description(String budget_description) {
        this.budget_description = budget_description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


}
