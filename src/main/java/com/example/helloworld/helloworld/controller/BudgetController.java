package com.example.helloworld.helloworld.controller;

import com.example.helloworld.helloworld.entity.Budget;
import com.example.helloworld.helloworld.service.BudgetService;
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
public class BudgetController {
@CrossOrigin(origins = "http://127.0.0.1:5500")
    @Autowired
    BudgetService serviceobj;

    @GetMapping("/getBudget")
    public List<Budget> getBudget() {
        return serviceobj.getBudget();
    }

    @GetMapping("/getBudgetByUserId/{id}")
    public ResponseEntity<?> getBudgetByUserId(@PathVariable int id) {
        List<Budget> budgets = serviceobj.getBudgetByUserId(id);
        if (budgets.isEmpty()) {
            return new ResponseEntity<>("No budgets found for the user ID: " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(budgets, HttpStatus.OK);
        }
    }

    @GetMapping("/getBudgetById/{id}")
    public Optional<Budget> getExpenseById(@PathVariable int id) {
        return serviceobj.getBudgetById(id);
    }

    private static final Logger logger = LoggerFactory.getLogger(BudgetController.class);

    @PostMapping("/addBudget")
    public ResponseEntity<String> addBudget(@RequestBody Budget budget) {
        logger.info("Budget received: {}", budget);
        try {
            boolean success = serviceobj.addBudget(budget);
            if (success) {
                return new ResponseEntity<>("Budget added successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error adding Budget", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (DataAccessException e) {
            logger.error("Error adding Budget", e);
            return new ResponseEntity<>("Database error adding Budget", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateBudget")
    public ResponseEntity<String> updateBudget(@RequestBody Budget updatedBudget) {
        try {
            boolean success = serviceobj.updateBudget(updatedBudget);
            if (success) {
                return new ResponseEntity<>("Budget updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Budget not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating Budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBudget/{budgetId}")
    public ResponseEntity<String> deleteBudget(@PathVariable int budgetId) {
        try {
            boolean success = serviceobj.deleteBudget(budgetId);
            if (success) {
                return new ResponseEntity<>("Budget deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Budget not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting Budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
