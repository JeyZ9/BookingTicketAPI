package com.demo.newairport.repository;

import com.demo.newairport.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, String> {
    @Query("SELECT a FROM AirportEntity a WHERE a.airportCode = ?1")
    Optional<AirportEntity> findAirportEntityById(String airportCode);
}

