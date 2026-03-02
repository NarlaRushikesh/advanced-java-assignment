package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    private void checkEmpty(List<Book> books) {
        if (books.isEmpty())
            throw new ResourceNotFoundException("No books found.");
    }

    public List<Book> getByAuthor(String author) {
        List<Book> books = repository.findByAuthor(author);
        checkEmpty(books);
        return books;
    }

    public Page<Book> getByGenre(String genre, Pageable pageable) {
        Page<Book> page = repository.findByGenre(genre, pageable);
        if (page.isEmpty())
            throw new ResourceNotFoundException("No books found.");
        return page;
    }

    public List<Book> getCheaperThan(Double price) {
        List<Book> books = repository.findByPriceLessThan(price);
        checkEmpty(books);
        return books;
    }

    public List<Book> getNewArrivals(LocalDate date) {
        List<Book> books = repository.findByPublishedDateAfter(date);
        checkEmpty(books);
        return books;
    }

    public Page<Book> getLatest(Pageable pageable) {
        return repository.findByOrderByPublishedDateDesc(pageable);
    }

    public Page<Book> getByPrice(Pageable pageable) {
        return repository.findByOrderByPriceAsc(pageable);
    }
}