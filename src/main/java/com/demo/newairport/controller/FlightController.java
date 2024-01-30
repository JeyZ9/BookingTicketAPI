package com.demo.newairport.controller;

import com.demo.newairport.entity.AirportEntity;
import com.demo.newairport.entity.FlightEntity;
import com.demo.newairport.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/create")
    public ResponseEntity<FlightEntity> addFlight(@RequestBody FlightEntity flightEntity) {
        try {
            FlightEntity addFlight = flightService.addFlight(flightEntity);
            return ResponseEntity.ok(addFlight);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get")
    public List<FlightEntity> getFlight(){
        return flightService.getFlight();
    }

    @DeleteMapping("/drop/flightNum")
    public void deleteFlight(@PathVariable("flightNum") String flightNum){
        flightService.removeFlight(flightNum);
    }

    @PutMapping("/edit/{flightNum}")
    public ResponseEntity<FlightEntity> updateFlight(@PathVariable String flightNum, @RequestBody FlightEntity updatedFlight){
        try {
            FlightEntity updateEntity = flightService.updateFlight(flightNum, updatedFlight);
            return ResponseEntity.ok(updateEntity);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
