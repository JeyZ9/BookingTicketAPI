package com.demo.newairport.repository;

import com.demo.newairport.entity.AirportEntity;
import com.demo.newairport.entity.TicketTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketTypeEntity, Long> {
    @Query("SELECT tt FROM TicketTypeEntity tt WHERE tt.ticketTypeId = ?1")
    Optional<TicketTypeEntity> findTicketTypeEntityById(Long TickTypeId);
}


