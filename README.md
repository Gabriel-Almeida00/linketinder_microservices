# Microservice de Cadastro do Linketinder - Sistema de Contratação de Funcionários
- Uma Simples implementação de microservices para o projeto do linketinder : https://github.com/Gabriel-Almeida00/ZG-HERO-Project, porem focando apenas na parte de cadastro de canidatos e empresas


## Funcionalidades

- Cadastrar novo candidato (Pessoa Física)
- Cadastrar nova empresa (Pessoa Jurídica)





### API REST
Na Atual versão do projeto foi desenvolvida uma API sem framework, foi necesario o tomcat e Servlet
1. versão Ultimate Intellij , é possível consguir a versão com a licença de estudante : https://www.jetbrains.com/pt-br/community/education/#students
2. Tomcat na versão 8  https://tomcat.apache.org/tomcat-8.5-doc/index.html baixar e descompactar em alguma pasta.
3. configurar o tomcat no intellij > https://www.jetbrains.com/idea/guide/tutorials/working-with-apache-tomcat/using-existing-application/ e https://www.youtube.com/watch?v=ThBw3WBTw9Q&t=343s
4. criar endpoins com servlet > https://www.youtube.com/watch?v=ThBw3WBTw9Q&t=343s. neste projeto apartir desse commit na pasta controllers tem exemplo de como implemnetar API com servlet > https://github.com/Gabriel-Almeida00/ZG-HERO-Project/commit/49ac78ffecb19da94a309215614d67fd1b690b9e
5. bibiotecas adicionadas no build.gradle ``   compileOnly group: 'javax.servlet', name: 'javax.servlet-api', version: '4.0.1'
   implementation group: 'javax.annotation', name: 'javax.annotation-api', version: '1.3.2' ``


   # Banco de Dados do Linketinder

Este repositório contém a modelagem de banco de dados para o Linketinder, um aplicativo de matchmaking entre candidatos e empresas. O banco de dados foi implementado usando PostgreSQL e o modelo foi criado usando a ferramenta dbdiagram.io.
- foi implementado o banco de dados nesse projeto com o padrão dao

## Modelo de Entidade-Relacionamento (MER)

O modelo de entidade-relacionamento (MER) para o banco de dados do Linketinder foi projetado para acomodar os perfis de candidatos, empresas, competências, formações, experiências e vagas. A modelagem inclui relações entre essas entidades, permitindo a interação entre candidatos e empresas por meio de curtidas em vagas e perfis.

O modelo pode ser visualizado em detalhes no arquivo [linketinder_model.png](https://github.com/Gabriel-Almeida00/ZG-HERO-Project/blob/main/src/sql/linketinder.pdf).

Script sql para criação:([https://github.com/Gabriel-Almeida00/ZG-HERO-Project/blob/main/src/sql/linketinder.pdf](https://github.com/Gabriel-Almeida00/ZG-HERO-Project/blob/main/src/sql/linketinder).





## PostgreSQL

O banco de dados foi implementado usando o sistema de gerenciamento de banco de dados PostgreSQL. O PostgreSQL é uma escolha sólida para sistemas relacionais, oferecendo robustez, escalabilidade e recursos avançados.


## Contribuição

Se você quiser contribuir para o projeto, fique à vontade para abrir um pull request. Qualquer ajuda é bem-vinda!

