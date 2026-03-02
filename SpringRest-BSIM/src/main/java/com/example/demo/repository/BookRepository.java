package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    Page<Book> findByGenre(String genre, Pageable pageable);

    List<Book> findByPriceLessThan(Double price);

    List<Book> findByPriceGreaterThan(Double price);

    List<Book> findByPublishedDateAfter(LocalDate date);

    List<Book> findByTitleContaining(String keyword);

    List<Book> findByGenreAndAuthor(String genre, String author);

    List<Book> findByGenreOrAuthor(String genre, String author);

    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Book> findByGenreAndPriceLessThan(String genre, Double price);

    Page<Book> findByOrderByPublishedDateDesc(Pageable pageable);

    Page<Book> findByOrderByPriceAsc(Pageable pageable);
}