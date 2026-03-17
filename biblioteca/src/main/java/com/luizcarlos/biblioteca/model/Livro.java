package com.luizcarlos.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar em branco")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioQuemPegou; // Este campo guardará quem está com o livro

    private boolean disponivel = true;

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

}
