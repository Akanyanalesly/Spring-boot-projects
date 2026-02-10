# Question 4 – E‑Commerce Product Management REST API

## Overview

This project is a **Spring Boot REST API** for managing products in an e‑commerce system. The API supports retrieving products with pagination, filtering by category and brand, searching by keyword, filtering by price range, checking stock availability, and performing full CRUD operations.

The application uses an **in‑memory ArrayList** to store products and does not require a database.

This implementation fully satisfies the requirements for **Question 4**.

---

## Technologies Used

* Java
* Spring Boot
* Spring Web (RESTful services)
* Maven

---

## Project Structure

```
question4-ecommerce-api
├── src/main/java/com/example/question4_ecommerce_api
│   ├── Question4EcommerceApiApplication.java
│   ├── controller
│   │   └── ProductController.java
│   └── model
│       └── Product.java
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
   `com.example.question4_ecommerce_api`
3. Run the main class:
   `Question4EcommerceApiApplication.java`
4. The application will start on:
   `http://localhost:8080`

---

## Preloaded Data

When the application starts, **ten (10) products** are automatically loaded into memory. The products cover multiple categories, brands, price ranges, and stock quantities for testing all endpoints.

---

## API Endpoints

### 1. Get All Products (Pagination)

**GET** `/api/products?page={page}&limit={limit}`

**Example:**

```
GET /api/products?page=0&limit=5
```

**Response:**

* `200 OK`
* Returns a paginated list of products

---

### 2. Get Product by ID

**GET** `/api/products/{productId}`

**Responses:**

* `200 OK` – Product found
* `404 Not Found` – Product does not exist

---

### 3. Get Products by Category

**GET** `/api/products/category/{category}`

**Example:**

```
GET /api/products/category/Electronics
```

---

### 4. Get Products by Brand

**GET** `/api/products/brand/{brand}`

**Example:**

```
GET /api/products/brand/Samsung
```

---

### 5. Search Products by Keyword

**GET** `/api/products/search?keyword=value`

**Example:**

```
GET /api/products/search?keyword=laptop
```

Searches in both product name and description.

---

### 6. Filter Products by Price Range

**GET** `/api/products/price-range?min=value&max=value`

**Example:**

```
GET /api/products/price-range?min=100&max=500
```

---

### 7. Get In‑Stock Products

**GET** `/api/products/in-stock`

**Response:**

* Returns only products with stock quantity greater than zero

---

### 8. Add a New Product

**POST** `/api/products`

**Request Body (JSON):**

```
{
  "productId": 11,
  "name": "Printer",
  "description": "Wireless printer",
  "price": 300.0,
  "category": "Electronics",
  "stockQuantity": 7,
  "brand": "HP"
}
```

**Response:**

* `201 Created`

---

### 9. Update Product (Full Update)

**PUT** `/api/products/{productId}`

**Response:**

* `200 OK` – Product updated
* `404 Not Found` – Product not found

---

### 10. Update Product Stock Only

**PATCH** `/api/products/{productId}/stock?quantity=value`

**Example:**

```
PATCH /api/products/3/stock?quantity=20
```

---

### 11. Delete Product

**DELETE** `/api/products/{productId}`

**Responses:**

* `204 No Content` – Product deleted
* `404 Not Found` – Product not found

---

## Testing the API

You can test this API using:

* **Postman** (recommended for POST, PUT, PATCH, DELETE)
* **Web Browser** (GET requests only)

Example browser test:

```
http://localhost:8080/api/products
```

---

## Notes

* This application uses **in‑memory storage**, so all data is reset when the application restarts.
* No database or JPA is required.
* Implemented strictly according to **Question 4 specifications**.

---


