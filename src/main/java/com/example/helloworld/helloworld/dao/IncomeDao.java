package com.example.helloworld.helloworld.dao;


import com.example.helloworld.helloworld.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncomeDao extends JpaRepository<Income,Integer> {
    @Query(value = "EXEC FindIncomesByUserId :userId", nativeQuery = true)
    List<Income> findIncomesByUserId(int userId);
}
