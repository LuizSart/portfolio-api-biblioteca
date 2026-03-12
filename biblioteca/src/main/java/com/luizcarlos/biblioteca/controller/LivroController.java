package com.luizcarlos.biblioteca.controller;

import com.luizcarlos.biblioteca.model.Livro;
import com.luizcarlos.biblioteca.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Avisa que esta classe é um controlador de uma API REST
@RequestMapping("/livros") // Diz que todas as rotas aqui vão começar com "localhost:8080/livros"
public class LivroController {

    private final LivroRepository repository;

    // Injetando o repositório para podermos usar o banco de dados
    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    // CREATE: Salvar um novo livro (POST)
    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    // READ: Listar todos os livros (GET)
    @GetMapping
    public List<Livro> listarLivros() {
        return repository.findAll();
    }

    // UPDATE: Atualizar um livro existente (PUT)
    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Livro livroExistente = repository.findById(id).orElseThrow();

        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());

        return repository.save(livroExistente);
    }

    // DELETE: Deletar um livro (DELETE)
    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        repository.deleteById(id);
    }
}