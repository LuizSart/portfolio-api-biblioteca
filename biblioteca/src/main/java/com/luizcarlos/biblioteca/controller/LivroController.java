package com.luizcarlos.biblioteca.controller;

import com.luizcarlos.biblioteca.model.Livro;
import com.luizcarlos.biblioteca.repository.LivroRepository;
import jakarta.validation.Valid; // <-- Importante: O IntelliJ deve importar isso automaticamente
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    // CREATE: O @Valid avisa o Spring para checar as regras antes de salvar
    @PostMapping
    public Livro adicionarLivro(@Valid @RequestBody Livro livro) {
        return repository.save(livro);
    }

    // READ
    @GetMapping
    public List<Livro> listarLivros() {
        return repository.findAll();
    }

    // UPDATE: O @Valid também checa as regras na hora de atualizar
    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @Valid @RequestBody Livro livroAtualizado) {
        Livro livroExistente = repository.findById(id).orElseThrow();

        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());

        return repository.save(livroExistente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        repository.deleteById(id);
    }
}