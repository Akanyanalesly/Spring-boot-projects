# Question 2 – Student Management REST API

## Overview

This project is a **Spring Boot REST API** for managing student records. It allows clients to retrieve students, search and filter them using different criteria, register new students, and update existing student information. The API uses an **in-memory data structure (ArrayList)** and does not require a database.

This implementation satisfies all the requirements for **Question 2**.

---

## Technologies Used

* Java
* Spring Boot
* Spring Web (RESTful services)
* Maven

---

## Project Structure

```
question2-student-api
├── src/main/java/com/example/question2_student_api
│   ├── Question2StudentApiApplication.java
│   ├── controller
│   │   └── StudentController.java
│   └── model
│       └── Student.java
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
2. Confirm package names start with:
   `com.example.question2_student_api`
3. Run the main class:
   `Question2StudentApiApplication.java`
4. The application will start on:
   `http://localhost:8080`

---

## Preloaded Data

At application startup, **five (5) students** are automatically loaded into memory with different majors and GPA values for testing purposes.

---

## API Endpoints

### 1. Get All Students

**GET** `/api/students`

**Response:**

* `200 OK`
* Returns a list of all students

---

### 2. Get Student by ID

**GET** `/api/students/{studentId}`

**Example:**

```
GET /api/students/1
```

**Responses:**

* `200 OK` – Student found
* `404 Not Found` – Student does not exist

---

### 3. Get Students by Major

**GET** `/api/students/major/{major}`

**Example:**

```
GET /api/students/major/Computer Science
```

**Response:**

* `200 OK`
* Returns all students enrolled in the specified major (case-insensitive)

---

### 4. Filter Students by GPA

**GET** `/api/students/filter?gpa=value`

**Example:**

```
GET /api/students/filter?gpa=3.5
```

**Response:**

* `200 OK`
* Returns students with GPA greater than or equal to the given value

---

### 5. Register a New Student

**POST** `/api/students`

**Request Body (JSON):**

```
{
  "studentId": 6,
  "firstName": "Anna",
  "lastName": "Taylor",
  "email": "anna@gmail.com",
  "major": "Business",
  "gpa": 3.4
}
```

**Response:**

* `201 Created`
* Returns the newly registered student

---

### 6. Update Student Information

**PUT** `/api/students/{studentId}`

**Example:**

```
PUT /api/students/3
```

**Request Body (JSON):**

```
{
  "firstName": "Alex",
  "lastName": "Brown",
  "email": "alex_updated@gmail.com",
  "major": "Computer Science",
  "gpa": 3.7
}
```

**Responses:**

* `200 OK` – Student updated successfully
* `404 Not Found` – Student not found

---

## Testing the API

You can test this API using:

* **Postman** (recommended for POST and PUT requests)
* **Web Browser** (GET requests only)

Example browser test:

```
http://localhost:8080/api/students
```

---

## Notes

* This application uses **in-memory storage**, so all data is reset when the application restarts.
* No database or JPA configuration is required.
* Designed for learning and assessment purposes.

---


