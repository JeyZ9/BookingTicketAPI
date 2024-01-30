package com.demo.newairport.controller;

import com.demo.newairport.entity.TableBookingEntity;
import com.demo.newairport.services.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tablebooking")
public class TableBookingController {
    private final TableBookingService tableBookingService;

    @Autowired
    public TableBookingController(TableBookingService tableBookingService) {
        this.tableBookingService = tableBookingService;
    }

    @GetMapping(path = "/get")
    public List<TableBookingEntity> getTableBookings() {
        return tableBookingService.getTableBooking();
    }

    @PostMapping(path = "/post")
    public ResponseEntity<TableBookingEntity> addTableBookingEntity(@RequestBody TableBookingEntity tableBookingEntity) {
        try {
            TableBookingEntity addTableBookingEntity = tableBookingService.addTableBookingEntity(tableBookingEntity);
            return ResponseEntity.ok(tableBookingEntity);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }
}
