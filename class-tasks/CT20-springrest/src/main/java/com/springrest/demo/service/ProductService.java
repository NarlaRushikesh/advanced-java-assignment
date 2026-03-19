package com.springrest.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

	String addProduct(String name, double price, MultipartFile image);

	Resource downloadImage(String imageName);
}