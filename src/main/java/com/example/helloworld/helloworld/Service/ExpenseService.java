package com.example.helloworld.helloworld.Service;

import com.example.helloworld.helloworld.Dao.ExpenseDao;
import com.example.helloworld.helloworld.Entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public boolean addExpense(@RequestBody Expense expense1) {
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
            if (!expense.existsById(updatedExpense.getExpense_id())) {
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
