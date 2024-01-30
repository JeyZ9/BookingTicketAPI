package com.demo.newairport.services;

import com.demo.newairport.entity.AirportEntity;
import com.demo.newairport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportEntity> getAirport(){return airportRepository.findAll();}

    public AirportEntity addAirportEntity(AirportEntity airportEntity){
        Optional<AirportEntity> airportEntityOptional = airportRepository.findAirportEntityById(airportEntity.getAirportCode());
            if (airportEntityOptional.isPresent()) {
                throw new IllegalArgumentException("CustomerEntity already");
            }
            airportRepository.save(airportEntity);
            return airportEntity;
    }

    public void removeAirport(String airportCode){
        boolean exists = airportRepository.existsById(airportCode);
        if (!exists) {
            throw new IllegalStateException("does not exist");
        }
        airportRepository.deleteById(airportCode);
    }

    public AirportEntity updateAirport(String airportCode, AirportEntity airportEntity){
        if (airportRepository.existsById(airportCode)){
            airportEntity.setAirportCode(airportCode);
            return airportRepository.save(airportEntity);
        } else {
            throw new RuntimeException("AirportEntity not found");
        }
    }
//    public void updateAirport(Long airportCode, String name, String country, String city, Float latitude, Float longitude) {
//        AirportEntity airportEntity = airportRepository.findById(airportCode)
//                .orElseThrow(() -> new IllegalStateException("Airport not found"));
//
//        if (name != null && !name.isEmpty() && !Objects.equals(airportEntity.getName(), name)) {
//            airportEntity.setName(name);
//        }
//
//        if (country != null && !country.isEmpty() && !Objects.equals(airportEntity.getCountry(), country)) {
//            airportEntity.setCountry(country);
//        }
//
//        if (city != null && !city.isEmpty() && !Objects.equals(airportEntity.getCity(), city)) {
//            airportEntity.setCity(city);
//        }
//
//        if (latitude != null && !Objects.equals(airportEntity.getLatitude(), latitude)) {
//            airportEntity.setLatitude(latitude);
//        }
//
//        if (longitude != null && !Objects.equals(airportEntity.getLongitude(), longitude)) {
//            airportEntity.setLongitude(longitude);
//        }
//    }

}


