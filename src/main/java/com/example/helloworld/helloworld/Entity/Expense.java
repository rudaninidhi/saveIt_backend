package com.example.helloworld.helloworld.Entity;
import java.io.Serializable;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Expense")
public class Expense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expense_id;
    private String expense_category;
    private String expense_description;
    private Date spend_date;
    private int amount_spended;
    private int user_id;

    public Expense() {
    }

    public Expense(int expense_id,String expense_description, String expense_category, Date spend_date, int amount_spended, int user_id) {
        this.expense_id = expense_id;
        this.expense_category = expense_category;
        this.spend_date = spend_date;
        this.amount_spended = amount_spended;
        this.user_id = user_id;
        this.expense_description=expense_description;
        System.out.println(expense_description+expense_category+spend_date+amount_spended);
    }

    public String getExpense_category() {
        return expense_category;
    }

    public int getExpense_id() {
        return expense_id;
    }


    public void setExpense_category(String expense_category) {
        this.expense_category = expense_category;
    }

    public String getExpense_description() {
        return expense_description;
    }

    public void setExpense_description(String expense_description) {
        this.expense_description = expense_description;
    }

    public Date getSpend_date() {
        return spend_date;
    }

    public void setSpend_date(Date spend_date) {
        this.spend_date = spend_date;
    }

    public int getAmount_spended() {
        return amount_spended;
    }

    public void setAmount_spended(int amount_spended) {
        this.amount_spended = amount_spended;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expense_id=" + expense_id +
                ", expense_category='" + expense_category + '\'' +
                ", expense_description='" + expense_description + '\'' +
                ", amount_spended=" + amount_spended +
                ", spend_date=" + spend_date +
                ", user_id=" + user_id +

                '}';
    }
}
