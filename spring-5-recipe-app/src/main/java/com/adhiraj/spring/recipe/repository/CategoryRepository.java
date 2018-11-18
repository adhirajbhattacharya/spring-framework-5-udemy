package com.adhiraj.spring.recipe.repository;

import org.springframework.data.repository.CrudRepository;
import com.adhiraj.spring.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
