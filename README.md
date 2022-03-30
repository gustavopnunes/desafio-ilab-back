<h1 align="center">
  <img src="https://i.imgur.com/sAvv5kW.png" title="EntregaLover Logo" width="400" />
</h1>

<h3 align="center">
  EntregaLovers App
</h3>

<p align="center">
  <a href="#sobre o projeto">Sobre o projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#iniciando">Iniciando</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#funcionalidades">Funcionalidades</a>
</p>

## Sobre o projeto

<p style="color: red;">Nossa aplicação...</p>

+ Para ver o repositório **front-end**, desenvolvido em React, clique [aqui](https://github.com/gustavopnunes/desafio-ilab-front).</br>

### 👩🏽‍💻 Pessoas Desenvolvedoras
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

## Links adicionais
- [Documentação das rotas no HackMD]()
- [Fluxograma do banco de dados]()
- [Kanban da equipe]()

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

O script para criação do banco, bem como as queries para populá-lo, encontram-se...

### Tudo pronto!

Agora, basta acessar a aplicação, disponível em: **localhost:8080**

+ Documentação dos endpoints disponível na rota:
**localhost:8080/api-docs**

+ Para acessar a API diretamente no seu browser, acesse: 
https://desafio-ilab-back.herokuapp.com/

## ⚙️ Funcionalidades
Funcionalidades que o sistema oferece:

EXEMPLO A SEGUIR

- Cadastro e Login de Usuários
- Cadastro de Clientes e Especialistas
- Cadastro de Atendimentos e de Históricos de Prontuários
- Pesquisa
	- Busca de atendimentos por Status, Paciente, Especialista, Data de agendamento ou de atendimento
- Criação de Agendamentos
- Criptografia de senhas
- Sistema de autenticação de usuário
- Validação de requisições
- Mensagens de erro customizadas *user friendly*
- Documentação dos endpoints
