# Todolist with Authentication

API REST de lista de tarefas (To-Do List) desenvolvida em Java com Spring Boot, com autenticação de usuários via JWT para garantir que cada usuário só acesse suas próprias tarefas.

## ✨ Funcionalidades

- Cadastro e login de usuários
- Autenticação via JWT (JSON Web Token)
- Criação, listagem, atualização e remoção de tarefas
- Prioridade e status de cada tarefa (via enums)
- Cada usuário só visualiza e gerência suas próprias tarefas
- Tratamento centralizado de exceções

## 🛠️ Tecnologias

- Java
- Spring Boot
- Spring Security + JWT
- H2 Database (em memória, uso durante desenvolvimento)
- Maven

> 🔜 Planejado: migração do banco H2 para PostgreSQL.

## 📁 Estrutura do projeto

```
src/main/java/br/com/italo/todolist
├── errors     # tratamento centralizado de exceções
├── filter     # filtro de autenticação (JWT)
├── task       # repository, controller, model e enums de Task
├── user       # repository, controller e model de User
└── utils      # classes utilitárias
```

## ▶️ Como rodar o projeto

1. Clone o repositório:
   ```
   git clone <url-do-repositorio>
   ```
2. Entre na pasta do projeto:
   ```
   cd todolist-with-authentication
   ```
3. Rode com o Maven Wrapper:
   ```
   ./mvnw spring-boot:run
   ```
4. A API estará disponível em `http://localhost:8080`

O console do H2 (se habilitado) fica disponível em `http://localhost:8080/h2-console`.

## 🔑 Autenticação

A maioria dos endpoints de tarefas exige um token JWT. Fluxo básico:

1. Cadastre um usuário em `/users/`
2. Faça login em todas as próximas requisições:
   ```
   Autho: Basic Auth
   ```

## 📌 Endpoints

### Usuário

| Método | Rota              | Descrição                  | Autenticado |
|--------|-------------------|----------------------------|-------------|
| POST   | /users/           | Cadastra um novo usuário   | Não         |

### Tarefas

| Método | Rota              | Descrição                        | Autenticado |
|--------|-------------------|------------------------------------|-------------|
| GET    | /tasks/            | Lista as tarefas do usuário logado | Sim |
| POST   | /tasks/            | Cria uma nova tarefa               | Sim |
| PUT    | /tasks/{id}        | Atualiza uma tarefa                | Sim |

## 📚 Sobre o projeto

Projeto criado como estudo pessoal, com foco em praticar lógica de programação, Spring Boot e autenticação com JWT.

## 🚧 Próximos passos

- Migrar o banco de dados de H2 para PostgreSQL
- Implementar outros métodos para Users e Tasks;
- Migrar as regras de negócio do Controller para o Service;
- Criar o Front-end e consumir a API;
- Criar novas funcionalidades;
