package com.elymberopoulos.REST_MySQL.service;

import com.elymberopoulos.REST_MySQL.businessModels.Customer;
import com.elymberopoulos.REST_MySQL.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService(){
        customerDAO = new CustomerDAO();
    }

    public synchronized List<Customer> GetAllCustomers() throws SQLException {
        return customerDAO.GetAllCustomers();
    }

    public synchronized Customer GetCustomerByID(int id) throws SQLException {
        return customerDAO.GetByID(id);
    }

}
