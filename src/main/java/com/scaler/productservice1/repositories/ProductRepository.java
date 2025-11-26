package com.scaler.productservice1.repositories;

import com.scaler.productservice1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { //name of the model with it's primary key type, it gets that table from that model
    //Declared Queries
    @Override
    Optional<Product> findById(Long aLong);
    //findById is already declared in JpaRepository(A query and optional    stops/saves from NullpointerException)

    @Override
    List<Product> findAll(); //No chance of NullPointerException, atleast empty

    //select * from products where title = ?
    List<Product> findByTitle(String title);

    //select * from products where lower(title) LIKE '%str%'
    List<Product> findByTitleContainsIgnoreCase(String str);

    List<Product> findByPriceBetween(Double start, Double end);

    //select * from products where lower(title) LIKE '%str%' and price between ? and ?
    List<Product> findByTitleContainsIgnoreCaseAndPriceBetween(String title, Double start, Double end);

    List<Product> findByCreatedAtBetween(Date start, Date end);

    @Override
    void deleteById(Long aLong);

    boolean existsById(Long aLong);

    /*c r u d
    c,u -> upsert
    think of it, DB creates table, if ID is present in DB, it updates else creates new entry
     */

    Product save(Product product); //upsert operation

    //Query : find the title and price of the product with id=10;
    //select title, price from products where id=10;



    //important ***
//    @Query("select p.title as title, p.price as price from Product p where p.id= :id") //HQL/Hibernate Query Language
//    @Query(value="select title, price from products where id= :id", nativeQuery = true)
//
//    @Query(value="select p.title, p.price from products where p.id=2", nativeQuery = true)

//    @Query("select p.title as title, p.price as price from Product p where p.id=1") //HQL/Hibernate Query Language
//    List<ProductWithTitleAndPrice> findTitleandPriceById(@Param("id") Long id); //If we have return type with exact some interface, Jpa tried to typecast it into the above type. Captures the above response and called as projections. Because we must return something
//    @Query(value="select title, price from products where id=2", nativeQuery = true)
//    List<ProductWithTitleAndPrice> findTitleandPriceById();



}
