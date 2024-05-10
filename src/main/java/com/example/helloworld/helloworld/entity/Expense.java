package com.example.helloworld.helloworld.entity;
import java.io.Serializable;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Expense")
public class Expense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int expenseId;

    @Column(name = "expense_category_id")
    private int expenseCategory;

    @Column(name = "expense_description")
    private String expenseDescription;

    @Column(name = "spend_date")
    private Date spendDate;

    @Column(name = "amount_spended")
    private int amountSpend;

    @Column(name = "user_id")
    private int userId;

    public Expense(int expenseId, int expenseCategory, String expenseDescription, Date spendDate, int amountSpend, int userId) {
        this.expenseId = expenseId;
        this.expenseCategory = expenseCategory;
        this.expenseDescription = expenseDescription;
        this.spendDate = spendDate;
        this.amountSpend = amountSpend;
        this.userId = userId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(int expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public Date getSpendDate() {
        return spendDate;
    }

    public void setSpendDate(Date spendDate) {
        this.spendDate = spendDate;
    }

    public int getAmountSpend() {
        return amountSpend;
    }

    public void setAmountSpend(int amountSpend) {
        this.amountSpend = amountSpend;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Expense() {

    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", expenseCategory='" + expenseCategory + '\'' +
                ", expenseDescription='" + expenseDescription + '\'' +
                ", spendDate=" + spendDate +
                ", amountSpend=" + amountSpend +
                ", userId=" + userId +
                '}';
    }
}
