package com.luizcarlos.biblioteca.service;

import com.luizcarlos.biblioteca.model.Livro;
import com.luizcarlos.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {

    private final LivroRepository repository;

    public BibliotecaService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro emprestarLivro(Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (!livro.isDisponivel()) {
            throw new RuntimeException("Este livro já está emprestado!");
        }

        livro.setDisponivel(false);
        return repository.save(livro);
    }

    public Livro devolverLivro(Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livro.setDisponivel(true);
        return repository.save(livro);
    }
}