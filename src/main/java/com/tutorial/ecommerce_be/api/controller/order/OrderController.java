package com.tutorial.ecommerce_be.api.controller.order;

import com.tutorial.ecommerce_be.model.LocalUser;
import com.tutorial.ecommerce_be.model.WebOrder;
import com.tutorial.ecommerce_be.service.OrderService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public List<WebOrder> getOrders(@AuthenticationPrincipal LocalUser user) {
        return orderService.getOrders(user);
    }
}
