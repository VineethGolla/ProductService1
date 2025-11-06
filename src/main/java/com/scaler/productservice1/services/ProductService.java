package com.scaler.productservice1.services;

import com.scaler.productservice1.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product);
}
