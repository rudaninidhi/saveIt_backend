package com.example.helloworld.helloworld.controller;

import com.example.helloworld.helloworld.entity.BudgetCategory;
import com.example.helloworld.helloworld.entity.Goal;
import com.example.helloworld.helloworld.service.BudgetCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BudgetCategoryController {
    @Autowired
    private BudgetCategoryService budgetCategoryService;
    private static final Logger logger = LoggerFactory.getLogger(BudgetCategoryController.class);

    @GetMapping("/getBudgetCategories")
    public List<BudgetCategory> getBudgetCategories() {
        return budgetCategoryService.getBudgetCategories();
    }

    @GetMapping("/getBudgetCategoryById/{id}")
    public ResponseEntity<?> getBudgetCategoryById(@PathVariable int id) {
        Optional<BudgetCategory> budgetCategory = budgetCategoryService.getBudgetCategoryById(id);
        if (budgetCategory.isEmpty()) {
            return new ResponseEntity<>("No Budget Category found for the user ID: " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(budgetCategory, HttpStatus.OK);
        }
    }


}
