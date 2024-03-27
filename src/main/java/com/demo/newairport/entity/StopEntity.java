package com.demo.newairport.entity;

import jakarta.persistence.*;

@Entity
@Table
public class StopEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long stop_id;
    private String stop_name;

    public StopEntity(){}

    public StopEntity(Long stop_id, String stop_name){
        this.stop_id = stop_id;
        this.stop_name = stop_name;
    }

    public Long getStop_id() {
        return stop_id;
    }

    public void setStop_id(Long stop_id) {
        this.stop_id = stop_id;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    @Override
    public String toString(){
        return "Stop [stop_id=" + stop_id + ", stop_name" + stop_name + "stop_price" + "]";
    }
}
