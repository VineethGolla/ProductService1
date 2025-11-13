package com.scaler.productservice1.controllers;

import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.models.Product;
import com.scaler.productservice1.services.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/products") // endpoint - /products
//@AllArgsConstructor  ( must use Quallifier if more than one implementation of interface exists)
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) { //two implementations of ProductService exist, so we use Qualifier to specify which one to use, we can also use one Bean as primary so that we don't have to use Qualifier every time
        this.productService = productService;
    }

    //localhost:8080/products/1
    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException { //replace productID with value inside PathVariable
        return productService.getSingleProduct(productId);
    }

    //localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //localhost:8080/products
    @PostMapping()// create new product
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @PutMapping("/{id}")// replace existing product with id
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product){
        //replace the existing product with id with the product
        return null;
    }

    //first checks for exception handler in Controller itself then Global exception Handler and then the others
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException() {
        return new ResponseEntity<>("Product Not Found, try again", HttpStatus.NOT_FOUND);
    }

}
