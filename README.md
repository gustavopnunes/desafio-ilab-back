<h1 align="center">
  <img src="https://i.imgur.com/pnrj6LW.png" title="EntregaLover Logo" width="400" />
</h1>

## Sobre o projeto

<p>Nosso projeto consiste em uma aplicação para recuperação e armazenamento de dados de geolocalização em tempo real.</p>

+ Para ver o repositório **front-end**, desenvolvido em React, clique [aqui](https://github.com/gustavopnunes/desafio-ilab-front).

### 👩🏽‍💻 Equipe responsável
- [Bianca Andrade](https://github.com/biancaandradee)
- [Gustavo Nunes](https://github.com/gustavopnunes)
- [Jean Pierre Sisse](https://github.com/JeanSisse)
- [Lisandre Darioli](https://github.com/lisdrl)
- [Mayanna Porto](https://github.com/mayannap)
- [Quézia Balonecker](https://github.com/queziabalonecker)

## 💻 Tecnologias

Tecnologias que utilizamos para desenvolver esta API Rest:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [JWT](https://jwt.io/)
- [Swagger](https://swagger.io/)

## 🏁 Iniciando o projeto

Para criar uma cópia do projeto na sua máquina local, siga os passos abaixo.

- Clone a API em sua máquina
- Importe o projeto na IDE de sua preferência
    - No Eclipse: File > Import > Existing Maven Projects
- Inicie a API
    - No Eclipse: 
		- selecione o projeto no Package Explorer;
		- clique em “Run” e escolha “Java Application”;
		- selecione a aplicação e clique em “Finish”.

### Acesso ao banco de dados:

Primeiro, crie seu banco de dados Postgresql fazendo uso do script que se encontra no arquivo **data.sql**. Então, para conectar a API a ele, altere as configurações presentes em **src/main/resources/application.properties**. Não se esqueça de salvar as alterações.

```
spring.datasource.username = seu_usuario
spring.datasource.password = sua_senha
spring.datasource.url = jdbc:postgresql://link_do_seu_banco?useTimezone=true&serverTimezone=UTC
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
zspring.jpa.show_sql = true
```

### Tudo pronto!

Agora, basta acessar a aplicação, disponível em: **localhost:8080**

+ Documentação dos endpoints disponível na rota:
**localhost:8080/swagger-ui.html**

+ Para verificar a API hospedada no Heroku, acesse: 
https://desafio-ilab-back.herokuapp.com/

## ⚙️ Funcionalidades
Funcionalidades que o sistema oferece:

- Login de Pessoa Entregadora
- Consulta de Pedidos por Status
- Criação de Rastreio (Atribuição de Pessoa Entregadora para o Pedido)
- Alteração do Status do Rastreio e do Pedido
- Captura e Registro da Geolocalização da Pessoa Entregadora
- Consultas de Geolocalização por Pedido
- Criptografia de senhas
- Validação de requisições
- Mensagens de erro customizadas
- Documentação dos endpoints

## 🔗 Links adicionais
- [Swagger](https://desafio-ilab-back.herokuapp.com/swagger-ui.html)
- [Fluxograma do banco de dados](https://drive.google.com/file/d/1B2aILJyphdKjPzKv8SEL5_3cfmk_E1XD/view?usp=sharing)
- [Kanban da equipe](https://sharing.clickup.com/31041916/b/h/xkabw-103/afe7965c2387ca4)
