# MS Docentes — Microsserviço de Docentes

Responsável pela gestão do corpo docente e suas qualificações. Faz parte da arquitetura de microsserviços do projeto junto ao ms-auth, API Gateway e Eureka Server.

---

## Tecnologias

Java 21 · Spring Boot · Spring Data JPA · PostgreSQL · Lombok · Validation · Spring Cloud Netflix Eureka · RestTemplate

---

## Responsabilidades

Gerenciar professores e seus dados cadastrais, formações acadêmicas, disponibilidades de horário e interesses por disciplinas. Expõe endpoints REST consumidos pelos demais microsserviços, incluindo o ms-auth durante o processo de login.

---

## Estrutura principal

`entity/` — entidades `Professor`, `Formacao`, `DisponibilidadeProfessor` e `InteresseDisciplina`.  
`dto/` — objetos de transferência de dados para entrada e saída das APIs.  
`repository/` — interfaces JPA para acesso ao banco de dados.  
`service/` — regras de negócio, mapeamento entre entidades e DTOs e validações.  
`controller/` — endpoints REST para cada entidade.  
`client/AcademicoClient` — cliente HTTP que consulta o ms-acadêmico para validar a existência de um horário antes de registrar uma disponibilidade.  
`config/AppConfig` — bean do `RestTemplate` para comunicação entre microsserviços.  
`exception/GlobalExceptionHandler` — tratamento centralizado de erros de validação e exceções de negócio.

---

## Ordem de inicialização

1. Eureka Server
2. ms-acadêmico
3. ms-docentes
4. ms-auth
5. API Gateway

---

## Desenvolvido por

Grupo 4 - Arquitetura de Software T1 - Universidade Católica de Salvador  
Microsserviços e API Gateway: [Link da Lista](https://github.com/stars/eduardaleall/lists/repos-ms-disp)
