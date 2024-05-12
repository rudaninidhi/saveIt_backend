package com.example.helloworld.helloworld.dao;

import com.example.helloworld.helloworld.entity.BudgetCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetCategoryDao extends JpaRepository<BudgetCategory,Integer> {
}
