package com.example._users_api.controllers;

import com.example._users_api.models.Book;
import com.example._users_api.models.User;
import com.example._users_api.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;


    // GET: localhost:8080/books
    @GetMapping
    public Iterable<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    // GET: localhost:8080/book/1
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        return booksService.getBookById(id);
    }

    // POST: localhost:8080/book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return booksService.createBook(book);
    }

    // PUT: localhost:8080/1
    @PutMapping("/{id}")
    public boolean updateBookById(@PathVariable Long id, @RequestBody Book book) {
        return booksService.updateBookById(id, book);
    }

    // DELETE: localhost:8080/books/3    @DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public boolean deleteBooksById(@PathVariable Long id) {
        return booksService.deleteBookById(id);
    }

    // POST: localhost:8080/books/seed
    @PostMapping("/seed")
    public boolean postSeedBooks() {
        return booksService.seedBooks();
    }

}
