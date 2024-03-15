package com.example.helloworld.helloworld;

import com.example.helloworld.helloworld.Dao.GoalDao;
import com.example.helloworld.helloworld.Entity.Goal;
import com.example.helloworld.helloworld.Service.GoalService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

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
        List<Goal> goalList = new ArrayList<>();
        goalList.add(new Goal());
        goalList.add(new Goal());

        Mockito.when(goalDao.findAll()).thenReturn(goalList);

        List<Goal> result = goalService.getAllGoals();

        assertEquals(goalList.size(), result.size());
    }

    @Test
    void getGoalById() {
        Goal goal = new Goal();
        goal.setGoal_id(1);

        Mockito.when(goalDao.findById(1)).thenReturn(Optional.of(goal));

        Optional<Goal> result = goalService.getGoalById(1);

        assertEquals(goal, result.orElse(null));
    }

    @Test
    void addGoal() {
        Goal goal = new Goal();

        Mockito.when(goalDao.save(any(Goal.class))).thenReturn(goal);

        boolean result = goalService.addGoal(goal);

        assertEquals(true, result);
    }

    @Test
    void updateGoal() {
        Goal goal = new Goal();
        goal.setGoal_id(1);

        Goal updatedGoal = new Goal();
        updatedGoal.setGoal_id(1);
        updatedGoal.setGoal_for("Updated Goal");

        Mockito.when(goalDao.existsById(1)).thenReturn(true);
        Mockito.when(goalDao.save(any(Goal.class))).thenReturn(updatedGoal);

        boolean result = goalService.updateGoal(updatedGoal);

        assertEquals(true, result);
    }

    @Test
    void deleteGoal() {
        Goal goal = new Goal();
        goal.setGoal_id(1);

        Mockito.when(goalDao.existsById(1)).thenReturn(true);

        boolean result = goalService.deleteGoal(1);

        assertEquals(true, result);
        verify(goalDao, times(1)).deleteById(1);
    }
}
