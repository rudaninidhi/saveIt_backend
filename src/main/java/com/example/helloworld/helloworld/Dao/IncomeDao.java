package com.example.helloworld.helloworld.Dao;


import com.example.helloworld.helloworld.Entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeDao extends JpaRepository<Income,Integer> {
}
