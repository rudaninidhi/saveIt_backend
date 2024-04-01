package com.example.helloworld.helloworld.dao;

import com.example.helloworld.helloworld.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalDao extends JpaRepository<Goal, Integer> {
    @Query(value = "EXEC FindGoalsByUserId :userId", nativeQuery = true)
    List<Goal> findGoalsByUserId(int userId);
}
