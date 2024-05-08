package com.example.helloworld.helloworld.controller;

import com.example.helloworld.helloworld.entity.Expense;
import com.example.helloworld.helloworld.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    ExpenseService serviceobj;

    @GetMapping("/getexpense")
    public List<Expense> getexpense() {
        return serviceobj.getexpense();
    }

    @GetMapping("/getExpensesByUserId/{user_id}")
    public ResponseEntity<?> getExpensesByUser_id(@PathVariable int user_id) {
        List<Expense> expenses = serviceobj.getExpensesByUserId(user_id);
        if (expenses.isEmpty()) {
            return new ResponseEntity<>("No expenses found for the user ID: " + user_id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        }
    }

    @GetMapping("/getExpenseById/{id}")
    public Optional<Expense> getExpenseById(@PathVariable int id) {
        return serviceobj.getExpenseById(id);
    }

    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @PostMapping("/addExpense")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        logger.info("Expense received: {}", expense);
        try {
            boolean success = serviceobj.addExpense(expense);
            if (success) {
                return new ResponseEntity<>("Expense added successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error adding expense", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (DataAccessException e) {
            logger.error("Error adding expense", e);
            return new ResponseEntity<>("Database error adding expense", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateExpense")
    public ResponseEntity<String> updateExpense(@RequestBody Expense updatedExpense) {
        try {
            System.out.println(updatedExpense);
            boolean success = serviceobj.updateExpense(updatedExpense);
            if (success) {
                return new ResponseEntity<>("Expense updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Expense not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteExpense/{expenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable int expenseId) {
        try {
            boolean success = serviceobj.deleteExpense(expenseId);
            if (success) {
                return new ResponseEntity<>("Expense deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Expense not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
