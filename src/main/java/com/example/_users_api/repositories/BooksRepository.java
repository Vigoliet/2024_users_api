package com.example._users_api.repositories;

import com.example._users_api.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository <Book, Long> {
}
