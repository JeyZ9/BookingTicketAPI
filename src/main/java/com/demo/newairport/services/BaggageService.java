package com.demo.newairport.services;

import com.demo.newairport.entity.BaggageEntity;
import com.demo.newairport.repository.BaggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaggageService {
    private BaggageRepository baggageRepository;

    @Autowired
    public BaggageService(BaggageRepository baggageRepository) {
        this.baggageRepository = baggageRepository;
    }

    public List<BaggageEntity> getBaggageEntities() {
        return baggageRepository.findAll();
    }

    public BaggageEntity getBaggage(BaggageEntity baggageEntity) {
        Optional<BaggageEntity> baggageEntityOptional = baggageRepository.findBaggageEntityById(baggageEntity.getBagId());
        if (baggageEntityOptional.isPresent()) {
            throw new IllegalStateException("BaggageEntity Already exists");
        }
        baggageRepository.save(baggageEntity);
        return baggageEntity;
    }
}
