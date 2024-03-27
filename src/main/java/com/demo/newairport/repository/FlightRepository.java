package com.demo.newairport.repository;

import com.demo.newairport.entity.AirportEntity;
import com.demo.newairport.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
    @Query("SELECT f FROM FlightEntity f WHERE f.flightNum = ?1")
    Optional<FlightEntity> findFlightEntityById(Long flightNum);
}

