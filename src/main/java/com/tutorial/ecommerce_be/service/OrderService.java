package com.tutorial.ecommerce_be.service;

import com.tutorial.ecommerce_be.model.LocalUser;
import com.tutorial.ecommerce_be.model.WebOrder;
import com.tutorial.ecommerce_be.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }

    public List<WebOrder> getOrders(LocalUser user) {
        return webOrderDAO.findByUser(user);
    }
}
