package com.scaler.productservice1.controllers;

import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.models.Product;
import com.scaler.productservice1.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;
//
//    @MockBean
//    private ProductService productService;
//
//    @Test
//        public void testGetSingleProduct() throws ProductNotFoundException {
//        Long productId = 10L;
//
//        Product product1 = new Product();
//        when(productService.getSingleProduct(productId)).
//                thenReturn(product1);
//        //when() is a persistent rule that applies to all calls throughout the test, not a one-time assignment like regular statements.
//        //So even in next statement, it gets applied
//
//        Product product2= productController.getSingleProduct(productId);
//
//        assertEquals(product2, product1,"Products aren't same");
//    }
//
//    @Test
//    public void testGetSingleProductInvalidId() throws ProductNotFoundException {
//        Long productId = -1L;
//
////        when(productService.getSingleProduct(productId))
////            .thenThrow(new ProductNotFoundException(productId));
////
////        assertThrows(
////                ProductNotFoundException.class,
////                () -> productController.getSingleProduct(productId)
////        );
//
//        when(productService.getSingleProduct(productId))
//            .thenThrow(new ProductNotFoundException());
//
//        assertThrows(
//                ProductNotFoundException.class,
//                ()->productController.getSingleProduct(productId)
//        );
//    }
//
//    @Test
//    public void testGetAllProducts() {
//        Product product1 = new Product();
//        Product product2 = new Product();
//
//        List<Product> expectedProducts = List.of(product1, product2);
//
//        when(productService.getAllProducts())
//                .thenReturn(expectedProducts);
//
//        List<Product> actualProducts = productController.getAllProducts();
//
//        assertArrayEquals(expectedProducts.toArray(), actualProducts.toArray(),
//                "Product lists are not the same");
//    }
//
}
