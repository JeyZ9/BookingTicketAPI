package com.demo.newairport.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "airport")
public class AirportEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue
//    @Id
//    @Column(unique = true)
    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true)
    private String airportCode;
    private String name;
    private String country;
    private String city;
    private Float latitude;
    private Float longitude;

    public AirportEntity(){}

    public AirportEntity(String name, String country, String city, Float latitude, Float longitude){
        this.name = name;
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

//    Getter && Setter

    public String getAirportCode() {
        return airportCode;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return "{" +
                ", fromAirportCode=" + airportCode +
                ", name=" + name + '\'' +
                ", country=" + country + '\'' +
                ", city=" + city + '\'' +
                ", latitude=" + latitude + '\'' +
                ", longitude=" + longitude + '\'' +
                "}";
    }
}
