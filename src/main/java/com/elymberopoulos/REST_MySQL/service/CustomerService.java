package com.elymberopoulos.REST_MySQL.service;

import com.elymberopoulos.REST_MySQL.businessModels.Customer;
import com.elymberopoulos.REST_MySQL.businessModels.CustomerRequest;
import com.elymberopoulos.REST_MySQL.dao.CustomerDAO;
import com.elymberopoulos.REST_MySQL.representations.CustomerRequestConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    private CustomerDAO customerDAO;
    private CustomerRequestConverter converter;

    public CustomerService(){
        customerDAO = new CustomerDAO();
        converter = new CustomerRequestConverter();
    }

    public synchronized List<Customer> GetAllCustomers() throws SQLException {
        return customerDAO.GetAllCustomers();
    }

    public synchronized Customer GetCustomerByID(int id) throws SQLException {
        return customerDAO.GetByID(id);
    }

    public synchronized Map<String, Integer> GetCustomerPointsGreaterThan(int points) throws SQLException {
        return customerDAO.GetCustomerPointsGreaterThan(points);
    }

    public synchronized Customer AddCustomer(CustomerRequest newCustomer) throws ParseException {
        Customer customer = converter.Convert(newCustomer);
        return customerDAO.AddCustomer(customer);
    }

}
