package com.example.methodsof._jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity 
@Data 
@AllArgsConstructor 
@Builder 
@NoArgsConstructor 
public class  Product{
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    private int productId;

    private String productName;

    private String productBrand;
    private double productPrice;
}
