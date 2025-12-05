package com.scaler.productservice1.services;

import  com.scaler.productservice1.dtos.FakeStoreProductDto;
import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.models.Category;
import com.scaler.productservice1.models.Product;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.coyote.Response;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service("fakeStoreProductService")
//@Primary or use Qualifier
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    //make a http call in spring boot application
    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class); //just like jpa returns <table, type> , here also we need something to return
        //Has body + status code + headers
        FakeStoreProductDto[] fakeStoreProductDtos = responseEntity.getBody();
        ArrayList<Product> products = new ArrayList<>();
        for(FakeStoreProductDto  fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;

    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //make a http call to fakestore api and get the product with given id
        //https://fakestoreapi.com/products/1
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class);
//Response of this API to convert to this Product object ---> "https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class
//        FakeStoreProductDto.class — Tells it to convert response body into FakeStoreProductDto objectRetryClaude can make mistakes. Please double-check responses.
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
//        if(fakeStoreProductDto == null) {
//            System.out.println("DEBUG");
//        }

        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException(productId);
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    //unwrap, convert
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto FakeStoreProductDto) {

//        if(FakeStoreProductDto == null) {
//            return null;
//        }
        Product product = new Product();
        product.setId(FakeStoreProductDto.getId());
        product.setTitle(FakeStoreProductDto.getTitle());
        product.setDescription(FakeStoreProductDto.getDescription());
        product.setPrice(FakeStoreProductDto.getPrice());
        product.setImageUrl(FakeStoreProductDto.getImage());
        Category category = new Category();
        category.setTitle(FakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

//    private List<Product> convertFakeStoreProductDtoToProducts(List<FakeStoreProductDto> FakeStoreProductDto) {
//
//        if(FakeStoreProductDto == null) {
//            return null;
//        }
//        List<Product> products= new ArrayList<>();
//
//        for(FakeStoreProductDto fakeStoreProductDto : FakeStoreProductDto) {
//            Product product = new Product();
//            product.setId(fakeStoreProductDto.getId());
//            product.setTitle(fakeStoreProductDto.getTitle());
//            product.setDescription(fakeStoreProductDto.getDescription());
//            product.setPrice(fakeStoreProductDto.getPrice());
//            product.setImageUrl(fakeStoreProductDto.getImage());
//            Category category = new Category();
//            category.setName(fakeStoreProductDto.getCategory());
//            product.setCategory(category);
//            products.add(product);
//        }
//        return products;
//    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product getTitleAndPriceById(Long productId)  {
        return null;
    }

    public void deleteproductByid(Long productId)  {

    }

    @Override
    public Page<Product> getProductsByCategoryTitleIgnoreCase(String title, int page, int size) {
        return null;
    }
}
