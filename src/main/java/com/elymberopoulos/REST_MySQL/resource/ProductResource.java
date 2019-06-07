package com.elymberopoulos.REST_MySQL.resource;

import com.elymberopoulos.REST_MySQL.businessModels.Product;
import com.elymberopoulos.REST_MySQL.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(){
        this.productService = new ProductService();
    }

    @GetMapping
    public synchronized List<Product> GetAllProducts() throws SQLException {
        return productService.GetAllProducts();
    }
}
