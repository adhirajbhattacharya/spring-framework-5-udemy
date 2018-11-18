package com.adhiraj.spring.recipe.repository;

import org.springframework.data.repository.CrudRepository;
import com.adhiraj.spring.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
