package com.project.snackswipe.controller;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.project.snackswipe.model.Order;

import com.project.snackswipe.service.OrderService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")

public class OrderController {
	 @Autowired
	    private OrderService orderService;

	    @PostMapping("/orders")
	    public Map<String, String> createOrder(@RequestBody Order order) {
	        Order savedOrder = orderService.createOrder(order);
	        Map<String, String> response = new HashMap<>();
	        response.put("status", "success");
	        response.put("orderId", savedOrder.getId());
	        return response;
	    }

	    @PostMapping("/validateQR")
	    public Map<String, Object> validateQrCode(@RequestBody Map<String, String> request) {
	        String orderId = request.get("orderId");
	        System.out.println(orderId);

	        Optional<Order> optionalOrder = orderService.validateQrCode(orderId);
	        Map<String, Object> response = new HashMap<>();

	        if (optionalOrder.isPresent() && !optionalOrder.get().isUsed()) {
	            Order order = optionalOrder.get();
	            orderService.markQrCodeAsUsed(order);
	            System.out.println("QR is valid. Marking as used.");

	            response.put("valid", "true");
	            response.put("orderDetails", Map.of(
	                "orderId", order.getId(),
	                "prnOrEmployeeId", order.getPrnOrEmployeeId(),
	                "items", order.getCart() // Assuming `order.getItems()` returns a list of food items
	            ));
	        } else {
	            System.out.println("QR is invalid or already used.");
	            response.put("valid", "false");
	            response.put("message", "QR code already used or invalid.");
	        }

	        return response;
	    }

	   
}