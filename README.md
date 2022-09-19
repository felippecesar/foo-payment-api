# foo-payment-api

**foo-payment-api** é uma aplicação REST que faz parte do [**foo-negotiation-system**](https://miro.com/app/board/uXjVPXztVMc=/?share_link_id=618705188281). 

A função desta aplicação é apresentar formas e propostas convenientes para a quitação das dívidas dos clientes do banco.

## Padrões de projeto

Nossa arquitetura segue os padrões [*Chain of Responsibility*](https://refactoring.guru/design-patterns/chain-of-responsibility) e [*Command*](https://refactoring.guru/design-patterns/command) para execução das funcionalidades.
Sendo assim, temos as seguintes "camadas" de código:

- **Flows:** define o fluxo da funcionalidade, chamando os validators, commands, metricasm, etc;
- **Commands:** executa uma parte da funcionalidade seguindo o conceito de responsabilidade única;
- **Services:** encapsula funcionalidades (ou validações) genéricas que podem ser utilizadas por vários commands, e tb fazem a ponte entre os commands e algumas integrações;
- **Contexts** são as classes manipuladas dentro dos fluxos de execução;

Antes de desenvolver, fique atento à organização dos pacotes.

Nossa API foi desenvolvida em Kotlin, Spring boot,Todas as nossas aplicações utilizam sleuth, nossas integrações são via Feign, wiremock,

## Regras báscias para desenvolvimento

- Todas as PRs com precisam de ao menos 2 aprovações;
- A cobertura de testes do projeto nao pode ser inferior a 80% para o geral e **100%  para novos códigos**
- Novas integrações devem ter testes integrados e mapeados no wiremock
- Atente-se aos conceitos de **SOLID**. Principalmente ao de responsabilidade única.


## Rodando a aplicação

A aplicação foi desenhada para subir de forma simples com a ajuda do docker compose. Para iniciá-la, execute o comando abaixo:

```
$ ./gradlew clean build && docker compose -f docker/docker-compose.yml up
```

Este comando builda a aplicação e a inicia no docker, cria e popula o banco de dados e sobe um servidor wiremock para simular as integrações Rest com outras aplicações.

### Exemplos de uso

Para acessar a aplicação após subir o docker, vá em:

http://localhost:8999/swagger-ui/index.html

No estado atual, como massa de dados serão criados 6 usuários (ids de 1 a 6), com diversas dívidas com e sem fornecedores registrados.
Exemplos de chamadas:

**Ex 1:**
```
curl -X 'GET' \
  'http://localhost:8999/debits/customer/1' \
  -H 'accept: */*'
```

**Ex 2:**
```
curl -X 'GET' \
'http://localhost:8999/debits/customer/5/12345679' \
-H 'accept: */*'
```

### Rodando locamente

Você também pode rodar a aplicação localmente, porém terá que subir as outras instancias no docker separadamente:

```
$ ./gradlew clean build && java -jar build/libs/foo-payment-api-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=local
```

## Tech stack

Tecnologias utlizadas:

- **Kotlin 1.7**+
- **JDK 11**+
- **Spring Boot 2.7.3**
- **Spring JPA, Sleuth, Open API 3(swagger)**
- **Gradle 7.5**+
- **Docker** e **Docker Compose 2**
- **Postgres 14.1**
- **H2 2.1.210**
- **Flyway 9.2.3**
- **Wiremock 2.34.0**
