
## 🧠 Flashcards Project

Aplicação Java para gerenciamento de flashcards, desenvolvida com o objetivo de auxiliar estudantes na memorização de conteúdos por meio de perguntas e respostas organizadas por temas.

---

### 📋 Funcionalidades

* ✅ Cadastro de flashcards com pergunta e resposta
* 📝 Edição e exclusão de flashcards
* 📂 Organização por categorias
* 🔁 Revisão de flashcards
* 🔍 Busca por palavras-chave ou categorias

---

### 🛠 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Banco de dados: PostgreSQL
* Maven
* Lombok
* Swagger (para documentação da API)

---

### 🗂 Estrutura do Projeto

```
flashcards-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.flashcards/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       └── entity/
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.md
```

---

### 🚀 Como Rodar o Projeto

1. **Clone o repositório**

```bash
git clone https://github.com/Eduardo9345/FlashCards
cd FlashCards
cd flashcards-backend
cd flashcards-project
```

#### 2. Suba o banco de dados com Docker Compose

Certifique-se de ter o Docker instalado, então execute:

```bash
docker-compose up -d
```

Isso iniciará um container PostgreSQL com as seguintes configurações (veja `docker-compose.yml`):

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:latest
    container_name: flashcards-postgres
    restart: always
    environment:
      POSTGRES_DB: flashcards-db
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - pg_data:/var/lib/postgresql/data

volumes:
  pg_data:
    driver: local
```

3. **Compile e rode o projeto**

```bash
./mvnw spring-boot:run
```

4. **Acesse o Swagger (caso esteja ativado)**

   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

### 📦 Exemplos de Endpoints

> Supondo uma API REST para flashcards

* `GET /flashcards` — Lista todos os flashcards
* `POST /flashcards` — Cria um novo flashcard
* `PUT /flashcards/{id}` — Atualiza um flashcard
* `DELETE /flashcards/{id}` — Remove um flashcard

---

### 🧪 Testes

> (Inclua se estiver usando JUnit ou outro framework)

```bash
./mvnw test
```

---

### 💡 Próximas Melhorias

* [ ] Integração com frontend (ex: React)
* [ ] Algoritmo de repetição espaçada (SRS)
* [ ] Login e autenticação com JWT

---

### 👨‍💻 Autor

Eduardo Jose Evangelista
[LinkedIn](https://www.linkedin.com/in/eduardo-jose-evangelista-408a9623b/) • [GitHub](https://github.com/Eduardo9345)
