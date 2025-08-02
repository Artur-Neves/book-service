<h1 align="center">Book Service - Bookrate - Versão Kubernetes</h1>

![GitHub Org's stars](https://img.shields.io/github/license/Artur-Neves/Gerenciamento-escolar_java)
&nbsp;
![Badge Finalizado](http://img.shields.io/static/v1?label=STATUS&message=finalizado)

Este é um dos microsserviços do projeto <a href="https://github.com/Artur-Neves/bookrate/tree/branch-update-config-with-kubernetes" target="_blank">bookrate</a>. Trata-se de uma **API REST** responsável pelo CRUD da entidade `Book`. Além das operações básicas, possui um endpoint específico (`/book-service/{id}/{from}`) que realiza uma comunicação externa com o microsserviço <a href="https://github.com/Artur-Neves/exchange-service/tree/branch-update-config-with-kubernetes" target="_blank">exchange-service</a> para conversão de valores. Este repositório contém a versão do microsserviço Book Service adaptado para execução em um cluster Kubernetes, eliminando a necessidade de serviços como API Gateway e Eureka.



<br>

# :hammer: Funcionalidades do projeto

- **`CRUD de Livros`**: Endpoints para criar, buscar, atualizar e deletar livros no sistema.
- **`Comunicação entre microsserviços`**: Endpoint que se comunica com o serviço de câmbio (`exchange-service`) para retornar valores convertidos.
- **`Validação e documentação de APIs`**: Validações com Bean Validation e documentação interativa com Swagger UI.
- **`Monitoramento e rastreamento`**: Métricas expostas com Actuator e rastreamento distribuído com Zipkin.

<br>

## ✔️ Técnicas e tecnologias utilizadas

As técnicas e tecnologias utilizadas no projeto foram:

- **`Spring Boot`**: Framework principal da aplicação.
- **`Spring Web`**: Criação de APIs REST.
- **`Spring Data JPA`**: Abstração de acesso ao banco de dados relacional.
- **`MySQL`**: Banco de dados relacional utilizado.
- **`Flyway`**: Versionamento e controle de migração do banco de dados.
- **`Spring Cloud OpenFeign`**: Comunicação HTTP com outros microsserviços.
- **`Resilience4j`**: Implementação de circuit breaker para resiliência na comunicação com outros serviços.
- **`Spring Boot Actuator`**: Monitoramento do estado da aplicação.
- **`Springdoc OpenAPI (Swagger UI)`**: Documentação automática das APIs REST.
- **`Java 21`**: Linguagem utilizada no desenvolvimento.
- **`Maven`**: Gerenciador de dependências e build.
- **`Docker`**: Suporte para execução containerizada (configurável).
- **`Kubernetes (YAML)`**: Orquestração de containers, deploy, configs, secrets, volumes, etc.
- **`ConfigMap & Secret`**: Gerenciamento de variáveis de ambiente sensíveis e não sensíveis.
- **`Deployment & Service`**: Estrutura para replicação, disponibilidade e exposição do microsserviço.

<br>

