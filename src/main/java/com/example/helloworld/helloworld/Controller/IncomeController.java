package com.example.helloworld.helloworld.Controller;

import com.example.helloworld.helloworld.Entity.Income;
import com.example.helloworld.helloworld.Service.IncomeService;
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
public class IncomeController {

    @Autowired
    IncomeService serviceobj;

    @GetMapping("/getIncome")
    public List<Income> getIncome() {
        return serviceobj.getIncome();
    }

    @GetMapping("/getIncomeById/{id}")
    public Optional<Income> getIncomeById(@PathVariable int id) {
        return serviceobj.getIncomeById(id);
    }


    @GetMapping("/getIncomeByUserId/{id}")
    public ResponseEntity<?> getIncomeByUserId(@PathVariable int id) {
        List<Income> income = serviceobj.getIncomeByUserId(id);
        if (income.isEmpty()) {
            return new ResponseEntity<>("No income records found for the user ID: " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(income, HttpStatus.OK);
        }
    }


    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @PostMapping("/addIncome")
    public ResponseEntity<String> addIncome(@RequestBody Income income) {
        logger.info("Income received: {}", income);
        try {
            boolean success = serviceobj.addIncome(income);
            if (success) {
                return new ResponseEntity<>("Income added successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error adding Income", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (DataAccessException e) {
            logger.error("Error adding Income", e);
            return new ResponseEntity<>("Database error adding Income", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateIncome")
    public ResponseEntity<String> updateIncome(@RequestBody Income updatedIncome) {
        try {
            boolean success = serviceobj.updateIncome(updatedIncome);
            if (success) {
                return new ResponseEntity<>("Income updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Income not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating Income: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteIncome/{incomeId}")
    public ResponseEntity<String> deleteIncome(@PathVariable int incomeId) {
        try {
            boolean success = serviceobj.deleteIncome(incomeId);
            if (success) {
                return new ResponseEntity<>("Income deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Income not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting Income: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
