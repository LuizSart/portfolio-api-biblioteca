package com.luizcarlos.biblioteca.controller;

import com.luizcarlos.biblioteca.model.Livro;
import com.luizcarlos.biblioteca.repository.LivroRepository;
import com.luizcarlos.biblioteca.service.BibliotecaService; // Importando o novo service
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;
    private final BibliotecaService service; // Adicionando o service aqui

    // Atualizando o construtor para receber o service também
    public LivroController(LivroRepository repository, BibliotecaService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public Livro adicionarLivro(@Valid @RequestBody Livro livro) {
        return repository.save(livro);
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return repository.findAll();
    }

    // --- NOVAS ROTAS DE EMPRÉSTIMO ---

    // Rota: POST http://localhost:8080/livros/1/emprestar
    @PostMapping("/{id}/emprestar")
    public Livro emprestarLivro(@PathVariable Long id) {
        return service.emprestarLivro(id);
    }

    // Rota: POST http://localhost:8080/livros/1/devolver
    @PostMapping("/{id}/devolver")
    public Livro devolverLivro(@PathVariable Long id) {
        return service.devolverLivro(id);
    }

    // --- Outros métodos (PUT, DELETE) podem continuar abaixo ---
}