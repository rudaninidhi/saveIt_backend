package com.example.helloworld.helloworld.service;

import com.example.helloworld.helloworld.dao.GoalDao;
import com.example.helloworld.helloworld.entity.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalDao goalDao;

    public List<Goal> getAllGoals() {
        return goalDao.findAll();
    }

    public Optional<Goal> getGoalById(int id) {
        return goalDao.findById(id);
    }

    public List<Goal> getGoalByUserId(int id) {
        return goalDao.findGoalsByUserId(id);
    }


    public boolean addGoal(Goal goal) {
        try {
            goalDao.save(goal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateGoal(Goal updatedGoal) {
        try {
            if (!goalDao.existsById(updatedGoal.getGoal_id())) {
                return false;
            }

            goalDao.save(updatedGoal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteGoal(int goalId) {
        try {
            if (goalDao.existsById(goalId)) {
                goalDao.deleteById(goalId);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
