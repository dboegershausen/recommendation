# Bike Recommender API
Projeto backend utilizando a stack java __spring boot__, para o recomendação de biciletas e acessórios.

## Features
- Recomendação de Bicicletas
- Recomendação de Acessórios

## Build e run dos testes :computer:
Para efetuar o build e o run dos testes iremos utilizar o __maven__.

`mvn clean install`

## Rodando o banco de dados com docker-compose :computer:
Para dar o start no banco de dados, basta apenas executar o comando:

`docker-compose -f docker-db.yml up`

## Rodando a aplicação via maven :computer:
Para executar a aplicação pelo maven basta utilizar o comando:

`mvn spring-boot:run`

A aplicação estará disponível e rodando na porta `8080`

## Criando a imagem do docker da aplicação :scroll:
Se desejar criar a imagem do docker da aplicação, utilize o comando:

`docker build -t recommendation:0.0.1 .`

## Rodando a aplicação com docker-compose :computer:
Depois da imagem criada, para dar o start na aplicação basta apenas executar o comando:

`docker-compose -f docker-app.yml up`

A aplicação estará disponível e rodando na porta `8080`

## Utilizando a aplicação
A Utilização da API pode ser feita através de seu Swagger `http://localhost:8080/swagger-ui.html`
