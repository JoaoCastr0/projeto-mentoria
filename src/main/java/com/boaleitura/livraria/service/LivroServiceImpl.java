package com.boaleitura.livraria.service;

import com.boaleitura.livraria.model.Livro;
import com.boaleitura.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public List<Livro> findAll() {
        // Retorna todos os livros disponíveis no banco de dados
        return livroRepository.findAll();
    }

    @Override
    public Livro save(Livro livro) {
        // Salva um novo livro no banco de dados ou atualiza um existente
        return livroRepository.save(livro);
    }

    @Override
    public Livro update(Long id, Livro livroDetails) {
        // Encontra o livro pelo ID, ou lança uma exceção caso não exista
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));

        // Atualiza os dados do livro conforme fornecido
        livro.setTitulo(livroDetails.getTitulo());
        livro.setAutor(livroDetails.getAutor());
        livro.setDataPublicacao(livroDetails.getDataPublicacao());
        livro.setPreco(livroDetails.getPreco());

        // Salva o livro atualizado no banco de dados
        return livroRepository.save(livro);
    }

    @Override
    public void delete(Long id) {
        // Encontra o livro pelo ID e remove-o do banco de dados
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));
        livroRepository.delete(livro);
    }

    @Override
    public Livro updatePartially(Long id, Livro livroDetails) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (livroDetails.getTitulo() != null) {
            livro.setTitulo(livroDetails.getTitulo());
        }
        if (livroDetails.getAutor() != null) {
            livro.setAutor(livroDetails.getAutor());
        }
        if (livroDetails.getDataPublicacao() != null) {
            livro.setDataPublicacao(livroDetails.getDataPublicacao());
        }
        if (livroDetails.getPreco() != null) {
            livro.setPreco(livroDetails.getPreco());
        }

        return livroRepository.save(livro);
    }
}
