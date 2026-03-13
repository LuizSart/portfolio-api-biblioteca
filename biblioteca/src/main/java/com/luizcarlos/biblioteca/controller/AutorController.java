package com.luizcarlos.biblioteca.controller;

import com.luizcarlos.biblioteca.model.Autor;
import com.luizcarlos.biblioteca.repository.AutorRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    // Rota para cadastrar um novo Autor (POST)
    @PostMapping
    public Autor adicionarAutor(@Valid @RequestBody Autor autor) {
        return repository.save(autor);
    }

    // Rota para listar os Autores existentes (GET)
    @GetMapping
    public List<Autor> listarAutores() {
        return repository.findAll();
    }
}