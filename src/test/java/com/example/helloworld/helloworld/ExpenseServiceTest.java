package com.example.helloworld.helloworld;

import com.example.helloworld.helloworld.Dao.ExpenseDao;
import com.example.helloworld.helloworld.Entity.Expense;
import com.example.helloworld.helloworld.Service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ExpenseServiceTest {

    @Mock
    private ExpenseDao expenseDao;

    @InjectMocks
    private ExpenseService expenseService;

    @Test
    void getExpense() {
        // Prepare data
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(new Expense());
        expenseList.add(new Expense());

        // Mock repository method
        Mockito.when(expenseDao.findAll()).thenReturn(expenseList);

        // Call service method
        List<Expense> result = expenseService.getexpense();

        // Verify
        assertEquals(expenseList.size(), result.size());
    }

    @Test
    void getExpenseById() {
        // Prepare data
        Expense expense = new Expense();
        expense.setExpense_id(19);

        // Mock repository method
        Mockito.when(expenseDao.findById(19)).thenReturn(Optional.of(expense));

        // Call service method
        Optional<Expense> result = expenseService.getExpenseById(1);

        // Verify
        assertEquals(expense, result.orElse(null));
    }

    @Test
    void addExpense() {
        // Prepare data
        Expense expense = new Expense();

        // Mock repository method
        Mockito.when(expenseDao.save(any(Expense.class))).thenReturn(expense);

        // Call service method
        ResponseEntity<String> result = expenseService.addExpense(expense);

        // Verify
        assertEquals("Expense added successfully", result.getBody());
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

//    @Test
//    void updateExpense() {
//        // Prepare data
//        Expense expense = new Expense();
//        expense.setExpense_id(20);
//
//        Expense updatedExpense = new Expense();
//        updatedExpense.setExpense_id(20);
//        updatedExpense.setAmount(100.0);
//
//        // Mock repository method
//        Mockito.when(expenseDao.existsById(20)).thenReturn(true);
//        Mockito.when(expenseDao.save(any(Expense.class))).thenReturn(updatedExpense);
//
//        // Call service method
//        ResponseEntity<String> result = expenseService.updateExpense(updatedExpense);
//
//        // Verify
//        assertEquals("Expense not found", result.getBody());
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//    }

    @Test
    void deleteExpense() {
        // Prepare data
        Expense expense = new Expense();
        expense.setExpense_id(19);

        // Mock repository method
        Mockito.when(expenseDao.existsById(19)).thenReturn(true);

        // Call service method
        ResponseEntity<String> result = expenseService.deleteExpense(1);

        // Verify
        assertEquals("Expense deleted successfully", result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(expenseDao, times(1)).deleteById(1);
    }
}
