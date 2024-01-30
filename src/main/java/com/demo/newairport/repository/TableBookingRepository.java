package com.demo.newairport.repository;

import com.demo.newairport.entity.TableBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableBookingRepository extends JpaRepository<TableBookingEntity, String> {
    @Query("SELECT b FROM TableBookingEntity b WHERE b.bookingId = ?1")
    Optional<TableBookingEntity> findTableBookingEntityById(String bookingId);
}
