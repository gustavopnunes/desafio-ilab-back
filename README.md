<h1 align="center">
  <img src="https://i.imgur.com/sAvv5kW.png" title="EntregaLover Logo" width="400" />
</h1>

## Sobre o projeto

<p style="color: red;">Nossa aplicação...</p>

+ Para ver o repositório **front-end**, desenvolvido em React, clique [aqui](https://github.com/gustavopnunes/desafio-ilab-front).</br>

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

A API está conectada ao nosso banco de dados já disponível no Heroku. Porém, caso queira criar seu próprio banco de dados e conectá-la a ele, basta alterar as configurações presentes em **src/main/resources/application.properties**. Não se esqueça de salvar as alterações.

```
spring.datasource.username = seu_usuario
spring.datasource.password = sua_senha
spring.datasource.url = jdbc:postgresql://link_do_seu_banco?useTimezone=true&serverTimezone=UTC
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
zspring.jpa.show_sql = true
```

O script para criação do banco se encontra no arquivo **data.sql**.

### Tudo pronto!

Agora, basta acessar a aplicação, disponível em: **localhost:8080**

+ Documentação dos endpoints disponível na rota:
**localhost:8080/api-docs**

+ Para acessar a API diretamente no seu browser, acesse: 
https://desafio-ilab-back.herokuapp.com/

## ⚙️ Funcionalidades
Funcionalidades que o sistema oferece:

- Endpoint para Autenticação de Pessoa Entregadora
- Endpoint para Consulta de Pedidos por Status
- Endpoint para Criação de Rastreio (Atribuição de Pessoa Entregadora para o Pedido)
- Endpoint para Alteração do Status do Rastreio e do Pedido
- Criação de Rastreio (atribuição de pedido a entregador)
- Endpoint para Receber Geolocalização da Pessoa Entregadora
- Endpoint para Consultas de Geolocalização por Rastreio
- Criptografia de senhas
- Validação de requisições
- Mensagens de erro customizadas
- Documentação dos endpoints

## 🔗 Links adicionais
- [Documentação das rotas no HackMD](https://hackmd.io/@xl8qmYgnSKeiH6rfFoNXSQ/SkGsq8UGc)
- [Fluxograma do banco de dados](https://drive.google.com/file/d/1STahipbU4bt0wiyP_wrGrMDDNsKsWCzJ/view?usp=sharing)
- [Kanban da equipe](https://sharing.clickup.com/31041916/b/h/xkabw-103/afe7965c2387ca4)
