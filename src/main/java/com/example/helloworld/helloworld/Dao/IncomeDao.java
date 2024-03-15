package com.example.helloworld.helloworld.Dao;


import com.example.helloworld.helloworld.Entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IncomeDao extends JpaRepository<Income,Integer> {
    @Query(value = "EXEC FindIncomesByUserId :userId", nativeQuery = true)
    List<Income> findIncomesByUserId(int userId);
}
