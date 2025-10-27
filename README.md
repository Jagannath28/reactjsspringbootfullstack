# 💰 Expense Tracker Backend

A **Spring Boot-based Expense Tracker Application** that helps users manage their daily expenses, analyze spending, and maintain a secure record of transactions.  
Built using **Java, Spring Boot, MySQL, JWT Authentication, and Docker**.

## 🚀 Features

✅ User registration and login with **JWT Authentication**  
✅ Add, update, delete, and view expenses  
✅ Filter expenses by **date** or **category**  
✅ View **monthly expense summary**  
✅ Integrated with **MySQL** (via Docker)  
✅ Fully containerized setup using **Docker Compose**  
✅ Secure REST APIs documented using **Swagger UI**  

## 🧰 Tech Stack

| Category | Technology |
|-----------|-------------|
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.x |
| **Security** | Spring Security, JWT |
| **Database** | MySQL 8 (Docker) |
| **ORM** | Hibernate / JPA |
| **Build Tool** | Maven |
| **Containerization** | Docker, Docker Compose |
| **Documentation** | Swagger / OpenAPI |

## 📁 Folder Structure

```
expense-tracker-backend/
├── src/main/java/com/expense/tracker/
│   ├── controller/
│   ├── dto/
│   ├── entity/
│   ├── repository/
│   ├── service/
│   ├── security/
│   └── ExpenseTrackerApplication.java
├── src/main/resources/
│   └── application.properties
├── Dockerfile
├── docker-compose.yml
├── .env
├── pom.xml
└── README.md
```

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/jagannathreddy/expense-tracker-backend.git
cd expense-tracker-backend
```

### 2️⃣ Run with Docker (Recommended)
Make sure **Docker** and **Docker Compose** are installed.

```bash
docker compose up --build
```

✅ This starts:
- **MySQL** (on port 3306)  
- **Spring Boot App** (on port 8080)

## 🌐 API Endpoints

| Method | Endpoint | Description | Auth |
|--------|-----------|-------------|------|
| `POST` | `/api/auth/register` | Register new user | ❌ |
| `POST` | `/api/auth/login` | Login and get JWT token | ❌ |
| `GET` | `/api/expenses` | Fetch all expenses | ✅ |
| `POST` | `/api/expenses` | Add new expense | ✅ |
| `DELETE` | `/api/expenses/{id}` | Delete expense by ID | ✅ |

## 🔐 Authentication
- Use JWT token for all secure endpoints.  
- After login, you’ll receive a token — include it in the header:

```
Authorization: Bearer <your_token_here>
```

## 🧾 Swagger API Docs
Access all APIs at:  
👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 🛠️ Environment Variables (`.env`)
```
MYSQL_DATABASE=expense_tracker
MYSQL_USER=expense_user
MYSQL_PASSWORD=expense_pass
MYSQL_ROOT_PASSWORD=root_pass
MYSQL_PORT=3306
JWT_SECRET=verysecretkeyforjwtwhichshouldbeatleast32bytes!
```

## 🧩 Future Improvements
- Add category-wise analytics dashboard  
- Export expenses as PDF/Excel  
- Add email reminders for monthly summaries  
- Convert to microservice architecture (User Service + Expense Service)

## ✨ Author
**Jagannath Reddy P**  
💼 Java Backend Developer | 2 Years Experience  
📧 [your-email@example.com]  
🔗 [LinkedIn](https://linkedin.com/in/jagannathreddy) • [GitHub](https://github.com/jagannathreddy)
