package com.demo.newairport.repository;

import com.demo.newairport.entity.BaggageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaggageRepository extends JpaRepository<BaggageEntity, Long> {
    @Query("SELECT b FROM BaggageEntity b WHERE b.bagId = ?1")
    Optional<BaggageEntity> findBaggageEntityById(Long BagId);

}
