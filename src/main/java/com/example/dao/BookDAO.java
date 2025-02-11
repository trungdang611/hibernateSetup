package com.example.dao;

import com.example.dto.BookCountDTO;
import com.example.entity.Author;
import com.example.entity.Book;

import java.util.List;

public interface BookDAO {

//    CRUD

    Book save(Book book);

    Book update (Book book);

    Boolean delete(Book book);

    Book findById(int id);

    List<Book> findAll();

//    Query


    List<Book> findAllBookByName(String name);

    List<Book> findAllBookByAuthorName(String authorName);

    List<Book> findAllBookByYear(int year);

    List<BookCountDTO> findBookCountByAuthor();

    List<BookCountDTO> findTotalQuantityBooksByAuthor();

    long findTotalQuantityBooksByAuthorId(int authorId);

    List<Book> findBooksWithZeroPriceOrZeroQuantity();

    List<Book> findBooksByPriceRange(double minPrice, double maxPrice);

    List<Author> findTop3AuthorsWithMostBooks();
}
