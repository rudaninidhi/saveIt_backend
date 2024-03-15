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

import java.util.ArrayList;
import java.util.List;
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
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(new Expense());
        expenseList.add(new Expense());

        Mockito.when(expenseDao.findAll()).thenReturn(expenseList);

        List<Expense> result = expenseService.getexpense();

        assertEquals(expenseList.size(), result.size());
    }



    @Test
    void deleteExpense() {
        Expense expense = new Expense();
        expense.setExpense_id(19);

        Mockito.when(expenseDao.existsById(19)).thenReturn(true);

        boolean result = expenseService.deleteExpense(19);

        assertEquals(true, result);
    }
}
