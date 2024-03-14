package com.example.helloworld.helloworld.Controller;

import com.example.helloworld.helloworld.Entity.Goal;
import com.example.helloworld.helloworld.Service.GoalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GoalController {

    @Autowired
    private GoalService goalService;

    private static final Logger logger = LoggerFactory.getLogger(GoalController.class);

    @GetMapping("/getGoals")
    public List<Goal> getGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/getGoalById/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable int id) {
        Optional<Goal> goal = goalService.getGoalById(id);
        return goal.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addGoal")
    public ResponseEntity<String> addGoal(@RequestBody Goal goal) {
        logger.info("Goal received: {}", goal);
        try {
            goalService.addGoal(goal);
            return new ResponseEntity<>("Goal added successfully", HttpStatus.OK);
        } catch (DataAccessException e) {
            logger.error("Error adding Goal", e);
            return new ResponseEntity<>("Database error adding Goal", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("Unexpected error adding Goal", e);
            return new ResponseEntity<>("Error adding Goal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateGoal")
    public ResponseEntity<String> updateGoal(@RequestBody Goal updatedGoal) {
        try {
            goalService.updateGoal(updatedGoal);
            return new ResponseEntity<>("Goal updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating Goal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteGoal/{goalId}")
    public ResponseEntity<String> deleteGoal(@PathVariable int goalId) {
        try {
            goalService.deleteGoal(goalId);
            return new ResponseEntity<>("Goal deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting Goal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
