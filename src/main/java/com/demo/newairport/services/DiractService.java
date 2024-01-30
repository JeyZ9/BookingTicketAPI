package com.demo.newairport.services;

import com.demo.newairport.entity.DiractEntity;
import com.demo.newairport.repository.DiractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiractService {
    private DiractRepository diractRepository;

    @Autowired
    public DiractService(DiractRepository diractRepository) {
        this.diractRepository = diractRepository;
    }

    public List<DiractEntity> getDiractEntities() {
        return diractRepository.findAll();
    }

    public DiractEntity addDiractEntity(DiractEntity entity) {
        Optional<DiractEntity> entityOptional = diractRepository.DiractEntityById(entity.getDiractId());
        if (entityOptional.isPresent()){
            throw new IllegalArgumentException("Direct Already");
        }
        diractRepository.save(entity);
        return entity;
    }

}
