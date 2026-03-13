package com.luizcarlos.biblioteca.repository;

import com.luizcarlos.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}