package com.elymberopoulos.REST_MySQL.resource;

import com.elymberopoulos.REST_MySQL.businessModels.Customer;
import com.elymberopoulos.REST_MySQL.businessModels.CustomerRequest;
import com.elymberopoulos.REST_MySQL.representations.CustomerRequestConverter;
import com.elymberopoulos.REST_MySQL.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping(path = "/customers")
@RestController
public class CustomerResource {


    private final CustomerService customerService;
    private final CustomerRequestConverter converter;

    @Autowired
    public CustomerResource(CustomerService customerService, CustomerRequestConverter converter){
        this.customerService = customerService;
        this.converter = converter;
    }

    //Short annotation for mapping
    @GetMapping
    public synchronized List<Customer> GetAllCustomers() throws SQLException {
        return customerService.GetAllCustomers();
    }

    //An alternative annotation for mapping
    @RequestMapping(value = "/{id}", method = GET)
    public synchronized Customer GetCustomerByID(@PathVariable("id") int id) throws SQLException {
        return customerService.GetCustomerByID(id);
    }

    @GetMapping(value = "/points")
    public synchronized Map<String, Integer> GetCustomerPoints(@RequestParam(required = true, name = "above") int points) throws SQLException {
        return customerService.GetCustomerPointsGreaterThan(points);
    }

    @PostMapping()
    public synchronized Customer PostCustomer(@RequestBody CustomerRequest newCustomer) throws ParseException {
        return customerService.AddCustomer(newCustomer);
    }
}
