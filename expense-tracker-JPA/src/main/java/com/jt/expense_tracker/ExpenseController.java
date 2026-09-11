package com.jt.expense_tracker;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
@CrossOrigin("http://localhost:5173") 
public class ExpenseController {
    

    // private final ExpenseRepository expenseRepository;
    private final ExpenseService expenseService;

    @GetMapping(value="/expenses")
    public List<Expense> getExpenses(){

      return expenseService.getExpenses();
}

    @GetMapping(value="/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id){

        
        // var sql="SELECT * FROM expenses WHERE id=?";
    //      Expense expense=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Expense>(Expense.class),id);
    //   return expense;

    // Optional<Expense> optExp=expenseRepository.findById(id);
//    Expense expense=optExp.orElseThrow();
// Expense expense=optExp.orElseThrow(()->
// new RuntimeException("unable to find Expense with id :-"+id));    
//    return expense;

return expenseService.getExpenseById(id);



    }
    // @RequestMapping(value="/expenses",method=RequestMethod.POST)
    @PostMapping(value="/expenses")
    @ResponseStatus(code = HttpStatus.CREATED) 
    public Expense createExpense(@RequestBody Expense expense){
        // var sql="   INSERT INTO %s (title,category,price,date) VALUES (?,?,?,?)".formatted(EXPENSES_TABLE);
        // jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),
        // expense.getPrice(),expense.getDate());
        // return expense;
        Expense savedExpense=expenseService.addExpense(expense);
        return savedExpense;
    }
    // @RequestMapping(value="/expenses/{id}",method=RequestMethod.DELETE)
    @DeleteMapping(value="/expenses/{id}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT) 
    public void deleteExpense(@PathVariable int id){
        // var sql="DELETE FROM %s WHERE id=?".formatted(EXPENSES_TABLE);
        // jdbcTemplate.update(sql,id);

    //    Expense toBeDeletedExpense =getExpenseById(id);
    //    expenseRepository.delete(toBeDeletedExpense);
     getExpenseById(id);
       expenseService.deleteExpenseById(id);
    }

 @PutMapping(value="/expenses")
 @ResponseStatus(HttpStatus.ACCEPTED) 
    public Expense updateExpense(@RequestBody Expense expense){
        // var sql="UPDATE %s SET title=?,category=?,price=?,date=? WHERE id=?".formatted(EXPENSES_TABLE);
        // jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),
        // expense.getPrice(),expense.getDate(),expense.getId());
        // return getExpenseById(expense.getId());

        getExpenseById(expense.getId());
       return expenseService.updateExpense(expense);
    }
//query-multiple value extract,
// queryForObject-single row,
// update-DDL,DML
}
