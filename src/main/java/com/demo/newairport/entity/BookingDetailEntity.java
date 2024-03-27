package com.demo.newairport.entity;

import jakarta.persistence.*;

@Entity
@Table

public class BookingDetailEntity {
//    field
    @Id
    private String seatNum;

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private TableBookingEntity bookingId;

    @ManyToOne
    @JoinColumn(name = "ticketId")
    private TicketEntity ticketId;

    @ManyToOne
    @JoinColumn(name="bag_id")
    private BaggageEntity bag_id;

    public BookingDetailEntity(){

    }
    public BookingDetailEntity(String seatNum, TableBookingEntity bookingId, TicketEntity ticketId, BaggageEntity bag_id){
        this.bookingId = bookingId;
        this.ticketId = ticketId;
        this.seatNum = seatNum;
        this.bag_id = bag_id;
    }

    public TableBookingEntity getBookingId(){
        return bookingId;
    }

    public TicketEntity getTicketId() {
        return ticketId;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setBookingId(TableBookingEntity bookingId) {
        this.bookingId = bookingId;
    }

    public void setTicketId(TicketEntity ticketId) {
        this.ticketId = ticketId;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public BaggageEntity getBag_id() {
        return bag_id;
    }

    public void setBag_id(BaggageEntity bag_id) {
        this.bag_id = bag_id;
    }

    @Override
    public String toString() {
        return "{" + "\'" +
                "bookingId=" + bookingId + "\'" +
                ", ticketId=" + ticketId + "\'" +
                ", seatNum=" + seatNum + "\'" +
                ", bag_id=" + bag_id + "\'" +
                "}";
    }
}
