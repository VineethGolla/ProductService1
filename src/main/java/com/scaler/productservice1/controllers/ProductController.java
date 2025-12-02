package com.scaler.productservice1.controllers;

import com.scaler.productservice1.commons.AuthCommons;
import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.models.Product;
import com.scaler.productservice1.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/products") // endpoint - /products
//@AllArgsConstructor  ( must use Quallifier if more than one implementation of interface exists)
public class ProductController {
    private ProductService productService;

//    public ProductController(@Qualifier("selfProductService") ProductService productService) { //two implementations of ProductService exist, so we use Qualifier to specify which one to use, we can also use one Bean as primary so that we don't have to use Qualifier every time
//        this.productService = productService;
//    }
    public ProductController(ProductService productService) { //two implementations of ProductService exist, so we use Qualifier to specify which one to use, we can also use one Bean as primary so that we don't have to use Qualifier every time
        this.productService = productService;
    }
    //constructor is needed to get the access of that created bean to this class to pass as productService.someMethod()

    //localhost:8080/products/1
    @GetMapping("/{productId}/{tokenValue}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId, @PathVariable("tokenValue") String tokenValue) throws ProductNotFoundException { //replace productID with value inside PathVariable

        Product product=null;
        ResponseEntity<Product> responseEntity=null;
        if(!AuthCommons.ValidateToken(tokenValue)) {
            responseEntity = new ResponseEntity<>(product, HttpStatus.UNAUTHORIZED);
        }else{
            product = productService.getSingleProduct(productId);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        }
        return responseEntity;
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

    @GetMapping("/summary/{productId}")
    public Product getTitleAndPriceById(@PathVariable("productId") Long productId) throws ProductNotFoundException { //replace productID with value inside PathVariable
        return productService.getTitleAndPriceById(productId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        productService.deleteproductByid(productId);
        return new ResponseEntity<String>("Product with id " + productId + " deleted successfully", HttpStatus.OK);
    }


    //first checks for exception handler in Controller itself then Global exception Handler and then the others
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException() {
        return new ResponseEntity<>("Product Not Found, try again", HttpStatus.NOT_FOUND);
    }
}