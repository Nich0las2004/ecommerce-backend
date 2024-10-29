package com.ecommerce.application.ecommerce_backend.order.service;

import com.ecommerce.application.ecommerce_backend.order.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders(Long id);
    Order getOrderById(Long id);
}
