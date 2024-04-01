package com.example.helloworld.helloworld.service;

import com.example.helloworld.helloworld.dao.BudgetDao;
import com.example.helloworld.helloworld.entity.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    BudgetDao budget;

    public List<Budget> getBudget() {
        return budget.findAll();
    }

    public Optional<Budget> getBudgetById(int id) {
        return budget.findById(id);
    }

    public List<Budget> getBudgetByUserId(int user_id) {
        return budget.findBudgetsByUserId(user_id);
    }
    public boolean addBudget(@RequestBody Budget budget1) {
        try {
            budget.save(budget1);
            System.out.println("here" + budget1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateBudget(Budget updatedBudget) {
        try {
            if (!budget.existsById(updatedBudget.getBudget_id())) {
                return false;
            }
            budget.save(updatedBudget);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteBudget(int budgetId) {
        try {
            if (budget.existsById(budgetId)) {
                budget.deleteById(budgetId);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
