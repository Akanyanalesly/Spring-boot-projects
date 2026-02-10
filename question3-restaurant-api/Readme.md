# Question 3 – Restaurant Menu Management REST API

## Overview

This project is a **Spring Boot REST API** for managing a restaurant menu. It allows clients to view menu items, filter them by category and availability, search by name, add new menu items, update item availability, and delete items. The application uses an **in-memory list (ArrayList)** and does not require a database.

This implementation fully satisfies the requirements for **Question 3**.

---

## Technologies Used

* Java
* Spring Boot
* Spring Web (RESTful services)
* Maven

---

## Project Structure

```
question3-restaurant-api
├── src/main/java/com/example/question3_restaurant_api
│   ├── Question3RestaurantApiApplication.java
│   ├── controller
│   │   └── MenuController.java
│   └── model
│       └── MenuItem.java
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
   `com.example.question3_restaurant_api`
3. Run the main class:
   `Question3RestaurantApiApplication.java`
4. The application will start on:
   `http://localhost:8080`

---

## Preloaded Data

When the application starts, **eight (8) menu items** are automatically loaded into memory, covering different categories such as:

* Appetizer
* Main Course
* Dessert
* Beverage

Each item includes availability status for testing filtering functionality.

---

## API Endpoints

### 1. Get All Menu Items

**GET** `/api/menu`

**Response:**

* `200 OK`
* Returns all menu items

---

### 2. Get Menu Item by ID

**GET** `/api/menu/{id}`

**Example:**

```
GET /api/menu/1
```

**Responses:**

* `200 OK` – Menu item found
* `404 Not Found` – Menu item does not exist

---

### 3. Get Menu Items by Category

**GET** `/api/menu/category/{category}`

**Example:**

```
GET /api/menu/category/Dessert
```

**Response:**

* `200 OK`
* Returns menu items matching the given category (case-insensitive)

---

### 4. Get Menu Items by Availability

**GET** `/api/menu/available?available=true`

**Example:**

```
GET /api/menu/available?available=true
```

**Response:**

* `200 OK`
* Returns menu items based on availability status

---

### 5. Search Menu Item by Name

**GET** `/api/menu/search?name=keyword`

**Example:**

```
GET /api/menu/search?name=burger
```

**Response:**

* `200 OK`
* Returns menu items whose names contain the given keyword (case-insensitive)

---

### 6. Add a New Menu Item

**POST** `/api/menu`

**Request Body (JSON):**

```
{
  "id": 9,
  "name": "Pasta",
  "description": "Creamy pasta",
  "price": 9.99,
  "category": "Main Course",
  "available": true
}
```

**Response:**

* `201 Created`
* Returns the newly added menu item

---

### 7. Toggle Menu Item Availability

**PUT** `/api/menu/{id}/availability`

**Example:**

```
PUT /api/menu/3/availability
```

**Response:**

* `200 OK`
* Returns the updated menu item with toggled availability
* `404 Not Found` – Menu item not found

---

### 8. Delete a Menu Item

**DELETE** `/api/menu/{id}`

**Example:**

```
DELETE /api/menu/5
```

**Responses:**

* `204 No Content` – Menu item deleted successfully
* `404 Not Found` – Menu item not found

---

## Testing the API

You can test this API using:

* **Postman** (recommended for POST, PUT, DELETE)
* **Web Browser** (GET requests only)

Example browser test:

```
http://localhost:8080/api/menu
```

---

## Notes

* This application uses **in-memory storage**, so all data is lost when the application restarts.
* No database or JPA configuration is required.
* Designed strictly according to **Question 3 requirements**.

---

