package com.productservice.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.productservice.demo.dto.ProductRequestDTO;
import com.productservice.demo.dto.ProductResponseDTO;
import com.productservice.demo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Value("${server.port}")
	private String port;
	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping
	public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO request) {
	    
		return service.createProduct(request);
	}

	@GetMapping
	public List<ProductResponseDTO> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/{id}")
	public ProductResponseDTO getProductById(@PathVariable Long id) {
		System.out.println("Request handled by port: " + port);
		return service.getProductById(id);
	}
}