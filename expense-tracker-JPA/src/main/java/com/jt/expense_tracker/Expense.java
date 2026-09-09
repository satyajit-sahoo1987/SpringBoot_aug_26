package com.jt.expense_tracker;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity 
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;
    private String title;
    private String category;
    private BigDecimal price;
    private LocalDate date;

    // private int description;
    // private BigDecimal price;
    // public Expense(){

    // }
    
    // public int getId() {
    //     return id;
    // }
    // public Expense(int id, String title, String category, double price, LocalDate date) {
    //     this.id = id;
    //     this.title = title;
    //     this.category = category;
    //     this.price = price;
    //     this.date = date;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    // public String getCategory() {
    //     return category;
    // }
    // public void setCategory(String category) {
    //     this.category = category;
    // }
    // public double getPrice() {
    //     return price;
    // }
    // public void setPrice(double price) {
    //     this.price = price;
    // }
    // public LocalDate getDate() {
    //     return date;
    // }
    // public void setDate(LocalDate date) {
    //     this.date = date;
    // }

}
