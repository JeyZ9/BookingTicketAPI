package com.demo.newairport.payment.controller;

import com.demo.newairport.payment.client.CustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    @PostMapping("/customer/create-customer")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequest customerRequest) {
        // Implement logic to create a customer
        // You may interact with Stripe or any other payment service
        return ResponseEntity.ok("Customer created successfully");
    }
}
