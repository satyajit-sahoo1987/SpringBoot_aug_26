package com.example.methodsof._jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Entity 
@Data 
@AllArgsConstructor 
@Builder 

public class  Product{
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    private int productId;

    private String productName;

    private String productBrand;
    private double productPrice;
}
