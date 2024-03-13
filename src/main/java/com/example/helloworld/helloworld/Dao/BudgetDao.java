package com.example.helloworld.helloworld.Dao;

import com.example.helloworld.helloworld.Entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetDao extends JpaRepository<Budget, Integer> {
}
