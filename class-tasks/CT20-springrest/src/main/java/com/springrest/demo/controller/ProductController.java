package com.springrest.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add Product
    @PostMapping("/add")
    public ResponseEntity<String> addProduct(
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam MultipartFile image) {

        String message = productService.addProduct(name, price, image);
        return ResponseEntity.ok(message);
    }

    // Download Image
    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> downloadImage(
            @PathVariable String imageName) {

        Resource resource = productService.downloadImage(imageName);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + imageName + "\"")
                .body(resource);
    }
}