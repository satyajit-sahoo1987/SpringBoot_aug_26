package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor 
public class ExpenseController {
    private  final JdbcTemplate jdbcTemplate;
    private static final String EXPENSES_TABLE="expenses";

    // public ExpenseController(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate=jdbcTemplate;
    // }//if add @RequiredArgsConstructor then no need to add constructor
    // @RequestMapping(value="/expenses",method=RequestMethod.GET)
    @GetMapping(value="/expenses")
    public List<Expense> getExpenses(){
     String sql="SELECT * FROM %s".formatted(EXPENSES_TABLE);

    return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Expense>(Expense.class));
    }

    // @RequestMapping(value="/expenses/{id}",method=RequestMethod.GET)//id is path variable-Dynamic routing
    @GetMapping(value="/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id){

        // System.out.println("Id is :"+id);
        var sql="SELECT * FROM %s WHERE id=?".formatted(EXPENSES_TABLE);
        // var sql="SELECT * FROM expenses WHERE id=?";
         Expense expense=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Expense>(Expense.class),id);
      return expense;
    }
    // @RequestMapping(value="/expenses",method=RequestMethod.POST)
    @PostMapping(value="/expenses")
    public Expense createExpense(@RequestBody Expense expense){
        var sql="   INSERT INTO %s (title,category,price,date) VALUES (?,?,?,?)".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),
        expense.getPrice(),expense.getDate());
        return expense;
    }
    // @RequestMapping(value="/expenses/{id}",method=RequestMethod.DELETE)
    @DeleteMapping(value="/expenses/{id}")
    public void deleteExpense(@PathVariable int id){
        var sql="DELETE FROM %s WHERE id=?".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql,id);
        
    }

 @PutMapping(value="/expenses")
    public Expense updateExpense(@RequestBody Expense expense){
        var sql="UPDATE %s SET title=?,category=?,price=?,date=? WHERE id=?".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),
        expense.getPrice(),expense.getDate(),expense.getId());
        return getExpenseById(expense.getId());
    }
//query-multiple value extract,
// queryForObject-single row,
// update-DDL,DML
}
