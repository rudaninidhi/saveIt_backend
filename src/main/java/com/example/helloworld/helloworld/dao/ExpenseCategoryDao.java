package com.example.helloworld.helloworld.dao;

import com.example.helloworld.helloworld.entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryDao extends JpaRepository<ExpenseCategory,Integer> {
}
