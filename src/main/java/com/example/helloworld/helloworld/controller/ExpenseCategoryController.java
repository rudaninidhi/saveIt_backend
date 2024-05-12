package com.example.helloworld.helloworld.controller;

import com.example.helloworld.helloworld.entity.ExpenseCategory;
import com.example.helloworld.helloworld.service.ExpenseCategoryService;
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
public class ExpenseCategoryController {
    @Autowired
    private ExpenseCategoryService expenseCategoryService;
    private static final Logger logger = LoggerFactory.getLogger(BudgetCategoryController.class);

    @GetMapping("/getExpenseCategories")
    public List<ExpenseCategory> getExpenseCategories() {
        return expenseCategoryService.getExpenseCategories();
    }

    @GetMapping("/getExpenseCategoryById/{id}")
    public ResponseEntity<?> getExpenseCategoryById(@PathVariable int id) {
        Optional<ExpenseCategory> expenseCategory = expenseCategoryService.getExpenseCategoryById(id);
        if (expenseCategory.isEmpty()) {
            return new ResponseEntity<>("No Expense Category found for the user ID: " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(expenseCategory, HttpStatus.OK);
        }
    }

}
