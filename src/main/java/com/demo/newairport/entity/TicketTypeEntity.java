package com.demo.newairport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class TicketTypeEntity {
    @GeneratedValue
    @Id
    private Long ticketTypeId;
    private String ticketTypeName;

    public TicketTypeEntity(){}
    public TicketTypeEntity(String ticketTypeName){
        this.ticketTypeName = ticketTypeName;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    @Override
    public String toString() {
        return "{" +
                "ticketTypeId=" + ticketTypeId +
                ", ticketTypeName=" + ticketTypeName + '\'' +
                "}";
    }
}
