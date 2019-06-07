package com.elymberopoulos.REST_MySQL.representations;

import com.elymberopoulos.REST_MySQL.businessModels.Customer;
import com.elymberopoulos.REST_MySQL.businessModels.CustomerRequest;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomerRequestConverter {

    public CustomerRequestConverter(){}

    public synchronized Customer Convert(CustomerRequest customerRequest) throws ParseException {

        Customer newCustomer = new Customer();

        newCustomer.setFirstName(customerRequest.getFirstName());
        newCustomer.setLastName(customerRequest.getLastName());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = dateFormat.parse(customerRequest.getBirthDate());
        java.sql.Date dateDB = new java.sql.Date(parsed.getTime());
        newCustomer.setBirthDate(dateDB);

        newCustomer.setPhone(customerRequest.getPhone());
        newCustomer.setAddress(customerRequest.getAddress());
        newCustomer.setCity(customerRequest.getCity());
        newCustomer.setState(customerRequest.getState());

        return newCustomer;
    }
}
