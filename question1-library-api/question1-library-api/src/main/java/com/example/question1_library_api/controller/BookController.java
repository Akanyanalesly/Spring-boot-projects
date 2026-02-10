package com.example.question1_library_api.controller;

import com.example.question1_library_api.model.Book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1L, "Clean Code", "Robert Martin", "978-0132350884", 2008));
        books.add(new Book(2L, "Effective Java", "Joshua Bloch", "978-0134685991", 2018));
        books.add(new Book(3L, "Spring in Action", "Craig Walls", "978-1617294945", 2018));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    for (Book book : books) {
        if (book.getId().equals(id)) {
            return ResponseEntity.ok(book); 
        }
    }
    return ResponseEntity.notFound().build(); 
}


    @GetMapping("/search")
    public List<Book> searchByTitle(@RequestParam String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                books.remove(book);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

}
