# Exemplo de Projeto - MVC - Custom RUP

## Como executar

```sh
./mvnw spring-boot:run
# Acessar localhost:8081/cliente
```

> Para mudar a porta, modifique o arquivo `src/resources/application.properties`

## Passo-a-passo da implementação

1. Criar o projeto usando o [Spring Initializr](https://start.spring.io/)
 * Adicionar as dependências: Spring Web, DevTools, Thymeleaf, JPA, H2

2. Criar as POJOs (Cliente e Conta)
 * Adicionar a anotação @Entity para persistência

3. Criar as classes do Model (Fachada, Controladores, Cadastro, Repositórios)
 * Implementar a lógica de negócio

4. Criar os DAOs para acesso ao banco de dados (ver ClienteDAO e ContaDAO)

5. Adicionar @Component e @Autowired para que a framework cuide da instanciação dos objetos

6. Criar o Controller (MVC) - ver ClienteController.java
 * Adicionar a anotação @Controller

7. Criar o template (View - MVC) em `src/resources/templates`
 * Verificar a sintaxe da template engine para "renderizar" os dados