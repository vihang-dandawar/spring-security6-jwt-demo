# 🛡️ Spring Security 6 JWT Demo Project

This project demonstrates a secure REST API built with **Spring Boot 3** and **Spring Security 6**, showcasing:

- ✅ CSRF protection
- ✅ Username & Password Authentication via Database
- ✅ Password encryption using `BCrypt`
- ✅ JWT Authentication with Bearer Token
- ✅ Role-based access control
- ✅ Protected `/students` endpoint (with dummy data)

---

## 📌 Tech Stack

- Spring Boot 3.x
- Spring Security 6
- JWT (JSON Web Tokens)
- H2 / MySQL Database
- BCrypt password hashing

---

## 🚀 API Endpoints

| Endpoint        | Method | Description                          | Auth Required |
|-----------------|--------|--------------------------------------|---------------|
| `/register`     | POST   | Register a new user                  | ❌ No          |
| `/login`        | POST   | Login with username and password     | ❌ No (returns JWT) |
| `/students`     | GET    | Get protected student list           | ✅ Yes (JWT Bearer Token) |

---

## 🔐 Authentication Flow

1. **Register** at `/register` (your password gets encrypted).
2. **Login** at `/login` (returns a JWT token).
3. Use the token as a **Bearer token** in header to access `/students`.

```http
Authorization: Bearer <your_token_here>
