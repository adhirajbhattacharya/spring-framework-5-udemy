package com.adhiraj.spring.recipe.service;

import java.util.Set;
import com.adhiraj.spring.recipe.domain.Recipe;

public interface RecipeService {
  
  Set<Recipe> getRecipes();
}
