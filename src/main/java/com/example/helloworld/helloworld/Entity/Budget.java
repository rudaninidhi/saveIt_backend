package com.example.helloworld.helloworld.Entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Budget")
public class Budget implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int budget_id;

    private String budget_category;
    private double amount;
    private Date start_date;
    private Date end_date;
    private String budget_description;
    private int user_id;

    public Budget() {
    }

    public Budget(String budget_category, double amount, Date start_date, Date end_date, String budget_description, int user_id) {
        this.budget_category = budget_category;
        this.amount = amount;
        this.start_date = start_date;
        this.end_date = end_date;
        this.budget_description = budget_description;
        this.user_id = user_id;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Budget{" +
                "budget_id=" + budget_id +
                ", budget_category='" + budget_category + '\'' +
                ", amount=" + amount +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", budget_description='" + budget_description + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public Integer getBudget_id() {
    return null;
    }
}
