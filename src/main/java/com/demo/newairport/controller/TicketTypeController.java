package com.demo.newairport.controller;

import com.demo.newairport.entity.TicketTypeEntity;
import com.demo.newairport.services.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickettypes")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketTypeController {
    private final TicketTypeService ticketTypeService;

    @Autowired
    public TicketTypeController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @GetMapping("/get")
    public List<TicketTypeEntity> getTicketType(){return ticketTypeService.getTicketTypes();}

    @PostMapping("/create")
    public ResponseEntity<TicketTypeEntity> addTicketType(@RequestBody TicketTypeEntity ticketTypeEntity){
        try{
            TicketTypeEntity addTicketType = ticketTypeService.addTicketType(ticketTypeEntity);
            return ResponseEntity.ok(addTicketType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
