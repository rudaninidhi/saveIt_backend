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
    @Column(name = "goal_id")
    private int goalId;

    @Column(name = "goal_for")
    private String goalFor;

    @Column(name = "target_amount")
    private BigDecimal targetAmount;

    @Column(name = "desired_date")
    private Date desiredDate;

    @Column(name = "saved_already")
    private BigDecimal savedAlready;

    @Column(name = "user_id")
    private int userId;

    public Goal() {
    }

    public Goal(int goalId, String goalFor, BigDecimal targetAmount, Date desiredDate, BigDecimal savedAlready, int userId) {
        this.goalId = goalId;
        this.goalFor = goalFor;
        this.targetAmount = targetAmount;
        this.desiredDate = desiredDate;
        this.savedAlready = savedAlready;
        this.userId = userId;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public String getGoalFor() {
        return goalFor;
    }

    public void setGoalFor(String goalFor) {
        this.goalFor = goalFor;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Date getDesiredDate() {
        return desiredDate;
    }

    public void setDesiredDate(Date desiredDate) {
        this.desiredDate = desiredDate;
    }

    public BigDecimal getSavedAlready() {
        return savedAlready;
    }

    public void setSavedAlready(BigDecimal savedAlready) {
        this.savedAlready = savedAlready;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
