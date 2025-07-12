

# ForumHub API - Exemplos e Referências


Bem-vindo à documentação da **ForumHub API** — uma API RESTful desenvolvida em Spring Boot para gerenciamento de tópicos de fórum, cursos, perfis e respostas. A autenticação é baseada em JWT para garantir segurança e controle de acesso.

## Configurando o Banco de Dados PostgreSQL no Spring Boot

Para garantir que sua aplicação **converse com o banco de dados de forma elegante e eficiente**, siga estes passos:

### 1. Prepare seu banco PostgreSQL

- Instale o PostgreSQL (local ou remoto).
- Crie um banco chamado `forumhub` (ou outro nome que preferir):


```
sql
CREATE DATABASE forumhub;


CREATE USER seu_usuario WITH PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE forumhub TO seu_usuario;


export DB_USER=seu_usuario
export DB_PASSWORD=sua_senha
export JWT_SECRET=uma_chave_secreta_super_forte


spring.datasource.url=jdbc:postgresql://localhost/forumhub
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```



## Endpoints Principais

| Método | Rota            | Descrição                |
| ------ | --------------- | ------------------------ |
| GET    | `/topicos`      | Lista tópicos (paginado) |
| POST   | `/topicos`      | Cadastra um novo tópico  |
| PUT    | `/topicos`      | Atualiza um tópico       |
| GET    | `/topicos/{id}` | Detalha um tópico        |
| DELETE | `/topicos/{id}` | Remove um tópico         |

---

| Método | Rota         | Descrição             |
| ------ | ------------ | --------------------- |
| POST   | `/respostas` | Cadastra uma resposta |

---

| Método | Rota           | Descrição               |
| ------ | -------------- | ----------------------- |
| GET    | `/perfis`      | Lista perfis paginados  |
| POST   | `/perfis`      | Cadastra um novo perfil |
| DELETE | `/perfis/{id}` | Remove um perfil        |

---

| Método | Rota      | Descrição         |
| ------ | --------- | ----------------- |
| POST   | `/cursos` | Cadastra um curso |

---

## 📍 Base URL

```http://localhost:8080```




## Exemplo de Login

```json
{
  "email": "usuario@email.com",
  "senha": "123456"
}
```


## Exemplos de Payloads JSON

### Cadastro de Tópico

```json
{
  "titulo": "Dúvida sobre Java",
  "mensagem": "Como funciona o record?",
  "idCurso": 1
}
```

### Atualização de Tópico

```json
{
  "id": 1,
  "titulo": "Título atualizado",
  "mensagem": "Mensagem atualizada"
}
```

### Cadastro de Resposta

```json
{
  "mensagem": "Os records em Java são úteis quando você deseja criar classes apenas para transportar dados.\n Eles são imutáveis por padrão e reduzem a verbosidade do código.",
  "topicoId": 1,
  "solucao": "Utilize `public record NomeDoRecord(...)` no lugar de uma classe tradicional com getters,\n construtor e equals/hashCode."
}
```

---

## Parâmetros de Paginação

| Parâmetro | Tipo   | Descrição                         |
| --------- | ------ | --------------------------------- |
| `page`    | int    | Número da página (inicia em 0)    |
| `size`    | int    | Tamanho da página (mínimo 1)      |
| `sort`    | string | Campo de ordenação (ex: `id,asc`) |

---

## Códigos HTTP

| Código | Significado                        |
| ------ | ---------------------------------- |
| 200    | OK – Requisição bem-sucedida       |
| 201    | Created – Recurso criado           |
| 400    | Bad Request – Requisição inválida  |
| 401    | Unauthorized – Não autenticado     |
| 404    | Not Found – Recurso não encontrado |
| 500    | Internal Server Error              |

---

## Esquema de Segurança JWT

```yaml
securitySchemes:
  bearer-key:
    type: http
    scheme: bearer
    bearerFormat: JWT
```

---

## Ferramentas Recomendadas

- Postman
- Swagger Editor (https://editor.swagger.io/)
- Insomnia

