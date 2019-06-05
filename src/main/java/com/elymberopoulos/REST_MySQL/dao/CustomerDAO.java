package com.elymberopoulos.REST_MySQL.dao;

import com.elymberopoulos.REST_MySQL.businessModels.Customer;
import com.elymberopoulos.REST_MySQL.dbConnection.Connect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDAO {

    private final Connect connector;
    @Autowired
    public CustomerDAO(){
        this.connector = new Connect();
    }

    @Autowired
    public synchronized List<Customer> getAllCustomers(){
        Connection conn = connector.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        List<Customer> result = new ArrayList<Customer>();
        String query = "SELECT * FROM sql_store.customers;";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setBirthDate(rs.getDate("birth_date"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setPoints(rs.getInt("points"));

                result.add(customer);
            }

            return result;
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}