package com.elymberopoulos.REST_MySQL.dbConnection;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private final Credentials dbCredentials;

    @Autowired
    public Connect() {
        this.dbCredentials = new Credentials();
    }

    public Connection GetConnection() {
        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbCredentials.getURL(),
                    dbCredentials.getUserName(), dbCredentials.getPassword());
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
