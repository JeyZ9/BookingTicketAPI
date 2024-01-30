//package com.demo.newairport.services;
//
//import com.demo.newairport.entity.ImageEntity;
//import com.demo.newairport.repository.ImageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ImageService {
//    @Autowired
//    public ImageRepository imageRepository;
//
//    public ImageService(ImageRepository imageRepository) {
//        this.imageRepository = imageRepository;
//    }
//
//    public List<ImageEntity> getImages() {
//        return imageRepository.findAll();
//    }
//
//    public ImageEntity addImage(ImageEntity imageEntity) {
//        Optional<ImageEntity> imageEntityOptional = imageRepository.findImageEntityById(imageEntity)
//    }
//}
