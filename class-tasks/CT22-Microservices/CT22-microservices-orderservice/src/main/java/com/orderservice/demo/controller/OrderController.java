package com.orderservice.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.orderservice.demo.model.Order;
import com.orderservice.demo.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService service;

	public OrderController(OrderService service) {
		this.service = service;
	}

	@PostMapping
	public Order create(@RequestBody Order order) {
		return service.save(order);
	}

	@GetMapping
	public List<Order> getAll() {
		return service.getAll();
	}
}
