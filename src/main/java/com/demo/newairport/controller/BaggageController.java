package com.demo.newairport.controller;

import com.demo.newairport.entity.BaggageEntity;
import com.demo.newairport.services.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/baggage")
@CrossOrigin("*")
public class BaggageController {
    private final BaggageService baggageService;
    @Autowired
    public BaggageController(BaggageService bagService) {
        this.baggageService = bagService;
    }

    @PostMapping("/create")
    public ResponseEntity<BaggageEntity> addBaggage(@RequestBody BaggageEntity baggageEntity){
        try{
            BaggageEntity addBaggageEntity = baggageService.createtBaggage(baggageEntity);
            return ResponseEntity.ok(addBaggageEntity);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


}
