package com.example.helloworld.helloworld.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Goal")
public class Goal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int goal_id;
    private String goal_for;
    private BigDecimal target_amount;
    private Date desired_date;
    private BigDecimal saved_already;
    private int user_id;
    public Goal() {
    }

    public Goal(int goal_id, String goal_for, BigDecimal target_amount, Date desired_date, BigDecimal saved_already, int user_id) {
        this.goal_id = goal_id;
        this.goal_for = goal_for;
        this.target_amount = target_amount;
        this.desired_date = desired_date;
        this.saved_already = saved_already;
        this.user_id = user_id;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public String getGoal_for() {
        return goal_for;
    }

    public void setGoal_for(String goal_for) {
        this.goal_for = goal_for;
    }

    public BigDecimal getTarget_amount() {
        return target_amount;
    }

    public void setTarget_amount(BigDecimal target_amount) {
        this.target_amount = target_amount;
    }

    public Date getDesired_date() {
        return desired_date;
    }

    public void setDesired_date(Date desired_date) {
        this.desired_date = desired_date;
    }

    public BigDecimal getSaved_already() {
        return saved_already;
    }

    public void setSaved_already(BigDecimal saved_already) {
        this.saved_already = saved_already;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
