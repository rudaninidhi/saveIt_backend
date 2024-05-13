package com.example.helloworld.helloworld.service;

import com.example.helloworld.helloworld.dao.BudgetCategoryDao;
import com.example.helloworld.helloworld.dao.IncomeCategoryDao;
import com.example.helloworld.helloworld.entity.BudgetCategory;
import com.example.helloworld.helloworld.entity.ExpenseCategory;
import com.example.helloworld.helloworld.entity.IncomeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IncomeCategoryService {
    @Autowired
    IncomeCategoryDao incomeCategoryDao;

    public List<IncomeCategory> getIncomeCategories(){return incomeCategoryDao.findAll();}
    public Optional<IncomeCategory> getIncomeCategoryById(int Id){
        return incomeCategoryDao.findById(Id);
    }
}
