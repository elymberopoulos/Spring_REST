package com.elymberopoulos.REST_MySQL.dao;

import com.elymberopoulos.REST_MySQL.businessModels.Customer;
import com.elymberopoulos.REST_MySQL.dbConnection.Connect;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private final Connect connector;
    @Autowired
    public CustomerDAO(){
        this.connector = new Connect();
    }

    public synchronized List<Customer> GetAllCustomers() throws SQLException {
        Connection conn = connector.GetConnection();
        Statement stmt = null;
        ResultSet rs = null;
        List<Customer> result = new ArrayList<Customer>();

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * " +
                                        "FROM sql_store.customers;");

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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null){
                conn.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return null;
    }

    public synchronized Customer GetByID(int id) throws SQLException {
        Connection conn = connector.GetConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM customers WHERE customer_id = '" + id + "';");

            while (rs.next()){
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

                return customer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null){
                conn.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return null;
    }
}