package com.example.helloworld.helloworld.Dao;


import com.example.helloworld.helloworld.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDao extends JpaRepository<Expense,Integer> {
}
