package com.demo.newairport.repository;

import com.demo.newairport.entity.BookingDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetailEntity, String> {
    @Query("SELECT s FROM BookingDetailEntity s WHERE s.seatNum = ?1")
    Optional<BookingDetailEntity> findBookingDetailEntityBy(String seatNum);
}
