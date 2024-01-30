package com.demo.newairport.repository;

import com.demo.newairport.entity.DiractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiractRepository extends JpaRepository<DiractEntity, Long> {
    @Query("select d from DiractEntity d Where d.diractId = ?1")
    Optional<DiractEntity> DiractEntityById(Long DiractId);
}
