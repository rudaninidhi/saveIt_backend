package com.example.helloworld.helloworld.Service;

import com.example.helloworld.helloworld.Dao.GoalDao;
import com.example.helloworld.helloworld.Entity.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> addGoal(Goal goal) {
        try {
            goalDao.save(goal);
            return new ResponseEntity<>("Goal added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding goal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateGoal(Goal updatedGoal) {
        try {
            if (!goalDao.existsById(updatedGoal.getGoalId())) {
                return new ResponseEntity<>("Goal not found", HttpStatus.NOT_FOUND);
            }

            goalDao.save(updatedGoal);

            return new ResponseEntity<>("Goal updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating goal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteGoal(int goalId) {
        try {
            if (!goalDao.existsById(goalId)) {
                return new ResponseEntity<>("Goal not found", HttpStatus.NOT_FOUND);
            }

            goalDao.deleteById(goalId);

            return new ResponseEntity<>("Goal deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting goal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
