package com.demo.newairport.controller;

import com.demo.newairport.entity.FlightEntity;
import com.demo.newairport.entity.TicketEntity;
import com.demo.newairport.entity.TicketTypeEntity;
import com.demo.newairport.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "http://localhost:5173")
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
    public void createTicket(
            @RequestParam("logoImage") MultipartFile imageFile,
            @RequestParam("price") float price,
            @RequestParam("baggageWeight") int baggageWeight,
            @RequestParam("ticketType")TicketTypeEntity ticketType,
            @RequestParam("flight")FlightEntity flight
    ){
        try{
            byte[] imageBytes = imageFile.getBytes();
            TicketEntity ticketEntity = new TicketEntity(imageBytes, price, baggageWeight, ticketType, flight);
            ticketService.addTicket(ticketEntity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public ResponseEntity<TicketEntity> addTicket(@RequestBody TicketEntity ticketEntity){
//        try{
//            TicketEntity addTicket = ticketService.addTicket(ticketEntity);
//            return ResponseEntity.ok(addTicket);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//    }
}
