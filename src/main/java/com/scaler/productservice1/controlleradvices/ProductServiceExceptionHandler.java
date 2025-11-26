package com.scaler.productservice1.controlleradvices;

import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handleRuntimeException() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException() {
        return new ResponseEntity<>("Try with valid ProductID",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        //This object ProductNotFoundException was created already, we receive it and use ID
        return new ResponseEntity<>(
                productNotFoundException.getProductId() +" is an invalid ProductID, pass a valid Id yoo",
                HttpStatus.NOT_FOUND);
    }
}