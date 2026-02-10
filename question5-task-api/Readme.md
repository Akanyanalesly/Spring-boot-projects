# Question 5 – Task Management REST API

## Overview

This project is a **Spring Boot REST API** for managing tasks in a simple task management system. The API allows clients to create tasks, retrieve tasks, filter tasks by status and priority, update task details, mark tasks as completed, and delete tasks.

The application uses an **in-memory ArrayList** to store tasks and does not require a database.

This implementation fully satisfies the requirements for **Question 5**.

---

## Technologies Used

* Java
* Spring Boot
* Spring Web (RESTful services)
* Maven

---

## Project Structure

```
question5-task-api
├── src/main/java/com/example/question5_task_api
│   ├── Question5TaskApiApplication.java
│   ├── controller
│   │   └── TaskController.java
│   └── model
│       └── Task.java
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
   `com.example.question5_task_api`
3. Run the main class:
   `Question5TaskApiApplication.java`
4. The application will start on:
   `http://localhost:8080`

---

## Preloaded Data

When the application starts, **three (3) tasks** are automatically loaded into memory with different priorities, due dates, and completion statuses for testing purposes.

---

## API Endpoints

### 1. Get All Tasks

**GET** `/api/tasks`

**Response:**

* `200 OK`
* Returns a list of all tasks

---

### 2. Get Task by ID

**GET** `/api/tasks/{taskId}`

**Responses:**

* `200 OK` – Task found
* `404 Not Found` – Task does not exist

---

### 3. Get Tasks by Completion Status

**GET** `/api/tasks/status?completed=true|false`

**Example:**

```
GET /api/tasks/status?completed=false
```

**Response:**

* Returns tasks based on completion status

---

### 4. Get Tasks by Priority

**GET** `/api/tasks/priority/{priority}`

**Example:**

```
GET /api/tasks/priority/HIGH
```

**Response:**

* Returns tasks matching the given priority (LOW, MEDIUM, HIGH)

---

### 5. Create a New Task

**POST** `/api/tasks`

**Request Body (JSON):**

```
{
  "taskId": 4,
  "title": "Prepare presentation",
  "description": "Spring Boot demo",
  "completed": false,
  "priority": "HIGH",
  "dueDate": "2026-02-20"
}
```

**Response:**

* `201 Created`

---

### 6. Update Task (Full Update)

**PUT** `/api/tasks/{taskId}`

**Response:**

* `200 OK` – Task updated successfully
* `404 Not Found` – Task not found

---

### 7. Mark Task as Completed

**PATCH** `/api/tasks/{taskId}/complete`

**Example:**

```
PATCH /api/tasks/2/complete
```

**Response:**

* `200 OK` – Task marked as completed
* `404 Not Found` – Task not found

---

### 8. Delete Task

**DELETE** `/api/tasks/{taskId}`

**Responses:**

* `204 No Content` – Task deleted successfully
* `404 Not Found` – Task not found

---

## Testing the API

You can test this API using:

* **Postman** (recommended for POST, PUT, PATCH, DELETE)
* **Web Browser** (GET requests only)

Example browser test:

```
http://localhost:8080/api/tasks
```

---

## Notes

* This application uses **in-memory storage**, so all task data is lost when the application restarts.
* No database or JPA configuration is required.
* Implemented strictly according to **Question 5 specifications**.

---


