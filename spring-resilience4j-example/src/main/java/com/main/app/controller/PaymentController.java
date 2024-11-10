package com.main.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
    private PaymentService paymentService;

    @GetMapping("/processPayment")
    public String processPayment() {
        return paymentService.processPayment();
    }

    @GetMapping("/simulateFailure")
    public String simulateFailure() {
        return paymentService.simulateFailure();
    }

}
