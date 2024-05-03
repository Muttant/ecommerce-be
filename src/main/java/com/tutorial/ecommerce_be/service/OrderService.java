package com.tutorial.ecommerce_be.service;

import com.tutorial.ecommerce_be.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }
}
