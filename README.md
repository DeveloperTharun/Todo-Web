# 📝 Todo Application

A full-stack Todo Management Application built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **PostgreSQL**, and a simple **HTML, CSS, JavaScript** frontend.

Users can register, log in securely, and manage their personal todo tasks.

---

## 🚀 Features

- 🔐 User Registration & Login
- 🔑 JWT Authentication
- 🛡️ Spring Security Integration
- ➕ Create Todo
- 📋 View All Todos
- ✏️ Update Todo
- 🗑️ Delete Todo
- 👤 User-specific Todo Management
- 🌐 REST API Backend
- 💻 Responsive Frontend using HTML, CSS & JavaScript

---

## 🛠️ Tech Stack

### Backend
- Java 24
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Token)
- Maven
- PostgreSQL

### Frontend
- HTML5
- CSS3
- JavaScript (Fetch API)

---

## 📂 Project Structure

```
todo-app/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   ├── security/
│   ├── utils/
│   └── resources/
│
├── frontend/
│   ├── index.html
│   ├── login.html
│   ├── register.html
│   ├── todo.html
│   ├── style.css
│   └── script.js
│
└── README.md
```

---

## 🔑 Authentication Flow

1. Register a new account.
2. Login with email and password.
3. Server generates a JWT token.
4. Token is stored in Local Storage.
5. Every authenticated request sends:

```
Authorization: Bearer <JWT_TOKEN>
```

6. Spring Security validates the token before allowing access.

---

## 📌 REST API Endpoints

### Authentication

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/auth/register` | Register User |
| POST | `/auth/login` | Login User |

### Todo

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/todo` | Get All Todos |
| POST | `/todo` | Create Todo |
| PUT | `/todo/{id}` | Update Todo |
| DELETE | `/todo/{id}` | Delete Todo |

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/your-username/todo-app.git

cd todo-app
```

---

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tododb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

---

### Run Backend

```bash
mvn spring-boot:run
```

Backend runs at

```
http://localhost:8080
```

---

### Run Frontend

Simply open

```
index.html
```

or use VS Code Live Server.

---

## 📸 Screenshots

Add screenshots here.

Example:

```
screenshots/
    login.png
    register.png
    dashboard.png
```

---

## 🔮 Future Improvements

- Email Verification
- Password Reset
- Dark Mode
- Due Dates
- Priority Levels
- Categories
- Search & Filter
- Pagination
- Docker Support
- Deployment on AWS

---

## 👨‍💻 Author

**Tharun Raj**

- GitHub: https://github.com/your-username
- LinkedIn: https://linkedin.com/in/your-profile

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

---

## 📜 License

This project is licensed under the MIT License.
