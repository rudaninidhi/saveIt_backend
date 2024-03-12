package com.example.helloworld.helloworld.Controller;

import com.example.helloworld.helloworld.Entity.Expense;
import com.example.helloworld.helloworld.Service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController

public class ExpenseController {

    @Autowired
    ExpenseService serviceobj;
    @GetMapping("/getexpense")
    public List<Expense> getexpense(){
        return serviceobj.getexpense();
    }
    @GetMapping("/getExpenseById/{id}")
    public Optional<Expense> getExpenseById(@PathVariable int id){
        System.out.println( serviceobj.getExpenseById(id));
        return serviceobj.getExpenseById(id);
    }
    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @PostMapping("/addExpense")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        logger.info("Expense received: {}", expense);
        try {
            serviceobj.addExpense(expense);
            return new ResponseEntity<>("Expense added successfully", HttpStatus.OK);
        } catch (DataAccessException e) {
            logger.error("Error adding expense", e);
            return new ResponseEntity<>("Database error adding expense", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("Unexpected error adding expense", e);
            return new ResponseEntity<>("Error adding expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateExpense")
    public ResponseEntity<String> updateExpense(@RequestBody Expense updatedExpense) {
        try {
            serviceobj.updateExpense(updatedExpense);
            return new ResponseEntity<>("Expense updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteExpense/{expenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable int expenseId) {
        try {
            serviceobj.deleteExpense(expenseId);
            return new ResponseEntity<>("Expense deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
