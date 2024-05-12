package com.example.helloworld.helloworld.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "budgetcategory")
public class BudgetCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_category_id")
    private int budgetCategoryId;

    @Column(name = "budget_category_desc")
    private String budgetCategoryDesc;

    @Column(name = "budget_category_name")
    private String budgetCategoryName;

    public BudgetCategory(int budgetCategoryId, String budgetCategoryDesc, String budgetCategoryName) {
        this.budgetCategoryId = budgetCategoryId;
        this.budgetCategoryDesc = budgetCategoryDesc;
        this.budgetCategoryName = budgetCategoryName;
    }

    public BudgetCategory() {
    }
}
