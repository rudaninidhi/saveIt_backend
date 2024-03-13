package com.example.helloworld.helloworld.Service;

import com.example.helloworld.helloworld.Dao.BudgetDao;
import com.example.helloworld.helloworld.Entity.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetDao budgetDao;

    public List<Budget> getBudgets() {
        return budgetDao.findAll();
    }

    public Optional<Budget> getBudgetById(int id) {
        return budgetDao.findById(id);
    }

    public ResponseEntity<String> addBudget(@RequestBody Budget budget) {
        try {
            budgetDao.save(budget);
            return new ResponseEntity<>("Budget added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateBudget(Budget updatedBudget) {
        try {
            if (!budgetDao.existsById(updatedBudget.getBudget_id())) {
                return new ResponseEntity<>("Budget not found", HttpStatus.NOT_FOUND);
            }

            budgetDao.save(updatedBudget);

            return new ResponseEntity<>("Budget updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteBudget(int budgetId) {
        try {
            if (!budgetDao.existsById(budgetId)) {
                return new ResponseEntity<>("Budget not found", HttpStatus.NOT_FOUND);
            }
            budgetDao.deleteById(budgetId);

            return new ResponseEntity<>("Budget deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting budget: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
