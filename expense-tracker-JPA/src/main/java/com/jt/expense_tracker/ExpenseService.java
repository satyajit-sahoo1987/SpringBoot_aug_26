package com.jt.expense_tracker;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(int id){
     return expenseRepository.findById(id).orElseThrow(()->
    new RuntimeException("Unnable to find Expense with id:- "+id)
    );

    }

    public Expense addExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    public void deleteExpenseById(int id){
        getExpenseById(id);
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Expense expense){
        getExpenseById(expense.getId());
        return expenseRepository.save(expense);
    }
}

