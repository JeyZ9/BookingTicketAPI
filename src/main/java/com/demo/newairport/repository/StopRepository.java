package com.demo.newairport.repository;

import com.demo.newairport.entity.StopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StopRepository extends JpaRepository<StopEntity, Long> {
//    @Query("SELECT s FROM StopEntity s WHERE s.stop_id = ?1")
//    Optional<StopEntity> findStopEntityBy(Long stop_id);
}
