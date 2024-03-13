package com.example.helloworld.helloworld.Controller;

import com.example.helloworld.helloworld.Entity.Budget;
import com.example.helloworld.helloworld.Service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/getBudgets")
    public List<Budget> getBudgets() {
        return budgetService.getBudgets();
    }

    @GetMapping("/getBudgetById/{id}")
    public Optional<Budget> getBudgetById(@PathVariable int id) {
        return budgetService.getBudgetById(id);
    }

    @PostMapping("/addBudget")
    public ResponseEntity<String> addBudget(@RequestBody Budget budget) {
        return budgetService.addBudget(budget);
    }

    @PutMapping("/updateBudget")
    public ResponseEntity<String> updateBudget(@RequestBody Budget updatedBudget) {
        return budgetService.updateBudget(updatedBudget);
    }

    @DeleteMapping("/deleteBudget/{budgetId}")
    public ResponseEntity<String> deleteBudget(@PathVariable int budgetId) {
        return budgetService.deleteBudget(budgetId);
    }
}
