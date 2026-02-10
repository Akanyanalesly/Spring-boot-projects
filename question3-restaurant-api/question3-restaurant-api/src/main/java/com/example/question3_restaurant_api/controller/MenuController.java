package com.example.question3_restaurant_api.controller;

import com.example.question3_restaurant_api.model.MenuItem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private List<MenuItem> menuItems = new ArrayList<>();

    // STEP 4.1: Create sample data (8 items)
    public MenuController() {
        menuItems.add(new MenuItem(1L, "Spring Rolls", "Crispy rolls", 5.99, "Appetizer", true));
        menuItems.add(new MenuItem(2L, "Chicken Burger", "Grilled chicken burger", 8.99, "Main Course", true));
        menuItems.add(new MenuItem(3L, "Beef Steak", "Juicy beef steak", 14.99, "Main Course", false));
        menuItems.add(new MenuItem(4L, "French Fries", "Golden fries", 3.99, "Appetizer", true));
        menuItems.add(new MenuItem(5L, "Ice Cream", "Vanilla ice cream", 4.50, "Dessert", true));
        menuItems.add(new MenuItem(6L, "Chocolate Cake", "Rich chocolate cake", 6.00, "Dessert", false));
        menuItems.add(new MenuItem(7L, "Coca Cola", "Cold drink", 2.00, "Beverage", true));
        menuItems.add(new MenuItem(8L, "Coffee", "Hot coffee", 2.50, "Beverage", true));
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItems;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/category/{category}")
    public List<MenuItem> getByCategory(@PathVariable String category) {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }
        return result;
    }

    @GetMapping("/available")
    public List<MenuItem> getAvailableItems(@RequestParam boolean available) {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.isAvailable() == available) {
                result.add(item);
            }
        }
        return result;
    }

    @GetMapping("/search")
    public List<MenuItem> searchByName(@RequestParam String name) {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        menuItems.add(menuItem);
        return new ResponseEntity<>(menuItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<MenuItem> toggleAvailability(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.isAvailable());
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                menuItems.remove(item);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

}