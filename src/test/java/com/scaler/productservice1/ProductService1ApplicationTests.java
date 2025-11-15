package com.scaler.productservice1;

import com.scaler.productservice1.projections.ProductWithTitleAndPrice;
import com.scaler.productservice1.repositories.ProductRepository;
import com.scaler.productservice1.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductService1ApplicationTests {
    @Autowired
    private ProductRepository  productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testQUERY(){
        List<ProductWithTitleAndPrice> productwithtitleandprice = productRepository.findTitleandPriceById();

        for(ProductWithTitleAndPrice p: productwithtitleandprice){
            System.out.println("Title: "+p.getTitle()+" Price: "+p.getPrice());
        }
    }

}
