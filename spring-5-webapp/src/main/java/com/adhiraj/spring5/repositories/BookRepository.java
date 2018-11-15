package com.adhiraj.spring5.repositories;

import org.springframework.data.repository.CrudRepository;
import com.adhiraj.spring5.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
