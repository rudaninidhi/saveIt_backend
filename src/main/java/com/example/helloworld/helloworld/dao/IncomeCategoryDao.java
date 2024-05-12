package com.example.helloworld.helloworld.dao;

import com.example.helloworld.helloworld.entity.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeCategoryDao extends JpaRepository<IncomeCategory,Integer> {
}
