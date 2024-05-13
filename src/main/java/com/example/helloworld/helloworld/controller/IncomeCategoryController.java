package com.example.helloworld.helloworld.controller;

import com.example.helloworld.helloworld.entity.BudgetCategory;
import com.example.helloworld.helloworld.entity.ExpenseCategory;
import com.example.helloworld.helloworld.entity.IncomeCategory;
import com.example.helloworld.helloworld.service.BudgetCategoryService;
import com.example.helloworld.helloworld.service.IncomeCategoryService;
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
public class IncomeCategoryController {
    @Autowired
    private IncomeCategoryService incomeCategoryService;
    private static final Logger logger = LoggerFactory.getLogger(IncomeCategoryController.class);


    @GetMapping("/getIncomeCategories")
    public List<IncomeCategory> getExpenseCategories() {
        return incomeCategoryService.getIncomeCategories();
    }


    @GetMapping("/getIncomeCategoryById/{id}")
    public ResponseEntity<?> getIncomeCategoryById(@PathVariable int id) {
        Optional<IncomeCategory> incomeCategory = incomeCategoryService.getIncomeCategoryById(id);
        if (incomeCategory.isEmpty()) {
            return new ResponseEntity<>("No Income Category found for the user ID: " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(incomeCategory, HttpStatus.OK);
        }
    }

}
