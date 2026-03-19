package com.orderservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderservice.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
