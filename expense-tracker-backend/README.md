# Expense Tracker (Spring Boot) - Ready to Run

## Overview
A minimal production-minded Expense Tracker backend built with Spring Boot.
Features:
- User registration & JWT authentication
- Add, list, delete expenses
- Monthly report grouped by category
- H2 in-memory DB for local development
- Swagger UI for API docs

## Run (local)
1. Make sure you have Java 17 and Maven installed.
2. Build: `mvn clean package`
3. Run: `mvn spring-boot:run`
4. Swagger UI: http://localhost:8080/swagger-ui.html
5. H2 console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:expensetrackerdb)

## Endpoints
- `POST /api/auth/register` — register {username, password, fullName}
- `POST /api/auth/login` — login {username, password} -> returns token
- Authenticated: include header `Authorization: Bearer <token>`
  - `POST /api/expenses` — add expense (see dto)
  - `GET /api/expenses` — list expenses
  - `DELETE /api/expenses/{id}` — delete
  - `GET /api/expenses/monthly-report?year=2025&month=10` — report

## Switch to MySQL
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=yourpass
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

## Notes
- Replace the JWT secret in `JwtUtil` with an environment variable for production.
- Add DTO validation and better exception handling as next steps.
