package com.example.helloworld.helloworld.dao;


import com.example.helloworld.helloworld.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDao extends JpaRepository<Expense,Integer> {
    @Query(value = "EXEC FindExpensesByUserId :userId", nativeQuery = true)
    List<Expense> findExpensesByUserId(int userId);

}
