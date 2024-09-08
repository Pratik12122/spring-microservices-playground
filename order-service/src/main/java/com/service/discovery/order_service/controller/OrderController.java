package com.service.discovery.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/orders")
    public String getOrders() {
        String paymentDetails = restTemplate.getForObject("http://payment-service/payments", String.class);
        return  "Order list: [Order1, Order2, Order3] " + paymentDetails ;
    }
}
