package com.goodreading.bookstore.controller;

import com.goodreading.bookstore.model.Book;
import com.goodreading.bookstore.repository.BookstoreRepository;
import com.goodreading.bookstore.service.BookstoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookstoreController {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    @Autowired
    private BookstoreService bookstoreService;

    // GET: Buscar todos os livros

    @GetMapping
    @Operation(summary = "Obter todos os livros", responses = {
            @ApiResponse(description = "Sucesso ao obter a lista de livros", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)))
    })
    public List<Book> getAllLivros() {
        return bookstoreService.findAll();
    }

    // POST: Criar um novo livro
    @PostMapping
    public Book createLivro(@RequestBody Book book) {
        return bookstoreService.save(book);
    }

    // PUT: Atualizar um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateLivro(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedBook = bookstoreService.update(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    // DELETE: Deletar um livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        bookstoreService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Método para atualização parcial de um livro
    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateLivroPartially(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedBook = bookstoreService.updatePartially(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }
}
