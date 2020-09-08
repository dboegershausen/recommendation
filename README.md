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

## Passos para utilização
- Criar um usuário usando o controller de User Management:
```json
{
  "email": "john.doe@gmail.com",
  "password": "doe@123"
}
```

- Gerar um token de acesso para o usuário gerado usando o controller Token Management:
```json
{
  "email": "john.doe@gmail.com",
  "password": "doe@123"
}
```

- Utilizar o controller Bike Recommendations para obter uma sugestão de bicicleta informando a altura do ciclista, o tipo de terreno onde a bicicleta será utilizada, a distância mensal em que a bicicleta será utilizada e os objetivos de utilização da bicicleta :

Tipos de Terreno: **DIRT_ROAD** (Estrada de Chão), **ROUGH_ROAD** (Asfalto Irregular), **NORMAL ROAD** (Asfalto Regular) 
Objetivos: **CITY** (Passeio na Cidade), **TREK** (Trilha), **CYCLING** (Pedalada) 

```json
{
  "cyclistHeight": 1.75,
  "grounds": [ "NORMAL_ROAD" ],
  "monthDistance": 100,
  "objectives": [ "CITY" ]
}
```
A sugestão de bicicleta terá o tamanho (**SMALL**, **MEDIUM**, **BIG**), a qualidade (**SIMPLE**, **INTERMEDIARY**, **PROFESSIONAL**) e o tipo (**LIFESTYLE**, **MOUNTAIN**, **SPEED**)


- Utilizar o controller Accessory Recommendations para obter uma sugestão de acessórios para sua pedalada com base na distância a ser percorrida:
```json
{
  "distance": 20
}
```
