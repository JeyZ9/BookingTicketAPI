package com.demo.newairport.services;

import com.demo.newairport.entity.TicketEntity;
import com.demo.newairport.entity.TicketTypeEntity;
import com.demo.newairport.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketTypeService {
    private final TicketTypeRepository ticketTypeRepository;

    @Autowired
    public TicketTypeService(TicketTypeRepository ticketTypeRepository) {
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public List<TicketTypeEntity> getTicketTypes(){return ticketTypeRepository.findAll();}

    public TicketTypeEntity addTicketType(TicketTypeEntity ticketTypeEntity){
        Optional<TicketTypeEntity> TicketTypeEntityOptional = ticketTypeRepository.findTicketTypeEntityById(ticketTypeEntity.getTicketTypeId());
            if (TicketTypeEntityOptional.isPresent()) {
                throw new IllegalStateException("TicketTypeEntity");
            }
            ticketTypeRepository.save(ticketTypeEntity);
            return ticketTypeEntity;
    }

    public void removeTicketType(Long ticketTypeId){
        boolean exists = ticketTypeRepository.existsById(ticketTypeId);
        if (!exists){
            throw new RuntimeException("not found ticket type");
        }
        ticketTypeRepository.deleteById(ticketTypeId);
    }

    public TicketTypeEntity addTicketType(Long ticketTypeId, TicketTypeEntity ticketTypeEntity){
        if (ticketTypeRepository.existsById(ticketTypeId)){
            ticketTypeEntity.setTicketTypeId(ticketTypeId);
            return ticketTypeRepository.save(ticketTypeEntity);
        }else {
            throw new RuntimeException("not found ticket type");
        }
    }
}
