package com.tutorial.ecommerce_be.service;

import com.tutorial.ecommerce_be.model.Product;
import com.tutorial.ecommerce_be.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    public List<Product> getProducts() {
        return productDAO.findAll();
    }
}
