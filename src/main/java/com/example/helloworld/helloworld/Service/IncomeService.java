package com.example.helloworld.helloworld.Service;

import com.example.helloworld.helloworld.Dao.IncomeDao;
import com.example.helloworld.helloworld.Entity.Income;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"Income"})
public  class IncomeService  {

    @Autowired
    IncomeDao income;

    public List<Income> getIncome(){
        return income.findAll();

    }

    public Optional<Income> getIncomeById(int id){
        return income.findById(id);
    }


    public ResponseEntity<String> addIncome(@RequestBody Income income1){
        try {
            income.save(income1);
            System.out.println("here"+income1);
            return new ResponseEntity<>("Income added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding Income: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateIncome(Income updatedIncome) {
        try {

            if (!income.existsById(updatedIncome.getIncome_id())) {
                return new ResponseEntity<>("Income not found", HttpStatus.NOT_FOUND);
            }
            income.save(updatedIncome);

            return new ResponseEntity<>("Income updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating Income: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<String> deleteIncome(int incomeId) {
        try {
            // Check if the expense with the given ID exists
            if (!income.existsById(incomeId)) {
                return new ResponseEntity<>("Income not found", HttpStatus.NOT_FOUND);
            }
            income.deleteById(incomeId);

            return new ResponseEntity<>("Income deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting Income: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


