package com.goodreading.bookstore.service;

import com.goodreading.bookstore.model.Book;
import com.goodreading.bookstore.repository.BookstoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreServiceImpl implements BookstoreService {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    @Override
    public List<Book> findAll() {
        // Retorna todos os livros disponíveis no banco de dados
        return bookstoreRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        // Salva um novo livro no banco de dados ou atualiza um existente
        return bookstoreRepository.save(book);
    }

    @Override
    public Book update(Long id, Book bookDetails) {
        // Encontra o livro pelo ID, ou lança uma exceção caso não exista
        Book book = bookstoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));

        // Atualiza os dados do livro conforme fornecido
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublicationDate(bookDetails.getPublicationDate());
        book.setPrice(bookDetails.getPrice());

        // Salva o livro atualizado no banco de dados
        return bookstoreRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        // Encontra o livro pelo ID e remove-o do banco de dados
        Book book = bookstoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));
        bookstoreRepository.delete(book);
    }

    @Override
    public Book updatePartially(Long id, Book bookDetails) {
        Book book = bookstoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (bookDetails.getTitle() != null) {
            book.setTitle(bookDetails.getTitle());
        }
        if (bookDetails.getAuthor() != null) {
            book.setAuthor(bookDetails.getAuthor());
        }
        if (bookDetails.getPublicationDate() != null) {
            book.setPublicationDate(bookDetails.getPublicationDate());
        }
        if (bookDetails.getPrice() != null) {
            book.setPrice(bookDetails.getPrice());
        }

        return bookstoreRepository.save(book);
    }
}
