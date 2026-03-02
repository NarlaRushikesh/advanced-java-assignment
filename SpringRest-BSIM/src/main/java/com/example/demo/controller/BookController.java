package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/author")
    public List<Book> getByAuthor(@RequestParam String author) {
        return service.getByAuthor(author);
    }

    @GetMapping("/genre")
    public Page<Book> getByGenre(@RequestParam String genre,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getByGenre(genre, pageable);
    }

    @GetMapping("/cheaper")
    public List<Book> cheaper(@RequestParam Double maxPrice) {
        return service.getCheaperThan(maxPrice);
    }

    @GetMapping("/new-arrivals")
    public List<Book> newArrivals(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate publishedAfter) {
        return service.getNewArrivals(publishedAfter);
    }

    @GetMapping("/latest")
    public Page<Book> latest(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getLatest(pageable);
    }

    @GetMapping("/by-price")
    public Page<Book> byPrice(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getByPrice(pageable);
    }
}