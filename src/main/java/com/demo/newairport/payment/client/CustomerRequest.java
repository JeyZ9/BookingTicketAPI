package com.demo.newairport.payment.client;

// CustomerRequest.java
public class CustomerRequest {
    private String name;
    private String email;

    // Getters and setters

    public CustomerRequest(){}
    public CustomerRequest (String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

