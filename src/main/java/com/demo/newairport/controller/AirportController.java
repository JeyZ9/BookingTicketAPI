package com.demo.newairport.controller;

import com.demo.newairport.entity.AirportEntity;
import com.demo.newairport.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/airports")
@CrossOrigin(origins = "http://localhost:5173")
public class AirportController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/create")
    public ResponseEntity<AirportEntity> addCustomer(@RequestBody AirportEntity airportEntity) {
        try {
            AirportEntity addAirportEntity = airportService.addAirportEntity(airportEntity);
            return ResponseEntity.ok(addAirportEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get")
    public List<AirportEntity> getAirport(){
        return airportService.getAirport();
    }

    @DeleteMapping("/drop/{airportCode}")
    public void deleteAirport(@PathVariable("airportCode") String airportCode){
        airportService.removeAirport(airportCode);
    }

//    @PutMapping("/edit/{airportCode}")
//    public void putAirport(@PathVariable("airportCode") Long airportCode,
//                           @RequestParam(required = false) String name,
//                           @RequestParam(required = false) String country,
//                           @RequestParam(required = false) String city,
//                           @RequestParam(required = false) Float latitude,
//                           @RequestParam(required = false) Float longitude
//                           ){
//        airportService.updateAirport(airportCode, name, country, city, latitude, longitude);
//    }

    @PutMapping("/edit/{airportCode}")
    public ResponseEntity<AirportEntity> updateAirport(@PathVariable String airportCode, @RequestBody AirportEntity updatedAirport) {
        try {
            AirportEntity updatedEntity = airportService.updateAirport(airportCode, updatedAirport);
            return ResponseEntity.ok(updatedEntity);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
