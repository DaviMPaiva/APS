# APS

Artur Santos - acs9  
  
Davi Monteiro Paiva - dmp  
  
Gustavo Campos - gcc2  
  
Lucas Cavalcanti - loc

## Aplicação: AluCar

Nossa proposta é um sistema de Aluguel de carros, no qual o usuário pode realizar login, buscar por carros e alugar. Além disso, ao devolver, pode dar um feedback sobre sua experiência. A Alucar possui uma base de dados dos seus carros.

## Requisitos

* Node - versão >= 20
* Java - versão >= 17
* Maven - versão >= 3.9.6

## Execução do programa
Obs.: É necessário um arquivo .env

1. Primeiro, instale as dependências do backend presentes pom.xml:

```mvn install```

2. Em seguida, execute o backend da aplicação:

```mvn spring-boot:run```

3.  Em outro terminal, instale as dependências do frontend presentes no package-lock.json:

```npm install```

4. Por fim, execute o frontend:

```npm run dev```


