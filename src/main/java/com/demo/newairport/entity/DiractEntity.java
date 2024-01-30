package com.demo.newairport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DiractEntity {
    @Id
    @Column(unique = true)
    private Long diractId;
    private String diractName;

    private int price;


    public DiractEntity(){}
    public DiractEntity(Long diractId, String diractName, int price){
        this.diractId = diractId;
        this.diractName = diractName;
        this.price = price;
    }

    // Getter and Setter


    public Long getDiractId() {
        return diractId;
    }

    public void setDiractId(Long diractId) {
        diractId = diractId;
    }

    public String getDiractName() {
        return diractName;
    }

    public void setDiractName(String diractName) {diractName = diractName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "DiractEntity{" + "diractId" + diractId + "diractName" + diractName + "price" + price + "} ";
    }
}
