package com.orderservice.demo.service;

import org.springframework.stereotype.Service;

import com.orderservice.demo.dto.ProductResponseDTO;
import com.orderservice.demo.feign.ProductClient;
import com.orderservice.demo.model.Order;
import com.orderservice.demo.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final ProductClient productClient;

    public OrderService(OrderRepository repository, ProductClient productClient) {
        this.repository = repository;
        this.productClient = productClient;
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "productFallback")
    public Order save(Order order) {

        // Call Product Service
        ProductResponseDTO product = productClient.getProductById(order.getProductId());

        // Calculate total
        Double total = product.getPrice() * order.getQuantity();
        order.setTotalAmount(total);

        return repository.save(order);
    }

    // Fallback method for CircuitBreaker
    public Order productFallback(Order order, Throwable t) {
        System.out.println("Product service is down. Returning dummy order. Error: " + t.getMessage());

        // Return dummy order
        Order dummyOrder = new Order();
        dummyOrder.setProductId(order.getProductId());
        dummyOrder.setQuantity(order.getQuantity());
        dummyOrder.setTotalAmount(0.0); // indicate fallback
        return dummyOrder;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }
}