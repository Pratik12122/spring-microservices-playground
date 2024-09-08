package com.service.discovery.payment_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Random;

@RestController
public class PaymentController {

    @Value("${spring.profiles.active:local}")
    private String activeProfile;

    @GetMapping("/payments")
    public String getPayments() {
        try {
            Thread.sleep(Duration.ofSeconds(new Random().nextInt(11)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Payment response from : " + activeProfile ;
    }
}
