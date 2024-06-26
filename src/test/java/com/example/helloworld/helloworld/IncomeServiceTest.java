package com.example.helloworld.helloworld;

import com.example.helloworld.helloworld.dao.IncomeDao;
import com.example.helloworld.helloworld.entity.Income;
import com.example.helloworld.helloworld.service.IncomeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        income.setIncomeId(1);

        // Mock repository method
        Mockito.when(incomeDao.findById(1)).thenReturn(Optional.of(income));

        // Call service method
        Optional<?> result = incomeService.getIncomeById(1);

        // Verify
        assertEquals(true, result.isPresent());
    }

    @Test
    void addIncome() {
        // Prepare data
        Income income = new Income();

        // Mock repository method
        Mockito.when(incomeDao.save(Mockito.any(Income.class))).thenReturn(income);

        // Call service method
        boolean result = incomeService.addIncome(income);

        // Verify
        assertEquals(true, result);
    }

    @Test
    void updateIncome() {
        // Prepare data
        Income income = new Income();
        income.setIncomeId(1);

        Income updatedIncome = new Income();
        updatedIncome.setIncomeId(1);
        updatedIncome.setIncomeAmount(100);

        // Mock repository method
        Mockito.when(incomeDao.existsById(1)).thenReturn(true);
        Mockito.when(incomeDao.save(Mockito.any(Income.class))).thenReturn(updatedIncome);

        // Call service method
        boolean result = incomeService.updateIncome(updatedIncome);

        // Verify
        assertEquals(true, result);
    }

    @Test
    void deleteIncome() {
        // Prepare data
        Income income = new Income();
        income.setIncomeId(1);

        // Mock repository method
        Mockito.when(incomeDao.existsById(1)).thenReturn(true);

        // Call service method
        boolean result = incomeService.deleteIncome(1);

        // Verify
        assertEquals(true, result);
    }
}
