package com.demo.newairport.services;

import com.demo.newairport.entity.TicketEntity;
import com.demo.newairport.entity.TicketTypeEntity;
import com.demo.newairport.repository.TicketRepository;
import com.demo.newairport.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketEntity> getTicket(){
        return ticketRepository.findAll();
    }

    public TicketEntity addTicket(TicketEntity ticketEntity){
        Optional<TicketEntity> ticketEntityOptional = ticketRepository.findTicketEntityById(ticketEntity.getTicketId());
            if (ticketEntityOptional.isPresent()) {
                throw new IllegalArgumentException("TicketEntity");
            }
            ticketRepository.save(ticketEntity);
            return ticketEntity;
    }
}
