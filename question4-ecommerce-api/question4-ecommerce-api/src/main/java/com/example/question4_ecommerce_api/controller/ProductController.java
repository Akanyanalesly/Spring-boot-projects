package com.example.question4_ecommerce_api.controller;

import com.example.question4_ecommerce_api.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    
    public ProductController() {
        products.add(new Product(1L, "Laptop", "Gaming laptop", 1200.0, "Electronics", 5, "Dell"));
        products.add(new Product(2L, "Phone", "Smart phone", 800.0, "Electronics", 10, "Samsung"));
        products.add(new Product(3L, "Headphones", "Noise cancelling", 150.0, "Accessories", 0, "Sony"));
        products.add(new Product(4L, "Shoes", "Running shoes", 100.0, "Fashion", 8, "Nike"));
        products.add(new Product(5L, "Watch", "Smart watch", 250.0, "Accessories", 4, "Apple"));
        products.add(new Product(6L, "TV", "4K Smart TV", 900.0, "Electronics", 2, "LG"));
        products.add(new Product(7L, "Backpack", "Travel backpack", 70.0, "Fashion", 12, "Adidas"));
        products.add(new Product(8L, "Keyboard", "Mechanical keyboard", 120.0, "Electronics", 6, "Logitech"));
        products.add(new Product(9L, "Mouse", "Wireless mouse", 60.0, "Electronics", 15, "Logitech"));
        products.add(new Product(10L, "Tablet", "Android tablet", 400.0, "Electronics", 3, "Samsung"));
    }
        @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int limit) {

        int start = page * limit;
        int end = Math.min(start + limit, products.size());

        if (start > products.size()) {
            return new ArrayList<>();
        }
        return products.subList(start, end);
    }

        @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

        @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

        @GetMapping("/brand/{brand}")
    public List<Product> getByBrand(@PathVariable String brand) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                result.add(p);
            }
        }
        return result;
    }

        @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                p.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

        @GetMapping("/price-range")
    public List<Product> priceRange(@RequestParam double min, @RequestParam double max) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                result.add(p);
            }
        }
        return result;
    }

        @GetMapping("/in-stock")
    public List<Product> inStock() {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getStockQuantity() > 0) {
                result.add(p);
            }
        }
        return result;
    }

        @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

        @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product updated) {

        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                p.setName(updated.getName());
                p.setDescription(updated.getDescription());
                p.setPrice(updated.getPrice());
                p.setCategory(updated.getCategory());
                p.setStockQuantity(updated.getStockQuantity());
                p.setBrand(updated.getBrand());
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

        @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(
            @PathVariable Long productId,
            @RequestParam int quantity) {

        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                p.setStockQuantity(quantity);
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

        @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                products.remove(p);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}













