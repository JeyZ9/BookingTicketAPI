package com.demo.newairport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table
public class TicketTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketTypeId;
    @NotBlank
    private String ticketTypeName;

    public TicketTypeEntity(){}
    public TicketTypeEntity(Long ticketTypeId, String ticketTypeName) {
        this.ticketTypeId = ticketTypeId;
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
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TicketTypeEntity that = (TicketTypeEntity) o;
        return Objects.equals(ticketTypeId, that.ticketTypeId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ticketTypeId);
    }
    @Override
    public String toString() {
        return "{" +
                "ticketTypeId=" + ticketTypeId +
                ", ticketTypeName=" + ticketTypeName + '\'' +
                "}";
    }
}
