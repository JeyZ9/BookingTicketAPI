package com.demo.newairport.payment.controller;

import com.demo.newairport.payment.client.CustomerRequest;
import com.demo.newairport.payment.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stripe")
public class StripeController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/create-customer")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequest customerRequest) {
        try {
            String email = customerRequest.getEmail();
            String name = customerRequest.getName();

            Customer customer = stripeService.createCustomer(email, name);

            return ResponseEntity.ok("Customer created successfully. Customer ID: " + customer.getId());
        } catch (StripeException e) {
            return ResponseEntity.status(500).body("Failed to create customer. Error: " + e.getMessage());
        }
    }
}
