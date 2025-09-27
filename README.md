# 📚 Sistema de Biblioteca em Java

Este projeto é um **sistema de gerenciamento de biblioteca** implementado em Java. Permite cadastrar usuários, cadastrar livros, realizar empréstimos, devoluções e consultar registros.

---

## ✨ Funcionalidades

1. **Cadastro de Usuários 👥**  
   - Tipos: **Estudante 🧑‍🎓** e **Professor 👩‍🏫**  
   - Cada tipo possui prazo de devolução diferente (polimorfismo).

2. **Cadastro de Livros 📖**  
   - Informações: título, autor, ano e quantidade.  
   - Ao cadastrar um livro já existente, a quantidade é atualizada.

3. **Empréstimos 📝**  
   - Um **Empréstimo** contém **Usuário** e **Livro** (composição).  
   - Atualiza automaticamente a quantidade disponível do livro.  
   - Calcula a **data prevista de devolução 📅** de acordo com o tipo de usuário.

4. **Devoluções 🔄**  
   - Permite devolver livros registrando a data de devolução.  
   - Atualiza o estoque automaticamente.

5. **Listagem de registros 📊**  
   - Lista todos os empréstimos em andamento e devolvidos.

---

## 🏗 Estrutura de Classes

- **Usuario** (abstrata)  
  - Subclasses: **Estudante 🧑‍🎓**, **Professor 👩‍🏫**  
  - Método polimórfico `getPrazoDias()` define o prazo de devolução.

- **Livro 📖**  
  - Contém informações: título, autor, ano, quantidade.

- **Emprestimo 📝**  
  - Composição: contém `Usuario` e `Livro`.  
  - Mantém data de empréstimo, data prevista e data de devolução.

- **Biblioteca 🏛**  
  - Armazena listas de usuários, livros, empréstimos e devolvidos.  
  - Métodos para adicionar usuários, livros, registrar empréstimos e devoluções.

- **Main 💻**  
  - Interface textual para interação com o usuário.

