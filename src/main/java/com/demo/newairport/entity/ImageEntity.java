package com.demo.newairport.entity;

import jakarta.persistence.*;

import java.awt.*;

@Entity
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;

    @Lob
    private byte[] data;

    public ImageEntity(){
    }
    public ImageEntity(Long image_id, byte[] data){
        this.image_id = image_id;
        this.data = data;
    }
    // getters and setters
    public Long getImage_id(){
        return image_id;
    }

    public byte[] getData(){
        return data;
    }
    public void setData(byte[] data){
        this.data = data;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }
}