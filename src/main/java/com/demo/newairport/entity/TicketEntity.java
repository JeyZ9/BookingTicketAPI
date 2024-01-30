package com.demo.newairport.entity;

import jakarta.persistence.*;

@Entity
@Table
public class TicketEntity {
    @GeneratedValue
    @Id
    private Long ticketId;
    private byte[] logoImage;
    private float price;
    private int baggageWeight;

    @ManyToOne
    @JoinColumn(name="ticket_type_id")
    private TicketTypeEntity ticketType;

    @ManyToOne
    @JoinColumn(name="flight_num")
    private FlightEntity flightNum;

    public TicketEntity(){}

    public TicketEntity(byte[] logoImage, float price, int baggageWeight, TicketTypeEntity ticketType, FlightEntity flightNum){
        this.logoImage = logoImage;
        this.price = price;
        this.ticketType = ticketType;
        this.flightNum = flightNum;
        this.baggageWeight = baggageWeight;
    }

    public FlightEntity getFlight() {
        return flightNum;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public byte[] getLogoImage() {
        return logoImage;
    }

    public TicketTypeEntity getTicketType() {
        return ticketType;
    }

    public float getPrice() {
        return price;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public void setFlight(FlightEntity flightNum) {
        this.flightNum = flightNum;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public void setLogoImage(byte[] logoImage) {
        this.logoImage = logoImage;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTicketType(TicketTypeEntity ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "{" +
                "ticketId=" + ticketId +
                ", logoImage=" + logoImage +
                ", ticketType=" + ticketType +
                ", price=" + price +
                ", baggageWeight=" + baggageWeight +
                ", flight=" + flightNum +
                "}";
    }
}
