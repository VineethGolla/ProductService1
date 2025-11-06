package com.scaler.productservice1.controllers;

import com.scaler.productservice1.models.Product;
import com.scaler.productservice1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/products") // endpoint - /products

public class ProductController {

    @Autowired
    private ProductService productService;

    //localhost:8080/products/1
    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) { //replace productID with value inside PathVariable
        return productService.getSingleProduct(productId);
    }

    //localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    //localhost:8080/products
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product){
        //replace the existing product with id with the product
        return null;
    }



}
