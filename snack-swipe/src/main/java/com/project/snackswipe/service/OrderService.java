package com.project.snackswipe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.snackswipe.model.Order;
import com.project.snackswipe.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> validateQrCode(String orderId) {
        return orderRepository.findByIdAndIsUsedFalse(orderId);
    }

    public void markQrCodeAsUsed(Order order) {
        order.setUsed(true);
        orderRepository.save(order);
    }
}
