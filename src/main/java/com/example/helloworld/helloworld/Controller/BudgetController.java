package com.example.helloworld.helloworld.Controller;

import com.example.helloworld.helloworld.Entity.Budget;
import com.example.helloworld.helloworld.Entity.Expense;
import com.example.helloworld.helloworld.Service.BudgetService;
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

public class BudgetController {

    @Autowired
    BudgetService serviceobj;
    @GetMapping("/getBudget")
    public List<Budget> getBudget(){
        return serviceobj.getBudget();
    }
    @GetMapping("/getBudgetById/{id}")
    public Optional<Budget> getExpenseById(@PathVariable int id){
        System.out.println( serviceobj.getBudgetById(id));
        return serviceobj.getBudgetById(id);
    }
    private static final Logger logger = LoggerFactory.getLogger(BudgetController.class);

    @PostMapping("/addBudget")
    public ResponseEntity<String> addBudget(@RequestBody Budget budget) {
        logger.info("Budget received: {}", budget);
        try {
            serviceobj.addBudget(budget);
            return new ResponseEntity<>("Budget added successfully", HttpStatus.OK);
        } catch (DataAccessException e) {
            logger.error("Error adding Budget", e);
            return new ResponseEntity<>("Database error adding Budget", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("Unexpected error adding Budget", e);
            return new ResponseEntity<>("Error adding Budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateBudget")
    public ResponseEntity<String> updateBudget(@RequestBody Budget updatedBudget) {
        try {
            serviceobj.updateBudget(updatedBudget);
            return new ResponseEntity<>("Budget updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating Budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBudget/{budgetId}")
    public ResponseEntity<String> deleteBudget(@PathVariable int budgetId) {
        try {
            serviceobj.deleteBudget(budgetId);
            return new ResponseEntity<>("Budget deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting Budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}