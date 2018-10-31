package com.adhira.spring5.repositories;

import org.springframework.data.repository.CrudRepository;
import com.adhira.spring5.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
