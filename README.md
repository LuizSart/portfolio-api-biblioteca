# 📚 API de Gerenciamento de Biblioteca

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

Projeto de portfólio desenvolvido para demonstrar conhecimentos práticos na construção de uma API RESTful corporativa utilizando **Java** e **Spring Boot**. 

## 🚀 Funcionalidades Implementadas

* **CRUD Completo:** Gerenciamento de livros e autores.
* **Banco de Dados Relacional:** Relacionamento `@ManyToOne` entre Livros e Autores usando Spring Data JPA.
* **Validação de Dados:** Uso de `Spring Boot Validation` para garantir a integridade das requisições (ex: impedir livros com anos no futuro ou campos em branco).
* **Tratamento Global de Exceções:** Uso de `@RestControllerAdvice` para capturar erros de validação e retornar respostas JSON amigáveis e padronizadas (`400 Bad Request`).

## 🛠️ Tecnologias Utilizadas

* **Java 21/22**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **H2 Database** (Banco de dados em memória)
* **Maven** (Gerenciamento de dependências)
* **Postman** (Testes de API)

## ⚙️ Como executar o projeto

1. Clone este repositório:
   ```bash
   git clone [https://github.com/LuizSart/portfolio-api-biblioteca.git](https://github.com/LuizSart/portfolio-api-biblioteca.git)
