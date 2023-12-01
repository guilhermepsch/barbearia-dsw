# Projeto 55DSW - weBarbearia

## Requisitos

- [Java](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/) (Opcional)
- [PgAdmin](https://www.pgadmin.org/download/) (Opcional)
- [Node.js](https://nodejs.org/en/download/)

## Instalação

- Clone o repositório com `git clone` ou baixe o zip.
- Entre no diretório com `cd barbearia-dsw`.

## Rodando o projeto

É necessário realizar na ordem apresentada.

### Banco de dados

- Crie um banco de dados no PostgreSQL com o nome `generic`.
- Crie um usuário com o nome `postgres` e senha `postgres`.
- Permita que o usuário `postgres` acesse o banco de dados `generic`.
- Deixe a conexão com o banco de dados `generic` aberta.

### Backend

- Entre na pasta `server` e execute `mvn install`.
- Assim que o processo terminar, execute `mvn spring-boot:run`.

### Frontend

- Entre na pasta `web` e execute `npm install`.
- Assim que o processo terminar, execute `npm run dev`.

## Acessando o projeto

- Acesse `http://localhost:5000` no seu navegador de escolha para acessar o projeto no frontend.
- Acesse `http://localhost:8080` no seu aplicativo de testes de api de escolha para acessar o projeto no backend.