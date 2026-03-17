package com.luizcarlos.biblioteca.repository;

import com.luizcarlos.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}