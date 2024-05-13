package com.example.helloworld.helloworld.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "incomecategory")
public class IncomeCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_category_id")
    private int incomeCategoryId;

    @Column(name = "income_category_desc")
    private String incomeCategoryDesc;

    @Column(name = "income_category_name")
    private String incomeCategoryName;

    public IncomeCategory(int incomeCategoryId, String incomeCategoryDesc, String incomeCategoryName) {
        this.incomeCategoryId = incomeCategoryId;
        this.incomeCategoryDesc = incomeCategoryDesc;
        this.incomeCategoryName = incomeCategoryName;
    }

    public IncomeCategory() {
    }

    public int getIncomeCategoryId() {
        return incomeCategoryId;
    }

    public void setIncomeCategoryId(int incomeCategoryId) {
        this.incomeCategoryId = incomeCategoryId;
    }

    public String getIncomeCategoryDesc() {
        return incomeCategoryDesc;
    }

    public void setIncomeCategoryDesc(String incomeCategoryDesc) {
        this.incomeCategoryDesc = incomeCategoryDesc;
    }

    public String getIncomeCategoryName() {
        return incomeCategoryName;
    }

    public void setIncomeCategoryName(String incomeCategoryName) {
        this.incomeCategoryName = incomeCategoryName;
    }
}
