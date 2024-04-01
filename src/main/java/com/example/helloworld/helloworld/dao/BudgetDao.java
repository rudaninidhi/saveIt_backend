package com.example.helloworld.helloworld.dao;

import com.example.helloworld.helloworld.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetDao extends JpaRepository<Budget, Integer> {
    @Query(value = "EXEC FindBudgetsByUserId :userId", nativeQuery = true)
    List<Budget> findBudgetsByUserId(int userId);
}
