package com.adhiraj.spring.recipe.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.adhiraj.spring.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

  Optional<UnitOfMeasure> findByDescription(String description);

}
