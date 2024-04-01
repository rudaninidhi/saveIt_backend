package com.example.helloworld.helloworld.service;

import com.example.helloworld.helloworld.dao.ExpenseDao;
import com.example.helloworld.helloworld.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseDao expense;

    public List<Expense> getexpense() {
        return expense.findAll();
    }
    public List<Expense> getExpensesByUserId(int user_id) {
        return expense.findExpensesByUserId(user_id);
    }
    public Optional<Expense> getExpenseById(int id) {
        return expense.findById(id);
    }

    public boolean addExpense( Expense expense1) {
        System.out.println("here" + expense1);
        try {
            expense.save(expense1);
            System.out.println("here" + expense1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateExpense(Expense updatedExpense) {
        try {
            if (!expense.existsById(updatedExpense.getExpenseId())) {
                return false;
            }
            expense.save(updatedExpense);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteExpense(int expenseId) {
            if (expense.existsById(expenseId)) {
                expense.deleteById(expenseId);
                return true;
            } else {
                return false;
            }
    }
}
