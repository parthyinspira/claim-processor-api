# Claim Processor API

Java 21 / Spring Boot 3 REST API for the Claim Processor application. Handles claim submission, adjudication workflow, eligibility inquiry, and remittance generation.

## Features
- Claim CRUD (`/api/claims`)
- Eligibility check (`/api/eligibility/check`)
- Adjudication engine (rule-based)
- 835 remittance generation
- Postgres persistence via Spring Data JPA

## Tech Stack
- Java 21, Spring Boot 3.3
- Spring Data JPA + PostgreSQL
- Maven
- JUnit 5 + Mockito

## Getting Started

```bash
# Start Postgres
docker run -d -e POSTGRES_DB=claims -e POSTGRES_USER=claims -e POSTGRES_PASSWORD=claims -p 5432:5432 postgres:16

# Run
./mvnw spring-boot:run
```

API available at `http://localhost:8080`.

## Environment Variables
```
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/claims
SPRING_DATASOURCE_USERNAME=claims
SPRING_DATASOURCE_PASSWORD=claims
```
