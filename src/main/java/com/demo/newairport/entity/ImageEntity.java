//package com.demo.newairport.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Table
//@Entity
//public class ImageEntity {
//
//    @GeneratedValue
//    @Id
//    private Long imageId;
//    private String imageName;
//    private String imagePath;
//
//    public ImageEntity(){}
//
//    public ImageEntity(String imageName, String imagePath){
//        this.imageName = imageName;
//        this.imagePath = imagePath;
//    }
//
//    public void setImageId(Long imageId) {
//        this.imageId = imageId;
//    }
//
//    public void setImageName(String imageName) {
//        this.imageName = imageName;
//    }
//
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }
//
//    public Long getImageId() {
//        return imageId;
//    }
//
//    public String getImageName() {
//        return imageName;
//    }
//
//    public String getImagePath() {
//        return imagePath;
//    }
//
//    @Override
//    public String toString(){
//        return "{" + "imageId" + imageId + "imageName=" + imageName + ", imagePath=" + imagePath + "}";
//    }
//}
