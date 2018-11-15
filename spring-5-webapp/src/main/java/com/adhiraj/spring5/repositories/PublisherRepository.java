package com.adhiraj.spring5.repositories;

import org.springframework.data.repository.CrudRepository;
import com.adhiraj.spring5.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
