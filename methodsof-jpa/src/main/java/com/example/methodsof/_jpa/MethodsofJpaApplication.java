package com.example.methodsof._jpa;

import java.beans.BeanProperty;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor 
public class MethodsofJpaApplication {
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MethodsofJpaApplication.class, args);
	}

	@Bean 
	public CommandLineRunner commandLineRunner(){
		return args->{
			Product product=Product.builder()
			.productName("Iphone 17 Pro Max")
			.productBrand("Apple")
			.productPrice(180000.99)
			.build();

			//  SAVE
			// Product savedProduct = productRepository.save(product);
			// System.out.println("saved product is:- " + savedProduct);

			// SAVEALL
			// productRepository.saveAll(getProducts());

			// COUNT
			// long totalProducts = productRepository.count();
			// System.out.println("total number of products is:-" + totalProducts);

			// Exists & Exists By ID
			// boolean isIphoneExists = productRepository.existsById(100);
			// System.out.println(" is Iphone 17 exists " + isIphoneExists);
			
			// Product existingProduct = productRepository.findById(1).orElseThrow();	
			// boolean isIphoneExists2 = productRepository.exists(Example.of(existingProduct));
			// System.out.println(" is Iphone 17 exists 2:- " + isIphoneExists2);

			//DELETE ALL
			// List<Product>products=prodcuctRepository.findAll();
			// productRepository.deleteAll(products);
           
			//Find all
			// List<Product> products=productRepository.findAll(Sort.by(Direction.DESC,"productPrice"));
			// Page <Product> products=productRepository.findAll(PageRequest.of(1,5,Direction.DESC,"productId"));
			// System.out.println("Page information is :"+products);
			//page number->which page available(0 baesd indexing)
			//page size->number of data inside the page
			// products.forEach(System.out::println);
            
			//update
			// Product updateProd = productRepository.findById(1).orElseThrow();
			// updateProd.setProductBrand("Samsung");
			// updateProd.setProductName("Samsung Ulta 23");
			// productRepository.save(updateProd);

        //    Product optGalaxy= productRepository.findByProductName("product-5").orElseThrow();
		//    System.out.println(optGalaxy);

		//    productRepository.findAllByProductPriceBetween(10000, 50000)
		//    .forEach(System.out::println);

		//    productRepository.findDistinctByProductName("product-9")
		//    .forEach(System.out::println);

		//    productRepository.findByProductNameAndProductBrand("Iphone 17 Pro Max","Apple")
		//    .forEach(System.out::println);
		//    productRepository.findByProductNameOrProductBrand("Iphone 17 Pro Max","Apple")
		//    .forEach(System.out::println);

		// List<Product> checkProduct=productRepository.findByProductNameIs("Apple");
		// System.out.println(checkProduct);
		//equals
		// List<Product> checkProduct=productRepository.findByProductNameEquals("Apple");
		// System.out.println(checkProduct);
		//less than
		// List<Product> checkProduct=productRepository. findByProductPriceLessThan(50000);
		// System.out.println(checkProduct);
        //less than equal
		// List<Product> checkProduct=productRepository. findByProductPriceLessThanEqual(50000);
		// System.out.println(checkProduct);
       //greaterthan
		// List<Product> checkProduct=productRepository.findByProductPriceGreaterThan(50000);
		// System.out.println(checkProduct);

		// List<Product> checkProduct=productRepository.findByProductPriceGreaterThan(50000);
		// System.out.println(checkProduct);

		// List<Product> checkDate=productRepository. findByCreatedDateAfter(LocalDate.of(2026,9,18));
		// System.out.println(checkDate);
		//isnull
		//  List<Product> checkProduct=productRepository.findByProductBrandIsNull();
		// System.out.println(checkProduct);
		//  List<Product> checkProduct=productRepository.findByProductBrandIsNotNull();
		// System.out.println(checkProduct);
		//like
		//  List<Product> checkProduct=productRepository.findByProductNameLike("%Iphone 17 Pro Max%");
		// System.out.println(checkProduct);
         //not like
		//  List<Product> checkProduct=productRepository.findByProductNameNotLike("%Iphone 17 Pro Max%");
		// System.out.println(checkProduct);
        //startingwith
		//  List<Product> checkProduct=productRepository.findByProductNameStartingWith("Iphone");
		// System.out.println(checkProduct);
		//endingwith
		//  List<Product> checkProduct=productRepository.findByProductNameEndingWith("Max");
		// System.out.println(checkProduct);
         //containing
		//  List<Product> checkProduct=productRepository.findByProductNameContaining("product-1");
		// System.out.println(checkProduct);
		//OrderBy
		//  List<Product> checkProduct=productRepository.findByProductBrandOrderByProductPriceAsc("brand-1");
		//  List<Product> checkProduct=productRepository.findByProductBrandOrderByProductPriceDesc("brand-1");
		// System.out.println(checkProduct);
		   

         //if i have required-> a product by ite name of or
		 //we use  1->Custom Query Methods
		 //2->JPQL
		 //3->normal sql query

		};
	}
private List<Product> getProducts(){
	return IntStream.range(1,10).mapToObj(i->Product.builder()
	.productName("product-"+i)
	.productBrand("brand-"+i)
	.productPrice(10000*i)
	.build())
	.toList();
}

}
