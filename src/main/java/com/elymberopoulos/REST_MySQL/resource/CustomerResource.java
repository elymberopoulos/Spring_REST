package com.elymberopoulos.REST_MySQL.resource;

import com.elymberopoulos.REST_MySQL.businessModels.Customer;
import com.elymberopoulos.REST_MySQL.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/customers")
@RestController
public class CustomerResource {


    private final CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> GetAllCustomers(){
        return customerService.GetAllCustomers();
    }
}
