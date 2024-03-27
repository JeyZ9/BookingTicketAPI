package com.demo.newairport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Duration;

@Entity
@Table
public class BaggageEntity {
    @Id
    @Column(unique = true)
    private Long bagId;
    private String bagName;
    private Double price;

    public BaggageEntity(){}
    public BaggageEntity(Long bagId, String bagName, Double price){
        this.bagId = bagId;
        this.bagName = bagName;
        this.price = price;
    }

    // Getter and Setter


    public Long getBagId() {
        return bagId;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagId(Long bagId) {
        bagId = bagId;
    }

    public void setBagName(String bagName) {
        bagName = bagName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "{" +
                "BagId=" + bagId + ", BagName=" + bagName + ", price" + price
                + "}";
    }
}
