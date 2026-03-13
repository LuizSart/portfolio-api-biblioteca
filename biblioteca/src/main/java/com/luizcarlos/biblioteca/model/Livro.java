package com.luizcarlos.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar em branco")
    private String titulo;

    // --- A MÁGICA DOS RELACIONAMENTOS ACONTECE AQUI ---
    @NotNull(message = "O autor é obrigatório")
    @ManyToOne // Diz à base de dados: "Muitos livros para Um Autor"
    @JoinColumn(name = "autor_id") // Cria uma coluna "chave estrangeira" para guardar o ID do Autor
    private Autor autor;

    @NotNull(message = "O ano de publicação é obrigatório")
    @Max(value = 2026, message = "O ano de publicação não pode estar no futuro")
    private Integer anoPublicacao;

    public Livro() {
    }

    // Atualizámos o construtor para receber o objeto Autor em vez de um texto
    public Livro(String titulo, Autor autor, Integer anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // --- Getters e Setters Atualizados ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
}
