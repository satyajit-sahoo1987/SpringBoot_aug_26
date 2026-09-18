package com.example.methodsof._jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByProductName(String name);
    List<Product> findAllByProductPriceBetween(double startPrice,double endPrice);
//distinct
List<Product> findDistinctByProductName(String productName);

Optional<Product> findByProductNameAndProductBrand( String productName,String productBrand);
List<Product> findByProductNameOrProductBrand( String productName,String productBrand);
List<Product> findByProductNameIs(String productName);
//equals
List<Product> findByProductNameEquals(String productName);
//less than
List<Product> findByProductPriceLessThan(double price);
//less than equal
List<Product> findByProductPriceLessThanEqual(double price);
//greaterthan
List<Product> findAllByProductPriceGreaterThanEqual(double price,Sort sort);
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


//======================JPQL->Java PersistenCE Query Language==============================================
// @Query("SELECT p FROM Product p WHERE p.productName=?1 AND p.productBrand=?2")//positional parameter
// Optional<Product>getProduct(String name,String brand);
// @Query("SELECT p FROM Product p WHERE p.productName=:name AND p.productBrand=:brand")//named parameter
// Optional<Product>getProduct(String name,String brand);
// raw SQL===========================
@Query(nativeQuery = true,value="SELECT * FROM product  WHERE product_name=? AND product_brand=?")
Optional<Product>getProduct(String name,String brand);

@Modifying 
@Transactional //1.while using any DML query or performing mulitple DB operation
@Query(nativeQuery = true,value="UPDATE product SET product_price=:price WHERE product_id=:id")
int updatePrice(int id,double price);
}
