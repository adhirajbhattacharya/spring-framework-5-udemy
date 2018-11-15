package com.adhiraj.spring5.repositories;

import org.springframework.data.repository.CrudRepository;
import com.adhiraj.spring5.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
