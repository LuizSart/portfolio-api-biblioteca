package com.luizcarlos.biblioteca.controller;

import com.luizcarlos.biblioteca.model.Usuario;
import com.luizcarlos.biblioteca.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Usuario cadastrar(@Valid @RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }
}