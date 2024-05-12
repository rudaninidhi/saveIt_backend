package com.example.helloworld.helloworld.service;

import com.example.helloworld.helloworld.dao.BudgetCategoryDao;
import com.example.helloworld.helloworld.dao.ExpenseCategoryDao;
import com.example.helloworld.helloworld.entity.BudgetCategory;
import com.example.helloworld.helloworld.entity.ExpenseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetCategoryService {
    @Autowired
    BudgetCategoryDao budgetCategoryDao;

    public List<BudgetCategory> getBudgetCategories(){return budgetCategoryDao.findAll();}
     public Optional<BudgetCategory> getBudgetCategoryById(int Id){
        return budgetCategoryDao.findById(Id);
    }
}
