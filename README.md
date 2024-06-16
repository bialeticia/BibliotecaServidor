# Biblioteca Servidor

Este projeto implementa um servidor de biblioteca utilizando sockets em Java. O servidor permite listar, cadastrar, alugar e devolver livros, comunicando-se com um cliente através de sockets.

## Dependências

É necessário clonar e utilizar o Cliente que se encontra no repositório: https://github.com/bialeticia/BibliotecaCliente

## Funcionalidades

- **Listar livros**: Exibe todos os livros disponíveis na biblioteca.
- **Cadastrar livros**: Permite cadastrar novos livros na biblioteca.
- **Alugar livros**: Permite alugar um exemplar de um livro existente.
- **Devolver livros**: Permite devolver um exemplar de um livro alugado.

## Estrutura do Projeto

- **Livro.java**: Classe que representa um livro.
- **Biblioteca.java**: Classe que encapsula uma lista de livros.
- **Servidor.java**: Classe principal que inicializa o servidor e gerencia as operações de livro.
- **ClienteHandler.java**: Classe que lida com a comunicação com o cliente.
- **Cliente.java**: Classe que representa o cliente que se comunica com o servidor.

## Pré-requisitos

- Java 17
- Biblioteca Jackson (para manipulação de JSON)

## Uso
### Comandos Disponíveis

- LISTAR: Lista todos os livros disponíveis na biblioteca.
  Sintaxe: LISTAR
  
- CADASTRAR: Cadastra um novo livro na biblioteca.
  Sintaxe: CADASTRAR <título>,<autor>,<gênero>,<exemplares>

- ALUGAR: Aluga um exemplar de um livro existente.
  Sintaxe: ALUGAR <título>

- DEVOLVER: Devolve um exemplar de um livro alugado.
  Sintaxe: DEVOLVER <título>
