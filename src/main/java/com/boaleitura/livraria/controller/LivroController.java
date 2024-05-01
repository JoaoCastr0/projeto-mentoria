package com.boaleitura.livraria.controller;

import com.boaleitura.livraria.model.Livro;
import com.boaleitura.livraria.repository.LivroRepository;
import com.boaleitura.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroService livroService;

    // GET: Buscar todos os livros
    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.findAll();
    }

    // POST: Criar um novo livro
    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) {
        return livroService.save(livro);
    }

    // PUT: Atualizar um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody Livro livroDetails) {
        Livro updatedLivro = livroService.update(id, livroDetails);
        return ResponseEntity.ok(updatedLivro);
    }

    // DELETE: Deletar um livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Método para atualização parcial de um livro
    @PatchMapping("/{id}")
    public ResponseEntity<Livro> updateLivroPartially(@PathVariable Long id, @RequestBody Livro livroDetails) {
        Livro updatedLivro = livroService.updatePartially(id, livroDetails);
        return ResponseEntity.ok(updatedLivro);
    }
}
