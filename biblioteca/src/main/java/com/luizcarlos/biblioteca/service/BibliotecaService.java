package com.luizcarlos.biblioteca.service;

import com.luizcarlos.biblioteca.model.Livro;
import com.luizcarlos.biblioteca.model.Usuario;
import com.luizcarlos.biblioteca.repository.LivroRepository;
import com.luizcarlos.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {

    private final LivroRepository repository;
    private final UsuarioRepository usuarioRepository;

    // Mantenha apenas este construtor que recebe os dois parâmetros
    public BibliotecaService(LivroRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    // Versão atualizada do emprestar que recebe o ID do usuário
    public Livro emprestarLivro(Long livroId, Long usuarioId) {
        Livro livro = repository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!livro.isDisponivel()) {
            throw new RuntimeException("Este livro já está emprestado!");
        }

        livro.setDisponivel(false);
        livro.setUsuarioQuemPegou(usuario); // Ligação entre as tabelas
        return repository.save(livro);
    }

    public Livro devolverLivro(Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livro.setDisponivel(true);
        livro.setUsuarioQuemPegou(null); // Ao devolver, removemos o vínculo com o usuário
        return repository.save(livro);
    }
}