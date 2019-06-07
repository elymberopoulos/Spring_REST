package com.elymberopoulos.REST_MySQL.dao;

import com.elymberopoulos.REST_MySQL.businessModels.Product;
import com.elymberopoulos.REST_MySQL.dbConnection.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connect connector;

    public ProductDAO() {
        this.connector = new Connect();
    }

    public synchronized List<Product> GetAllProducts() throws SQLException {
        Connection conn = connector.GetConnection();
        Statement stmt = null;
        ResultSet rs = null;
        List<Product> result = new ArrayList<Product>();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(
                    "SELECT * " +
                            "FROM sql_inventory.products;");

            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setQuantityInStock(rs.getInt("quantity_in_stock"));
                product.setUnitPrice(rs.getFloat("unit_price"));

                result.add(product);
            }

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return null;
    }
}
