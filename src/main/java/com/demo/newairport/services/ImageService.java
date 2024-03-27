package com.demo.newairport.services;

import com.demo.newairport.entity.ImageEntity;
import com.demo.newairport.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public ImageEntity saveImageEntity(byte[] imageData){
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setData(imageData);
        return imageRepository.save(imageEntity);
    }

    public ImageEntity getImage(Long image_id){
        return imageRepository.findById(image_id).orElse(null);
    }

    public ImageEntity updateImage(@RequestBody Long image_id, ImageEntity imageEntity){
        if(imageRepository.existsById(image_id)){
            imageEntity.setImage_id(image_id);
            return imageRepository.save(imageEntity);
        }else {
            throw new RuntimeException("not found image");
        }
    }

    public void removeImage(Long image_id){
        boolean exists = imageRepository.existsById(image_id);
        if (!exists){
            throw new IllegalArgumentException("not found image delete");
        }
        imageRepository.deleteById(image_id);
    }

}