package com.scaler.productservice1.services;

import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.models.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product);

    Product getTitleAndPriceById(Long productId) throws ProductNotFoundException;
    void deleteproductByid(Long productId) throws ProductNotFoundException;

    Page<Product> getProductsByCategoryTitleIgnoreCase(String title, int page, int size);

}
