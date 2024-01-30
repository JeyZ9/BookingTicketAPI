package com.demo.newairport.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_booking")
public class TableBookingEntity {
    @GeneratedValue
    @Id
    private String bookingId;
    private String bookingTime;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customerId;

    public TableBookingEntity(){

    }

    public TableBookingEntity(String bookingId, String bookingTime, CustomerEntity customer){
        this.bookingId = bookingId;
        this.bookingTime = bookingTime;
        this.customerId = customer;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public CustomerEntity getCustomerId() {
        return customerId;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setCustomerId(CustomerEntity customerId) {
        this.customerId = customerId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "{" + "\'" +
                "customerId=" + customerId + "\'" +
                ", bookingTime=" + bookingTime + "\'" +
                ", customerId=" + customerId + "\'" +
                "}";
    }

}
