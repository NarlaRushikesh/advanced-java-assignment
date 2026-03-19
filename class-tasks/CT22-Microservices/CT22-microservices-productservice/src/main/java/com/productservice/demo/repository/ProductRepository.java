package com.productservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productservice.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
