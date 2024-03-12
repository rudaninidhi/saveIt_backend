package com.example.helloworld.helloworld.Service;



import com.example.helloworld.helloworld.Dao.ExpenseDao;
import com.example.helloworld.helloworld.Entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"expense"})
public class ExpenseService  {

    @Autowired
    ExpenseDao expense;

    public List<Expense> getexpense(){
        return expense.findAll();

    }

    public Optional<Expense> getExpenseById(int id){
        return expense.findById(id);
    }


    public ResponseEntity<String> addExpense(@RequestBody Expense expense1){
        try {
            expense.save(expense1);
            System.out.println("here"+expense1);
            return new ResponseEntity<>("Expense added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateExpense(Expense updatedExpense) {
        try {

            if (!expense.existsById(updatedExpense.getExpense_id())) {
                return new ResponseEntity<>("Expense not found", HttpStatus.NOT_FOUND);
            }

            expense.save(updatedExpense);

            return new ResponseEntity<>("Expense updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<String> deleteExpense(int expenseId) {
        try {
            // Check if the expense with the given ID exists
            if (!expense.existsById(expenseId)) {
                return new ResponseEntity<>("Expense not found", HttpStatus.NOT_FOUND);
            }
            expense.deleteById(expenseId);

            return new ResponseEntity<>("Expense deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

