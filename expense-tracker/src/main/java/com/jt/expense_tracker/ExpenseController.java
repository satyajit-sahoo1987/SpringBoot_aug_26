package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private  final JdbcTemplate jdbcTemplate;

    // public ExpenseController(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate=jdbcTemplate;
    // }//if add @RequiredArgsConstructor then no need to add constructor
    @RequestMapping(value="/expenses",method=RequestMethod.GET)
    public List<Expense> getExpenses(){
     String sql="SELECT * FROM expenses";

    //  List<Expense> expenses=new ArrayList<>();
    //  jdbcTemplate.query(sql,(resultSet)->{
    //     // System.out.println("id is :"+resultSet.getInt("id"));
    //     // System.out.println("title is :"+resultSet.getString("title"));
    //     // System.out.println("category is is :"+resultSet.getString("category"));

    //     // Expense expense=new Expense();//not required

//         var id=resultSet.getInt("id");
//         var title=resultSet.getString("title");
//         var category=resultSet.getString("category");
//         var price=resultSet.getDouble("price");
//         var date=resultSet.getDate("date").toLocalDate();

//         var expense=new Expense(id, title, category, price, date);
//         expenses.add(expense);
        
//      });
// return expenses;
    


// List<Expense> expenses=jdbcTemplate.query(sql,new BeanPropertyRowMapper<Expense>(Expense.class));
//      return expenses;

    return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Expense>(Expense.class));
    }
//query-multiple value extract,
// queryForObject-single row,
// update-DDL,DML
}
