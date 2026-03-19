package com.productservice.demo.dto;

import org.springframework.stereotype.Component;

import com.productservice.demo.model.Product;

@Component
public class ProductMapper {

	public Product toEntity(ProductRequestDTO dto) {
		Product product = new Product();
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		return product;
	}

	public ProductResponseDTO toResponseDTO(Product product) {
		return new ProductResponseDTO(product.getId(), product.getName(), product.getPrice());
	}
}