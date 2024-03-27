package com.demo.newairport.controller;

import com.demo.newairport.entity.*;
import com.demo.newairport.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin("*")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/get")
    public List<TicketEntity> getTicket(){
        return ticketService.getTicket();
    }

    @PostMapping("/create")
    public ResponseEntity<TicketEntity> createTicket(@RequestBody TicketEntity ticketEntity){
        try{
            TicketEntity addTicketEntity = ticketService.addTicket(ticketEntity);
            return ResponseEntity.ok(addTicketEntity);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        }catch(Exception e){
            throw new IllegalStateException("Error creating ", e);
        }
    }
}
