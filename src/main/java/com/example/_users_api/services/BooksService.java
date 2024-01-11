package com.example._users_api.services;

import com.example._users_api.models.Book;
import com.example._users_api.repositories.BooksRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    // Get all books
    public Iterable<Book> getAllBooks(){
        return booksRepository.findAll();
    }


    // Get one book
    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }


    // Create book
    public Book createBook(@RequestBody Book book){
        booksRepository.save(book);
        return book;
    }

    // Update book
    public boolean updateBookById(@PathVariable Long id, @RequestBody Book book){
        if (booksRepository.existsById(id))
            book.setId(id);
        booksRepository.save(book);
        return true;
    }

    // Delete Book
    public boolean deleteBookById(@PathVariable Long id){
        // Check if the book exits
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return true;
            // Else return false
        } else {
            return false;
        }
    }

    // Seed Book
    public boolean seedBooks(){
        try {
            Book[] books = {
                    new Book("Harry potter 1", 110),
                    new Book("Harry potter 2", 200),
                    new Book("Harry potter 3", 300)
            };
            var bookList = Arrays.stream(books).toList();
            booksRepository.saveAll(bookList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }


}
