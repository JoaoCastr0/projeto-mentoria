package com.goodreading.bookstore.service;

import com.goodreading.bookstore.model.Book;

import java.util.List;

public interface BookstoreService {
    List<Book> findAll();
    Book save(Book book);
    Book update(Long id, Book book);
    void delete(Long id);
    Book updatePartially(Long id, Book bookDetails);
}
