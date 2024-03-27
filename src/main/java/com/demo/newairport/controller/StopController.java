package com.demo.newairport.controller;

import com.demo.newairport.entity.StopEntity;
import com.demo.newairport.services.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/stop")
public class StopController {
    private StopService stopService;

    @Autowired
    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public List<StopEntity> getStopEntities() {
        return stopService.getStopEntities();
    }

    @GetMapping("/{stop_id}")
    public Optional<StopEntity> getStopId(@PathVariable Long stop_id){
        try{
            return stopService.getStopById(stop_id);
        }catch(Exception e){
            throw new RuntimeException((e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<StopEntity> createStop(@RequestBody  StopEntity stopEntity) {
        try{
            StopEntity addStopEntity = stopService.addStop(stopEntity);
            return ResponseEntity.ok(addStopEntity);
        }catch (Exception e){
            throw new IllegalStateException(e);
        }
    }
    @PutMapping("/{stop_id}")
    public ResponseEntity<StopEntity> updateStopId(@PathVariable Long stop_id, @RequestBody StopEntity stopEntity){
        StopEntity updateStopId = stopService.updateStop(stop_id, stopEntity);
        return new ResponseEntity<>(updateStopId, HttpStatus.OK);
    }

    @DeleteMapping("/{stop_id}")
    public ResponseEntity<Void> deleteStopId(@PathVariable Long stop_id){
        stopService.removeStop(stop_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
