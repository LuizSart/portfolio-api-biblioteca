package com.luizcarlos.biblioteca.repository;

import com.luizcarlos.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Só de estender o JpaRepository, o Spring já cria automaticamente os
    // métodos de salvar, deletar, buscar por ID e listar todos!
}
