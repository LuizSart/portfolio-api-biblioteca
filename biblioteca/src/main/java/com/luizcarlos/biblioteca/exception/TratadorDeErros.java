package com.luizcarlos.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Avisa o Spring que esta classe vai "escutar" todos os erros da API
public class TratadorDeErros {

    // Dizemos ao Spring: "Quando acontecer o erro de validação, rode este método e devolva o status 400"
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> lidarComErrosDeValidacao(MethodArgumentNotValidException ex) {

        // Criamos um "dicionário" vazio para guardar o nome do campo e a mensagem de erro
        Map<String, String> erros = new HashMap<>();

        // Pegamos todos os erros que aconteceram e colocamos no nosso dicionário
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nomeDoCampo = ((FieldError) error).getField();
            String mensagemDeErro = error.getDefaultMessage();
            erros.put(nomeDoCampo, mensagemDeErro);
        });

        return erros; // Devolvemos o dicionário formatado como JSON!
    }

    // Captura erros de lógica de negócio (como "livro já emprestado")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> lidarComErrosDeNegocio(RuntimeException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("mensagem", ex.getMessage());
        return erro;
    }
}
