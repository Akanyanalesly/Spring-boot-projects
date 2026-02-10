# Question 1 – Library Management REST API

## Overview

This project is a **Spring Boot REST API** for managing a simple library. It exposes endpoints to **list books**, **retrieve a book by ID**, **search by title**, **add a new book**, and **delete a book**. The API uses an **in‑memory list** (no database) and is intended for learning and assessment purposes.

You already have all required source files implemented:

* `BookController` (REST endpoints)
* `Book` model
* `Question1LibraryApiApplication` (main class)

---

## Technologies Used

* Java
* Spring Boot
* Spring Web (REST)
* Maven

---

## Project Structure

```
question1-library-api
├── src/main/java/com/example/question1_library_api
│   ├── Question1LibraryApiApplication.java
│   ├── controller
│   │   └── BookController.java
│   └── model
│       └── Book.java
└── src/main/resources
    └── application.properties
```

---

## Running the Application

### Prerequisites

* Java 17 (or compatible)
* Maven
* IDE (IntelliJ, Eclipse, or VS Code)

### Steps

1. Open the project in your IDE.
2. Make sure all package names match `com.example.question1_library_api`.
3. Run the main class:

   * `Question1LibraryApiApplication.java`
4. The application starts on:

   * `http://localhost:8080`

---

## Preloaded Data

When the application starts, the following books are automatically loaded into memory:

* Clean Code – Robert Martin (2008)
* Effective Java – Joshua Bloch (2018)
* Spring in Action – Craig Walls (2018)

---

## API Endpoints

### 1. Get All Books

**GET** `/api/books`

**Response:**

* `200 OK`
* Returns a list of all books

---

### 2. Get Book by ID

**GET** `/api/books/{id}`

**Example:**

```
GET /api/books/1
```

**Responses:**

* `200 OK` – Book found
* `404 Not Found` – Book does not exist

---

### 3. Search Book by Title

**GET** `/api/books/search?title=keyword`

**Example:**

```
GET /api/books/search?title=java
```

**Response:**

* `200 OK`
* Returns matching books (case‑insensitive)

---

### 4. Add a New Book

**POST** `/api/books`

**Request Body (JSON):**

```
{
  "id": 4,
  "title": "Java Basics",
  "author": "John Doe",
  "isbn": "123-4567890123",
  "publicationYear": 2022
}
```

**Response:**

* `201 Created`
* Returns the created book

---

### 5. Delete a Book

**DELETE** `/api/books/{id}`

**Example:**

```
DELETE /api/books/2
```

**Responses:**

* `204 No Content` – Book deleted successfully
* `404 Not Found` – Book not found

---

## Testing the API

You can test the API using:

* **Postman** (recommended)
* **Web Browser** (for GET requests only)

Example in browser:

```
http://localhost:8080/api/books
```

---

## Notes

* This project uses an **in‑memory ArrayList**, so data resets when the application restarts.
* No database or JPA is required for this question.
* This implementation fully satisfies **Question 1 requirements**.

---


