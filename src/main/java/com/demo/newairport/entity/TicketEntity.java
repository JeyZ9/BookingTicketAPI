package com.demo.newairport.entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.*;

@Entity
@Table
public class TicketEntity {
    @GeneratedValue
    @Id
    private Long ticketId;

//    @ManyToOne
//    @JoinColumn(name = "image", referencedColumnName = "image_id")
//    private ImageEntity image;

    private float price;

    @ManyToOne
    @JoinColumn(name = "ticketType", referencedColumnName = "ticketTypeId")
    private TicketTypeEntity ticketType;

    @ManyToOne
    @JoinColumn(name = "flight", referencedColumnName = "flightNum")
    private FlightEntity flight;

    @ManyToOne
    @JoinColumn(name = "stop", referencedColumnName = "stop_id")
    private StopEntity stop;

    public TicketEntity() {
    }

    public TicketEntity(float price, TicketTypeEntity ticketType, FlightEntity flight, StopEntity stop) {
        this.price = price;
        this.ticketType = ticketType;
        this.flight = flight;
        this.stop = stop;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public StopEntity getStop() {
        return stop;
    }

    public Long getTicketId() {
        return ticketId;
    }


    public TicketTypeEntity getTicketType() {
        return ticketType;
    }

    public float getPrice() {
        return price;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }


    public void setPrice(float price) {
        this.price = price;
    }

    public void setTicketType(TicketTypeEntity ticketType) {
        this.ticketType = ticketType;
    }

    public void setStop(StopEntity stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "{" +
                "ticketId=" + ticketId +
                ", ticketType=" + ticketType +
                ", price=" + price +
                ", flight=" + flight +
                ", stop=" + stop +
                "}";
    }
}
