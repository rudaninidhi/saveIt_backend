package com.example.helloworld.helloworld.service;

import com.example.helloworld.helloworld.dao.IncomeDao;
import com.example.helloworld.helloworld.entity.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean addIncome(Income income1) {
        System.out.println("here" + income1);
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
            if (!income.existsById(updatedIncome.getIncomeId())) {
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
