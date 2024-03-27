package com.demo.newairport.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "flight")
public class FlightEntity {

//    @GeneratedValue
    @Id
//    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightNum;
    private String airlineName;
//    private String toAirline;
    private Time arrival;
    private Date arrivalDate;
    private Time departure;
    private Date departureDate;
    @ManyToOne
    @JoinColumn(name = "image", referencedColumnName = "image_id")
    private ImageEntity image;
//    private String direct;


    @ManyToOne
    @JoinColumn(name="origin", referencedColumnName="airportCode")
    private AirportEntity origin;

    @ManyToOne
    @JoinColumn(name="destination", referencedColumnName="airportCode")
    private AirportEntity destination;

    // No-argument constructor (required by JPA)
    public FlightEntity(){}

    // Parameterized constructor
    public FlightEntity(String airlineName, Time arrival, Date arrivalDate, Time departure, Date departureDate, AirportEntity origin, AirportEntity destination, ImageEntity image){
        this.airlineName = airlineName;
        this.destination = destination;
        this.origin = origin;
        this.arrival = arrival;
        this.arrivalDate = arrivalDate;
        this.departure = departure;
        this.departureDate = departureDate;
        this.image = image;
//        this.direct = direct;
    }

//    Getter and Setter

    public Time getArrival() {
        return arrival;
    }
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Time getDeparture() {
        return departure;
    }
    public Date getDepartureDate() {
        return departureDate;
    }

    public AirportEntity getOrigin() {
        return origin;
    }

    public AirportEntity getDestination() {
        return destination;
    }

    public Long getFlightNum() {
        return flightNum;
    }

    public String getAirlineName() {
        return airlineName;
    }

//    public String getDirect(){
//        return direct;
//    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }

    public ImageEntity getImage() {
        return image;
    }
    public void setImage(ImageEntity image) {
        this.image = image;
    }


    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }

    public void setFlightNum(Long flightNum) {
        this.flightNum = flightNum;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setOrigin(AirportEntity origin) {
        this.origin = origin;
    }

    public void setDestination(AirportEntity destination) {
        this.destination = destination;
    }

//    public void setDirect(String direct) {
//        this.direct = direct;
//    }

    @Override
    public String toString() {
        return "{" +
                "flightNum: " + flightNum +
                ", airlineName: " + airlineName + '\'' +
                ", origin: " + origin + '\'' +
                ", destination" + destination + '\'' +
                ", arrival" + arrival + '\'' +
                ", arrivalDate" + arrivalDate + '\'' +
                ", departure" + departure + '\'' +
                ", departure" + departureDate + '\'' +
//                ", direct" + direct + '\'' +
                "}";
    }
}
