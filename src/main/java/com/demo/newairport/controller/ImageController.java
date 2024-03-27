package com.demo.newairport.controller;

import com.demo.newairport.entity.ImageEntity;
import com.demo.newairport.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:5173")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("data") MultipartFile data) {
        try {
            if (data.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }

            byte[] imageData = data.getBytes();
            ImageEntity savedImageEntity = imageService.saveImageEntity(imageData);

            return ResponseEntity.ok("Uploaded image successfully. Image ID: " + savedImageEntity.getImage_id());
        } catch (Exception e) {
            e.printStackTrace(); // Add this line for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }

//    @PutMapping("/edit")
//    public ResponseEntity<String> editImage(@RequestParam("data") MultipartFile data) {
//        imageService.updateImage(data.getBytes());
//    }


    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        ImageEntity imageEntity = imageService.getImage(id);
        if (imageEntity != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageEntity.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
