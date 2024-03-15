package com.example.helloworld.helloworld.Service;

import com.example.helloworld.helloworld.Dao.IncomeDao;
import com.example.helloworld.helloworld.Entity.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    IncomeDao income;

    public List<Income> getIncome() {
        return income.findAll();
    }

    public Optional<Income> getIncomeById(int id) {
        return income.findById(id);
    }

    public List<Income> getIncomeByUserId(int id) {
        return income.findIncomesByUserId(id);
    }

    public boolean addIncome(@RequestBody Income income1) {
        try {
            income.save(income1);
            System.out.println("here" + income1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateIncome(Income updatedIncome) {
        try {
            if (!income.existsById(updatedIncome.getIncome_id())) {
                return false;
            }
            income.save(updatedIncome);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteIncome(int incomeId) {
        try {
            if (income.existsById(incomeId)) {
                income.deleteById(incomeId);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
