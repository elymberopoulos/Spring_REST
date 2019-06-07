package com.elymberopoulos.REST_MySQL.service;

import com.elymberopoulos.REST_MySQL.businessModels.Product;
import com.elymberopoulos.REST_MySQL.dao.ProductDAO;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(){
        this.productDAO = new ProductDAO();
    }

    public synchronized List<Product> GetAllProducts() throws SQLException {
        return productDAO.GetAllProducts();
    }
}
