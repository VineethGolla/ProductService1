package com.scaler.productservice1.services;

import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.models.Category;
import com.scaler.productservice1.models.Product;
import com.scaler.productservice1.repositories.CategoryRepository;
import com.scaler.productservice1.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct =productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(productId);
        }

        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {

//        if(product.getId() != null){//may be a random id
//            Optional<Product> optionalProduct =productRepository.findById(product.getId());
//            if(optionalProduct.isEmpty()){ // check product exists with that id
//                throw new RuntimeException("Invalid product");
//            }
//        }

        Category category = product.getCategory();
        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());
        if(optionalCategory.isEmpty()){
            //create a category
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }else{
            product.setCategory(optionalCategory.get());
        }

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product getTitleAndPriceById(Long productId) throws RuntimeErrorException, ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(productId);
        }

        Product existingProduct = optionalProduct.get();
        Product summaryProduct = new Product();
        summaryProduct.setId(existingProduct.getId());
        summaryProduct.setTitle(existingProduct.getTitle());
        summaryProduct.setPrice(existingProduct.getPrice());
        return summaryProduct;
    }
}