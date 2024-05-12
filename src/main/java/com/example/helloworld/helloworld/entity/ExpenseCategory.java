package com.example.helloworld.helloworld.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "expensecategory")
public class ExpenseCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_category_id")
    private int expenseCategoryId;

    @Column(name = "expense_category_desc")
    private String expenseCategoryDesc;

    @Column(name = "expense_category_name")
    private String expenseCategoryName;

    public ExpenseCategory(int expenseCategoryId, String expenseCategoryDesc, String expenseCategoryName) {
        this.expenseCategoryId = expenseCategoryId;
        this.expenseCategoryDesc = expenseCategoryDesc;
        this.expenseCategoryName = expenseCategoryName;
    }

    public void setExpenseCategoryId(int expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public void setExpenseCategoryDesc(String expenseCategoryDesc) {
        this.expenseCategoryDesc = expenseCategoryDesc;
    }

    public void setExpenseCategoryName(String expenseCategoryName) {
        this.expenseCategoryName = expenseCategoryName;
    }

    public int getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public String getExpenseCategoryDesc() {
        return expenseCategoryDesc;
    }

    public String getExpenseCategoryName() {
        return expenseCategoryName;
    }

    public ExpenseCategory() {
    }
}