Automação de Testes de API com REST Assured + Cucumber

Este projeto tem como objetivo validar funcionalidades de uma API de produtos utilizando **REST Assured** para testes automatizados e **Cucumber** para descrever cenários em linguagem natural.

A automação cobre operações básicas de CRUD (Create, Read, Update, Delete), além de validações de contrato como status HTTP e campos obrigatórios da resposta.

---

Tecnologias Utilizadas

* Java 11+
* REST Assured
* JUnit 5
* Cucumber (BDD)
* Maven

---

Estrutura do Projeto

```
src
 ├── main
 │    └── java
 │         ├── model        # Representação do JSON (POJO)
 │         ├── service      # Requisições da API
 │         └── factory      # Criação de dados dinâmicos
 │
 └── test
      ├── java
      │     ├── steps       # Step Definitions (BDD)
      │     ├── hooks       # Configurações globais (Before)
      │     └── runner      # Classe executora dos testes
      │
      └── resources
            └── features    # Cenários em Gherkin
```

---

Cenários Automatizados

* ✅ Buscar produto existente
* ✅ Criar produto
* ✅ Atualizar produto
* ✅ Deletar produto
* ❌ Buscar produto inexistente (teste negativo)

---

## ✔️ Validações Implementadas

* Status Code (200, 201, 404)
* Campos obrigatórios da API:

  * `id`
  * `title`
* Estrutura da resposta JSON
* Testes independentes com dados dinâmicos

---

## ▶️ Como Executar o Projeto

1. Clonar o repositório:

```
git clone <url-do-repositorio>
```

2. Abrir no IntelliJ ou IDE de sua preferência

3. Executar a classe:

```
TestRunner.java
```

---

Relatórios

Após a execução, o relatório será gerado em:

```
target/cucumber-report.html
```

Abra o arquivo no navegador para visualizar os resultados dos testes.

---

Próximos Passos (Evoluções)

* Integração com Allure Report
* Validação com JSON Schema
* Integração com CI/CD (GitHub Actions)
* Testes com autenticação (token)

---

Autor

Projeto desenvolvido para teste em automação de testes de API.
