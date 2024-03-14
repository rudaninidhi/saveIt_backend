package com.example.helloworld.helloworld.Service;



import com.example.helloworld.helloworld.Dao.BudgetDao;
import com.example.helloworld.helloworld.Dao.ExpenseDao;
import com.example.helloworld.helloworld.Entity.Budget;
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
public class BudgetService  {

    @Autowired
    BudgetDao budget;

    public List<Budget> getBudget(){
        return budget.findAll();

    }

    public Optional<Budget> getBudgetById(int id){
        return budget.findById(id);
    }


    public ResponseEntity<String> addBudget(@RequestBody Budget budget1){
        try {
            budget.save(budget1);
            System.out.println("here"+budget1);
            return new ResponseEntity<>("budget added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateBudget(Budget updatedBudget) {
        try {

            if (!budget.existsById(updatedBudget.getBudget_id())) {
                return new ResponseEntity<>("budget not found", HttpStatus.NOT_FOUND);
            }

            budget.save(updatedBudget);

            return new ResponseEntity<>("budget updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<String> deleteBudget(int budgetId) {
        try {
            // Check if the expense with the given ID exists
            if (!budget.existsById(budgetId)) {
                return new ResponseEntity<>("Expense not found", HttpStatus.NOT_FOUND);
            }
            budget.deleteById(budgetId);

            return new ResponseEntity<>("Expense deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting expense: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
