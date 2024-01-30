package com.demo.newairport.services;

import com.demo.newairport.entity.TableBookingEntity;
import com.demo.newairport.repository.TableBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableBookingService {
    private final TableBookingRepository tableBookingRepository;

    @Autowired
    public TableBookingService(TableBookingRepository tableBookingRepository){
        this.tableBookingRepository = tableBookingRepository;
    }

    public List<TableBookingEntity> getTableBooking(){
        return tableBookingRepository.findAll();
    }

    public TableBookingEntity addTableBookingEntity(TableBookingEntity tableBookingEntity){
        Optional<TableBookingEntity> tableBookingEntityOptional = tableBookingRepository.findTableBookingEntityById(tableBookingEntity.getBookingId());
            if (tableBookingEntityOptional.isPresent()) {
                throw new IllegalArgumentException("TableBooking already");
            }
            tableBookingRepository.save(tableBookingEntity);
            return tableBookingEntity;
    }
}
