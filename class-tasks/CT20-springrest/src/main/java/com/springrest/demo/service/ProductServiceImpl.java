package com.springrest.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.demo.model.Product;
import com.springrest.demo.repository.ProductRepository;

import java.io.IOException;
import java.nio.file.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final String UPLOAD_DIR = "uploads/";

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String addProduct(String name, double price, MultipartFile image) {

        try {
            // Create folder if not exists
            Path path = Paths.get(UPLOAD_DIR);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            // Save image
            String imageName = image.getOriginalFilename();
            Path filePath = path.resolve(imageName);

            Files.copy(image.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING);

            // Save product in DB
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setImageName(imageName);

            productRepository.save(product);

            return "Product added successfully";

        } catch (IOException e) {
            throw new RuntimeException("Error uploading image");
        }
    }

    @Override
    public Resource downloadImage(String imageName) {

        try {
            Path filePath = Paths.get(UPLOAD_DIR).resolve(imageName);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("Image not found");
            }

        } catch (Exception e) {
            throw new RuntimeException("Image not found");
        }
    }
}