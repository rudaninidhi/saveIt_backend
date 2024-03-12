package com.example.helloworld.helloworld.Controller;

import com.example.helloworld.helloworld.Entity.Income;
import com.example.helloworld.helloworld.Service.*;
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
    public List<Income> getIncome(){
        return serviceobj.getIncome();
    }
    @GetMapping("/getIncomeById/{id}")
    public Optional<Income> getExpenseById(@PathVariable int id){
        System.out.println( serviceobj.getIncomeById(id));
        //
        return serviceobj.getIncomeById(id);
    }
    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @PostMapping("/addIncome")
    public ResponseEntity<String> addIncome(@RequestBody Income income) {
        logger.info("Income received: {}", income);
        try {
            serviceobj.addIncome(income);
            return new ResponseEntity<>("Income added successfully", HttpStatus.OK);
        } catch (DataAccessException e) {
            logger.error("Error adding Income", e);
            return new ResponseEntity<>("Database error adding Income", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("Unexpected error adding Income", e);
            return new ResponseEntity<>("Error adding Income: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateIncome")
    public ResponseEntity<String> updateExpense(@RequestBody Income updatedIncome) {
        try {
            serviceobj.updateIncome(updatedIncome);
            return new ResponseEntity<>("Income updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating Income: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteIncome/{incomeId}")
    public ResponseEntity<String> deleteIncome(@PathVariable int incomeId) {
        try {
            serviceobj.deleteIncome(incomeId);
            return new ResponseEntity<>("Income deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting Income: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
