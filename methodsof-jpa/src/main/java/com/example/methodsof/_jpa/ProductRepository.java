package com.example.methodsof._jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByProductName(String name);
    List<Product> findAllByProductPriceBetween(double startPrice,double endPrice);
//distinct
List<Product> findDistinctByProductName(String productName);

List<Product> findByProductNameAndProductBrand( String productName,String productBrand);
List<Product> findByProductNameOrProductBrand( String productName,String productBrand);
List<Product> findByProductNameIs(String productName);
//equals
List<Product> findByProductNameEquals(String productName);
//less than
List<Product> findByProductPriceLessThan(double price);
//less than equal
List<Product> findByProductPriceLessThanEqual(double price);
//greaterthan
List<Product> findByProductPriceGreaterThan(double price);
// List<Product> findByCreatedDateAfter(LocalDate date);
// List<Product> findByCreatedDateBefore(LocalDate date);
List<Product> findByProductBrandIsNull();
List<Product> findByProductBrandIsNotNull();
List<Product> findByProductNameLike(String productName);
List<Product> findByProductNameNotLike(String productName);
//startingwith
List<Product> findByProductNameStartingWith(String name);
//endingwith
List<Product> findByProductNameEndingWith(String name);
List<Product> findByProductNameContaining(String name);
//orderBy
List<Product> findByProductBrandOrderByProductPriceAsc(String productBrand);
// List<Product> findByProductBrandOrderByProductPriceDesc(String productBrand);

}
