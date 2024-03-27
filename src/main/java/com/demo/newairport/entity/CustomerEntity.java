package com.demo.newairport.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class CustomerEntity {
    @GeneratedValue
//    field
    @Id
    private Long customerId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    private String password;
    private int number;
    private String nationality;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    public CustomerEntity(String firstName,String lastName,String email,int number,String nationality,Date dateOfBirth, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }
    public CustomerEntity(){}

    public String getPassword() {
        return password;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getNumber() {
        return number;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString(){
        return "{" +
                    "customerId=" + customerId +
                    ", firstName=" + firstName + '\'' +
                    ", lastName=" + lastName + '\'' +
                    ", email=" + email + '\'' +
                    ", number=" + number + '\'' +
                    ", nationality" + nationality + '\'' +
                    ", password" + password + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                "}";
    }

}
