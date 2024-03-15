package com.example.helloworld.helloworld;

import com.example.helloworld.helloworld.Dao.GoalDao;
import com.example.helloworld.helloworld.Entity.Goal;
import com.example.helloworld.helloworld.Service.GoalService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class GoalServiceTest {

    @Mock
    private GoalDao goalDao;

    @InjectMocks
    private GoalService goalService;

    @Test
    void getAllGoals() {
        // Prepare data
        List<Goal> goalList = new ArrayList<>();
        goalList.add(new Goal());
        goalList.add(new Goal());

        // Mock repository method
        Mockito.when(goalDao.findAll()).thenReturn(goalList);

        // Call service method
        List<Goal> result = goalService.getAllGoals();

        // Verify
        assertEquals(goalList.size(), result.size());
    }

    @Test
    void getGoalById() {
        // Prepare data
        Goal goal = new Goal();
        goal.setGoal_id(1);

        // Mock repository method
        Mockito.when(goalDao.findById(1)).thenReturn(Optional.of(goal));

        // Call service method
        Optional<Goal> result = goalService.getGoalById(1);

        // Verify
        assertEquals(goal, result.orElse(null));
    }

    @Test
    void addGoal() {
        // Prepare data
        Goal goal = new Goal();

        // Mock repository method
        Mockito.when(goalDao.save(any(Goal.class))).thenReturn(goal);

        // Call service method
       boolean result = goalService.addGoal(goal);

        // Verify
//        assertEquals("Goal added successfully", result.getBody());
//        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void updateGoal() {
        // Prepare data
        Goal goal = new Goal();
        goal.setGoal_id(1);

        Goal updatedGoal = new Goal();
        updatedGoal.setGoal_id(1);
        updatedGoal.setGoal_for("Updated Goal");

        // Mock repository method
        Mockito.when(goalDao.existsById(1)).thenReturn(true);
        Mockito.when(goalDao.save(any(Goal.class))).thenReturn(updatedGoal);

        // Call service method
        boolean result = goalService.updateGoal(updatedGoal);

        // Verify
//        assertEquals("Goal updated successfully", result.getBody());
//        assertEquals(HttpStatus.OK, result);
    }

    @Test
    void deleteGoal() {
        // Prepare data
        Goal goal = new Goal();
        goal.setGoal_id(1);

        // Mock repository method
        Mockito.when(goalDao.existsById(1)).thenReturn(true);

        // Call service method
        boolean result = goalService.deleteGoal(1);

        // Verify
//        assertEquals("Goal deleted successfully", result);
//        assertEquals(HttpStatus.OK, result);
//        verify(goalDao, times(1)).deleteById(1);
    }
}
