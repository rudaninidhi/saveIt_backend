package com.example.helloworld.helloworld;

import com.example.helloworld.helloworld.dao.BudgetDao;
import com.example.helloworld.helloworld.entity.Budget;
import com.example.helloworld.helloworld.service.BudgetService;
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
class BudgetServiceTest {

    @Mock
    private BudgetDao budgetDao;

    @InjectMocks
    private BudgetService budgetService;

    @Test
    void getBudget() {
        List<Budget> budgetList = new ArrayList<>();
        budgetList.add(new Budget());
        budgetList.add(new Budget());

        Mockito.when(budgetDao.findAll()).thenReturn(budgetList);

        List<Budget> result = budgetService.getBudget();

        assertEquals(budgetList.size(), result.size());
    }

    @Test
    void getBudgetById() {
        Budget budget = new Budget();
        budget.setBudget_id(1);

        Mockito.when(budgetDao.findById(1)).thenReturn(Optional.of(budget));

        Optional<Budget> result = budgetService.getBudgetById(1);

        assertEquals(budget, result.orElse(null));
    }

    @Test
    void addBudget() {
        Budget budget = new Budget();

        Mockito.when(budgetDao.save(any(Budget.class))).thenReturn(budget);

        boolean result = budgetService.addBudget(budget);

        assertEquals(true, result);
    }

    @Test
    void updateBudget() {
        Budget budget = new Budget();
        budget.setBudget_id(10);

        Budget updatedBudget = new Budget();
        updatedBudget.setBudget_id(10);
        updatedBudget.setAmount(100.0);

        Mockito.when(budgetDao.existsById(10)).thenReturn(true);
        Mockito.when(budgetDao.save(any(Budget.class))).thenReturn(updatedBudget);

        boolean result = budgetService.updateBudget(updatedBudget);

        assertEquals(true, result);
    }

    @Test
    void deleteBudget() {
        Budget budget = new Budget();
        budget.setBudget_id(10);

        Mockito.when(budgetDao.existsById(1)).thenReturn(true);

        boolean result = budgetService.deleteBudget(1);

        assertEquals(true, result);
        verify(budgetDao, times(1)).deleteById(1);
    }
}
