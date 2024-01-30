package com.demo.newairport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class BaggageEntity {
    @Id
    @Column(unique = true)
    private Long bagId;
    private String bagName;
    private int price;

    public BaggageEntity(){}
    public BaggageEntity(Long bagId, String bagName, int price){
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "{" +
                "BagId=" + bagId + ", BagName=" + bagName + ", price" + price
                + "}";
    }
}
