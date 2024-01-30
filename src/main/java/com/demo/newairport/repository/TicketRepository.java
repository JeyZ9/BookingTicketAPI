package com.demo.newairport.repository;


import com.demo.newairport.entity.AirportEntity;
import com.demo.newairport.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    @Query("SELECT t FROM TicketEntity t WHERE t.ticketId = ?1")
    Optional<TicketEntity> findTicketEntityById(Long ticketId);
}

