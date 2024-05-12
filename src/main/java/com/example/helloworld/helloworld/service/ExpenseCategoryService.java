package com.example.helloworld.helloworld.service;

import com.example.helloworld.helloworld.dao.ExpenseCategoryDao;
import com.example.helloworld.helloworld.entity.ExpenseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryService {
    @Autowired
    ExpenseCategoryDao expenseCategoryDao;

    public List<ExpenseCategory> getExpenseCategories(){return expenseCategoryDao.findAll();}
    public Optional<ExpenseCategory> getExpenseCategoryById(int Id){
        return expenseCategoryDao.findById(Id);
    }
}
