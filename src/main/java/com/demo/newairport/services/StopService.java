package com.demo.newairport.services;

import com.demo.newairport.entity.StopEntity;
import com.demo.newairport.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopService {
    private StopRepository stopRepository;

    @Autowired
    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public List<StopEntity> getStopEntities() {
        return stopRepository.findAll();
    }

    public Optional<StopEntity> getStopById(Long stop_id){
        return stopRepository.findById(stop_id);
    }

    public StopEntity addStop(StopEntity stopEntity) {
        return stopRepository.save(stopEntity);
    }

    public StopEntity updateStop(Long stop_id, StopEntity stopEntity){
        if (stopRepository.existsById(stop_id)){
            stopEntity.setStop_id(stop_id);
            return stopRepository.save(stopEntity);
        }else {
            throw new RuntimeException("StopEntity already exists for id " + stop_id);
        }
    }

    public void removeStop(Long stop_id){
        if (stopRepository.existsById(stop_id)){
//            stopEntity.setStop_id(stop_id);
            stopRepository.deleteById(stop_id);
        }else {
            throw new RuntimeException("StopEntity already exists for id " + stop_id);
        }
    }
}
