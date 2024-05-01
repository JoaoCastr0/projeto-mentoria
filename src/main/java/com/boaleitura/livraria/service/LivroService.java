package com.boaleitura.livraria.service;

import com.boaleitura.livraria.model.Livro;
import java.util.List;

public interface LivroService {
    List<Livro> findAll();
    Livro save(Livro livro);
    Livro update(Long id, Livro livro);
    void delete(Long id);
    Livro updatePartially(Long id, Livro livroDetails);
}
