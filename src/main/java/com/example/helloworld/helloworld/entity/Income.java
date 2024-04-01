package com.example.helloworld.helloworld.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Income")
public class Income implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_id")
    private int incomeId;

    @Column(name = "income_category")
    private String incomeCategory;

    @Column(name = "income_description")
    private String incomeDescription;

    @Column(name = "income_date")
    private Date incomeDate;

    @Column(name = "income")
    private int incomeAmount;

    @Column(name = "user_id")
    private int userId;

    public Income(int incomeId, String incomeCategory, String incomeDescription, Date incomeDate, int incomeAmount, int userId) {
        this.incomeId = incomeId;
        this.incomeCategory = incomeCategory;
        this.incomeDescription = incomeDescription;
        this.incomeDate = incomeDate;
        this.incomeAmount = incomeAmount;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Income{" +
                "incomeId=" + incomeId +
                ", incomeCategory='" + incomeCategory + '\'' +
                ", incomeDescription='" + incomeDescription + '\'' +
                ", incomeDate=" + incomeDate +
                ", incomeAmount=" + incomeAmount +
                ", userId=" + userId +
                '}';
    }

    public Income() {

    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public String getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(String incomeCategory) {
        this.incomeCategory = incomeCategory;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public int getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(int incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
