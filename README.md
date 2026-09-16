# Expense Tracker API

A RESTful API built with Spring Boot and PostgreSQL for tracking personal expenses.

## Tech Stack

- Java 17
- Spring Boot 4 (Spring Web MVC, Spring JDBC)
- PostgreSQL (via Docker)
- Gradle

## Status

Work in progress. Currently implements user registration; more endpoints and features are planned.

## Running locally

1. Start PostgreSQL via Docker:
   ```bash
   docker run --name postgresdb -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres
   ```
2. Load the schema:
   ```bash
   docker cp expensetracker_db.sql postgresdb:/
   docker exec -it postgresdb psql -U postgres -f /expensetracker_db.sql
   ```
3. Run the app:
   ```bash
   ./gradlew bootRun