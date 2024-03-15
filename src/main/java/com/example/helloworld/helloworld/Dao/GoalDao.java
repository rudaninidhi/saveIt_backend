package com.example.helloworld.helloworld.Dao;

import com.example.helloworld.helloworld.Entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoalDao extends JpaRepository<Goal, Integer> {
    @Query(value = "EXEC FindGoalsByUserId :userId", nativeQuery = true)
    List<Goal> findGoalsByUserId(int userId);
}
