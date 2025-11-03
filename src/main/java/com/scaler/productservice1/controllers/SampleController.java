package com.scaler.productservice1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//host Rest HTTP APIs.

@RequestMapping("/sample")
/*
when mapped/called or used /sample, point it to RequestMapping
for amazon
amazon.in/orders => Ordercontroller

amazon.in/payment => PaymentController

amazon.in/card => CartController
 */

public class SampleController {

    @GetMapping("/hello/{name}/{times}")
    public String sayhello(@PathVariable("name") String name,
                        @PathVariable("times") int x) {
        String s= "";

        for (int i = 0; i < x; i++) {
            s+= "Hello" + name + "! <br>";
        }
        return s;
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }

    //hello is endpoint and /hi is end point
}
