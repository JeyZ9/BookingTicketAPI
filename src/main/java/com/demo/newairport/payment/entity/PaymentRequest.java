package com.demo.newairport.payment.entity;

public class PaymentRequest {

    private String token;
    private String email;
    private String customerId;  // For chargeCustomerCard
    private double amount;

    public PaymentRequest(){}

    public PaymentRequest(String token, String email, String customerId,double amount){
        this.token = token;
        this.email = email;
        this.customerId = customerId;
        this.amount = amount;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getToken() {
        return token;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
