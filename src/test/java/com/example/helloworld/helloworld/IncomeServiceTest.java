package com.example.helloworld.helloworld;

import com.example.helloworld.helloworld.Dao.IncomeDao;
import com.example.helloworld.helloworld.Entity.Income;
import com.example.helloworld.helloworld.Service.IncomeService;
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
class IncomeServiceTest {

    @Mock
    private IncomeDao incomeDao;

    @InjectMocks
    private IncomeService incomeService;

    @Test
    void getIncome() {
        // Prepare data
        List<Income> incomeList = new ArrayList<>();
        incomeList.add(new Income());
        incomeList.add(new Income());

        // Mock repository method
        Mockito.when(incomeDao.findAll()).thenReturn(incomeList);

        // Call service method
        List<Income> result = incomeService.getIncome();

        // Verify
        assertEquals(incomeList.size(), result.size());
    }

    @Test
    void getIncomeById() {
        // Prepare data
        Income income = new Income();
        income.setIncome_id(1);

        // Mock repository method
        Mockito.when(incomeDao.findById(1)).thenReturn(Optional.of(income));

        // Call service method
//        boolean result = incomeService.getIncomeById(1);

        // Verify
//        assertEquals(income, result.orElse(null));
    }

    @Test
    void addIncome() {
        // Prepare data
        Income income = new Income();

        // Mock repository method
        Mockito.when(incomeDao.save(any(Income.class))).thenReturn(income);

        // Call service method
        boolean result = incomeService.addIncome(income);

        // Verify
//        assertEquals("Income added successfully", result.getBody());
//        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void updateIncome() {
        // Prepare data
        Income income = new Income();
        income.setIncome_id(1);

        Income updatedIncome = new Income();
        updatedIncome.setIncome_id(1);
        updatedIncome.setAmount(100.0);

        // Mock repository method
        Mockito.when(incomeDao.existsById(1)).thenReturn(true);
        Mockito.when(incomeDao.save(any(Income.class))).thenReturn(updatedIncome);

        // Call service method
       boolean result = incomeService.updateIncome(updatedIncome);

        // Verify
//        assertEquals("Income updated successfully", result);
//        assertEquals(HttpStatus.OK, result);
    }

    @Test
    void deleteIncome() {
        // Prepare data
        Income income = new Income();
        income.setIncome_id(1);

        // Mock repository method
        Mockito.when(incomeDao.existsById(1)).thenReturn(true);

        // Call service method
        boolean result = incomeService.deleteIncome(1);

        // Verify
//        assertEquals("Income deleted successfully", result);
//        assertEquals(HttpStatus.OK, result);
//        verify(incomeDao, times(1)).deleteById(1);
    }
}
