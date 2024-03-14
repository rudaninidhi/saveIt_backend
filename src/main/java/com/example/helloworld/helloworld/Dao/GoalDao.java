package com.example.helloworld.helloworld.Dao;

import com.example.helloworld.helloworld.Entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalDao extends JpaRepository<Goal, Integer> {
}
