package com.productservice.demo.service;

import org.springframework.stereotype.Service;

import com.productservice.demo.dto.ProductMapper;
import com.productservice.demo.dto.ProductRequestDTO;
import com.productservice.demo.dto.ProductResponseDTO;
import com.productservice.demo.model.Product;
import com.productservice.demo.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

	private final ProductRepository repository;
	private final ProductMapper mapper;

	public ProductService(ProductRepository repository, ProductMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ProductResponseDTO createProduct(ProductRequestDTO request) {

		Product product = mapper.toEntity(request);
		Product saved = repository.save(product);

		return mapper.toResponseDTO(saved);
	}

	public List<ProductResponseDTO> getAllProducts() {
		return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
	}

	public ProductResponseDTO getProductById(Long id) {

		Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		return mapper.toResponseDTO(product);
	}
}