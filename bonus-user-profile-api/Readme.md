# Bonus Question – User Profile Management REST API

## Overview

This project is a **Spring Boot REST API** for managing user profiles. It demonstrates advanced REST concepts such as **custom API response wrappers**, searching with query parameters, partial updates using PATCH, and activation/deactivation of users.

All responses are returned using a **custom `ApiResponse<T>` wrapper**, providing a consistent structure with `success`, `message`, and `data` fields.

The application uses **in-memory storage (ArrayList)** and does not require a database.

---

## Technologies Used

* Java
* Spring Boot
* Spring Web (RESTful services)
* Maven

---

## Project Structure

```
bonus-user-profile-api
├── src/main/java/com/example/bonus_user_profile_api
│   ├── BonusUserProfileApiApplication.java
│   ├── controller
│   │   └── UserProfileController.java
│   └── model
│       ├── UserProfile.java
│       └── ApiResponse.java
└── src/main/resources
    └── application.properties
```

---

## Running the Application

### Prerequisites

* Java 17 (or compatible)
* Maven
* Any Java IDE (IntelliJ, Eclipse, or VS Code)

### Steps

1. Open the project in your IDE.
2. Ensure all package names start with:
   `com.example.bonus_user_profile_api`
3. Run the main class:
   `BonusUserProfileApiApplication.java`
4. The application will start on:
   `http://localhost:8080`

---

## Preloaded Data

At application startup, **two (2) user profiles** are automatically loaded into memory for testing purposes.

---

## API Response Format

All endpoints return responses using the following structure:

```
{
  "success": true,
  "message": "Description message",
  "data": { }
}
```

---

## API Endpoints

### 1. Create User Profile

**POST** `/api/users`

**Request Body (JSON):**

```
{
  "userId": 3,
  "username": "mark_dev",
  "email": "mark@gmail.com",
  "fullName": "Mark Lee",
  "age": 28,
  "country": "UK",
  "bio": "Backend developer",
  "active": true
}
```

---

### 2. Get All User Profiles

**GET** `/api/users`

---

### 3. Get User by ID

**GET** `/api/users/{id}`

---

### 4. Search User by Username

**GET** `/api/users/search/username?username=value`

**Example:**

```
GET /api/users/search/username?username=jane_smith
```

---

### 5. Search Users by Country

**GET** `/api/users/search/country?country=value`

---

### 6. Search Users by Age Range

**GET** `/api/users/search/age?min=value&max=value`

**Example:**

```
GET /api/users/search/age?min=20&max=30
```

---

### 7. Update User Profile (Full Update)

**PUT** `/api/users/{id}`

---

### 8. Activate User

**PATCH** `/api/users/{id}/activate`

---

### 9. Deactivate User

**PATCH** `/api/users/{id}/deactivate`

---

### 10. Delete User Profile

**DELETE** `/api/users/{id}`

---

## Testing the API

You can test this API using:

* **Postman** (recommended)
* **Web Browser** (GET requests only)

Example browser test:

```
http://localhost:8080/api/users
```

---

## Notes

* This application uses **in-memory storage**, so data is lost when the application restarts.
* No database or JPA is required.
* Custom response wrapper improves API consistency and readability.
* Implemented as a **Bonus Question** to demonstrate advanced REST design.

---


