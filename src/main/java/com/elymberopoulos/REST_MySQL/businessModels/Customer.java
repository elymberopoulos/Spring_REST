package com.elymberopoulos.REST_MySQL.businessModels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    //    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private int customerID;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int points;

    public Customer() {}

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

//    public void setBirthDate(String birthDate) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
//        this.birthDate = format.parse(birthDate);
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}