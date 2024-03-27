package com.demo.newairport.services;

import com.demo.newairport.entity.AirportEntity;
import com.demo.newairport.entity.FlightEntity;
import com.demo.newairport.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightEntity> getFlight(){return flightRepository.findAll();}

    public FlightEntity addFlight(FlightEntity flightEntity){
        Optional<FlightEntity> flightEntityOptional = flightRepository.findFlightEntityById(flightEntity.getFlightNum());
        if (flightEntityOptional.isPresent()) {
            throw new IllegalArgumentException("CustomerEntity already");
        }
        flightRepository.save(flightEntity);
        return flightEntity;
    }

    public void removeFlight(Long flightNum){
        boolean exists = flightRepository.existsById(flightNum);
        if (!exists) {
            throw new IllegalArgumentException("not found");
        }
        flightRepository.deleteById(flightNum);
    }

    public FlightEntity updateFlight(@RequestBody Long flightNum, FlightEntity flightEntity){
        if (flightRepository.existsById(flightNum)){
            flightEntity.setFlightNum(flightNum);
            return flightRepository.save(flightEntity);
        }else{
            throw new RuntimeException("not found");
        }
    }
}
