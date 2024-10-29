package com.ecommerce.application.ecommerce_backend.order.controller;

import com.ecommerce.application.ecommerce_backend.order.Order;
import com.ecommerce.application.ecommerce_backend.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(Long id) {
        List<Order> orders = orderService.getAllOrders(id);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

}
