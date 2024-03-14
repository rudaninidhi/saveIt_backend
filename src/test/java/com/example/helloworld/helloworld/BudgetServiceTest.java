
package com.example.helloworld.helloworld;

import com.example.helloworld.helloworld.Dao.BudgetDao;
import com.example.helloworld.helloworld.Entity.Budget;
import com.example.helloworld.helloworld.Service.BudgetService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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
        // Prepare data
        List<Budget> budgetList = new ArrayList<>();
        budgetList.add(new Budget());
        budgetList.add(new Budget());

        // Mock repository method
        Mockito.when(budgetDao.findAll()).thenReturn(budgetList);

        // Call service method
        List<Budget> result = budgetService.getBudget();

        // Verify
        assertEquals(budgetList.size(), result.size());
    }

    @Test
    void getBudgetById() {
        // Prepare data
        Budget budget = new Budget();
        budget.setBudget_id(1);

        // Mock repository method
        Mockito.when(budgetDao.findById(1)).thenReturn(Optional.of(budget));

        // Call service method
        Optional<Budget> result = budgetService.getBudgetById(1);

        // Verify
        assertEquals(budget, result.orElse(null));
    }

    @Test
    void addBudget() {
        // Prepare data
        Budget budget = new Budget();

        // Mock repository method
        Mockito.when(budgetDao.save(any(Budget.class))).thenReturn(budget);

        // Call service method
        ResponseEntity<String> result = budgetService.addBudget(budget);

        // Verify
        assertEquals("budget added successfully", result.getBody());
    }

    @Test
    void updateBudget() {
        // Prepare data
        Budget budget = new Budget();
        budget.setBudget_id(1);

        Budget updatedBudget = new Budget();
        updatedBudget.setBudget_id(1);
        updatedBudget.setAmount(100.0);

        // Mock repository method
        Mockito.when(budgetDao.existsById(1)).thenReturn(true);
        Mockito.when(budgetDao.save(any(Budget.class))).thenReturn(updatedBudget);

        // Call service method
        ResponseEntity<String> result = budgetService.updateBudget(updatedBudget);

        // Verify
        assertEquals("budget updated successfully", result.getBody());
    }

    @Test
    void deleteBudget() {
        // Prepare data
        Budget budget = new Budget();
        budget.setBudget_id(1);

        // Mock repository method
        Mockito.when(budgetDao.existsById(1)).thenReturn(true);

        // Call service method
        ResponseEntity<String> result = budgetService.deleteBudget(1);

        // Verify
        assertEquals("Expense deleted successfully", result.getBody());
        verify(budgetDao, times(1)).deleteById(1);
    }
}
